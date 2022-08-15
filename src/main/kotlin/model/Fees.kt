package model

data class Fees(
    val Bundle: Float,
    val EndDate: Float,
    val Feature: Float,
    val Gallery: Float,
    val Listing: Float,
    val Reserve: Float,
    val Subtitle: Float,
    val TenDays: Float,
    val ListingFeeTiers: List<ListingFeeTiers>,
    val SecondCategory: Float
)
