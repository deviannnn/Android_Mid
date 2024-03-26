package vn.edu.tdtu.demo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.compose.runtime.Composable
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost

class ChangeScreenActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val nameState = remember { mutableStateOf("Tuan An") }
            MainScreen(nameState)
        }
    }
}

@Composable
fun MainScreen(nameState: MutableState<String>) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "firstScreen") {
        composable("firstScreen") {
            FirstScreen(navController, nameState.value)
        }
        composable("secondScreen") {
            SecondScreen(navController, nameState.value) { newName ->
                nameState.value = newName
                navController.navigateUp() // chuyển trở lại màn hình trước
            }
        }
    }
}

@Composable
fun FirstScreen(navController: NavHostController, name: String) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Name: ${name}")
        Button(
            onClick = { navController.navigate("secondScreen") }
        ) {
            Text(text = "Edit Name")
        }
    }
}

@Composable
fun SecondScreen(navController: NavHostController, name: String, onNameChanged: (String) -> Unit) {
    var newName by rememberSaveable { mutableStateOf(name) }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = newName,
            onValueChange = { edit -> newName = edit },
            label = { Text(text = "Enter Name") },
            modifier = Modifier.padding(16.dp).fillMaxWidth()
        )
        Button(
            onClick = {
                onNameChanged(newName)
            }
        ) {
            Text(text = "Save Name")
        }
    }
}
