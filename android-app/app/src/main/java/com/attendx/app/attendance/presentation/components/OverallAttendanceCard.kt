package com.attendx.app.attendance.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.attendx.app.attendance.domain.model.AttendanceSummary
import com.attendx.app.core.theme.Brand
import com.attendx.app.core.theme.BrandSoft
import com.attendx.app.core.theme.MutedInk

@Composable
fun OverallAttendanceCard(summary: AttendanceSummary, modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(24.dp),
        color = MaterialTheme.colorScheme.surface,
        tonalElevation = 1.dp,
    ) {
        Row(
            modifier = Modifier.padding(20.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(20.dp),
        ) {
            Box(contentAlignment = Alignment.Center) {
                CircularProgressIndicator(
                    progress = { summary.overallPercentage / 100f },
                    modifier = Modifier.size(104.dp),
                    color = Brand,
                    trackColor = BrandSoft,
                    strokeWidth = 10.dp,
                )
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = "${summary.overallPercentage}%",
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold,
                    )
                    Text(text = "overall", color = MutedInk, fontSize = 11.sp)
                }
            }
            Column(modifier = Modifier.weight(1f)) {
                Text(text = "Overall attendance", style = MaterialTheme.typography.titleLarge)
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = "Across ${summary.subjects.size} subjects",
                    color = MutedInk,
                    style = MaterialTheme.typography.bodyMedium,
                )
                Spacer(modifier = Modifier.height(14.dp))
                Row(
                    modifier = Modifier
                        .background(BrandSoft, RoundedCornerShape(14.dp))
                        .padding(horizontal = 12.dp, vertical = 9.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(
                        text = "${summary.totalSafeBunks}",
                        color = Brand,
                        fontWeight = FontWeight.Bold,
                    )
                    Text(
                        text = "  safe bunks available",
                        color = Color(0xFF5346B9),
                        style = MaterialTheme.typography.bodyMedium,
                    )
                }
            }
        }
    }
}

