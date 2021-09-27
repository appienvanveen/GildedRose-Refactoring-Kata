package com.gildedrose;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

class GildedRose {
    private List<Item> items;
    private final List<QualityDeterminer> determiners;
    private final QualityDeterminer defaultDeterminer;

    public GildedRose(List<Item> items, QualityDeterminer defaultDeterminer, QualityDeterminer... determiners) {
        this.items = items;
        this.defaultDeterminer = defaultDeterminer;
        this.determiners = Collections.unmodifiableList(Arrays.asList(determiners));
    }

    public void updateQuality() {
        items = items.stream().map(it -> {
            QualityDeterminer determiner = findDeterminer(it).orElse(this.defaultDeterminer);
            int newQuality = determiner.getCalculatedQuality(it);
            int newSellin = determiner.updateSellIn(it);
            return new Item(it.getName(), newSellin, newQuality, it.isLegendary());
        }).collect(Collectors.toList());
    }

    public List<Item> getItems() {
        return Collections.unmodifiableList(this.items);
    }

    private Optional<QualityDeterminer> findDeterminer(Item item) {
        return determiners.stream().filter(it -> it.matches(item)).findFirst();
    }
}
