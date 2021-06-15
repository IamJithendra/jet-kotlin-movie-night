package com.ang.acb.movienight.data.remote

import com.ang.acb.movienight.data.asMovies
import com.ang.acb.movienight.domain.Movies
import javax.inject.Inject

class RemoteMovieDataSource @Inject constructor(
    private val movieService: MovieService
) {

    suspend fun getPopularMovies(page: Int): Movies {
        return movieService.getPopularMovies(page).asMovies()
    }

    suspend fun getTopRatedMovies(page: Int): Movies {
        return movieService.getTopRatedMovies(page).asMovies()
    }

    suspend fun getNowPlayingMovies(page: Int): Movies {
        return movieService.getNowPlayingMovies(page).asMovies()
    }

    suspend fun getUpcomingMovies(page: Int): Movies {
        return movieService.getUpcomingMovies(page).asMovies()
    }

    suspend fun searchMovies(query: String, page: Int): Movies {
        return movieService.searchMovies(query, page).asMovies()
    }
}