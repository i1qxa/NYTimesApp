package com.example.nytimesapp.domain.reviews

data class ReviewItem(
    val id:Float,
    val mpaaRating:String?,
    val criticPick:Int?,
    val byline:String?,
    val headLine:String?,
    val summaryShort:String?,
    val publicationDate:String?,
    val openingDate:String?,
    val dateUpdated:String?,
    val reviewItemLinkId: Float?,
    val reviewItemImgId:Float?,
)
