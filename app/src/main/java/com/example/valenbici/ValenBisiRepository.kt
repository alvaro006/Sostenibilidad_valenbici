package com.example.valenbici

import com.example.valenbici.StationModel
import com.example.valenbici.ValenBisiApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.json.JSONObject
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class ValenBisiRepository {

    private val api: ValenBisiApi

    init {
        val logging = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BASIC
        }
        val client = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://valencia.opendatasoft.com/")
            .client(client)
            // usamos ResponseBody directo, no necesitamos converter aquí, pero dejamos Moshi en caso que quieras
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

        api = retrofit.create(ValenBisiApi::class.java)
    }

    // Devuelve lista de StationModel (parseo tolerante a nombres de campo)
    suspend fun fetchStations(): List<StationModel> = withContext(Dispatchers.IO) {
        val resp = api.getRecords()
        if (!resp.isSuccessful) return@withContext emptyList()

        val bodyStr = resp.body()?.string() ?: return@withContext emptyList()
        val json = JSONObject(bodyStr)
        val records = json.optJSONArray("records") ?: return@withContext emptyList()

        val result = mutableListOf<StationModel>()

        for (i in 0 until records.length()) {
            val rec = records.optJSONObject(i) ?: continue
            val fields = rec.optJSONObject("fields") ?: continue

            // Valores por defecto
            var direccion = "Sin dirección"
            var bicisDisponibles = 0
            var espaciosLibres = 0

            // Iteramos dinámicamente sobre todas las claves del JSON
            val keys = fields.keys()
            while (keys.hasNext()) {
                val key = keys.next()
                val value = fields.get(key)

                when (value) {
                    is String -> if (direccion == "Sin dirección") direccion = value
                    is Number -> {
                        if (bicisDisponibles == 0) bicisDisponibles = value.toInt()
                        else if (espaciosLibres == 0) espaciosLibres = value.toInt()
                    }
                }
            }

            result.add(
                StationModel(
                    direccion = direccion,
                    bicisDisponibles = bicisDisponibles,
                    espaciosLibres = espaciosLibres
                )
            )
        }

        result
    }
}