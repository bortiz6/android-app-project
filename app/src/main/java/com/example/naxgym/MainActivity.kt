package com.example.naxgym

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.FileDownload
import androidx.compose.material.icons.outlined.History
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.PieChart
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            NaxGymApp()
        }
    }
}

@Composable
fun NaxGymApp() {

    var currentScreen by remember {
        mutableStateOf("home")
    }

    if (currentScreen == "home") {

        HomeScreen(
            onImageClick = {
                currentScreen = "overview"
            }
        )

    } else {

        OverviewScreen(
            onHomeClick = {
                currentScreen = "home"
            }
        )
    }
}

@Composable
fun HomeScreen(onImageClick: () -> Unit) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray)
            .padding(24.dp),

        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(80.dp))

        Text(
            text = "NaxGym",
            fontSize = 40.sp,
            color = Color.Blue
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Tap the dumbbell to view workouts",
            fontSize = 20.sp
        )

        Spacer(modifier = Modifier.height(100.dp))

        Image(
            painter = painterResource(
                id = R.drawable.dumbbells_clipart_gym_machine_dumbbell_gym_art
            ),

            contentDescription = "Dumbbell",

            modifier = Modifier
                .size(220.dp)
                .clickable {
                    onImageClick()
                }
        )
    }
}

@Composable
fun OverviewScreen(onHomeClick: () -> Unit) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFEDEDED))
            .padding(20.dp)
    ) {

        Spacer(modifier = Modifier.height(50.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),

            horizontalArrangement = Arrangement.SpaceBetween,

            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = "Overview",
                fontSize = 32.sp
            )

            Icon(
                imageVector = Icons.Outlined.AccountCircle,
                contentDescription = "Profile",
                modifier = Modifier.size(38.dp)
            )
        }

        Spacer(modifier = Modifier.height(30.dp))

        Image(
            painter = painterResource(
                id = R.drawable.bar_graph
            ),

            contentDescription = "Bar Graph",

            modifier = Modifier
                .fillMaxWidth()
                .height(190.dp)
        )

        Spacer(modifier = Modifier.height(30.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),

            horizontalArrangement = Arrangement.SpaceEvenly
        ) {

            Column {

                StatText("Sets", "3")
                StatText("Reps", "12")
                StatText("Workouts", "6")
            }

            Column {

                StatText("Days", "1")
                StatText("Hours", "2")
                StatText("Water intake", "1.2 liters")
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        BottomNavigationBar(onHomeClick)
    }
}

@Composable
fun StatText(title: String, value: String) {

    Column {

        Text(
            text = title,
            fontSize = 24.sp
        )

        Text(
            text = value,
            fontSize = 24.sp
        )

        Spacer(modifier = Modifier.height(10.dp))
    }
}

@Composable
fun BottomNavigationBar(onHomeClick: () -> Unit) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp),

        horizontalArrangement = Arrangement.SpaceEvenly
    ) {

        BottomItem(
            icon = Icons.Outlined.Home,
            label = "Home",
            onClick = onHomeClick
        )

        BottomItem(
            icon = Icons.Outlined.PieChart,
            label = "Stats",
            onClick = {}
        )

        BottomItem(
            icon = Icons.Outlined.FileDownload,
            label = "Start",
            onClick = {}
        )

        BottomItem(
            icon = Icons.Outlined.History,
            label = "History",
            onClick = {}
        )

        BottomItem(
            icon = Icons.Outlined.Settings,
            label = "Settings",
            onClick = {}
        )
    }
}

@Composable
fun BottomItem(
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    label: String,
    onClick: () -> Unit
) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,

        modifier = Modifier.clickable {
            onClick()
        }
    ) {

        Icon(
            imageVector = icon,
            contentDescription = label,
            modifier = Modifier.size(30.dp)
        )

        Text(
            text = label,
            fontSize = 12.sp
        )
    }
}