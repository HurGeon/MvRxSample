package com.example.mvrxsample.data.dto

import com.tickaroo.tikxml.annotation.Element
import com.tickaroo.tikxml.annotation.Xml

@Xml
data class Channel(
    @Element(name = "item") var list: List<Item>? = null
)
