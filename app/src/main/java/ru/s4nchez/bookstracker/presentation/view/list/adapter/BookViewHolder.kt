package ru.s4nchez.bookstracker.presentation.view.list.adapter

import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_book.view.*
import ru.s4nchez.bookstracker.R
import ru.s4nchez.bookstracker.data.book.model.Book

class BookViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    fun bind(book: Book) {
        val context = itemView.context

        itemView.title_view.text = book.title

        if (adapterPosition % 2 == 0) {
            itemView.setBackgroundColor(ContextCompat.getColor(context, R.color.item_book_background_even))
        } else {
            itemView.setBackgroundColor(ContextCompat.getColor(context, R.color.item_book_background_odd))
        }
    }
}