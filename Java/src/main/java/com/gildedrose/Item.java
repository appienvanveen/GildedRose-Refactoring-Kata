package com.gildedrose;

public class Item {

    /*
    Max quality for non_legenda
     */
    private static final int MAX_QUALITY = 50;

    private final String name;
    private final int sellIn;
    private final int quality;
    private final boolean isLegendary;

    public Item(String name, int sellIn, int quality, boolean isLegendary) {
        this.name = name;
        this.sellIn = sellIn;
        this.isLegendary = isLegendary;
        if (this.isLegendary) {
            this.quality = quality;
        } else {
            if (quality < 0) {
                this.quality = 0;
            } else if (quality > 50) {
                this.quality = MAX_QUALITY;
            }
            else{
                this.quality = quality;
            }
        }
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

}
