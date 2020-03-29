package com.andrtw.androidbaseproject.ui.recyclerview.base

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer


abstract class AbstractViewHolder<T : RecyclerViewModel>(
    override val containerView: View
) : RecyclerView.ViewHolder(containerView), LayoutContainer {

    abstract fun bind(model: T)
}