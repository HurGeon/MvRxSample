package com.example.mvrxsample.presenter.sample

import android.util.Log
import androidx.annotation.MainThread
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvrxsample.domain.repository.NewsRepository
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class NewsSampleViewModel @Inject constructor(
    private val newsRepository: NewsRepository
): ViewModel() {

    var testStr = MutableLiveData<String>()

    init {
        getNews()
    }

    fun getNews(){
        newsRepository.getNews("ko")
            .subscribeOn(Schedulers.io())
            .subscribe({
                Log.d("TAG", it.toString())
                testStr.postValue(it.channel?.list.toString())
            }, {
                Log.d("Throwable", it.toString())
                testStr.postValue(it.toString())
            })
    }

}
