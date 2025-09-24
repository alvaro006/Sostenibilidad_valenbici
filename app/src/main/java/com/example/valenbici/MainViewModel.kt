package com.example.valenbici

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.valenbici.StationModel
import com.example.valenbici.ValenBisiRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val repo = ValenBisiRepository()

    private val _stations = MutableStateFlow<List<StationModel>>(emptyList())
    val stations: StateFlow<List<StationModel>> = _stations

    private val _loading = MutableStateFlow(false)
    val loading: StateFlow<Boolean> = _loading

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error

    init {
        loadStations()
    }

    fun loadStations() {
        viewModelScope.launch {
            _loading.value = true
            _error.value = null
            try {
                val list = repo.fetchStations()
                _stations.value = list.sortedBy { it.direccion } // orden básico
            } catch (e: Exception) {
                _error.value = e.message ?: "Error desconocido"
            } finally {
                _loading.value = false
            }
        }
    }
}