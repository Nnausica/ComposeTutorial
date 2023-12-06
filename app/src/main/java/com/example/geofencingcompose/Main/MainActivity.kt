package com.example.geofencingcompose.Main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.geofencingcompose.R
import com.example.geofencingcompose.ui.theme.GeofencingComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GeofencingComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AndroidBugGreeting(
                        getString(R.string.hello_lil_android_bug),
                        getString(R.string.you_industrious_coder_you)
                    )
                }
            }
        }
    }
}

@Composable
fun GreetingText(message: String, from: String, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        Text(
            text = message,
            fontSize = 60.sp,
            lineHeight = 60.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(16.dp)
        )
        Text(
            text = from,
            fontSize = 30.sp,
            lineHeight = 30.sp,
            color = Color.Magenta,
            fontStyle = FontStyle.Italic,
            modifier = Modifier
                .padding(8.dp)
                .align(alignment = Alignment.CenterHorizontally)

        )
    }
}

@Composable
fun AndroidBugGreeting(message: String, from: String, modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
    ) {
        GreetingText(
            message = message,
            from = from,
            modifier = Modifier
        )
        LocationPermissionsButton(
            modifier = Modifier
        )
    }
}


//pascal case, always a noun
@Composable
fun LocationPermissionsButton(modifier: Modifier = Modifier) {

    var result by remember { mutableStateOf(1) }
    val imageResource = when (result) {
        1 -> R.drawable.androidbug1
        2 -> R.drawable.androidbug2
        else -> R.drawable.androidbug3
    }

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(imageResource),
            contentDescription = "Android bug",
            contentScale = ContentScale.FillWidth,
            alpha = 0.9F,
            modifier = Modifier
                .background(color = Color.Blue)
        )
        Button(
            onClick = { result = (1..3).random() },
            modifier = Modifier
        ) {
            Text(stringResource(R.string.lets_go_on_an_adventure))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GeofencingComposeTheme {
        AndroidBugGreeting(
            message = "Hello 'lil Android Bug",
            from = "you industrious coder you"
        )
    }
}