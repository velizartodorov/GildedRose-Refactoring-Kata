package com.gildedrose.items;

import static com.gildedrose.items.LegendaryItem.LEGENDARY_ITEM_QUALITY;
import static com.gildedrose.items.LegendaryItem.NOT_LEGENDARY_ITEM_ERROR_MESSAGE;

import com.gildedrose.helper.TestHelper;
import com.gildedrose.main.Item;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(OrderAnnotation.class)
public class LegendaryItemTest extends TestHelper {

  public static final String LEGENDARY = "Sulfuras, Hand of Ragnaros";
  private final Item item = new Item(LEGENDARY, 5, 80);
  private final Item fakeLegendaryItem = new Item(LEGENDARY, 5, 75);

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
    checkItemForExceptionMessage(fakeLegendaryItem, NOT_LEGENDARY_ITEM_ERROR_MESSAGE);
  }

}
