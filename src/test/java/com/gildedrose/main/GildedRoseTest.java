package com.gildedrose.main;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class GildedRoseTest {

  @Test
  void foo() {
    Item[] items = new Item[]{new Item("foo", 0, 0)};
    GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertEquals("foo", app.items[0].name);
  }

}
