package com.attendx.app.attendance.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.attendx.app.attendance.domain.model.RiskStatus
import com.attendx.app.core.theme.Critical
import com.attendx.app.core.theme.CriticalSoft
import com.attendx.app.core.theme.Safe
import com.attendx.app.core.theme.SafeSoft
import com.attendx.app.core.theme.Warning
import com.attendx.app.core.theme.WarningSoft

@Composable
fun RiskStatusBadge(status: RiskStatus, modifier: Modifier = Modifier) {
    val (label, background, foreground) = when (status) {
        RiskStatus.SAFE -> Triple("Safe", SafeSoft, Safe)
        RiskStatus.WARNING -> Triple("Warning", WarningSoft, Warning)
        RiskStatus.CRITICAL -> Triple("Critical", CriticalSoft, Critical)
    }

    Text(
        text = label,
        modifier = modifier
            .background(background, RoundedCornerShape(50))
            .padding(horizontal = 10.dp, vertical = 5.dp),
        color = foreground,
        fontSize = 12.sp,
        fontWeight = FontWeight.SemiBold,
    )
}

