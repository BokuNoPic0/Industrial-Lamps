package ru.ICY.lamp.Other;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class CreativeTab extends CreativeTabs {
    ItemStack icon;
    public CreativeTab(String label,ItemStack icon) {
        super(label);
        this.icon=icon;
    }
    @Override
    public ItemStack createIcon() {
        return icon;
    }
}