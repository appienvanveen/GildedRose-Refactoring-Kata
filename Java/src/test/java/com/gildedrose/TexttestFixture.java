package com.gildedrose;

import com.gildedrose.determiners.AgedBrieQualityDeterminer;
import com.gildedrose.determiners.BackstagePassesQualityDeterminer;
import com.gildedrose.determiners.DefaultItemQualityDeterminer;
import com.gildedrose.determiners.SulfurasQualityDeterminer;

import java.util.Arrays;

public class TexttestFixture {
    public static void main(String[] args) {
        System.out.println("OMGHAI!");


        Item[] items = new Item[]{

            new Item("+5 Dexterity Vest", 10, 20, false), //
            new Item("Aged Brie", 2, 0, false), //
            new Item("Elixir of the Mongoose", 5, 7, false), //
            new Item("Sulfuras, Hand of Ragnaros", 0, 80, true), //
            new Item("Sulfuras, Hand of Ragnaros", -1, 80, true),
            new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20, false),
            new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49, false),
            new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49, false),
            // this conjured item does not work properly yet
            new Item("Conjured Mana Cake", 3, 6, false)};

        GildedRose app = new GildedRose(Arrays.asList(items), new DefaultItemQualityDeterminer(), new BackstagePassesQualityDeterminer(), new AgedBrieQualityDeterminer(), new SulfurasQualityDeterminer());

        int days = 2;
        if (args.length > 0) {
            days = Integer.parseInt(args[0]) + 1;
        }

        for (int i = 0; i < days; i++) {
            System.out.println("-------- day " + i + " --------");
            System.out.println("name, sellIn, quality");
            for (Item item : items) {
                System.out.println(item);
            }
            System.out.println();
            app.updateQuality();
        }
    }

}
