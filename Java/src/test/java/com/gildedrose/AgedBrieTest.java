package com.gildedrose;

import com.gildedrose.determiners.AgedBrieItemUpdater;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static com.gildedrose.ProductConstants.AGED_BRIE;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AgedBrieTest {

    private AgedBrieItemUpdater determiner = new AgedBrieItemUpdater();

    @Test
    void testBrieIncreasInQuality() {
        //given
        Item item = new Item(AGED_BRIE, 2, 2, false);
        GildedRose app = new GildedRose(Collections.singletonList(item), determiner);
        //when
        app.updateQuality();

        //then
        assertEquals(3, app.getItems().get(0).getQuality());
        assertEquals(1, app.getItems().get(0).getSellIn());
    }

    @Test
    void testQualityNeverHigherThan50() {
        //given
        GildedRose app = new GildedRose(Collections.singletonList(new Item(AGED_BRIE, 0, 50, false)), determiner);

        //when
        app.updateQuality();

        //then
        assertEquals(50, app.getItems().get(0).getQuality());
    }

}
