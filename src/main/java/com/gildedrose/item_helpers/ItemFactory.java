package com.gildedrose.item_helpers;

import static java.util.stream.Collectors.toMap;
import static java.util.stream.Stream.of;

import com.gildedrose.items.AgedBrieItem;
import com.gildedrose.items.BackstagePassItem;
import com.gildedrose.items.ConjuredItem;
import com.gildedrose.items.LegendaryItem;
import com.gildedrose.items.NormalItem;
import com.gildedrose.main.Item;

public final class ItemFactory {

  private ItemFactory() {
  }

  public static ItemType getItemType(Item item) {
    ItemType itemType = getItem(item);
    if (itemType == null) {
      itemType = new NormalItem(item);
    }
    return itemType;
  }

  private static ItemType getItem(Item item) {
    return of(new NormalItem(item), new AgedBrieItem(item), new LegendaryItem(item),
        new BackstagePassItem(item), new ConjuredItem(item))
        .collect(toMap(ItemType::getName, itemType -> itemType))
        .get(item.name);
  }

}
