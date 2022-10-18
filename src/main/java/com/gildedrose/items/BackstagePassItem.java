package com.gildedrose.items;

import static java.lang.Math.min;

import com.gildedrose.item_helpers.ItemType;
import com.gildedrose.main.Item;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class BackstagePassItem implements ItemType {

  @Getter
  private final String name = "Backstage passes to a TAFKAL80ETC concert";

  private final Item item;

  @Override
  public void updateQuality() {
    decrementSellInDate();
    if (moreThan10DaysToSellIn()) {
      incrementQuality();
    } else if (lessThan10DaysToSellIn()) {
      incrementQualityBy2();
    } else if (lessThan5DaysToSellIn()) {
      incrementQualityBy3();
    } else {
      makeQualityZero();
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

  private boolean lessThan5DaysToSellIn() {
    return item.sellIn >= 0 && item.sellIn <= 5;
  }

  private boolean lessThan10DaysToSellIn() {
    return item.sellIn >= 5 && item.sellIn <= 10;
  }

  private boolean moreThan10DaysToSellIn() {
    return item.sellIn >= 10;
  }

  private void makeQualityZero() {
    item.quality = 0;
  }

  private void incrementQuality() {
    item.quality = min(item.quality + 1, QUALITY_LIMIT);
  }

  private void incrementQualityBy2() {
    item.quality = min(item.quality + 2, QUALITY_LIMIT);
  }

  private void incrementQualityBy3() {
    item.quality = min(item.quality + 3, QUALITY_LIMIT);
  }

}
