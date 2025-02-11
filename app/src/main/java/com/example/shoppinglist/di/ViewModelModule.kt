package com.example.shoppinglist.di

import com.example.shoppinglist.usecase.ShoppingListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import javax.inject.Inject

@Module
@InstallIn(ViewModelComponent::class)
class ViewModelModule {

    @Provides
    fun provideShoppingListUseCase():ShoppingListUseCase = ShoppingListUseCase()
}