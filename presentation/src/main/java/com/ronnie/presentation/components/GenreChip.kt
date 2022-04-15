package com.ronnie.presentation.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun GenreChip(){
    Surface(
        modifier = Modifier.padding(end = 6.dp, start = 6.dp),
        shape = RoundedCornerShape(14.dp), color = Color(0xFFDCDCDC)
    ){
      Text(text = "Family", color = Color.DarkGray, fontSize = 13.sp, modifier = Modifier
          .padding(end = 8.dp, start = 8.dp, top = 6.dp, bottom = 6.dp))
    }
}