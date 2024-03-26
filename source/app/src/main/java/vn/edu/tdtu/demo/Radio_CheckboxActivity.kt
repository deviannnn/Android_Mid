package vn.edu.tdtu.demo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import vn.edu.tdtu.demo.ui.theme.DemoTheme

class Radio_CheckboxActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DemoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    CommonScreen()
                }
            }
        }
    }
}

@Composable
fun CommonScreen() {
    Column(modifier = Modifier.padding(25.dp)) {
        DemoRadioButton()
        Spacer(modifier = Modifier.height(10.dp))
        DemoRadioButton2()
        Spacer(modifier = Modifier.height(10.dp))
        DemoCheckBox()
        Spacer(modifier = Modifier.height(10.dp))
        DemoCheckBox2()
    }
}

@Composable
fun DemoRadioButton() {
    var selectedOption by remember {
        mutableStateOf(0)
    }
    Column {
        RadioButton(
            selected = selectedOption == 0, onClick = { selectedOption = 0 },
            colors = RadioButtonDefaults.colors(
                selectedColor = Color.Green,
                unselectedColor = Color.Red,
                disabledColor = Color.Gray
            )
        )
        RadioButton(
            selected = selectedOption == 1, onClick = { selectedOption = 1 },
            colors = RadioButtonDefaults.colors(
                selectedColor = Color.Green,
                unselectedColor = Color.Red,
                disabledColor = Color.Gray
            )
        )
        RadioButton(
            selected = selectedOption == 2, onClick = { selectedOption = 2 },
            colors = RadioButtonDefaults.colors(
                selectedColor = Color.Green,
                unselectedColor = Color.Red,
                disabledColor = Color.Gray
            ),
            enabled = false
        )
    }

}

@Composable
fun DemoRadioButton2() {
    var selectedOption by remember { mutableStateOf(0) }
    val options = listOf("Option 1", "Option 2", "Option 3") //0,1,2

    Column {
        options.forEachIndexed { index, label ->
            Row (
                modifier = Modifier.clickable(
                    onClick = { selectedOption = index },
                    role = Role.RadioButton
                ).padding(10.dp)
            ) {
                RadioButton(
                    selected = (index == selectedOption), onClick = null,
                    colors = RadioButtonDefaults.colors(
                        selectedColor = Color.Green,
                        unselectedColor = Color.Red,
                    )
                )
                Text(text = label)
            }
        }
    }
}

@Composable
fun DemoCheckBox() {
    Column {
        Checkbox(
            checked = true, onCheckedChange = {},
            colors = CheckboxDefaults.colors(
                checkedColor = Color.Green,
                uncheckedColor = Color.Red,
                disabledColor = Color.Gray
            )
        )
        Checkbox(
            checked = false, onCheckedChange = {},
            colors = CheckboxDefaults.colors(
                checkedColor = Color.Green,
                uncheckedColor = Color.Red,
                disabledColor = Color.Gray
            )
        )
        Checkbox(
            checked = true, onCheckedChange = {},
            colors = CheckboxDefaults.colors(
                checkedColor = Color.Green,
                uncheckedColor = Color.Red,
                disabledColor = Color.Gray
            ),
            enabled = false
        )
    }

}

@Composable
fun DemoCheckBox2() {
    val selectedOptions = remember { mutableStateListOf<String>() }
    val options = listOf("Option 1", "Option 2", "Option 3")
    Column {
        options.forEach { label ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.clickable(
                    onClick = {
                        if (selectedOptions.contains(label)) {
                            selectedOptions.remove(label)
                        } else {
                            selectedOptions.add(label)
                        }
                    },
                    role = Role.Checkbox
                )
            ) {
                val isSelected = selectedOptions.contains(label)
                Checkbox(
                    checked = isSelected,
                    onCheckedChange = {
                        if (it) {
                            selectedOptions.add(label)
                        } else {
                            selectedOptions.remove(label)
                        }
                    },
                    colors = CheckboxDefaults.colors(
                        checkedColor = Color.Green,
                        uncheckedColor = Color.Red
                    )
                )
                Text(text = label)
            }
        }
        Text("Selected: ${selectedOptions.joinToString()}")
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview6() {
    DemoTheme {
        CommonScreen()
    }
}