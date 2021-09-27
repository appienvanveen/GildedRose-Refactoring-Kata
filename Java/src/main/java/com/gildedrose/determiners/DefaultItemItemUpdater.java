package com.gildedrose.determiners;

import com.gildedrose.Item;
import com.gildedrose.ItemUpdater;

public class DefaultItemItemUpdater implements ItemUpdater {

    @Override
    public boolean matches(Item item) {
        throw new RuntimeException("The matches method should not be called on the DefaultItemQualityDeterminer");
    }

    @Override
    public int getQualityStep(Item item) {
        return 1;
    }

    @Override
    public int getCalculatedQuality(Item item) {
        return item.getQuality() - (this.getQualityStep(item) * this.getDegradePace(item));
    }

}
