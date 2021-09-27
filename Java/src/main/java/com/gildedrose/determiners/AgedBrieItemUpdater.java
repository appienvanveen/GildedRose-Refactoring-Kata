package com.gildedrose.determiners;

import com.gildedrose.Item;
import com.gildedrose.ItemUpdater;

import static com.gildedrose.ProductConstants.AGED_BRIE;

/**
 * "Aged Brie" actually increases in Quality the older it gets
 */
public class AgedBrieItemUpdater implements ItemUpdater {

    @Override
    public boolean matches(Item item) {
        return item.getName().equalsIgnoreCase(AGED_BRIE);
    }

    @Override
    public int getQualityStep(Item item) {
        return 1;
    }

    @Override
    public int getCalculatedQuality(Item item) {
        return item.getQuality() + (this.getQualityStep(item) * this.getDegradePace(item));
    }

}
