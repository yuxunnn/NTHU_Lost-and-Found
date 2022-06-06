package com.example.ss_team2.presentation.ui.utility

import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun AlertDialogSample(
    openAlert: Boolean,
    onDismissRequest: () -> Unit,
    description: String,
    onClickConfirm: () -> Unit,
    confirmText: String,
    onClickDismiss: () -> Unit,
    dismissText: String
) {
    if (openAlert) {
        AlertDialog(
            onDismissRequest = onDismissRequest,
            title = {Text(description)},
            text = {Text(description)},
            confirmButton = {
                Button(onClick = onClickConfirm) {
                    Text(text = confirmText)
                }
            },
            dismissButton = {
                Button(onClick = onClickDismiss) {
                    Text(text = dismissText)
                }
            }
        )
    }
}