package com.gildedrose.items;

import static lombok.AccessLevel.PRIVATE;

import com.gildedrose.main.Item;
import lombok.experimental.FieldDefaults;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

@FieldDefaults(makeFinal = true, level = PRIVATE)
public class AgedBrieItemTest extends TestHelper {

  public final static String AGED_BRIE = "Aged Brie";

  Item item = new Item(AGED_BRIE, 5, 20);
  Item itemError = new Item(AGED_BRIE, 10, -5);
  Item itemAboveLimitQuality = new Item(AGED_BRIE, 10, 60);

  @Test
  @Order(1)
  void incrementQualityByOneSuccess() {
    testItem(item, 2, 3, 22);
  }

  @Test
  @Order(2)
  void incrementQualityByTwoSuccess() {
    testItem(item, 7, -2, 29);
  }

  @Test
  @Order(3)
  void negativeQualityFail() {
    testItemException(itemError);
  }

  @Test
  @Order(4)
  void qualityAboveLimitFail() {
    testItemQualityAboveLimitException(itemAboveLimitQuality);
  }

}
