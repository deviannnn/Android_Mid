package vn.edu.tdtu.demo

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import vn.edu.tdtu.demo.ui.theme.DemoTheme

class TextFieldActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DemoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    TextFieldScreen()
                }
            }
        }
    }
}

@Composable
fun TextFieldScreen() {
    Column(modifier = Modifier.padding(25.dp)) {
        DemoTextField()
        Spacer(modifier = Modifier.height(10.dp))
        DemoTextField2()
        Spacer(modifier = Modifier.height(10.dp))
        DemoTextField3()
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun DemoTextField() {
    val focusRequester1 = remember { FocusRequester() }
    val focusRequester2 = remember { FocusRequester() }
    val userKeyboard = LocalSoftwareKeyboardController.current
    Column {
        var email by remember {
            mutableStateOf("")
        }
        Log.e("Textfield", "Type in Email")
        TextField(
            value = email,
            onValueChange = {edited -> email = edited},
            textStyle = TextStyle(color = Color.White, fontSize = 20.sp),
            label = { Text(text = "Email", color = Color.Magenta)},
            placeholder = { Text(text = "Nhập Email", color = Color.White)},
            leadingIcon = { Icon(Icons.Default.Email, "")},
            trailingIcon = { IconButton(onClick = { /*TODO*/ }) {
                Icon(Icons.Default.Clear, "" )
            }},
            shape = RoundedCornerShape(15.dp),
            colors =  TextFieldDefaults.textFieldColors(
                backgroundColor = Color.Black,
                leadingIconColor = Color.Cyan,
                trailingIconColor = Color.Cyan,
                cursorColor = Color.Cyan
            ),
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Next,
                keyboardType = KeyboardType.Email,
            ),
            keyboardActions = KeyboardActions(
                onNext = { focusRequester2.requestFocus() }
            ),
            modifier = Modifier.focusRequester(focusRequester1)
        )
        Log.e("Textfield", "Type out Email")

        var name by rememberSaveable {
            mutableStateOf("")
        }
        OutlinedTextField(
            value = name,
            onValueChange = {
                name = it
            },
            label = { Text(text = "Fullname", color = Color.Magenta)},
            placeholder = { Text(text = "Nhập họ tên", color = Color.Black)},
            leadingIcon = { Icon(Icons.Default.Person, "")},
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Done,
                capitalization = KeyboardCapitalization.Words
            ),
            keyboardActions = KeyboardActions(
                onDone = { userKeyboard?.hide() }
            ),
            modifier = Modifier.focusRequester(focusRequester2)
        )
    }

}

@Composable
fun DemoTextField2() {
    Log.e("Textfield", "Type in Phone")
    var phone by remember {
        mutableStateOf("")
    }
    OutlinedTextField(
        value = phone,
        onValueChange = {
            phone = it
        },
        label = { Text(text = "Phone Number", color = Color.Magenta)},
        placeholder = { Text(text = "Nhập số điện thoại", color = Color.Black)},
        leadingIcon = { Icon(Icons.Default.Phone, "")},
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Search,
            keyboardType = KeyboardType.Phone,
        ),
    )
    Log.e("Textfield", "Type out Phone")
}

@Composable
fun DemoTextField3() {
    var pw by remember {
        mutableStateOf("")
    }
    var show by remember {
        mutableStateOf(false)
    }
    OutlinedTextField(
        value = pw,
        onValueChange = {
            pw = it
        },
        label = { Text(text = "Password", color = Color.Magenta)},
        placeholder = { Text(text = "Nhập mật khẩu", color = Color.Black)},
        leadingIcon = { Icon(Icons.Default.Lock, "")},
        trailingIcon = { IconButton(onClick = {
            show = !show
        }) {
            Icon(if (show) Icons.Default.KeyboardArrowDown else Icons.Default.KeyboardArrowUp, "")}
        },
        visualTransformation = if (show) VisualTransformation.None else PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Send,
            keyboardType = KeyboardType.Password,
        )
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview7() {
    DemoTheme {
        TextFieldScreen()
    }
}