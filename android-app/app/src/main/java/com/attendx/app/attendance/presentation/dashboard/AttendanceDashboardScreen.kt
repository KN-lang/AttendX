package com.attendx.app.attendance.presentation.dashboard

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.attendx.app.attendance.domain.model.AttendanceStatus
import com.attendx.app.attendance.presentation.components.OverallAttendanceCard
import com.attendx.app.attendance.presentation.components.RiskStatusBadge
import com.attendx.app.attendance.presentation.components.SubjectAttendanceCard
import com.attendx.app.core.theme.MutedInk


@Composable
fun AttendanceDashboardScreen(
    uiState: AttendanceDashboardUiState,
    onAddSubjectClick: () -> Unit,
    onMarkAttendance: (String, AttendanceStatus) -> Unit,
    modifier: Modifier = Modifier,
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        floatingActionButton = {
            ExtendedFloatingActionButton(
                onClick = onAddSubjectClick,
                text = { Text(text = "Add subject", fontWeight = FontWeight.SemiBold) },
                icon = { Text(text = "+", style = MaterialTheme.typography.headlineSmall) },
            )
        },
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentPadding = PaddingValues(horizontal = 20.dp, vertical = 22.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp),
        ) {
            item {
                Column(modifier = Modifier.padding(bottom = 8.dp)) {
                    Text(text = "AttendX", style = MaterialTheme.typography.headlineLarge)
                    Text(
                        text = "Track your classes. Stay on target.",
                        color = MutedInk,
                        style = MaterialTheme.typography.bodyLarge,
                    )
                }
            }

            item {
                OverallAttendanceCard(summary = uiState.summary)
            }

            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    Text(text = "Your subjects", style = MaterialTheme.typography.headlineSmall)
                    RiskStatusBadge(status = uiState.summary.riskStatus)
                }
            }

            items(
                items = uiState.summary.subjects,
                key = { it.id },
            ) { subject ->
                SubjectAttendanceCard(
                    subject = subject,
                    onPresentClick = {
                        onMarkAttendance(subject.id, AttendanceStatus.PRESENT)
                    },
                    onAbsentClick = {
                        onMarkAttendance(subject.id, AttendanceStatus.ABSENT)
                    },
                    onCancelledClick = {
                        onMarkAttendance(subject.id, AttendanceStatus.CANCELLED)
                    },
                )
            }
        }
    }
}


// @Composable
// fun AttendanceDashboardScreen(
    
    
//     // uiState: AttendanceDashboardUiState,
//     // onAddSubjectClick: () -> Unit,
//     // modifier: Modifier = Modifier,
// ) {
//     Scaffold(
//         modifier = modifier.fillMaxSize(),
//         floatingActionButton = {
//             ExtendedFloatingActionButton(
//                 onClick = onAddSubjectClick,
//                 text = { Text(text = "Add subject", fontWeight = FontWeight.SemiBold) },
//                 icon = { Text(text = "+", style = MaterialTheme.typography.headlineSmall) },
//             )
//         },
//     ) { innerPadding ->
//         LazyColumn(
//             modifier = Modifier
//                 .fillMaxSize()
//                 .padding(innerPadding),
//             contentPadding = PaddingValues(horizontal = 20.dp, vertical = 22.dp),
//             verticalArrangement = Arrangement.spacedBy(14.dp),
//         ) {
//             item {
//                 Column(modifier = Modifier.padding(bottom = 8.dp)) {
//                     Text(text = "AttendX", style = MaterialTheme.typography.headlineLarge)
//                     Text(
//                         text = "Track your classes. Stay on target.",
//                         color = MutedInk,
//                         style = MaterialTheme.typography.bodyLarge,
//                     )
//                 }
//             }
//             item {
//                 OverallAttendanceCard(summary = uiState.summary)
//             }
//             item {
//                 Row(
//                     modifier = Modifier
//                         .fillMaxWidth()
//                         .padding(top = 10.dp),
//                     verticalAlignment = Alignment.CenterVertically,
//                     horizontalArrangement = Arrangement.SpaceBetween,
//                 ) {
//                     Text(text = "Your subjects", style = MaterialTheme.typography.headlineSmall)
//                     RiskStatusBadge(status = uiState.summary.riskStatus)
//                 }
//             }
//             items(
//                 items = uiState.summary.subjects,
//                 key = { it.id },
//             ) { subject ->
//                 SubjectAttendanceCard(subject = subject)
//             }
//         }
//     }
// }


