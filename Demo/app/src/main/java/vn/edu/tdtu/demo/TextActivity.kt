package vn.edu.tdtu.demo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import vn.edu.tdtu.demo.ui.theme.DemoTheme

class TextActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DemoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    DemoText()
                }
            }
        }
    }
}

@Composable
fun TextScreen() {
    Column(modifier = Modifier.padding(25.dp))
    {
        DemoText()
        //Composable được sử dụng để thêm khoảng cách giữa các thành phần trong Compose UI
        Spacer(modifier = Modifier.height(10.dp))
        DemoText2()
        Spacer(modifier = Modifier.height(10.dp))
        DemoTextStyle()
        Spacer(modifier = Modifier.height(10.dp))
        DemoText3()
    }
}
@Composable
fun DemoText() {
    Text(
        text = stringResource(id = R.string.temp_text),
        color = Color.Blue,
        fontSize = 20.sp,
        fontWeight = FontWeight.Light,
        fontStyle = FontStyle.Italic,
        textAlign = TextAlign.Right,
        fontFamily = FontFamily.Cursive,
        textDecoration = TextDecoration.LineThrough,
    )
}

@Composable
fun DemoText2() {
    Text(
        text = stringResource(id = R.string.temp_text),
        color = Color.Magenta,
        fontSize = 25.sp,
        fontWeight = FontWeight.Bold,
        fontStyle = FontStyle.Normal,
        textAlign = TextAlign.Left,
        fontFamily = FontFamily.Monospace,
        textDecoration = TextDecoration.Underline,
        maxLines = 5,
        overflow = TextOverflow.Ellipsis,
    )
}

@Composable
fun DemoTextStyle() {
    val myTextStyle = TextStyle(
        color = Color.Green,
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        fontFamily = FontFamily.Monospace,
        textAlign = TextAlign.Center
    )

    Text(
        text = "This is my first text",
        modifier = Modifier.fillMaxWidth(),
        color = Color.Cyan,
        style = myTextStyle
    )
    Text(
        text = "This is my second text",
        modifier = Modifier.fillMaxWidth(),
        style = myTextStyle
    )
}

@Composable
fun DemoText3() {
    Text(
        text = buildAnnotatedString {
            append("Đã gửi mã ")
            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                append("OTP")
            }
            append(" về máy của bạn ")
            withStyle(style = SpanStyle(color = Color.Red, textDecoration = TextDecoration.Underline)) {
                append("59s")
            }
        },
        modifier = Modifier.fillMaxWidth(),
        textAlign = TextAlign.Center
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview3() {
    DemoTheme {
        TextScreen()
    }
}