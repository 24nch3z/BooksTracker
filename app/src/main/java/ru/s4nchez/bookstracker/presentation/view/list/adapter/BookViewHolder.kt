package ru.s4nchez.bookstracker.presentation.view.list.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_book.view.*
import ru.s4nchez.bookstracker.data.book.model.Book

class BookViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    fun bind(book: Book) {
        itemView.title_view.text = book.title
    }
}