package vn.edu.tdtu.demo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import vn.edu.tdtu.demo.ui.theme.DemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DemoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    LoginScreen()
                }
            }
        }
    }
}


@Composable
fun CustomButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true
) {
    Button(
        onClick = onClick,
        enabled = enabled,
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = MaterialTheme.colors.primary
        )
    ) {
        Text(
            text = text,
            color = Color.White,
            style = MaterialTheme.typography.button
        )
    }
}

@Composable
fun LoginScreen() {
    CustomButton(
        text = "Đăng nhập",
        onClick = { /* Hành động khi nhấn Button 1 */ },
        modifier = Modifier.fillMaxWidth(),
        enabled = true
    )
}

@Composable
fun RegisterScreen() {
    CustomButton(
        text = "Đăng ký",
        onClick = { /* Hành động khi nhấn Button 2 */ },
        modifier = Modifier.padding(8.dp),
        enabled = false
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    DemoTheme {
        Column() {
            LoginScreen()
        }

    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPrevie() {
    DemoTheme {
        Column {
            RegisterScreen()
        }

    }
}