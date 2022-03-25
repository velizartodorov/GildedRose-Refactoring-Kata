package com.gildedrose.multiple_items;

import static com.gildedrose.items.AgedBrieItem.AGED_BRIE;
import static com.gildedrose.items.BackstagePassItem.BACKSTAGE_PASS;
import static com.gildedrose.items.ConjuredItem.CONJURED;
import static com.gildedrose.items.LegendaryItem.LEGENDARY;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gildedrose.main.GildedRose;
import com.gildedrose.main.Item;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(OrderAnnotation.class)
class MultipleItemsTest {

  public static final Item normalItem1 = new Item("+5 Dexterity Vest", 10, 20);
  public static final Item agedBrieItem = new Item(AGED_BRIE, 2, 0);
  public static final Item normalItem2 = new Item("Elixir of the Mongoose", 5, 7);
  public static final Item legendaryItem1 = new Item(LEGENDARY, 0, 80);
  public static final Item legendaryItem2 = new Item(LEGENDARY, -1, 80);
  public static final Item backStagePassItem1 = new Item(BACKSTAGE_PASS, 15, 20);
  public static final Item backStagePassItem2 = new Item(BACKSTAGE_PASS, 10, 49);
  public static final Item backStagePassItem3 = new Item(BACKSTAGE_PASS, 5, 49);
  public static final Item conjuredItem = new Item(CONJURED, 3, 6);

  public static Item[] getMultipleItems() {
    return new Item[]{normalItem1, agedBrieItem, normalItem2,
        legendaryItem1, legendaryItem2,
        backStagePassItem1, backStagePassItem2, backStagePassItem3,
        conjuredItem};
  }

  @BeforeAll
  static void updateItemsQualityFor20Days() {
    Item[] items = getMultipleItems();
    GildedRose gildedRose = new GildedRose(items);
    int days = 20;
    for (int i = 0; i < days; i++) {
      gildedRose.updateQuality();
      for (Item item : items) {
        System.out.println(item);
      }
    }
  }

  @Test
  @Order(1)
  void checkNormalItem1Success() {
    assertEquals(-10, normalItem1.sellIn);
    assertEquals(0, normalItem1.quality);
  }

  @Test
  @Order(2)
  void checkAgedBrieSuccess() {
    assertEquals(-18, agedBrieItem.sellIn);
    assertEquals(38, agedBrieItem.quality);
  }

  @Test
  @Order(3)
  void checkNormalItem2Success() {
    assertEquals(-15, normalItem2.sellIn);
    assertEquals(0, normalItem2.quality);
  }

  @Test
  @Order(4)
  void checkLegendaryItem1Success() {
    assertEquals(-20, legendaryItem1.sellIn);
    assertEquals(80, legendaryItem1.quality);
  }

  @Test
  @Order(5)
  void checkLegendaryItem2Success() {
    assertEquals(-21, legendaryItem2.sellIn);
    assertEquals(80, legendaryItem2.quality);
  }

  @Test
  @Order(6)
  void checkBackStagePass1Success() {
    assertEquals(-5, backStagePassItem1.sellIn);
    assertEquals(0, backStagePassItem1.quality);
  }

  @Test
  @Order(7)
  void checkBackStagePass2Success() {
    assertEquals(-10, backStagePassItem2.sellIn);
    assertEquals(0, backStagePassItem2.quality);
  }

  @Test
  @Order(8)
  void checkBackStagePass3Success() {
    assertEquals(-15, backStagePassItem3.sellIn);
    assertEquals(0, backStagePassItem3.quality);
  }

  @Test
  @Order(9)
  void checkConjuredItemSuccess() {
    assertEquals(-17, conjuredItem.sellIn);
    assertEquals(0, conjuredItem.quality);
  }

}
