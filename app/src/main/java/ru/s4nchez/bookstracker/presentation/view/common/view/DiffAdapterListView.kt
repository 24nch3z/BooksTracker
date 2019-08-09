package ru.s4nchez.bookstracker.presentation.view.common.view

import ru.s4nchez.bookstracker.presentation.view.common.adaper.ListItem

interface DiffAdapterListView {
    fun setItems(items: List<ListItem>)
}