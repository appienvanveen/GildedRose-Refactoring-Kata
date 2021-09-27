package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AgedBrieTest {

    @Test
    void testBrieIncreasInQuality(){
        Item[] items = new Item[] { new Item("Aged Brie", 2, 2) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(3, app.items[0].quality);
        assertEquals(1, app.items[0].sellIn);
    }

    @Test
    void testQualityNeverHigherThan50(){
        Item[] items = new Item[] { new Item("Aged Brie", 0, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
    }
}
