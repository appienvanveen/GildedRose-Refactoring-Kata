package com.gildedrose;

import com.gildedrose.determiners.DefaultItemItemUpdater;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DefaultItemTest {

    private DefaultItemItemUpdater determiner = new DefaultItemItemUpdater();

    @Test
    void testNeverNegativeQuality() {
        //given
        GildedRose app = new GildedRose(Collections.singletonList(new Item("X", 2, 0, false)), determiner);
        //when
        app.updateQuality();

        //then
        assertEquals(0, app.getItems().get(0).getQuality());
    }

    @Test
    void testDegradesTwiceAsFastSellDatePassed() {
        //given
        GildedRose app = new GildedRose(Collections.singletonList(new Item("X", 0, 10, false)), determiner);

        //when
        app.updateQuality();

        //then
        assertEquals(8, app.getItems().get(0).getQuality());
    }

}
