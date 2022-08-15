package model

data class JsonInput(
    val CategoryId: Int,
    val Name: String,
    val Path: String,
    val CanListAuctions: Boolean,
    val CanListClassifieds: Boolean,
    val CanRelist: Boolean,
    val LegalNotice: String,
    val DefaultDuration: Int,
    val AllowedDurations: List<Int>,
    val Fees: Fees,
    val FreePhotoCount: Int,
    val MaximumPhotoCount: Int,
    val IsFreeToRelist: Boolean,
    val Promotions : List<Promotions>,
    val MaximumTitleLength: Int,
    val AreaOfBusiness: Int,
    val DefaultRelistDuration: Int,
    val CanUseCounterOffers: Boolean
)
