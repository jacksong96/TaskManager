package com.example.taskmanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.taskmanager.ui.theme.TaskManagerTheme
import androidx.compose.foundation.Image
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TaskManagerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    TaskManagerImage(stringResource(R.string.completion_status), stringResource(R.string.message))
                }
            }
        }
    }
}

@Composable
fun TaskManagerImage(completion: String, message: String){
    val image = painterResource(R.drawable.ic_task_completed)
    Column(verticalArrangement = Arrangement.Center)
    {
        Image(
            painter = image,
            contentDescription = "Giant Tick",
            modifier = Modifier.fillMaxWidth().wrapContentSize(Alignment.Center)
        )
        TaskManagerText(completion = completion, message = message)
    }
}


@Composable
fun TaskManagerText(completion: String, message: String) {
    Column {
        Text(
            text = completion,
            fontSize = 24.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp, bottom = 8.dp)
        )
        Text(
            text = message,
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TaskManagerTheme {
        TaskManagerImage(stringResource(R.string.completion_status), stringResource(R.string.message))
    }
}