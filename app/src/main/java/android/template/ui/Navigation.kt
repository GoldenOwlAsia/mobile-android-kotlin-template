/*
 * Created by: glynn.nguyen.goldenowl@gmail.com
 * Copyright © 2015 - 2023 Golden Owl Consulting
 * Contact us: https://goldenowl.asia/
 */

package android.template.ui

import android.template.ui.template.compose.ComposeTempleScreen
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun MainNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "main") {
        composable("main") { ComposeTempleScreen(modifier = Modifier.padding(16.dp)) }
    }
}
