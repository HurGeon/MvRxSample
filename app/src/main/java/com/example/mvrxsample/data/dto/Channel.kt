package com.example.mvrxsample.data.dto

import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root

@Root(name = "channel", strict = false)
data class Channel(
    @field:ElementList(entry = "item", inline = true)
    var list: List<Item>? = null
)
