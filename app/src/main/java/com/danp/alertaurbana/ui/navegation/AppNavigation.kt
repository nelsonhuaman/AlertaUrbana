package com.danp.alertaurbana.ui.navegation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.danp.alertaurbana.ui.navegation.NavigationRoutes


@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = NavigationRoutes.LOGIN
    ) {
        composable(NavigationRoutes.LOGIN) {
            LoginScreen(
                onLoginSuccess = { navController.navigate(NavigationRoutes.LIST) }, // 👈
                onRegisterClick = { navController.navigate(NavigationRoutes.REGISTER) }
            )
        }

        composable(NavigationRoutes.REGISTER) {
            RegisterScreen(
                onRegisterSuccess = { navController.navigate(NavigationRoutes.LOGIN) },
                onBack = { navController.popBackStack() }
            )
        }

        composable(NavigationRoutes.LIST) {
            ReportListScreen(
                onReportSelected = { id: Int ->
                    navController.navigate(NavigationRoutes.detailWithId(id))
                },
                onUserClick = {
                    navController.navigate(NavigationRoutes.USER)
                },
                onNewReportClick = {
                    navController.navigate(NavigationRoutes.REPORT)
                }
            )
        }

        composable(NavigationRoutes.REPORT) {
            ReportScreen(onBack = { navController.popBackStack() })
        }

        composable(
            route = NavigationRoutes.DETAIL,
            arguments = listOf(navArgument("reportId") { type = NavType.IntType })
        ) {
            val reportId = it.arguments?.getInt("reportId") ?: -1
            ReportDetailScreen(reportId = reportId, onBack = { navController.popBackStack() })
        }

        composable(NavigationRoutes.USER) {
            UserScreen(
                onLogout = {
                    navController.navigate(NavigationRoutes.LOGIN) {
                        popUpTo(NavigationRoutes.LIST) { inclusive = true }
                    }
                },
                onBack = { navController.popBackStack() }
            )
        }
    }
}
