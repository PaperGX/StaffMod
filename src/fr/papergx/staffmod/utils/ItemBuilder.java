package fr.papergx.staffmod.utils;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Collections;

public class ItemBuilder {
    ItemStack itemStack;
    ItemMeta itemMeta;

    public ItemBuilder(Material material, int amount) {
        this.itemStack = new ItemStack(material);
        this.itemMeta = itemStack.getItemMeta();
    }

    public ItemBuilder(Material material, int amount, int shorts) {
        this.itemStack = new ItemStack(material, amount, (short) shorts);
        this.itemMeta = itemStack.getItemMeta();
    }

    public ItemBuilder addName(String s) {
        itemMeta.setDisplayName(s);
        return this;
    }

    public ItemBuilder addLore(String s) {
        itemMeta.setLore(Collections.singletonList(s));
        return this;
    }

    public ItemStack build() {
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
}
