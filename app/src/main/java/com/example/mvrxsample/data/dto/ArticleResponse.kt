package com.example.mvrxsample.data.dto

import com.tickaroo.tikxml.annotation.Element
import com.tickaroo.tikxml.annotation.Xml

@Xml
data class ArticleResponse(
    @Element(name = "channel")
    var channel: Channel? = null
)
