package com.danp.alertaurbana.ui.view

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.danp.alertaurbana.ui.viewmodel.RegistroReporteViewModel

@Composable
fun RegistroReporteScreen(viewModel: RegistroReporteViewModel, onBack: () -> Unit) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text("Registrar Reporte")

        OutlinedTextField(
            value = viewModel.titulo.value,
            onValueChange = { viewModel.titulo.value = it },
            label = { Text("Título") }
        )
        OutlinedTextField(
            value = viewModel.descripcion.value,
            onValueChange = { viewModel.descripcion.value = it },
            label = { Text("Descripción") }
        )

        Button(onClick = onBack, modifier = Modifier.padding(top = 16.dp)) {
            Text("Guardar")
        }
    }
}