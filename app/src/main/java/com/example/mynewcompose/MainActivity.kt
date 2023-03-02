package com.example.mynewcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Device
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mynewcompose.ui.theme.MyNewComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyNewComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                    MyStateExample()
                }
            }
        }
    }
}


@Composable
fun MyColumn() {
    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceBetween) {
        Text(text = "Hola", modifier = Modifier.background(Color.Green))
        Text(text = "Hola", modifier = Modifier.background(Color.Cyan))
        Text(text = "Hola", modifier = Modifier.background(Color.Yellow))
        Text(text = "Hola", modifier = Modifier.background(Color.Red))

    }

}

@Composable
fun MyBox() {
    Column() {
        MySpacer(size = 20)
        Box(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f)
                .background(Color.Blue), Alignment.Center
        ) {
            Text(text = "1")
        }

        MySpacer(20)
        Row(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f)
                    .background(Color.Yellow), Alignment.Center
            ) {
                Text(text = "2")
            }

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f)
                    .background(Color.DarkGray), contentAlignment = Alignment.Center
            ) {
                Text(text = "3")
            }
        }

        MySpacer(size = 20)
        Box(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f)
                .background(Color.Red),
            Alignment.BottomCenter
        ) {
            Text(text = "4")
        }
        MySpacer(size = 20)

    }
}

@Composable
fun MySpacer(size: Int) {

    Spacer(modifier = Modifier.height(size.dp))

}


@Composable
fun MyStateExample() {
    var counter = 0

    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Button(onClick = { counter += 1 }) {
            Text(text = "Click here")

        }
        Text(text = "I've been click $counter times")

    }

}


@Preview(
    showBackground = true,
    showSystemUi = true,
    device = Devices.DEFAULT,
)
@Composable
fun DefaultPreview() {
    MyNewComposeTheme {
        MyStateExample()
    }
}