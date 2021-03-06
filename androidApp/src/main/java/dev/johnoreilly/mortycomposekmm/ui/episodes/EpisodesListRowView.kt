package dev.johnoreilly.mortycomposekmm.ui.episodes

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import dev.johnoreilly.mortycomposekmm.GetEpisodesQuery


@Composable
fun EpisodesListRowView(episode: GetEpisodesQuery.Result, episodeSelected: (episode: GetEpisodesQuery.Result) -> Unit) {

    Row(modifier = Modifier.fillMaxWidth()
        .clickable(onClick = { episodeSelected(episode) })
        .padding(vertical = 8.dp, horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Column(modifier = Modifier.weight(1f)) {
            Text(episode.name ?: "",
                style = MaterialTheme.typography.h6,
                maxLines = 1, overflow = TextOverflow.Ellipsis,)
            Text(episode.episode ?: "",
                style = MaterialTheme.typography.subtitle2)
        }

        Text(episode.air_date ?: "", modifier = Modifier.padding(start = 16.dp))
    }
    Divider()
}