package com.gildedrose.determiners;

import com.gildedrose.Item;
import com.gildedrose.QualityDeterminer;

import static com.gildedrose.ProductConstants.BACKSTAGE_PASSES;

public class BackstagePassesQualityDeterminer implements QualityDeterminer {

    @Override
    public boolean matches(Item item) {
        return item.getName().equalsIgnoreCase(BACKSTAGE_PASSES);
    }

    @Override
    public int getQualityDegrade(Item item) {
        if (item.getSellIn() <= 5) {
            return 3;
        } else if (item.getSellIn() <= 10) {
            return 2;
        }
        return 1;
    }

    @Override
    public int getCalculatedQuality(Item item) {
        if (item.getSellIn() < 0) {
            return 0;
        } else {
            return item.getQuality() + (this.getQualityDegrade(item) * this.getDegradePace(item));
        }
    }
}
