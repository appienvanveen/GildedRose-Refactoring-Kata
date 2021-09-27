package com.gildedrose.determiners;

import com.gildedrose.Item;
import com.gildedrose.ItemUpdater;

import static com.gildedrose.ProductConstants.SULFURAS;

/**
 * "Sulfuras", being a legendary item, never has to be sold or decreases in Quality
 */
public class SulfurasItemUpdater implements ItemUpdater {

    @Override
    public boolean matches(Item item) {
        return item.getName().equalsIgnoreCase(SULFURAS);
    }

    @Override
    public int getQualityStep(Item item) {
        return 0;
    }

    @Override
    public int getCalculatedQuality(Item item) {
        return item.getQuality();
    }

    @Override
    public int getCalculatedSellIn(Item item) {
        return item.getSellIn();
    }

}
