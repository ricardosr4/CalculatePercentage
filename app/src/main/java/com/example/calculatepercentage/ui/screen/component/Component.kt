package com.example.calculatepercentage.ui.screen.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ZetaSpaceHeight(size: Dp = 10.dp) {
    Spacer(modifier = Modifier.height(size))
}

@Composable
fun ZetaSpaceWidth(size: Dp = 10.dp) {
    Spacer(modifier = Modifier.width(size))
}

@Composable
fun ZetaOutlinedTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String){
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(text = label) },
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 30.dp)
    )

}

@Composable
fun ZetaButtonBasic(
    text: String,
    color: Color = MaterialTheme.colorScheme.primary,
    textSize: TextUnit = 16.sp,
    onClick: () -> Unit){
    OutlinedButton(
        onClick = onClick,
        colors = ButtonDefaults.outlinedButtonColors(
            contentColor = color,
            containerColor = Color.Transparent
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 50.dp)

    ) {
        Text(text = text, fontSize = textSize)
    }

}

@Composable
fun ZetaCard(
    title: String,
    number: Double,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.LightGray
        )
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = title,
                    color = Color.Black,
                    fontSize = 20.sp
                )
                Text(
                    text = "$${number}",
                    color = Color.Black,
                    fontSize = 20.sp
                )
            }
        }
    }
}

@Composable
fun ZetaTwoCards(
    title1: String,
    number1: Double,
    title2: String,
    number2: Double,
    modifier: Modifier = Modifier
){
    Row(
        modifier = Modifier
        .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly

    ) {
        ZetaCard(
            title = title1,
            number = number1,
            modifier = Modifier.weight(1f)
        )
        ZetaSpaceWidth()
        ZetaCard(
            title = title2,
            number = number2,
            modifier = Modifier.weight(1f)
        )
    }

}

@Composable
fun ZetaAlertDialog(
    title: String,
    message:String,
    confirmText: String,
    onConfirmClick: () -> Unit,
    onDismissClick: () -> Unit
){
    AlertDialog(
        onDismissRequest = onDismissClick,
        title = { Text(text = title) },
        text = { Text(text = message) },
        confirmButton = {
            OutlinedButton(onClick = onConfirmClick) {
                Text(text = confirmText)
            }
        }
    )

}
