package com.gildedrose;

public class Item {

    /*
    Max quality for non legendary items
     */
    private static final int MAX_QUALITY_NON_LEGANDARY_ITEMS = 50;

    private final String name;
    private final int sellIn;
    private final int quality;
    private final boolean isLegendary;

    public Item(String name, int sellIn, int quality, boolean isLegendary) {
        this.name = name;
        this.sellIn = sellIn;
        this.isLegendary = isLegendary;
        this.quality = determineQuality(quality);
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality + ", " + this.isLegendary;
    }

    public String getName() {
        return name;
    }

    public int getSellIn() {
        return sellIn;
    }

    public int getQuality() {
        return quality;
    }

    public boolean isLegendary() {
        return isLegendary;
    }

    /**
     * The Quality of an item is never more than 50
     * The Quality of an item is never negative
     *
     * @param quality
     * @return the quality
     */
    private int determineQuality(int quality) {
        if (!this.isLegendary) {
            if (quality < 0) {
                return 0;
            } else if (quality > MAX_QUALITY_NON_LEGANDARY_ITEMS) {
                return MAX_QUALITY_NON_LEGANDARY_ITEMS;
            }
        }
        return quality;
    }

}
