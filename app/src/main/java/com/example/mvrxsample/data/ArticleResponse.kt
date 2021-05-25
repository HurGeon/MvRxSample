package com.example.mvrxsample.data

import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Path
import org.simpleframework.xml.Root

@Root(name = "rss", strict = false)
data class ArticleResponse(

    @Element(name = "title")
    @Path("channel")
    var channelTitle: String,

    @ElementList(entry = "item", inline = true)
    @Path("channel")
    var list: List<Feed>? = null
)
