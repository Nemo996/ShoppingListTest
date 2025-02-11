package com.example.shoppinglist

import androidx.lifecycle.ViewModel
import com.example.shoppinglist.model.ShoppingItem
import com.example.shoppinglist.usecase.ShoppingListUseCase
import com.example.shoppinglist.usecase.Sorting
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(private val useCase: ShoppingListUseCase) :
    ViewModel() {

    val state = MutableStateFlow<State>(State(list = emptyList(), order = emptyMap<Int, Boolean>()))

    init {
        val list = useCase.getShoppingList()
        state.value = state.value.copy(list = list, order = list.associate { it.id to false })
    }

    fun sortAlphabet() {
        if (state.value.sort == Sorting.ALPHABETIC){
            val list = useCase.getShoppingList(sort = Sorting.NONE)
            state.value = state.value.copy(list = list,sort =  Sorting.NONE)
        }else{
            val list = useCase.getShoppingList(sort = Sorting.ALPHABETIC)
            state.value = state.value.copy(list = list,sort =  Sorting.ALPHABETIC)
        }
    }

    fun sortAisle() {
        if (state.value.sort == Sorting.AISLE){
            val list = useCase.getShoppingList(sort = Sorting.NONE)
            state.value = state.value.copy(list = list,sort =  Sorting.NONE)
        }else{
            val list = useCase.getShoppingList(sort = Sorting.AISLE)
            state.value = state.value.copy(list = list,sort =  Sorting.AISLE)
        }
    }

    fun onClick(id: Int) {
        state.value = state.value.copy(
            order = state.value.order.toMutableMap().apply {
                this[id] = !state.value.order[id]!!
            }
        )
    }
}

data class State(
    val list: List<ShoppingItem>,
    val order: Map<Int, Boolean>,
    val sort: Sorting = Sorting.NONE
)