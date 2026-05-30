package com.attendx.app.core.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val AttendXColorScheme = lightColorScheme(
    primary = Brand,
    onPrimary = Surface,
    background = Canvas,
    onBackground = Ink,
    surface = Surface,
    onSurface = Ink,
    outline = Border,
)

@Composable
fun AttendXTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = AttendXColorScheme,
        typography = AttendXTypography,
        content = content,
    )
}

