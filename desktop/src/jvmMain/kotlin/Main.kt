import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.example.common.App
import com.example.common.m1
import com.example.common.m2
import moe.tlaster.precompose.navigation.NavHost
import moe.tlaster.precompose.navigation.path
import moe.tlaster.precompose.navigation.rememberNavigator


fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
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


