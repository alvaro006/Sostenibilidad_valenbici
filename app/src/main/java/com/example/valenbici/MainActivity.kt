package com.example.valenbici
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DirectionsBike
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.valenbici.StationModel
import androidx.compose.material3.Text
import androidx.compose.material3.Scaffold

class MainActivity : ComponentActivity() {

    private val vm = MainViewModel()

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme { // Material3 theme from Compose BOM
                val stations by vm.stations.collectAsState()
                val loading by vm.loading.collectAsState()
                val error by vm.error.collectAsState()

                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = { Text("Valenbisi - Disponibilidad") }
                        )                    }
                ) { innerPadding ->
                    Box(modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding)) {

                        if (loading) {
                            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                        } else if (error != null) {
                            Column(modifier = Modifier.align(Alignment.Center), horizontalAlignment = Alignment.CenterHorizontally) {
                                Text("Error: $error")
                                Spacer(modifier = Modifier.height(8.dp))
                                Button(onClick = { vm.loadStations() }) {
                                    Text("Reintentar")
                                }
                            }
                        } else {
                            StationsList(stations = stations)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun StationsList(stations: List<StationModel>) {
    LazyColumn(
        modifier = Modifier.fillMaxSize().padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(stations) { station ->
            StationCard(station)
        }
    }
}

@Composable
fun StationCard(station: StationModel) {
    // color logic: 0 -> red, 1..3 -> orange, >3 -> green
    val availabilityColor = when {
        station.bicisDisponibles <= 0 -> MaterialTheme.colorScheme.error
        station.bicisDisponibles <= 3 -> MaterialTheme.colorScheme.secondary // advertencia (puedes personalizar)
        else -> MaterialTheme.colorScheme.primary
    }

    Card(
        modifier = Modifier
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(modifier = Modifier.padding(12.dp), verticalAlignment = Alignment.CenterVertically) {
            Icon(
                imageVector = Icons.Default.DirectionsBike,
                contentDescription = "Bici",
                modifier = Modifier.size(36.dp),
                tint = availabilityColor
            )
            Spacer(modifier = Modifier.width(12.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(text = station.direccion, style = MaterialTheme.typography.titleMedium)
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = "Bicis disponibles: ${station.bicisDisponibles}", style = MaterialTheme.typography.bodyMedium)
                Text(text = "Espacios libres: ${station.espaciosLibres}", style = MaterialTheme.typography.bodySmall)
            }
            // pequeño círculo o indicador con color
            Box(
                modifier = Modifier
                    .size(16.dp)
                    .padding(start = 8.dp)
            ) {
                Surface(
                    shape = MaterialTheme.shapes.small,
                    color = availabilityColor,
                    modifier = Modifier.fillMaxSize()
                ) {}
            }
        }
    }
}