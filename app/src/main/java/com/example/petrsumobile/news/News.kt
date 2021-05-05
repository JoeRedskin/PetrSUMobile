package com.example.petrsumobile.news

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class NewsList(
        @Expose
        @SerializedName("items")
        var newsList: List<News>
)

@Entity
data class News(
        @PrimaryKey(autoGenerate = true)
        var id: Int = 0,
        @Expose
        var title: String,
        @Expose
        var description: String,
        @SerializedName("pubDate")
        @Expose
        var date: String,
        @Expose
        var link: String,
        @Embedded
        @Expose
        var enclosure: Enclosure
) {
    data class Enclosure(
            @Expose
            @SerializedName("link")
            var urlImage: String,
    )
}

