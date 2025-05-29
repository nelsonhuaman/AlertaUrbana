package com.danp.alertaurbana.ui.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.danp.alertaurbana.ui.viewmodel.FeedViewModel
import com.danp.alertaurbana.ui.viewmodel.Reporte
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add


@Composable
fun FeedScreen(
    viewModel: FeedViewModel,
    onNavigateToDetail: (Int) -> Unit
) {
    val reportes by viewModel.reportes.collectAsState()

    LazyColumn {
        items(reportes) { reporte ->
            Text(
                text = reporte.titulo,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        onNavigateToDetail(reporte.id)
                    }
                    .padding(16.dp)
            )
        }
    }
}