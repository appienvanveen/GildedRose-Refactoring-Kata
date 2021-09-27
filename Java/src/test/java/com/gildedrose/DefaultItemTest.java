package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DefaultItemTest {

    @Test
    void testNeverNegativeQuality(){
        Item[] items = new Item[] { new Item("X", 2, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void testDegradesTwiceAsFastSellDatePassed(){
        Item[] items = new Item[] { new Item("X", 0, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(8, app.items[0].quality);
    }

}
