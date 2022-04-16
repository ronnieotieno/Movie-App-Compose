package com.ronnie.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.ronnie.commons.IMAGE_URL
import com.ronnie.domain.model.UiState
import com.ronnie.presentation.theme.Teal200
import com.ronnie.presentation.viewmodels.DetailViewModel

@Composable
fun MovieDetails(movieId: String, viewModel: DetailViewModel = hiltViewModel()) {
    viewModel.getMovieDetail(movieId.toInt())
    val detail = viewModel.movieDetail.collectAsState()

    when {
        detail.value.isLoading -> {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                CircularProgressIndicator()
            }
        }
        detail.value.data != null -> {
            Content(detail.value)
        }
        detail.value.error -> {

        }
    }
}

@Composable
fun Content(state: UiState) {
    val data = state.data
    val scrollState = rememberScrollState()
    Column(
        Modifier
            .verticalScroll(scrollState)
            .fillMaxSize()
            .padding(10.dp)
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(IMAGE_URL + data?.poster_path)
                .crossfade(true)
                .build(),
            contentDescription = "movie Image",
            modifier = Modifier
                .height(250.dp)
                .fillMaxWidth(),
            contentScale = ContentScale.Fit
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Column {
                Spacer(Modifier.height(10.dp))
                data?.title?.let {
                    Text(
                        text = it,
                        color = Color.Black,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
                Spacer(Modifier.height(10.dp))
                data?.release_date?.substringBefore("-")
                    ?.let { Text(text = it, color = Color.DarkGray, fontSize = 14.sp) }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 20.dp)
                    .align(Alignment.CenterVertically),
                horizontalArrangement = Arrangement.End
            ) {
                Text(
                    text = data?.vote_average.toString(),
                    color = Teal200,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "/10",
                    color = Color.DarkGray,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
        Spacer(Modifier.height(10.dp))
        LazyRow {
            data?.genres?.size?.let { total ->
                items(total) {
                    GenreChip(data.genres[it])
                }
            }
        }
        Spacer(Modifier.height(10.dp))
        data?.overview?.let { Text(text = it, color = Color.DarkGray, fontSize = 14.sp) }
    }
}