package com.gildedrose.main;

import lombok.AllArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
public class Item {

  public final String name;
  public int sellIn;
  public int quality;
}
