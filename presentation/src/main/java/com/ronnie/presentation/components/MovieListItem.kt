package com.ronnie.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.ronnie.commons.IMAGE_URL
import com.ronnie.domain.model.movieList.Movie
import com.ronnie.presentation.R
import com.ronnie.presentation.utils.Screen
import com.ronnie.presentation.viewmodels.ListViewModel

@Composable
fun MovieListItem(navController: NavController, movie:Movie) {
    Box(
        Modifier
            .clickable { navController.navigate(Screen.Detail.createRoute(movie.id.toString())) }
            .fillMaxWidth()) {
        Row(
            Modifier
                .padding(10.dp)
                .fillMaxWidth()
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(IMAGE_URL + movie.poster_path)
                    .crossfade(true)
                    .build(),
                contentDescription = "movie Image",
                modifier = Modifier
                    .height(110.dp)
                    .width(110.dp),
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier
                    .padding(start = 10.dp)
                    .fillMaxHeight()
                    .align(CenterVertically),
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = movie.title, color = Color.Black, fontSize = 14.sp)
                Spacer(Modifier.height(10.dp))
                if(movie.release_date != null) {
                    movie.release_date?.substringBefore("-")
                        ?.let { Text(text = it, color = Color.DarkGray, fontSize = 14.sp) }
                }
                Spacer(Modifier.height(10.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Text(
                        text = movie.vote_average.toString(), color = Color.DarkGray, fontSize = 14.sp,
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    Image(
                        painter = painterResource(R.drawable.star),
                        contentDescription = "rating",
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Divider(
            color = Color.Gray,
            modifier = Modifier
                .fillMaxWidth()
                .height(0.7.dp)
        )
    }
}