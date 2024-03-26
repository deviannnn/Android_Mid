package vn.edu.tdtu.demo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import vn.edu.tdtu.demo.ui.theme.DemoTheme

class LayoutActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DemoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    DemoBoxLayout()
                }
            }
        }
    }
}

@Composable
fun DemoBoxLayout() {
    Box(
    ) {
        Box(
            modifier = Modifier
                .background(Color.Blue)
                .size(200.dp)
                .align(Alignment.Center)
        )
        Box(
            modifier = Modifier
                .background(Color.Green)
                .size(150.dp)
                .align(Alignment.BottomEnd)
        )
        Box(
            modifier = Modifier
                .background(Color.Yellow)
                .size(100.dp)
                .align(Alignment.TopCenter)
        )
    }
}

@Composable
fun DemoColumnLayout() {
    Box {
        Column (
            modifier = Modifier
                .size(400.dp, 300.dp)
                .background(color = Color.LightGray),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(text = "Hello")
            Text(text = "new")
            Text(text = "world")
        }
    }
}

@Composable
fun DemoRowLayout() {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = "Hello")
        Text(text = "new")
        Text(text = "world")
    }
}


@Composable
fun DemoScroll() {
    Box {
        Column(
            modifier = Modifier
                .size(400.dp, 300.dp)
                .background(color = Color.LightGray)
                .verticalScroll(
                    rememberScrollState()
                )
        ) {
            Box(
                modifier = Modifier
                    .background(Color.Blue)
                    .size(100.dp)
            )
            Box(
                modifier = Modifier
                    .background(Color.Green)
                    .size(100.dp)
            )
            Box(
                modifier = Modifier
                    .background(Color.Yellow)
                    .size(100.dp)
            )
            Box(
                modifier = Modifier
                    .background(Color.Blue)
                    .size(100.dp)
            )
            Box(
                modifier = Modifier
                    .background(Color.Green)
                    .size(100.dp)
            )
            Box(
                modifier = Modifier
                    .background(Color.Yellow)
                    .size(100.dp)
            )
        }
    }
}

@Composable
fun DemoWeight() {
    Row {
        Box(
            modifier = Modifier
                .weight(1f)
                .background(Color.Blue)
                .height(100.dp)
        )
        Box(
            modifier = Modifier
                .weight(2f)
                .background(Color.Green)
                .height(100.dp)
        )
        Box(
            modifier = Modifier
                .weight(1f)
                .background(Color.Yellow)
                .height(100.dp)
        )
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview2() {
    DemoTheme {
//        DemoBoxLayout()
//        DemoColumnLayout()
//        DemoRowLayout()
//        DemoScroll()
        DemoWeight()
    }
}