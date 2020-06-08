import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class ItemTests {
    @Test
    fun reducePrice_givenAnItemWithPositivePrice_shouldReducePriceByPercentage1() {
        val item: Item = Item(price = 5.5)
        item.reducePrice(byPercentage = 0.1)
        assertEquals(4.95, item.price)
    }

    @Test
    fun reducePrice_givenAnItemWithPositivePrice_shouldReducePriceByPercentage2(){
        val item = Item(price = 4.5)
        item.reducePrice(byPercentage = 0.2)
        assertEquals(3.6, item.price)
    }

    @Test
    fun isInRedPencilPromotion_givenPriceReduction_returnsTrue() {
        val item = Item(price = 1.0)
        item.reducePrice(byPercentage = 0.2)
        assertTrue(item.isInRedPencilPromotion())
    }
}