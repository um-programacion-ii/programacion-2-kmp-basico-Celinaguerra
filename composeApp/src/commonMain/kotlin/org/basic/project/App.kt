package org.basic.project

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.currentOrThrow
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import kmpbasico.composeapp.generated.resources.Res
import kmpbasico.composeapp.generated.resources.compose_multiplatform

@Composable
fun App() {
    MaterialTheme {
        Navigator(
            screen = MainScreen()
        )
    }
}

class MainScreen: Screen {
    @Composable
    override fun Content() {

        val navigator: Navigator = LocalNavigator.currentOrThrow
        var name: String by remember { mutableStateOf("") }
        var pw: String by remember { mutableStateOf("") }

        Column(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.primaryContainer)
                .safeContentPadding()
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextField(
                value = name,
                onValueChange = {
                    name = it
                }
            )

            Spacer(modifier = Modifier.height(40.dp))

            if (name.isNotEmpty()) {
                Text(
                    text = "Ingreso: $name",
                    fontSize = 20.sp
                )
            }

            Spacer(modifier = Modifier.height(40.dp))

            AnimatedVisibility(name.isNotEmpty()) {
                Text(
                    text = "Version animada $name",
                    fontSize = 24.sp
                )
            }

            TextField(
                value = pw,
                onValueChange = {
                    pw = it
                }
            )

            AnimatedVisibility(pw.isNotEmpty()) {
                Text(
                    text = "Contraseña: $pw",
                    fontSize = 20.sp
                )
            }

            Spacer(modifier = Modifier.height(30.dp))

            Button(
                onClick = {
                    navigator.push(SecondScreen())
                }
            ) {
                Text(
                    text = "Navegando"
                )
            }

            Spacer(modifier = Modifier.height(30.dp))

            Button(
                onClick = {
                    navigator.push(ThirdScreen())
                }
            ) {
                Text(
                    text = "Vamos a la Tercera Pantalla!!"
                )
            }
        }
    }
}

class SecondScreen: Screen {
    @Composable
    override fun Content() {
        val navigator: Navigator=LocalNavigator.currentOrThrow
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Yellow),
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Segunda pantalla",
                fontSize = 20.sp,
                color = Color.Black
            )

            Spacer(
                modifier = Modifier
                    .height(20.dp)
            )

            Button(
                onClick = {
                    navigator.pop()
                }
            ) {
                Text(
                    text = "Vamos para atras"
                )
            }
        }
    }
}

class ThirdScreen: Screen {
    @Composable
    override fun Content() {
        val navigator: Navigator=LocalNavigator.currentOrThrow
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Magenta),
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Tercera pantalla (La más linda)",
                fontSize = 20.sp,
                color = Color.Black
            )

            Spacer(
                modifier = Modifier
                    .height(20.dp)
            )

            Button(
                onClick = {
                    navigator.pop()
                }
            ) {
                Text(
                    text = "Vamos a la primera pantalla!!!"
                )
            }
        }
    }
}


//boton en la main screen que lleve a 3ra pantalla que tenga un boton para volver a la primera