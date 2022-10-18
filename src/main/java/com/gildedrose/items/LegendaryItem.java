package com.gildedrose.items;

import com.gildedrose.item_helpers.ItemType;
import com.gildedrose.main.Item;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class LegendaryItem implements ItemType {

  @Getter
  private final String name = "Sulfuras, Hand of Ragnaros";
  public static final int LEGENDARY_ITEM_QUALITY = 80;
  public static final String NOT_LEGENDARY_ITEM_ERROR_MESSAGE = "Item is legendary, quality must be always 80! Current value: ";

  private final Item item;

  @Override
  public void updateQuality() {
    decrementSellInDate();
  }

  @Override
  public void validateQuality() {
    if (qualityIsNotLegendary(item)) {
      throw new IllegalArgumentException(NOT_LEGENDARY_ITEM_ERROR_MESSAGE + item.quality);
    }
  }

  private static boolean qualityIsNotLegendary(Item item) {
    return item.quality != LEGENDARY_ITEM_QUALITY;
  }

  private void decrementSellInDate() {
    item.sellIn--;
  }

}
