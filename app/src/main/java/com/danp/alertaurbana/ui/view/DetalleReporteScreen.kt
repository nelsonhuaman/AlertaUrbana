package com.danp.alertaurbana.ui.view

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.danp.alertaurbana.ui.viewmodel.DetalleReporteViewModel

@Composable
fun DetalleReporteScreen(
    reportId: Int,
    viewModel: DetalleReporteViewModel,
    onBack: () -> Unit
) {
    LaunchedEffect(reportId) {
        viewModel.cargarReporte(reportId)
    }

    val reporte by viewModel.reporte.collectAsState()

    Column(modifier = Modifier.padding(16.dp)) {
        Text("Detalle del Reporte", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(8.dp))

        Text("Título: ${reporte?.titulo ?: "Cargando..."}")
        Spacer(modifier = Modifier.height(4.dp))
        Text("Descripción: ${reporte?.descripcion ?: "Cargando..."}")

        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = onBack) {
            Text("Volver")
        }
    }
}