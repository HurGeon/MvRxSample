package com.example.mvrxsample.domain.mapper

import com.example.mvrxsample.data.dto.NewsDto
import com.example.mvrxsample.domain.model.News

fun NewsDto.toNews(): News =
    News(
        this.title,
        this.description,
        this.imageUrl
    )


fun News.toNewsDto(): NewsDto =
    NewsDto(
        this.title,
        this.description,
        this.imageUrl
    )


