package com.gildedrose.items;

import static lombok.AccessLevel.PRIVATE;

import com.gildedrose.main.Item;
import lombok.experimental.FieldDefaults;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

@FieldDefaults(makeFinal = true, level = PRIVATE)
public class LegendaryItemTest extends TestHelper {

  public static final String LEGENDARY = "Sulfuras, Hand of Ragnaros";
  int LEGENDARY_ITEM_QUALITY = 80;
  Item item = new Item(LEGENDARY, 5, 80);
  Item fakeLegendaryItem = new Item(LEGENDARY, 5, 75);

  @Test
  @Order(1)
  void getLegendaryQualityBeforeSellInDateSuccess() {
    testItem(item, 2, 3, LEGENDARY_ITEM_QUALITY);
  }

  @Test
  @Order(2)
  void getLegendaryQualityPassSellInDateSuccess() {
    testItem(item, 10, -5, LEGENDARY_ITEM_QUALITY);
  }

  @Test
  @Order(3)
  void testFakeLegendaryItemExceptionFail() {
    String NOT_LEGENDARY_ITEM_ERROR_MESSAGE = "Item is legendary, quality must be always 80! Current value: ";
    checkItemForExceptionMessage(fakeLegendaryItem, NOT_LEGENDARY_ITEM_ERROR_MESSAGE);
  }

}
