package ru.s4nchez.bookstracker.presentation.view.common.decorator

import android.content.Context
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import ru.s4nchez.bookstracker.R

class FabItemDecoration(context: Context) : RecyclerView.ItemDecoration() {

    private val margin = context.resources.getDimension(R.dimen.list_fab_margin_decoration).toInt()

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        val position = parent.getChildLayoutPosition(view)

        if ((position + 1) == state.itemCount) {
            outRect.bottom = margin
        }
    }
}