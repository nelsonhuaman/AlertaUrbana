package com.danp.alertaurbana.ui.navegation

// Compose
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel

// Navigation
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

// Screens
import com.danp.alertaurbana.ui.view.LoginScreen
import com.danp.alertaurbana.ui.view.FeedScreen
import com.danp.alertaurbana.ui.view.RegistroReporteScreen
import com.danp.alertaurbana.ui.view.DetalleReporteScreen

// ViewModels
import com.danp.alertaurbana.ui.viewmodel.LoginViewModel
import com.danp.alertaurbana.ui.viewmodel.FeedViewModel
import com.danp.alertaurbana.ui.viewmodel.RegistroReporteViewModel
import com.danp.alertaurbana.ui.viewmodel.DetalleReporteViewModel

@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = NavigationRoutes.LOGIN
    ) {
        composable(NavigationRoutes.LOGIN) {
            LoginScreen(
                viewModel = LoginViewModel(),
                onLoginSuccess = { navController.navigate(NavigationRoutes.LIST) }
            )
        }


        composable(NavigationRoutes.REPORT) {
            RegistroReporteScreen(viewModel = RegistroReporteViewModel(),
                onBack = { navController.popBackStack() }
            )
        }
        composable(NavigationRoutes.LIST) {
            val viewModel: FeedViewModel = viewModel()
            FeedScreen(
                viewModel = viewModel,
                onNavigateToDetail = { reportId ->
                    navController.navigate("report_detail/$reportId")
                }
            )
        }

        composable(
            route = "report_detail/{reportId}",
            arguments = listOf(navArgument("reportId") { type = NavType.IntType })
        ) { backStackEntry ->
            val reportId = backStackEntry.arguments?.getInt("reportId") ?: -1
            val viewModel: DetalleReporteViewModel = viewModel() // o hiltViewModel()
            DetalleReporteScreen(reportId = reportId, viewModel = viewModel, onBack = { navController.popBackStack() })
        }



    }
}

