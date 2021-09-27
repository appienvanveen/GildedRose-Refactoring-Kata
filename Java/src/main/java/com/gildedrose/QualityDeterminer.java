package com.gildedrose;

public interface QualityDeterminer {

    boolean matches(Item item);

    int getQualityDegrade(Item item);

    int getCalculatedQuality(Item item);

    default int updateSellIn(Item item) {
        return item.getSellIn() - 1;
    }

    default boolean hasSellDatePassed(Item item) {
        return item.getSellIn() <= 0;
    }

    default int getDegradePace(Item item) {
        return this.hasSellDatePassed(item) ? 2 : 1;
    }
}
