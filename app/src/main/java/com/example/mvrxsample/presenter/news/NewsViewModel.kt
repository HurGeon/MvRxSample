package com.example.mvrxsample.presenter.news

import com.airbnb.mvrx.BaseMvRxViewModel
import com.airbnb.mvrx.FragmentViewModelContext
import com.airbnb.mvrx.MvRxViewModelFactory
import com.airbnb.mvrx.ViewModelContext
import com.example.mvrxsample.domain.repository.NewsRepository
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject

class NewsViewModel @AssistedInject constructor(
    @Assisted initialState: State,
    private var repository: NewsRepository
) : BaseMvRxViewModel<State>(initialState = initialState, debugMode = true) {
    init {
        getNews()
    }

    fun getNews() = withState { repository.getNews("").execute { copy(news = it) } }


    companion object : MvRxViewModelFactory<NewsViewModel, State> {
        @JvmStatic
        override fun create(viewModelContext: ViewModelContext, state: State): NewsViewModel? {
            val fragment : NewsFragment = (viewModelContext as FragmentViewModelContext).fragment()
            return fragment.viewModelFactory.create(state)
        }
    }

    @AssistedFactory
    interface Factory{
        fun create(initialState: State): NewsViewModel
    }

}

