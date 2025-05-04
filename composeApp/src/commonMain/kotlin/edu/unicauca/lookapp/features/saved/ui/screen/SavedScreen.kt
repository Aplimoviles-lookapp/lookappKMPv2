package edu.unicauca.lookapp.features.saved.ui.screen



import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import edu.unicauca.lookapp.core.ui.components.BottomNavBar
import edu.unicauca.lookapp.core.ui.components.TopAppBar
import edu.unicauca.lookapp.features.saved.ui.viewmodel.SavedViewModel
import org.koin.compose.viewmodel.koinViewModel
import org.jetbrains.compose.ui.tooling.preview.Preview


@Composable
fun SavedScreen(
    modifier: Modifier = Modifier,
    savedViewModel: SavedViewModel=  koinViewModel()

) {
    //val currentUser = savedViewModel.currentUser.collectAsState().value.currentUserAccount
    val savedItems = savedViewModel.getSavedItems().collectAsState(initial = emptyList())


    LazyColumn(modifier = modifier.padding(8.dp)) {
        items(savedItems.value) { item ->
            SavedItem(
                title = item.title,
                subtitle = item.subtitle,
                imageUrl = item.imageUrl,
                onDelete = { savedViewModel.deleteItem(item.itemId) },
                modifier = Modifier
            )
        }

    }

}

@Preview()
@Composable
fun SavedScreenPreview() {
    Scaffold(
        topBar = { TopAppBar(title = "Guardados") },
        bottomBar = { BottomNavBar() }
    ) { padding ->
        SavedScreen(Modifier.padding(padding))
    }
}