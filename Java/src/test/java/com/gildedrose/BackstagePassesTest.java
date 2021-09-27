package com.gildedrose;

import com.gildedrose.determiners.BackstagePassesQualityDeterminer;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BackstagePassesTest {

    private BackstagePassesQualityDeterminer determiner = new BackstagePassesQualityDeterminer();

    @Test
    void testBrieIncreasesInQuality() {
        GildedRose app = new GildedRose(Collections.singletonList(new Item("Backstage passes to a TAFKAL80ETC concert", 100, 2, false)), determiner);
        app.updateQuality();
        assertEquals(3, app.getItems().get(0).getQuality());
        assertEquals(99, app.getItems().get(0).getSellIn());
    }

    @Test
    void testBrieIncreasesQuickerBy10orLessSellIn() {
        GildedRose app = new GildedRose(Collections.singletonList(new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20, false)), determiner);
        app.updateQuality();
        assertEquals(22, app.getItems().get(0).getQuality());
        assertEquals(9, app.getItems().get(0).getSellIn());
    }

    @Test
    void testBrieIncreasesQuickerBy5orLessSellIn() {
        GildedRose app = new GildedRose(Collections.singletonList(new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20, false)), determiner);
        app.updateQuality();
        assertEquals(23, app.getItems().get(0).getQuality());
        assertEquals(4, app.getItems().get(0).getSellIn());
    }

    @Test
    void testQualityDropsWhenAfterSellIn() {
        GildedRose app = new GildedRose(Collections.singletonList(new Item("Backstage passes to a TAFKAL80ETC concert", -1, 20, false)), determiner);
        app.updateQuality();
        assertEquals(0, app.getItems().get(0).getQuality());
        assertEquals(-2, app.getItems().get(0).getSellIn());
    }
}
