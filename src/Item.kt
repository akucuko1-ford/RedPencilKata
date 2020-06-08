
class Item(var price: Double) {

    fun reducePrice(byPercentage: Double) {
        price -= price * byPercentage
    }

    fun isInRedPencilPromotion(): Boolean {
        return true
    }
}