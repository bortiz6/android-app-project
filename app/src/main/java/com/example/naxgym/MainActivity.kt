package com.example.naxgym

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.offset
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.example.naxgym.ui.theme.NaxGymTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            NaxGymTheme {
                MyApp()
            }
        }
    }
}

@Composable
fun MyApp() {
    var currentScreen by remember { mutableStateOf("home") }

    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->

        when (currentScreen) {
            "home" -> HomeScreen(
                innerPadding = innerPadding,
                onNavigateToSecondScreen = { currentScreen = "second" }
            )

            "second" -> SecondScreen(
                innerPadding = innerPadding,
                onBackToHome = { currentScreen = "home" }
            )
        }
    }
}

@Composable
fun HomeScreen(
    innerPadding: PaddingValues,
    onNavigateToSecondScreen: () -> Unit
)

{
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "NaxGym",
            style = MaterialTheme.typography.headlineLarge,
            color = Color.Blue,
            fontSize = 70.sp
        )

        Spacer(modifier = Modifier.height(300.dp))



        Image(
            painter = painterResource(
                id = R.drawable.dumbbells_clipart_gym_machine_dumbbell_gym_art
            ),
            contentDescription = "Gym Image",
            modifier = Modifier
                .height(180.dp)
                .offset(y = (-180.dp))
                .clickable {
                    onNavigateToSecondScreen()
                },
            contentScale = ContentScale.Fit

        )
    }
}

@Composable
fun SecondScreen(
    innerPadding: PaddingValues,
    onBackToHome: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Workout Screen",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "This screen will show workout features."
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(onClick = onBackToHome) {
            Text("Back to Home")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewHomeScreen() {
    NaxGymTheme {
        HomeScreen(
            innerPadding = PaddingValues(0.dp),
            onNavigateToSecondScreen = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSecondScreen() {
    NaxGymTheme {
        SecondScreen(
            innerPadding = PaddingValues(0.dp),
            onBackToHome = {}
        )
    }
}