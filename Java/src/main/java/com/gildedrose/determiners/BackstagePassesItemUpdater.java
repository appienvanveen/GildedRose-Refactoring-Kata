package com.gildedrose.determiners;

import com.gildedrose.Item;
import com.gildedrose.ItemUpdater;

import static com.gildedrose.ProductConstants.BACKSTAGE_PASSES;

/**
 * "Backstage passes", like aged brie, increases in Quality as its SellIn value approaches;
 * Quality increases by 2 when there are 10 days or less and by 3 when there are 5 days or less but
 * Quality drops to 0 after the concert
 */
public class BackstagePassesItemUpdater implements ItemUpdater {

    @Override
    public boolean matches(Item item) {
        return item.getName().equalsIgnoreCase(BACKSTAGE_PASSES);
    }

    @Override
    public int getQualityStep(Item item) {
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
            return item.getQuality() + (this.getQualityStep(item) * this.getDegradePace(item));
        }
    }
}
