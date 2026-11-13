package com.example.myapplication1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            // Реальное приложение
            Column(
                modifier = Modifier.fillMaxSize().safeDrawingPadding().padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Hello(name = "Кирилл")
                Hello(name = null)
            }
        }
    }
}

@Composable
fun Hello(name: String?, modifier: Modifier = Modifier) {
    Text(
        text = if (name == null) "Имя не задано" else "Привет, $name!",
        modifier = modifier
    )
}

// ==========================================
// ЗАДАНИЕ 2: Три макета предпросмотра
// ==========================================

// 1. Портретная ориентация
@Preview(
    name = "portrait",
    showSystemUi = true,
    device = "spec:width=411dp,height=891dp"
)
@Composable
fun HelloPreviewPortrait() {
    // Оборачиваем в Surface (фон) и Column с отступами, чтобы текст не заезжал на статус-бар
    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.safeDrawingPadding().padding(16.dp)
        ) {
            Hello("Кирилл")
        }
    }
}

// 2. Альбомная ориентация
@Preview(
    name = "landscape",
    showSystemUi = true,
    device = "spec:width=891dp,height=411dp,orientation=landscape"
)
@Composable
fun HelloPreviewLandscape() {
    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.safeDrawingPadding().padding(16.dp)
        ) {
            Hello("Кирилл")
        }
    }
}

// 3. Круглый дисплей 200x200dp, желтый фон
@Preview(
    name = "round",
    showSystemUi = true,
    device = "spec:width=200dp,height=200dp,isRound=true",
    showBackground = true
)
@Composable
fun HelloPreviewRound() {
    // Box позволяет выравнивать контент по центру.
    // Modifier.background(Color.Yellow) красит саму область приложения в желтый.
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Yellow)
            .safeDrawingPadding(), // Отступы от системных элементов по кругу
        contentAlignment = Alignment.Center // Центрируем текст
    ) {
        Hello("Кирилл")
    }
}