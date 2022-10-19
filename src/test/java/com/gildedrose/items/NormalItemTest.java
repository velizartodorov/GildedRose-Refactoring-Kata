package com.gildedrose.items;

import static lombok.AccessLevel.PRIVATE;

import com.gildedrose.main.Item;
import lombok.experimental.FieldDefaults;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(OrderAnnotation.class)
@FieldDefaults(makeFinal = true, level = PRIVATE)
class NormalItemTest extends TestHelper {

  String NORMAL = "Normal";

  Item item = new Item(NORMAL, 5, 20);
  Item itemNegativeQuality = new Item(NORMAL, 10, -5);
  Item itemAboveLimitQuality = new Item(NORMAL, 10, 60);

  @Test
  @Order(1)
  void decrementQualityByOneSuccess() {
    testItem(item, 2, 3, 18);
  }

  @Test
  @Order(2)
  void decrementQualityByTwoSuccess() {
    testItem(item, 10, -5, 5);
  }

  @Test
  @Order(3)
  void negativeQualityFail() {
    testItemException(itemNegativeQuality);
  }

  @Test
  @Order(4)
  void QualityAboveLimitFail() {
    testItemQualityAboveLimitException(itemAboveLimitQuality);
  }
}
