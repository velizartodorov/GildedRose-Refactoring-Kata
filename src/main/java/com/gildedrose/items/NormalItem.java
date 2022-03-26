package com.gildedrose.items;

import static com.gildedrose.item_helpers.ItemType.qualityIsAboveLimit;
import static com.gildedrose.item_helpers.ItemType.qualityIsNegative;
import static java.lang.Math.max;

import com.gildedrose.item_helpers.ItemType;
import com.gildedrose.main.Item;

public class NormalItem implements ItemType {

  public static final String NORMAL = "Normal";
  private final Item item;

  public NormalItem(Item item) {
    this.item = item;
  }

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

  @Override
  public String getName() {
    return NORMAL;
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
