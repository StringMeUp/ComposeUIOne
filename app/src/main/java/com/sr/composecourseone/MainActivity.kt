package com.sr.composecourseone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sr.composecourseone.ui.theme.ComposeCourseOneTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeCourseOneTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background) {
                    ShowBizzCard()
                }
            }
        }
    }
}

@Composable
fun ShowBizzCard() {
    Surface(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()) {
        Card(modifier = Modifier
            .padding(12.dp)
            .width(200.dp)
            .height(390.dp),
            shape = RoundedCornerShape(CornerSize(15.dp)),
            elevation = 4.dp,
            backgroundColor = Color.White) {
            Column(Modifier
                .width(IntrinsicSize.Max)
                .height(200.dp)
                .padding(12.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                ProfilePicture()
                Divider(
                    modifier = Modifier.padding(top = 12.dp),
                    thickness = 3.dp,
                    color = Color.Black)
                UserInfo()
            }

            Column(verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.CenterHorizontally) {
                TextButton(modifier = Modifier
                    .width(200.dp)
                    .padding(top = 12.dp, bottom = 46.dp),
                    onClick = { print("This is the shit") },
                    colors = ButtonDefaults.textButtonColors(colorResource(
                        id = R.color.purple_200))) {
                    Text(text = "click me", color = Color.White)
                }
            }
        }
    }
}


@Composable
fun ProfilePicture() {
    Column(horizontalAlignment = Alignment.Start) {
        Surface(Modifier
            .size(150.dp)
            .background(Color.Transparent)
            .padding(4.dp),
            shape = CircleShape,
            border = BorderStroke(2.dp, Color.DarkGray)
        ) {
            Image(painterResource(
                id = R.drawable.ic_profile),
                contentDescription = "Just an image")
        }
    }
}


@Composable
private fun UserInfo() {
    Column(Modifier
        .fillMaxWidth()
        .padding(top = 12.dp)) {
        Text(text = "Jon Doe", modifier = Modifier.padding(4.dp))
        Text(text = "Job: Developer", modifier = Modifier.padding(4.dp))
        Text(text = "E-mail: jon.doe@gmail.com", modifier = Modifier.padding(4.dp))
    }
}

@Composable
private fun Test() {
    Surface(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()) {
        Column(modifier = Modifier.width(IntrinsicSize.Max)) {
            Text(text = "One")
            Text(
                text = "Two",
                textAlign = TextAlign.Center,
                modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
            )
            Text(text = "Three", Modifier.align(alignment = Alignment.End))
            Text(text = "Four", Modifier.align(alignment = Alignment.Start))
           RadioButton(selected = true,
                onClick = { /*TODO*/ },
                modifier = Modifier.align(alignment = Alignment.CenterHorizontally))
        }
    }
}

/* Simple state hoistig */
@Composable
fun HelloScreen() {
    var name: String by rememberSaveable { mutableStateOf("") }
    HelloContent(name = name, onNameChange = { name = it })
}

@Composable
fun HelloContent(name: String, onNameChange: (String) -> Unit) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = "Hello, $name",
            modifier = Modifier.padding(bottom = 8.dp),
            style = MaterialTheme.typography.body1
        )
        OutlinedTextField(value = name, onValueChange = onNameChange, label = { Text("Name") })
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeCourseOneTheme {
        HelloScreen()
    }
}