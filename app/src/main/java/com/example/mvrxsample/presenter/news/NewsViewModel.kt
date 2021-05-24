package com.example.mvrxsample.presenter.news

import com.airbnb.mvrx.BaseMvRxViewModel
import com.example.mvrxsample.domain.repository.NewsRepository

class NewsViewModel constructor(
    initialState: State,
    private var repository: NewsRepository
) : BaseMvRxViewModel<State>(initialState = initialState, debugMode = true) {
    init {
        getNews()
    }

    fun getNews() = withState { repository.getNews("").execute { copy(it) } }


//    companion object : MvRxViewModelFactory<NewsViewModel, State> {
//        override fun create(viewModelContext: ViewModelContext, state: State): NewsViewModel? {
//            val repository =
//                NetworkModule.provideRepositories(NetworkModule.provideApiService(NetworkModule.provideRetrofit()))
//            return NewsViewModel(state, repository)
//        }
//    }
}

