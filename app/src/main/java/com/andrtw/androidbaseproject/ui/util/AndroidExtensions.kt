package com.andrtw.androidbaseproject.ui.util

import android.content.Context
import android.view.View
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar


fun DialogFragment.show(manager: FragmentManager?, tag: String? = this.javaClass.name) {
    if (!isAdded && (dialog == null || dialog?.isShowing == false) && manager != null) {
        this.show(manager, tag)
    }
}

fun <T> Fragment.observe(source: LiveData<T>?, block: (T) -> Unit) {
    source?.observe(viewLifecycleOwner, Observer(block))
}

fun <T> Fragment.observeEvent(source: LiveData<Event<T>>?, block: (T) -> Unit) {
    source?.observe(viewLifecycleOwner, EventObserver(block))
}

fun <T> AppCompatActivity.observe(source: LiveData<T>?, block: (T) -> Unit) {
    source?.observe(this, Observer(block))
}

fun <T> AppCompatActivity.observeEvent(source: LiveData<Event<T>>?, block: (T) -> Unit) {
    source?.observe(this, EventObserver(block))
}

fun Fragment.showSnackbar(
    @StringRes message: Int?,
    root: View? = view,
    @BaseTransientBottomBar.Duration duration: Int = Snackbar.LENGTH_SHORT
) {
    if (root != null && message != null) {
        Snackbar.make(root, message, duration).show()
    }
}

fun Fragment.showSnackbar(
    message: String?,
    root: View? = view,
    @BaseTransientBottomBar.Duration duration: Int = Snackbar.LENGTH_SHORT
) {
    if (root != null && message != null) {
        Snackbar.make(root, message, duration).show()
    }
}

fun RecyclerView.addDefaultItemDecoration(context: Context) {
    addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
}
