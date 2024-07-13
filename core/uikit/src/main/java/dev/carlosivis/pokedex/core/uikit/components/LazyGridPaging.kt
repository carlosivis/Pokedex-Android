
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.LazyGridItemScope
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

@Composable
fun <T> LazyGridPaging(
    items: List<T>,
    requestNewPage: () -> Unit,
    itemContent: @Composable LazyGridItemScope.(item: T) -> Unit,
    modifier: Modifier = Modifier,
    state: LazyGridState = rememberLazyGridState(),
    itemCount: Int = 10,
    itemsPerPage: Int = 50
) {
    var lastIndexViewed by remember { mutableIntStateOf(0) }
    var itemVisibleCount by remember { mutableIntStateOf(0) }

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = modifier,
        state = state,
        content = {
            items(items, itemContent = itemContent)
        }
    )

    LaunchedEffect(remember { derivedStateOf { state.layoutInfo } }.value.visibleItemsInfo.lastOrNull()?.index) {
        val last = state.layoutInfo.visibleItemsInfo.lastOrNull()
        if (last?.index != null && last.index > lastIndexViewed) {
            lastIndexViewed = last.index
        }
    }

    LaunchedEffect(remember { derivedStateOf { state.layoutInfo } }.value.visibleItemsInfo.size) {
        itemVisibleCount = state.layoutInfo.visibleItemsInfo.size
    }

    LaunchedEffect(Unit) {
        requestNewPage()
    }

    LaunchedEffect(lastIndexViewed) {
        if (state.layoutInfo.totalItemsCount > itemsPerPage) {
            val limit = (state.layoutInfo.totalItemsCount - itemCount)
            if (lastIndexViewed >= limit) {
                requestNewPage()
            }
        }
    }
}
