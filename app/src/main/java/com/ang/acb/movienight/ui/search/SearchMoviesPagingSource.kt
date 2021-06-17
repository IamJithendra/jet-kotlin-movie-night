package com.ang.acb.movienight.ui.search

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.ang.acb.movienight.domain.entities.Movie
import com.ang.acb.movienight.domain.usecases.SearchMoviesUseCase
import timber.log.Timber

private const val STARTING_PAGE_INDEX = 1

class SearchMoviesPagingSource(
    private val query: String,
    private val searchMoviesUseCase: SearchMoviesUseCase,
) : PagingSource<Int, Movie>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movie> {
        val page = params.key ?: STARTING_PAGE_INDEX

        return try {
            val response = searchMoviesUseCase(query, page)

            LoadResult.Page(
                data = response.movies,
                prevKey = if (page == STARTING_PAGE_INDEX) null else page - 1,
                // Avoid infinite loading when the search response total_pages is 0
                nextKey = if (page == response.totalPages || response.totalPages == 0) null else page + 1
            )
        } catch (e: Exception) {
            Timber.e(e)
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Movie>): Int? {
        return state.anchorPosition
    }
}