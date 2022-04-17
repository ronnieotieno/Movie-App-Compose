package com.ronnie.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.ronnie.domain.model.UiState
import com.ronnie.presentation.R
import com.ronnie.presentation.theme.Teal200

@Composable
fun MovieDetails(state: UiState) {
    val movieDetail = state.data
    val scrollState = rememberScrollState()
    Column(
        Modifier
            .verticalScroll(scrollState)
            .fillMaxSize()
            .padding(10.dp)
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(movieDetail?.image)
                .crossfade(true)
                .error(R.drawable.movie_place_holder)
                .build(),
            contentDescription = "movie Image",
            modifier = Modifier
                .height(300.dp)
                .fillMaxWidth(),
            contentScale = ContentScale.Fit
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Column {
                Spacer(Modifier.height(10.dp))
                Text(
                    text = movieDetail?.title ?: "",
                    color = Color.Black,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(Modifier.height(10.dp))
                Text(text = movieDetail?.release_date ?: "", color = Color.Black, fontSize = 14.sp)
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 20.dp)
                    .align(Alignment.CenterVertically),
                horizontalArrangement = Arrangement.End
            ) {
                Text(
                    text = movieDetail?.vote ?: "",
                    color = Teal200,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "/10",
                    color = Color.Black,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
        Spacer(Modifier.height(10.dp))
        LazyRow {
            movieDetail?.genres?.size?.let { total ->
                items(total) { index ->
                    GenreChip(movieDetail.genres[index])
                }
            }
        }
        Spacer(Modifier.height(10.dp))
        Text(text = movieDetail?.overView ?: "", color = Color.Black, fontSize = 14.sp)
    }
}