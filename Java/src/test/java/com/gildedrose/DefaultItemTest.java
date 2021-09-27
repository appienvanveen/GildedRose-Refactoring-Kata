package com.gildedrose;

import com.gildedrose.determiners.DefaultItemQualityDeterminer;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DefaultItemTest {

    private DefaultItemQualityDeterminer determiner = new DefaultItemQualityDeterminer();

    @Test
    void testNeverNegativeQuality() {
        Item[] items = new Item[]{};
        GildedRose app = new GildedRose(Collections.singletonList(new Item("X", 2, 0, false)), determiner);
        app.updateQuality();
        assertEquals(0, app.getItems().get(0).getQuality());
    }

    @Test
    void testDegradesTwiceAsFastSellDatePassed() {
        GildedRose app = new GildedRose(Collections.singletonList(new Item("X", 0, 10, false)), determiner);
        app.updateQuality();
        assertEquals(8, app.getItems().get(0).getQuality());
    }

}
