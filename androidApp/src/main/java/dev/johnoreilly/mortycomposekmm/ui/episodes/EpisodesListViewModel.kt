package dev.johnoreilly.mortycomposekmm.ui.episodes

import androidx.lifecycle.ViewModel
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import dev.johnoreilly.mortycomposekmm.GetEpisodeQuery
import dev.johnoreilly.mortycomposekmm.GetEpisodesQuery
import dev.johnoreilly.mortycomposekmm.shared.MortyRepository
import kotlinx.coroutines.flow.Flow

class EpisodesListViewModel(private val repository: MortyRepository): ViewModel() {

    val episodes: Flow<PagingData<GetEpisodesQuery.Result>> = Pager(PagingConfig(pageSize = 20)) {
        EpisodesDataSource(repository)
    }.flow


    suspend fun getEpisode(episodeId: String): GetEpisodeQuery.Episode? {
        return repository.getEpisode(episodeId)
    }

}