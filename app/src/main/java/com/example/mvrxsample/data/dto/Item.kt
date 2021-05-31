package com.example.mvrxsample.data.dto

import com.tickaroo.tikxml.annotation.PropertyElement
import com.tickaroo.tikxml.annotation.Xml

@Xml
data class Item(
    @PropertyElement(name = "title") var title: String? = null,
    @PropertyElement(name = "link") var link: String? = null,
    @PropertyElement(name = "guid") var guid: String? = null,
    @PropertyElement(name = "pubDate") var pubDate: String? = null,
    @PropertyElement(name = "description") var description: String? = null,
    @PropertyElement(name = "source") var source: String? = null
)
