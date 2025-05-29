package com.danp.alertaurbana.ui.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

data class Reporte(
    val id: Int,
    val titulo: String,
    val descripcion: String
)

class FeedViewModel : ViewModel() {
    private val _reportes = MutableStateFlow(
        listOf(
            Reporte(1, "Robo de celular", "Sucedió en la Av. Principal a las 10:30 AM."),
            Reporte(2, "Hurto en tienda", "Tienda 'XYZ' sufrió hurto por la tarde."),
            Reporte(3, "Asalto en parque", "Persona fue asaltada mientras caminaba.")
        )
    )
    val reportes: StateFlow<List<Reporte>> = _reportes
}