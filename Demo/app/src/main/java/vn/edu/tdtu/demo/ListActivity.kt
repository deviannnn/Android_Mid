package vn.edu.tdtu.demo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import vn.edu.tdtu.demo.ui.theme.DemoTheme

class ListActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DemoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ListScreen()
                }
            }
        }
    }
}

@Composable
fun ListScreen() {
    Column(modifier = Modifier.padding(25.dp)) {
        DemoLazyRow()
        Spacer(modifier = Modifier.padding(10.dp))
        DemoLazyColumn()
    }
}

@Composable
fun DemoLazyRow() {
    LazyRow {
        items(50) { index ->
            Text(text = "Row ${index}")
        }
    }
}

@Composable
fun DemoLazyColumn() {
    data class Person(val name: String, val age: Int)

    val personList = listOf(
        Person("Alice", 25),
        Person("Bob", 30),
        Person("Charlie", 20),
        Person("Alice", 25),
        Person("Bob", 30),
        Person("Charlie", 20),
        Person("Alice", 25),
        Person("Bob", 30),
        Person("Charlie", 20),
        Person("Alice", 25),
        Person("Bob", 30),
        Person("Charlie", 20),
        Person("Alice", 25),
        Person("Bob", 30),
        Person("Charlie", 20),
        Person("Alice", 25),
        Person("Bob", 30),
        Person("Charlie", 20),
        Person("Charlie", 20),
        Person("Alice", 25),
        Person("Bob", 30),
        Person("Charlie", 20),
        Person("Alice", 25),
        Person("Bob", 30),
        Person("Charlie", 20),
    )

    LazyColumn {
        items(personList) { person ->
            Text(
                text = "Name: ${person.name}, Age: ${person.age}",
                fontSize = 30.sp
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview8() {
    DemoTheme {
        ListScreen()
    }
}