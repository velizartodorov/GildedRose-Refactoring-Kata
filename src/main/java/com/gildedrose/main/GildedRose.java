package com.gildedrose.main;

import static com.gildedrose.item_helpers.ItemFactory.getItemType;
import static java.util.Arrays.stream;

import com.gildedrose.item_helpers.ItemType;

public class GildedRose {

  final Item[] items;

  public GildedRose(Item[] items) {
    this.items = items;
  }

  public void updateQuality() {
    stream(items).forEach(item -> {
      ItemType itemType = getItemType(item);
      itemType.validateQuality();
      itemType.updateQuality();
    });
  }
}
