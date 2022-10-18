package com.gildedrose.main;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Item {

  public final String name;

  public int sellIn;

  public int quality;

  @Override
  public String toString() {
    return this.name + ", " + this.sellIn + ", " + this.quality;
  }
}
