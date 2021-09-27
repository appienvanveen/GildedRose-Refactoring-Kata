package com.gildedrose.determiners;

import com.gildedrose.Item;
import com.gildedrose.QualityDeterminer;

public class DefaultItemQualityDeterminer implements QualityDeterminer {

    @Override
    public boolean matches(Item item) {
        throw new RuntimeException("The matches method should not be called on the DefaultItemQualityDeterminer");
    }

    @Override
    public int getQualityDegrade(Item item) {
        return 1;
    }

    @Override
    public int getCalculatedQuality(Item item) {
        return item.getQuality() - (this.getQualityDegrade(item) * this.getDegradePace(item));
    }

}
