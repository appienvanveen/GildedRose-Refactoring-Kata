package com.gildedrose;

import com.gildedrose.determiners.SulfurasQualityDeterminer;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SulfurasTest {

    @Test
    void testSulfurasNeverChangesQuantityAndSellIn() {
        GildedRose app = new GildedRose(Collections.singletonList(new Item("Sulfuras, Hand of Ragnaros", 20, 10, true)), new SulfurasQualityDeterminer());
        app.updateQuality();
        assertEquals(10, app.getItems().get(0).getQuality());
        assertEquals(20, app.getItems().get(0).getSellIn());
    }
}
