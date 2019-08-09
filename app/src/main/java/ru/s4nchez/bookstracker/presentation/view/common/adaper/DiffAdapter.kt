package ru.s4nchez.bookstracker.presentation.view.common.adaper

import androidx.recyclerview.widget.DiffUtil
import com.hannesdorfmann.adapterdelegates4.AdapterDelegate
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter

class DiffAdapter(
        delegates: List<AdapterDelegate<List<ListItem>>>,
        private val adapterListener: AdapterListener
) : AsyncListDifferDelegationAdapter<ListItem>(ListDiffCallback()) {

    init {
        delegates.forEach { delegatesManager.addDelegate(it) }
    }

    override fun setItems(items: MutableList<ListItem>?) {
        if (items.isNullOrEmpty()) {
            adapterListener.showEmptyListView()
        } else {
            adapterListener.hideEmptyListView()
        }
        super.setItems(items)
    }

    private class ListDiffCallback<T : ListItem> : DiffUtil.ItemCallback<T>() {

        override fun areItemsTheSame(oldItem: T, newItem: T): Boolean {
            return oldItem.listId == newItem.listId
        }

        override fun areContentsTheSame(oldItem: T, newItem: T): Boolean {
            return oldItem.equals(newItem)
        }
    }
}