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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.attendx.app.attendance.domain.model.RiskStatus
import com.attendx.app.attendance.domain.model.SubjectAttendance
import com.attendx.app.core.theme.Brand
import com.attendx.app.core.theme.BrandSoft
import com.attendx.app.core.theme.Critical
import com.attendx.app.core.theme.MutedInk
import com.attendx.app.core.theme.Safe
import com.attendx.app.core.theme.Warning

@Composable
fun SubjectAttendanceCard(
    subject: SubjectAttendance,
    onPresentClick: () -> Unit,
    onAbsentClick: () -> Unit,
    onCancelledClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val progressColor = when (subject.riskStatus) {
        RiskStatus.SAFE -> Safe
        RiskStatus.WARNING -> Warning
        RiskStatus.CRITICAL -> Critical
    }

    Surface(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        color = MaterialTheme.colorScheme.surface,
        tonalElevation = 1.dp,
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .size(42.dp)
                        .background(BrandSoft, CircleShape),
                    contentAlignment = Alignment.Center,
                ) {
                    Text(
                        text = subject.name.take(1),
                        color = Brand,
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Bold,
                    )
                }

                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = 12.dp),
                ) {
                    Text(text = subject.name, style = MaterialTheme.typography.titleMedium)

                    subject.facultyName?.let { facultyName ->
                        Text(
                            text = facultyName,
                            color = MutedInk,
                            style = MaterialTheme.typography.bodyMedium,
                        )
                    }

                    Text(
                        text = "${subject.attendedClasses} of ${subject.totalClasses} classes attended",
                        color = MutedInk,
                        style = MaterialTheme.typography.bodyMedium,
                    )
                }

                Text(
                    text = "${subject.attendancePercentage}%",
                    color = progressColor,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                )
            }

            Spacer(modifier = Modifier.height(15.dp))

            LinearProgressIndicator(
                progress = { subject.attendancePercentage / 100f },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(6.dp),
                color = progressColor,
                trackColor = Color(0xFFF0F1F5),
            )

            Spacer(modifier = Modifier.height(13.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Text(
                    text = "${subject.safeBunkCount} safe bunks",
                    color = MutedInk,
                    style = MaterialTheme.typography.bodyMedium,
                )

                RiskStatusBadge(status = subject.riskStatus)
            }

            Spacer(modifier = Modifier.height(14.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                Button(
                    onClick = onPresentClick,
                    modifier = Modifier.weight(1f),
                ) {
                    Text("Present")
                }

                Button(
                    onClick = onAbsentClick,
                    modifier = Modifier.weight(1f),
                ) {
                    Text("Absent")
                }

                OutlinedButton(
                    onClick = onCancelledClick,
                    modifier = Modifier.weight(1f),
                ) {
                    Text("Cancel")
                }
            }
        }
    }
}