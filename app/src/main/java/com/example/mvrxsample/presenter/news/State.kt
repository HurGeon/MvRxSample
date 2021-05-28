package com.example.mvrxsample.presenter.news

import com.airbnb.mvrx.Async
import com.airbnb.mvrx.MvRxState
import com.airbnb.mvrx.Uninitialized
import com.example.mvrxsample.domain.model.News

data class State(val newsList: Async<List<News?>> = Uninitialized) : MvRxState
