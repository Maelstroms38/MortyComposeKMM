package dev.johnoreilly.mortycomposekmm.ui.episodes

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import dev.johnoreilly.mortycomposekmm.GetEpisodesQuery
import org.koin.androidx.compose.getViewModel

@Composable
fun EpisodesListView(bottomBar: @Composable () -> Unit, episodeSelected: (episode: GetEpisodesQuery.Result) -> Unit) {
    val episodesListViewModel = getViewModel<EpisodesListViewModel>()
    val lazyEpisodeList = episodesListViewModel.episodes.collectAsLazyPagingItems()

    Scaffold(
        topBar = { TopAppBar(title = { Text( "Episodes") }) },
        bottomBar = bottomBar)
    {
        LazyColumn(contentPadding = it) {
            items(lazyEpisodeList) { episode ->
                episode?.let {
                    EpisodesListRowView(episode, episodeSelected)
                }
            }
        }
    }
}

