package vn.edu.tdtu.demo

import android.os.Bundle
import android.util.Log
import android.widget.ToggleButton
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Email
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import vn.edu.tdtu.demo.ui.theme.DemoTheme

class ButtonActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DemoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ButtonScreen()
                }
            }
        }
    }
}
@Composable
fun ButtonScreen() {
    Column(modifier = Modifier.padding(25.dp)) {
        DemoButton()
        Spacer(modifier = Modifier.height(10.dp))
        DemoButton2()
        Spacer(modifier = Modifier.height(10.dp))
        DemoButton3()
        Spacer(modifier = Modifier.height(10.dp))
        IconButton(onClick = { /*TODO*/ }) {
            Icon(imageVector = Icons.Default.Email, contentDescription = "")
        }
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedButton(onClick = { /*TODO*/ }) {
            Text(text = "Outline")
        }
        Spacer(modifier = Modifier.height(50.dp))
        DemoButton4()
        Spacer(modifier = Modifier.height(50.dp))
        DemoCLickable()
    }
}

@Composable
fun DemoButton() {
    Button(
        onClick = { /*TODO*/ },
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.Magenta,
            contentColor = Color.Cyan
        ),
        shape = RoundedCornerShape(20.dp),
        border = BorderStroke(2.dp,Color.Black)
    ) {
        Icon(imageVector = Icons.Default.Create, contentDescription = "")
        Text(text = "Edit")
    }
}

@Composable
fun DemoButton2() {
    Button(
        onClick = { /*TODO*/ },
        colors = ButtonDefaults.buttonColors(
            disabledBackgroundColor = Color.Gray,
            disabledContentColor = Color.Black
        ),
        enabled = false
    ) {
        Text(text = "Disable")
    }
}

@Composable
fun DemoButton3() {
    Button(
        onClick = { /*TODO*/ },
    ) {
        Icon(imageVector = Icons.Default.AccountCircle, contentDescription = "")
        Text(text = "Rounded")
    }
}

@Composable
fun DemoButton4() {
    val count = remember {
        mutableStateOf(0)
    }
    Column {
        Log.e("count", "start")
        Text(text = "total click: ${count.value}")
        Button(
            onClick = {
                count.value++
            },
        ) {
            Icon(imageVector = Icons.Default.Add, contentDescription = "")
            Text(text = "Count click")
        }
        Log.e("count", "end")
    }
}

@Composable
fun DemoCLickable() {
    val count = remember {
        mutableStateOf(100)
    }
    Column {
        Log.e("down", "start")
        Text(text = "count down: ${count.value}")
        Image(
            painter = painterResource(id = R.drawable.image3),
            contentDescription = "",
            modifier = Modifier.size(100.dp).clickable {
                count.value--
            }
        )
        Log.e("down", "end")
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview5() {
    DemoTheme {
        ButtonScreen()
    }
}