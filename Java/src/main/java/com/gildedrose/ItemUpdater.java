package com.gildedrose;

public interface ItemUpdater {

    /**
     * Determines if the determiner matches the item
     *
     * @param item
     * @return
     */
    boolean matches(Item item);

    /**
     * Returns with which value the quality will improve or degrade
     *
     * @param item
     * @return
     */
    int getQualityStep(Item item);

    /**
     * Returns the calculated quality
     *
     * @param item
     * @return
     */
    int getCalculatedQuality(Item item);

    /**
     * Return the calculated SellIn
     *
     * @param item
     * @return
     */
    default int getCalculatedSellIn(Item item) {
        return item.getSellIn() - 1;
    }

    /**
     * determines if the selldate has passed
     *
     * @param item
     * @return true or false
     */
    default boolean hasSellDatePassed(Item item) {
        return item.getSellIn() <= 0;
    }

    /**
     * Once the sell by date has passed, Quality degrades twice as fast
     *
     * @param item
     * @return the pace of degrading
     */
    default int getDegradePace(Item item) {
        return this.hasSellDatePassed(item) ? 2 : 1;
    }
}
