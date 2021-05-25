package com.example.mvrxsample.data

import org.simpleframework.xml.Element

@Element(name = "item")
data class Item(
    @field:Element(name = "title") var title: String? = null,
    @field:Element(name = "link") var link: String? = null,
    @field:Element(name = "guid") var guid: String? = null,
    @field:Element(name = "pubDate") var pubDate: String? = null,
    @field:Element(name = "description") var description: String? = null,
    @field:Element(name = "source") var source: String? = null
)
