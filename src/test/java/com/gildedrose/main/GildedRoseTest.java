package com.gildedrose.main;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.gildedrose.item_helpers.ItemFactory;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import org.junit.jupiter.api.Test;

class GildedRoseTest {

  @Test
  void foo() {
    Item[] items = new Item[]{new Item("foo", 0, 0)};
    GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertEquals("foo", app.items[0].name);
  }

  @Test
  void itemFactoryTestFail() {
    Exception exception = assertThrows(InvocationTargetException.class, () -> {
      Constructor<ItemFactory> constructor = ItemFactory.class.getDeclaredConstructor();
      constructor.setAccessible(true);
      constructor.newInstance();
    });
    String expectedMessage = "This is a utility class and cannot be instantiated";
    String actualMessage = exception.getCause().getMessage();
    assertTrue(actualMessage.contains(expectedMessage));
  }

}
