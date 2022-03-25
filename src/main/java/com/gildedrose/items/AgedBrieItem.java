package com.gildedrose.items;

import static com.gildedrose.item_helpers.ItemType.qualityIsAboveLimit;
import static com.gildedrose.item_helpers.ItemType.qualityIsNegative;
import static java.lang.Math.min;

import com.gildedrose.item_helpers.ItemType;
import com.gildedrose.main.Item;

public class AgedBrieItem implements ItemType {

  public static final String AGED_BRIE = "Aged Brie";

  private final Item item;

  public AgedBrieItem(Item item) {
    this.item = item;
  }

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

  @Override
  public String getName() {
    return AGED_BRIE;
  }

  public void incrementQuality() {
    item.quality = min(item.quality + 1, QUALITY_LIMIT);
  }

  public void incrementQualityBy2() {
    item.quality = min(item.quality + 2, QUALITY_LIMIT);
  }

  public void decrementSellInDate() {
    item.sellIn--;
  }

  public boolean beforeSellInDate() {
    return item.sellIn >= 0;
  }

}
