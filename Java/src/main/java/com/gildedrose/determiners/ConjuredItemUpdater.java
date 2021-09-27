package com.gildedrose.determiners;

import com.gildedrose.Item;
import com.gildedrose.ItemUpdater;

import static com.gildedrose.ProductConstants.CONJURED;

/*
 * "Conjured" items degrade in Quality twice as fast as normal items
 */
public class ConjuredItemUpdater implements ItemUpdater {

    @Override
    public boolean matches(Item item) {
        return item.getName().equalsIgnoreCase(CONJURED);
    }

    @Override
    public int getQualityStep(Item item) {
        return 1;
    }

    @Override
    public int getDegradePace(Item item) {
        return 2;
    }

    @Override
    public int getCalculatedQuality(Item item) {
        return item.getQuality() - (this.getQualityStep(item) * this.getDegradePace(item));
    }
}
