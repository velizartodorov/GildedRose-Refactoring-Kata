package com.gildedrose.items;

import static java.lang.Math.min;
import static lombok.AccessLevel.NONE;

import com.gildedrose.item_helpers.ItemType;
import com.gildedrose.main.Item;
import lombok.Getter;
import lombok.Value;

@Value
public class AgedBrieItem implements ItemType {

  String name = "Aged Brie";
  
  @Getter(NONE)
  Item item;

  @Override
  public void updateQuality() {
    decrementSellInDate();
    if (beforeSellInDate()) {
      incrementQuality();
    } else {
      incrementQualityBy2();
    }
  }

  @Override
  public void validateQuality() {
    if (qualityIsNegative(item)) {
      throw new IllegalArgumentException(QUALITY_ERROR_MESSAGE + item.quality);
    } else if (qualityIsAboveLimit(item)) {
      throw new IllegalArgumentException(OUT_OF_BOUND_QUALITY_MESSAGE + item.quality);
    }
  }

  private void incrementQuality() {
    item.quality = min(item.quality + 1, QUALITY_LIMIT);
  }

  private void incrementQualityBy2() {
    item.quality = min(item.quality + 2, QUALITY_LIMIT);
  }

  private void decrementSellInDate() {
    item.sellIn--;
  }

  private boolean beforeSellInDate() {
    return item.sellIn >= 0;
  }

}
