package com.gildedrose.determiners;

import com.gildedrose.Item;
import com.gildedrose.QualityDeterminer;

import static com.gildedrose.ProductConstants.CONJURED;

public class ConjuredQualityDeterminer implements QualityDeterminer {

    @Override
    public boolean matches(Item item) {
        return item.getName().equalsIgnoreCase(CONJURED);
    }

    @Override
    public int getQualityDegrade(Item item) {
        return 1;
    }

    @Override
    public int getDegradePace(Item item) {
        return 2;
    }

    @Override
    public int getCalculatedQuality(Item item) {
        return item.getQuality() - (this.getQualityDegrade(item) * this.getDegradePace(item));
    }
}
