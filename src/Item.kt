
class Item(var price: Double, daysSinceChanged: Int = 31) {
    private var isInPromotion = false
    fun reducePrice(byPercentage: Double) {
        price -= price * byPercentage
        isInPromotion = byPercentage >= 0.05 && byPercentage <= 0.3
    }

    fun isInRedPencilPromotion(): Boolean {
        return isInPromotion
    }


}