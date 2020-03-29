package com.andrtw.androidbaseproject.data.source

import androidx.lifecycle.LiveData
import com.andrtw.androidbaseproject.domain.model.ErrorType
import com.andrtw.androidbaseproject.ui.util.Event


interface HasErrorHandling {

    val error: LiveData<Event<ErrorType>>
}