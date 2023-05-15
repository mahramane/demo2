package com.example.common

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.material.Text
import androidx.compose.material.Button
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import moe.tlaster.precompose.navigation.NavHost
import moe.tlaster.precompose.navigation.path
import moe.tlaster.precompose.navigation.rememberNavigator

@Composable
@Preview
fun App() {

    @OptIn(ExperimentalAnimationApi::class, ExperimentalMaterialApi::class)
    @Composable
    fun App() {
        val navigator = rememberNavigator()
        MaterialTheme {
            NavHost(
                navigator = navigator,
                initialRoute = "/phone",
            ) {
                scene(
                    route = "/phone"
                ) {
                    m1()
                }

                scene(
                    route = "/sign_in"
                ) { backStackEntry ->
                    val countryCode = backStackEntry.path<String>("country_code")
                    val phone = backStackEntry.path<String>("phone")
                    m2()
                }
            }
        }
    }
}



@Composable
fun m1() {
    var text by remember { mutableStateOf("Hello, World!") }
    Button(onClick = {
        text = "Hello, Desktop!"
    }) {
        Text(text)
    }
}

@Composable
fun m2() {
    var text by remember { mutableStateOf("Hello, World!") }
    Button(onClick = {
        text = "Hello, Desktop!"
    }) {
        Text(text)
    }
}