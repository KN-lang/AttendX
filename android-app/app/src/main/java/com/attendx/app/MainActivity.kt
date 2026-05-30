package com.attendx.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.attendx.app.attendance.presentation.AttendanceFlowRoute
import com.attendx.app.core.theme.AttendXTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AttendXTheme {
                AttendanceFlowRoute()
            }
        }
    }
}
