package com.ym.sss.main.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ym.sss.base.bean.FeedBean
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.launch


class MainViewModel : ViewModel() {
    var listLiveDirection = MutableLiveData<List<FeedBean>>()
    fun load() {
        viewModelScope.launch {

        }
    }
}