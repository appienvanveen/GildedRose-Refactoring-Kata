package com.gildedrose;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

class GildedRose {
    private List<Item> items;
    private final List<ItemUpdater> determiners;
    private final ItemUpdater defaultDeterminer;

    public GildedRose(List<Item> items, ItemUpdater defaultDeterminer, ItemUpdater... determiners) {
        this.items = items;
        this.defaultDeterminer = defaultDeterminer;
        this.determiners = Collections.unmodifiableList(Arrays.asList(determiners));
    }

    public void updateQuality() {
        items = items.stream().map(it -> {
            ItemUpdater determiner = findDeterminer(it).orElse(this.defaultDeterminer);
            int newQuality = determiner.getCalculatedQuality(it);
            int newSellIn = determiner.getCalculatedSellIn(it);
            return new Item(it.getName(), newSellIn, newQuality, it.isLegendary());
        }).collect(Collectors.toList());
    }

    public List<Item> getItems() {
        return Collections.unmodifiableList(this.items);
    }

    private Optional<ItemUpdater> findDeterminer(Item item) {
        return determiners.stream().filter(it -> it.matches(item)).findFirst();
    }
}
