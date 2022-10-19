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
public class BackstagePassItemTest extends TestHelper {

  public static final String BACKSTAGE_PASS = "Backstage passes to a TAFKAL80ETC concert";

  Item item = new Item(BACKSTAGE_PASS, 15, 20);
  Item itemError = new Item(BACKSTAGE_PASS, 10, -5);
  Item itemAboveLimitQuality = new Item(BACKSTAGE_PASS, 10, 60);

  @Test
  @Order(1)
  void testIncrementQualityByOneSuccess() {
    testItem(item, 5, 10, 25);
  }

  @Test
  @Order(2)
  void testIncrementQualityByTwoSuccess() {
    testItem(item, 10, 5, 35);
  }

  @Test
  @Order(3)
  void testIncrementQualityByThreeSuccess() {
    testItem(item, 15, 0, 50);
  }

  @Test
  @Order(4)
  void testQualityZeroSuccess() {
    testItem(item, 16, -1, 0);
  }

  @Test
  @Order(5)
  void negativeQualityFail() {
    testItemException(itemError);
  }

  @Test
  @Order(6)
  void QualityAboveLimitFail() {
    testItemQualityAboveLimitException(itemAboveLimitQuality);
  }

}
