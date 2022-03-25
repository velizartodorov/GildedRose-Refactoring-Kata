package com.gildedrose.main;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(OrderAnnotation.class)
class ItemClassTest {

  private final Item item = new Item("foo", 5, 20);

  @Test
  @Order(1)
  void testItemSuccess() {
    assertEquals("foo", item.name);
    assertEquals(5, item.sellIn);
    assertEquals(20, item.quality);
    assertEquals("foo, 5, 20", item.toString());
  }

}
