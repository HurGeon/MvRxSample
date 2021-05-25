package com.example.mvrxsample.data

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name = "item", strict= false)
data class Feed(
    @Element(name = "title")
    val title: String? = null,
//
)
