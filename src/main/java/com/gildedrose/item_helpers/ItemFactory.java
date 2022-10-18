package com.gildedrose.item_helpers;

import static java.util.stream.Collectors.toMap;
import static java.util.stream.Stream.of;
import static lombok.AccessLevel.PRIVATE;

import com.gildedrose.items.AgedBrieItem;
import com.gildedrose.items.BackstagePassItem;
import com.gildedrose.items.ConjuredItem;
import com.gildedrose.items.LegendaryItem;
import com.gildedrose.items.NormalItem;
import com.gildedrose.main.Item;
import java.util.stream.Stream;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = PRIVATE)
public final class ItemFactory {

  public static ItemType getItemType(Item item) {
    return getItems(item)
        .collect(toMap(ItemType::getName, itemType -> itemType))
        .computeIfAbsent(item.name, (itemType -> new NormalItem(item)));
  }

  private static Stream<ItemType> getItems(Item item) {
    return of(new NormalItem(item), new AgedBrieItem(item), new LegendaryItem(item),
        new BackstagePassItem(item), new ConjuredItem(item));
  }

}
