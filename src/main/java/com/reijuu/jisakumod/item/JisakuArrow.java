package com.reijuu.jisakumod.item;

import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.ItemStack;

public class JisakuArrow extends BowItem {
    public static int ARROW_DAMAGE = 1000;

    public JisakuArrow() {
        super(new Properties().durability(500));
    }

    @Override
    public int getDamage(ItemStack stack) {
        return ARROW_DAMAGE;
    }

    public int getDefaultProjectileRange() {
        return 5000;
    }
}
