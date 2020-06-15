import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
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
        val item = Item(price = 4.5, daysSinceChanged = 31)
        item.reducePrice(byPercentage = 0.2)
        assertEquals(3.6, item.price)
    }

    @Test
    fun isInRedPencilPromotion_givenPriceReduction_returnsTrue() {
        val item = Item(price = 1.0, daysSinceChanged = 31)
        item.reducePrice(byPercentage = 0.2)
        assertTrue(item.isInRedPencilPromotion())
    }

    @Test
    fun isInRedPencilPromotion_givenNoPriceReduction_returnsFalse() {
        val item = Item(price = 1.0, daysSinceChanged = 31)
        item.reducePrice(byPercentage = 0.0)
        assertFalse(item.isInRedPencilPromotion())
    }

    @Test
    fun isInRedPencilPromotion_givenPriceReductionLessThan5Percent_returnsFalse() {
        val item = Item(price = 1.0, daysSinceChanged = 31)
        item.reducePrice(byPercentage = 0.049)
        assertFalse(item.isInRedPencilPromotion())
    }

    @Test
    fun isInRedPencilReduction_givenPriceReductionIs5Percent_returnsTrue() {
        val item = Item(price = 1.0, daysSinceChanged = 31)
        item.reducePrice(byPercentage = 0.05)
        assertTrue(item.isInRedPencilPromotion())
    }

    @Test
    fun isInRedPencilPromotion_givenPriceReductionGreaterThan30Percent_returnsFalse() {
        val item = Item(price = 1.0, daysSinceChanged = 31)
        item.reducePrice(byPercentage = 0.31)
        assertFalse(item.isInRedPencilPromotion())
    }

    @Test
    fun isInRedPencilPromotion_givenPriceReductionIs30Percent_returnsTrue(){
        val item = Item(price = 1.0, daysSinceChanged = 31)
        item.reducePrice(byPercentage = 0.3)
        assertTrue(item.isInRedPencilPromotion())
    }

    @Test
    fun isInRedPencilPromotion_givenPriceDeductionIsBetween5And30Percent_returnsTrue() {
        val item = Item(price = 1.0, daysSinceChanged = 31)
        item.reducePrice(byPercentage = 0.13)
        assertTrue(item.isInRedPencilPromotion())
    }

    @Test
    fun IsPriceStable_given31DaysSinceChanged_ReturnsTrue(){
        val item = Item(price = 1.0, daysSinceChanged = 31)
    }
}