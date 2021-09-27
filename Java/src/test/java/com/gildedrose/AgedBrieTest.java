package com.gildedrose;

import com.gildedrose.determiners.AgedBrieQualityDeterminer;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static com.gildedrose.ProductConstants.AGED_BRIE;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AgedBrieTest {

    private AgedBrieQualityDeterminer determiner = new AgedBrieQualityDeterminer();

    @Test
    void testBrieIncreasInQuality() {
        Item item = new Item(AGED_BRIE, 2, 2, false);

        GildedRose app = new GildedRose(Collections.singletonList(item), determiner);
        app.updateQuality();

        assertEquals(3, app.getItems().get(0).getQuality());
        assertEquals(1, app.getItems().get(0).getSellIn());
    }

    @Test
    void testQualityNeverHigherThan50() {
        GildedRose app = new GildedRose(Collections.singletonList(new Item(AGED_BRIE, 0, 50, false)), determiner);
        app.updateQuality();
        assertEquals(50, app.getItems().get(0).getQuality());
    }

}
