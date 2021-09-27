package com.gildedrose.determiners;

import com.gildedrose.Item;
import com.gildedrose.QualityDeterminer;

import static com.gildedrose.ProductConstants.SULFURAS;

public class SulfurasQualityDeterminer implements QualityDeterminer {

    @Override
    public boolean matches(Item item) {
        return item.getName().equalsIgnoreCase(SULFURAS);
    }

    @Override
    public int getQualityDegrade(Item item) {
        return 0;
    }

    @Override
    public int getCalculatedQuality(Item item) {
        return item.getQuality();
    }

    @Override
    public int updateSellIn(Item item) {
        return item.getSellIn();
    }

}
