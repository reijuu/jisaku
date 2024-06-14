package com.reijuu.jisakumod.item;

import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.ItemStack;

public class JisakuArrow extends BowItem {

    public JisakuArrow() {
        super(new Properties().durability(500));
    }

    @Override
    public int getMaxDamage(ItemStack stack) {
        return 1000;
    }

    public int getDefaultProjectileRange() {
        return 5000;
    }
}
