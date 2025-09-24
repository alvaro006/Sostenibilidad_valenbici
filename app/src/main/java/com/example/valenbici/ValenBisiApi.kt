package com.example.valenbici

import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ValenBisiApi {
    // Usamos el endpoint records para obtener varios registros
    @GET("api/records/1.0/search/")
    suspend fun getRecords(
        @Query("dataset") dataset: String = "valenbisi-disponibilitat-valenbisi-dsiponibilidad",
        @Query("rows") rows: Int = 1000 // número suficientemente grande para traer todas las estaciones
    ): Response<ResponseBody>
}