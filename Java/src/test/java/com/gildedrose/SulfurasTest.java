package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SulfurasTest {

    @Test
    void testSulfurasNeverChangesQuantityAndSellIn(){
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 20, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(10, app.items[0].quality);
        assertEquals(20, app.items[0].sellIn);
    }
}
