package com.example.petrsumobile.news

import org.simpleframework.xml.Attribute
import org.simpleframework.xml.Element
import org.simpleframework.xml.Root
import java.util.*

@Root(name = "item")
data class News(
        @Element(name = "title")
        val title: String,
        @Element(name = "description")
        val description: String,
        @Element(name = "pubDate")
        val date: Date,
        @Element(name = "link")
        val link: String,
        @Attribute(name = "url")
        val imageUrl: String
)