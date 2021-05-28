package com.example.mvrxsample.util

import com.example.mvrxsample.data.dto.NewsDto
import okhttp3.ResponseBody
import org.jsoup.Jsoup
import retrofit2.Converter
import retrofit2.Retrofit
import java.lang.reflect.Type

class HTMLConverterFactory : Converter<ResponseBody, NewsDto> {
    override fun convert(value: ResponseBody): NewsDto? {
        val document = Jsoup.parse(value.string())
        return null
    }

    companion object {
        fun create(): Converter.Factory {
            return object : Converter.Factory() {
                override fun responseBodyConverter(
                    type: Type,
                    annotations: Array<out Annotation>,
                    retrofit: Retrofit
                ): Converter<ResponseBody, *>? {
                    if (type != NewsDto::class.java) return null
                    return HTMLConverterFactory()
                }
            }
        }
    }
}
