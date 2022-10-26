package com.gildedrose.items;

import static com.gildedrose.item_helpers.ItemType.OUT_OF_BOUND_QUALITY_MESSAGE;
import static com.gildedrose.item_helpers.ItemType.QUALITY_ERROR_MESSAGE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.gildedrose.main.GildedRose;
import com.gildedrose.main.Item;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(OrderAnnotation.class)
public class TestHelper {

  void testItem
      (Item item,
          int daysToPass,
          int expectedSellIn,
          int expectedQuality
      ) {
    Item[] items = new Item[1];
    items[0] = item;
    GildedRose app = new GildedRose(items);
    for (int i = 0; i < daysToPass; i++) {
      app.updateQuality();
    }
    assertEquals(expectedSellIn, item.sellIn);
    assertEquals(expectedQuality, item.quality);
  }

  void testItemException(Item item) {
    checkItemForExceptionMessage(item, QUALITY_ERROR_MESSAGE);
  }

  void testItemQualityAboveLimitException(Item item) {
    checkItemForExceptionMessage(item, OUT_OF_BOUND_QUALITY_MESSAGE);
  }

  void checkItemForExceptionMessage(Item item, String message) {
    Item[] items = new Item[1];
    items[0] = item;
    GildedRose gildedRose = new GildedRose(items);
    Exception exception = assertThrows(IllegalArgumentException.class, gildedRose::updateQuality);
    String actualMessage = exception.getMessage();
    assertTrue(actualMessage.contains(message));
  }

}
