package com.example.mvrxsample.news

import com.airbnb.mvrx.BaseMvRxViewModel
import com.airbnb.mvrx.MvRxViewModelFactory
import com.airbnb.mvrx.ViewModelContext
import com.example.mvrxsample.domain.repository.NewsRepository
import com.example.mvrxsample.module.NetworkModule
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject


class NewsViewModel @AssistedInject constructor(
    @Assisted initialState: State,
    private var repository: NewsRepository
) : BaseMvRxViewModel<State>(initialState = initialState, debugMode = true) {
    init {
        getNews()
    }

    fun getNews() = withState { repository.getNews("").execute { copy(it) } }


    companion object : MvRxViewModelFactory<NewsViewModel, State> {
        override fun create(viewModelContext: ViewModelContext, state: State): NewsViewModel? {
            val repository =
                NetworkModule.provideRepositories(NetworkModule.provideApiService(NetworkModule.provideRetrofit()))
            return NewsViewModel(state, repository)
        }
    }
}

