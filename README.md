# Gilded Rose Kata in Java

Forked Java version of the Gilded-Rose-Refactoring-Kate project, original can be found
[here](https://github.com/emilybache/GildedRose-Refactoring-Kata).

# Requirements

## Gilded Rose Requirements Specification

Hi and welcome to team Gilded Rose. As you know, we are a small inn with a prime location in a
prominent city ran by a friendly innkeeper named Allison. We also buy and sell only the finest
goods. Unfortunately, our goods are constantly degrading in quality as they approach their sell by
date. We have a system in place that updates our inventory for us. It was developed by a no-nonsense
type named Leeroy, who has moved on to new adventures. Your task is to add the new feature to our
system so that we can begin selling a new category of items. First an introduction to our system:

	- All items have a SellIn value which denotes the number of days we have to sell the item
	- All items have a Quality value which denotes how valuable the item is
	- At the end of each day our system lowers both values for every item

Pretty simple, right? Well this is where it gets interesting:

	- Once the sell by date has passed, Quality degrades twice as fast
	- The Quality of an item is never negative
	- "Aged Brie" actually increases in Quality the older it gets
	- The Quality of an item is never more than 50
	- "Sulfuras", being a legendary item, never has to be sold or decreases in Quality
	- "Backstage passes", like aged brie, increases in Quality as its SellIn value approaches;
	Quality increases by 2 when there are 10 days or less and by 3 when there are 5 days or less but
	Quality drops to 0 after the concert

We have recently signed a supplier of conjured items. This requires an update to our system:

	- "Conjured" items degrade in Quality twice as fast as normal items

Feel free to make any changes to the UpdateQuality method and add any new code as long as everything
still works correctly. However, do not alter the Item class or Items property as those belong to the
goblin in the corner who will insta-rage and one-shot you as he doesn't believe in shared code
ownership (you can make the UpdateQuality method and Items property static if you like, we'll cover
for you).

Just for clarification, an item can never have its Quality increase above 50, however "Sulfuras" is
a legendary item and as such its Quality is 80 and it never alters.

# Notes

* `Test` must not break the original contract
* `GildedRose` class must not break the original contract

## Item rules

* Quality increases or decreases when sell-in days pass or is constant.
* Quality of an item cannot be negative value.
* Quality of an item cannot be higher than 50.
* If item is Legendary, it's quality is always 80 and never changes.

## Types of items

| **Item Type**           | **Description**                                                                    | **Behavior**                                                                                                                                                |
|-------------------------|------------------------------------------------------------------------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **General Items**       | All standard items sold at the inn.                                                | - Quality and SellIn decrease by 1 daily.<br> - After the sell-by date, Quality degrades twice as fast.<br> - Quality cannot be negative.                   |
| **Aged Brie**           | A special cheese that becomes more valuable over time.                             | - Quality increases as it ages.<br> - Quality cannot exceed 50.                                                                                             |
| **Sulfuras**            | A legendary item with immutable properties.                                        | - Quality is fixed at 80.<br> - Does not need to be sold.<br> - Does not degrade in Quality.                                                                |
| **Backstage Passes**    | Tickets that gain value as the concert date approaches but become worthless after. | - Quality increases as SellIn approaches:<br>   - +2 when 10 days or less.<br>   - +3 when 5 days or less.<br> - Quality drops to 0 after the concert date. |
| **Conjured Items**      | Recently introduced items that degrade faster than normal items.                   | - Quality degrades twice as fast as normal items.<br> - Quality cannot be negative.                                                                         |



# Release notes

## After v. 1.0

- fixed bug in quality changes
- designed it using rich models

## v 1.0

- designed it with anemic models
