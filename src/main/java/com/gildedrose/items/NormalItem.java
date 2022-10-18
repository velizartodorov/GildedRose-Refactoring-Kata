package com.gildedrose.items;

import static java.lang.Math.max;
import static lombok.AccessLevel.NONE;

import com.gildedrose.item_helpers.ItemType;
import com.gildedrose.main.Item;
import lombok.Getter;
import lombok.Value;

@Value
public class NormalItem implements ItemType {

  String name = "Normal";

  @Getter(NONE)
  Item item;

  @Override
  public void updateQuality() {
    decrementSellInDate();
    if (beforeSellInDate()) {
      decrementQuality();
    } else {
      decrementQualityBy2();
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

  private void decrementSellInDate() {
    item.sellIn--;
  }

  private boolean beforeSellInDate() {
    return item.sellIn >= 0;
  }

  private void decrementQuality() {
    item.quality = max(item.quality - 1, 0);
  }

  private void decrementQualityBy2() {
    item.quality = max(item.quality - 2, 0);
  }

}
