package com.gildedrose.items;

import static java.lang.Math.max;

import com.gildedrose.item_helpers.ItemType;
import com.gildedrose.main.Item;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class ConjuredItem implements ItemType {

  @Getter
  public final String name = "Conjured Mana Cake";

  private final Item item;

  @Override
  public void updateQuality() {
    decrementSellInDate();
    if (beforeSellInDate()) {
      decrementQualityBy2();
    } else {
      decrementQualityBy4();
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

  private void decrementQualityBy2() {
    item.quality = max(item.quality - 2, 0);
  }

  private void decrementQualityBy4() {
    item.quality = max(item.quality - 4, 0);
  }

}
