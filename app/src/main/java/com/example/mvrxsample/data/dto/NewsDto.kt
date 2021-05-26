package com.example.mvrxsample.data.dto

import org.simpleframework.xml.Attribute

data class NewsDto(

    @Attribute(name="og:title")
    val title:String?,

    @Attribute(name="og:description")
    val description:String?,

    @Attribute(name="og:image")
    val imageUrl:String?
)
