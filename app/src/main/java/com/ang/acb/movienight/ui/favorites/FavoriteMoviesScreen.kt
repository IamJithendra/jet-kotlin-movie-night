package com.ang.acb.movienight.ui.favorites

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.ang.acb.movienight.ui.common.MovieItem

@Composable
fun FavoriteMoviesScreen(
    viewModel: FavoritesViewModel = hiltViewModel()
) {
    Scaffold(
        topBar = { FavoritesTopBar() }
    ) {
        LazyColumn {
            items(viewModel.movies) {
                MovieItem(movie = it, onMovieClick = { /*TODO*/ })
            }
        }
    }
}