package vn.edu.tdtu.demo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import vn.edu.tdtu.demo.ui.theme.DemoTheme

class ImageActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DemoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ImageScreen()
                }
            }
        }
    }
}

@Composable
fun ImageScreen() {
    Column(modifier = Modifier.padding(25.dp)) {
        DemoImage()
        Spacer(modifier = Modifier.height(10.dp))
        DemoImage2()
        Spacer(modifier = Modifier.height(10.dp))
        DemoImage3()
    }
}

@Composable
fun DemoImage() {
    Image(
        painter = painterResource(id = R.drawable.image1),
        contentDescription = "",
        modifier =  Modifier.size(200.dp)
            .border(BorderStroke(5.dp, color = Color.Green)),
        alignment = Alignment.Center
    )
}

@Composable
fun DemoImage2() {
    Image(
        painter = painterResource(id = R.drawable.image2),
        contentDescription = "",
        modifier = Modifier.height(150.dp)
            .fillMaxWidth()
            .shadow(elevation = 40.dp, shape = RoundedCornerShape(50.dp)),
    )
}

@Composable
fun DemoImage3() {
    Surface(
        modifier = Modifier.border(
                BorderStroke(2.dp, color = Color.Red),
                shape = CircleShape
            )
            .clip(shape = CircleShape)
    ) {
        Image(
            painter = painterResource(id = R.drawable.image3),
            contentDescription = "",
            modifier = Modifier.size(200.dp)
        )
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview4() {
    DemoTheme {
        ImageScreen()
    }
}