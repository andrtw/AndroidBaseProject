package com.andrtw.androidbaseproject.ui.recyclerview

import androidx.annotation.IntDef
import com.andrtw.androidbaseproject.ui.recyclerview.base.RecyclerViewModel


interface TodoRecyclerViewModel : RecyclerViewModel {

    companion object {
        const val TYPE_TODO = 1
    }

    @IntDef(
        TYPE_TODO
    )
    annotation class Type

    @Type
    val type: Int
}