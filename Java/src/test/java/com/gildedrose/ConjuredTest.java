package com.gildedrose;

import com.gildedrose.determiners.ConjuredItemUpdater;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static com.gildedrose.ProductConstants.CONJURED;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConjuredTest {

    private ConjuredItemUpdater determiner = new ConjuredItemUpdater();

    @Test
    void testDegradeTwiceAsFast() {
        //given
        Item item = new Item(CONJURED, 3, 4, false);
        GildedRose app = new GildedRose(Collections.singletonList(item), determiner);

        //when
        app.updateQuality();

        //then
        assertEquals(2, app.getItems().get(0).getQuality());
        assertEquals(2, app.getItems().get(0).getSellIn());
    }

}
