package com.danp.alertaurbana.ui.viewmodel


import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class RegistroReporteViewModel : ViewModel() {
    var titulo = mutableStateOf("")
    var descripcion = mutableStateOf("")
}