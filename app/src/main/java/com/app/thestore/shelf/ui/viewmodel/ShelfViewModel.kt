package com.app.thestore.shelf.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.thestore.shelf.data.repository.DefaultShelfRepository
import com.app.thestore.shelf.data.repository.ShelfRepository
import com.app.thestore.shelf.ui.model.PageState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class ShelfViewModel(
    private val repository: ShelfRepository = DefaultShelfRepository(),
) : ViewModel() {
    private val state: MutableStateFlow<PageState> by lazy {
        MutableStateFlow(PageState())
    }

    internal val pageState: StateFlow<PageState> by lazy {
        state
    }

    /**
     * Method to fetch the result from
     */
    internal fun fetchProduct() {
        viewModelScope.launch {
            repository.getProducts().collectLatest { result ->
                result.onFailure {
                    state.value = PageState(false, null)
                }.onSuccess {
                    state.value = PageState(false, it)
                }
            }
        }
    }
}
