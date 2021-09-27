package com.gildedrose;

import com.gildedrose.determiners.BackstagePassesItemUpdater;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static com.gildedrose.ProductConstants.BACKSTAGE_PASSES;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BackstagePassesTest {

    private BackstagePassesItemUpdater determiner = new BackstagePassesItemUpdater();

    @Test
    void testBrieIncreasesInQuality() {
        // given
        GildedRose app = new GildedRose(Collections.singletonList(new Item(BACKSTAGE_PASSES, 100, 2, false)), determiner);

        //when
        app.updateQuality();

        //then
        assertEquals(3, app.getItems().get(0).getQuality());
        assertEquals(99, app.getItems().get(0).getSellIn());
    }

    @Test
    void testBrieIncreasesQuickerBy10orLessSellIn() {
        // given
        GildedRose app = new GildedRose(Collections.singletonList(new Item(BACKSTAGE_PASSES, 10, 20, false)), determiner);
        // when
        app.updateQuality();

        // then
        assertEquals(22, app.getItems().get(0).getQuality());
        assertEquals(9, app.getItems().get(0).getSellIn());
    }

    @Test
    void testBrieIncreasesQuickerBy5orLessSellIn() {
        // given
        GildedRose app = new GildedRose(Collections.singletonList(new Item(BACKSTAGE_PASSES, 5, 20, false)), determiner);

        // when
        app.updateQuality();

        // then
        assertEquals(23, app.getItems().get(0).getQuality());
        assertEquals(4, app.getItems().get(0).getSellIn());
    }

    @Test
    void testQualityDropsWhenAfterSellIn() {
        // given
        GildedRose app = new GildedRose(Collections.singletonList(new Item(BACKSTAGE_PASSES, -1, 20, false)), determiner);

        // when
        app.updateQuality();

        // then
        assertEquals(0, app.getItems().get(0).getQuality());
        assertEquals(-2, app.getItems().get(0).getSellIn());
    }
}
