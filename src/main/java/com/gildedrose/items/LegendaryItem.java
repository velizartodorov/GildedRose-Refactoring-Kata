package com.gildedrose.items;

import static lombok.AccessLevel.NONE;

import com.gildedrose.item_helpers.ItemType;
import com.gildedrose.main.Item;
import lombok.Getter;
import lombok.Value;

@Value
public class LegendaryItem implements ItemType {

  String name = "Sulfuras, Hand of Ragnaros";

  @Getter(NONE)
  Item item;

  @Override
  public void updateQuality() {
    decrementSellInDate();
  }

  @Override
  public void validateQuality() {
    if (isNotLegendary(item)) {
      String errorMessage = "Item is legendary, quality must be always 80! Current value: ";
      throw new IllegalArgumentException(errorMessage + item.quality);
    }
  }

  private boolean isNotLegendary(Item item) {
    return item.quality != 80;
  }

  private void decrementSellInDate() {
    item.sellIn--;
  }

}
