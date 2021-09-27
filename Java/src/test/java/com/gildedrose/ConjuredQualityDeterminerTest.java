package com.gildedrose;

import com.gildedrose.determiners.ConjuredQualityDeterminer;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static com.gildedrose.ProductConstants.AGED_BRIE;
import static com.gildedrose.ProductConstants.CONJURED;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConjuredQualityDeterminerTest {

    private ConjuredQualityDeterminer determiner = new ConjuredQualityDeterminer();

    @Test
    void testDegradeTwiceAsFast() {
        Item item = new Item(CONJURED, 3, 4, false);

        GildedRose app = new GildedRose(Collections.singletonList(item), determiner);
        app.updateQuality();

        assertEquals(2, app.getItems().get(0).getQuality());
        assertEquals(2, app.getItems().get(0).getSellIn());
    }

}
