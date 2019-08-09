package ru.s4nchez.bookstracker.presentation.view.list.adapter

import android.view.ViewGroup
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate
import ru.s4nchez.bookstracker.R
import ru.s4nchez.bookstracker.data.book.model.Book
import ru.s4nchez.bookstracker.presentation.view.common.adaper.ListItem
import ru.s4nchez.bookstracker.presentation.view.common.adaper.RecyclerItemClickListener
import ru.s4nchez.bookstracker.utils.inflate

class BookDelegate(
        private val recyclerItemClickListener: RecyclerItemClickListener
) : AbsListItemAdapterDelegate<BookDelegate.Model, ListItem, BookViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup): BookViewHolder {
        return BookViewHolder(parent.inflate(R.layout.item_book))
    }

    override fun isForViewType(item: ListItem, items: MutableList<ListItem>, position: Int) = item is Model

    override fun onBindViewHolder(item: Model, holder: BookViewHolder, payloads: MutableList<Any>) {
        holder.bind(item.book)
        holder.itemView.setOnClickListener { recyclerItemClickListener.onClick(item) }
    }

    data class Model(override val listId: String, val book: Book) : ListItem
}