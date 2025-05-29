package com.danp.alertaurbana.ui.viewmodel


import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import com.danp.alertaurbana.ui.viewmodel.Reporte

class DetalleReporteViewModel : ViewModel() {
    private val _reporte = MutableStateFlow<Reporte?>(null)
    val reporte: StateFlow<Reporte?> = _reporte

    fun cargarReporte(id: Int) {
        // Simulación (en un caso real obtendrías de un repo o base de datos)
        val todosLosReportes = listOf(
            Reporte(1, "Robo de celular", "Sucedió en la Av. Principal a las 10:30 AM."),
            Reporte(2, "Hurto en tienda", "Tienda 'XYZ' sufrió hurto por la tarde."),
            Reporte(3, "Asalto en parque", "Persona fue asaltada mientras caminaba.")
        )
        _reporte.value = todosLosReportes.find { it.id == id }
    }
}
