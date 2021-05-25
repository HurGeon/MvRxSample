package com.example.mvrxsample.data

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name = "rss", strict = false)
data class ArticleResponse(
    @field:Element(name = "channel")
    var channel: Channel? = null
)



