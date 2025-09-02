package org.basic.project.bottomBar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.VerifiedUser
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.VectorPainter
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.sp

object UserTabScreen : Tab {
    override val options: TabOptions

        @Composable
        get() {

            val icon: VectorPainter = rememberVectorPainter(Icons.Default.VerifiedUser)

            return remember {
                TabOptions(
                    index = 0u, title = "User", icon = icon
                )
            }
        }

    @Composable
    override fun Content() {
        Box(
            modifier = Modifier.fillMaxSize().background(Color.Cyan),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "User Screen",
                fontSize = 30.sp,
                color = Color.Black
            )
        }
    }

}