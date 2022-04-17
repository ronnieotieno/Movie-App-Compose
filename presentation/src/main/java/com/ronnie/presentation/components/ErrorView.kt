package com.ronnie.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ronnie.presentation.R
import com.ronnie.presentation.theme.Teal200


@Composable
fun ErrorView(retryFunction: () -> Unit) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(R.drawable.oops),
                contentDescription = "error",
                modifier = Modifier.size(150.dp)
            )
            Text(
                text = stringResource(R.string.error),
                color = Color.Black,
                fontSize = 17.sp,
                textAlign = TextAlign.Center,
            )
            Button(
                onClick = { retryFunction.invoke() }, colors = ButtonDefaults.buttonColors(
                    backgroundColor = Teal200,
                    contentColor = Color.White
                )
            ) {
                Text(stringResource(R.string.retry))
            }
        }
    }
}