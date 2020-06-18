package com.fakhrymubarak.submission.sinopsisbuku.model

data class Book(
    var title: String = "",
    var writer: String = "",
    var category: String = "",
    var synopsis: String = "",
    var rating: String = "",
    var cover: Int = 0
)