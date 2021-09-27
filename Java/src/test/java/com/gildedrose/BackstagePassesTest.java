package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BackstagePassesTest {

    @Test
    void testBrieIncreasesInQuality(){
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 100, 2) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(3, app.items[0].quality);
        assertEquals(99, app.items[0].sellIn);
    }

    @Test
    void testBrieIncreasesQuickerBy10orLessSellIn(){
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(22, app.items[0].quality);
        assertEquals(9, app.items[0].sellIn);
    }

    @Test
    void testBrieIncreasesQuickerBy5orLessSellIn(){
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(23, app.items[0].quality);
        assertEquals(4, app.items[0].sellIn);
    }
}
