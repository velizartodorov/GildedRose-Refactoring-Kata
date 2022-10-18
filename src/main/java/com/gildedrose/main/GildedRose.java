package com.gildedrose.main;

import static com.gildedrose.item_helpers.ItemFactory.getItemType;
import static java.util.Arrays.stream;
import static lombok.AccessLevel.PUBLIC;

import com.gildedrose.item_helpers.ItemType;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = PUBLIC)
public class GildedRose {

  Item[] items;

  public void updateQuality() {
    stream(items).forEach(item -> {
      ItemType itemType = getItemType(item);
      itemType.validateQuality();
      itemType.updateQuality();
    });
  }
}
