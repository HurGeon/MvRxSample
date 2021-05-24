package com.example.mvrxsample.presenter.news

import com.airbnb.mvrx.Async
import com.airbnb.mvrx.MvRxState
import com.airbnb.mvrx.Uninitialized
import com.example.mvrxsample.domain.News

data class State(val news: Async<List<News>> = Uninitialized) : MvRxState
