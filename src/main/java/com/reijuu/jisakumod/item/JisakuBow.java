package com.reijuu.jisakumod.item;

import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.ItemStack;

import java.util.function.Predicate;

public class JisakuBow extends BowItem {

    public JisakuBow() {
        super(new Properties());
    }

    public int getDefaultProjectileRange() {
        return 5000;
    }

    @Override
    public Predicate<ItemStack> getAllSupportedProjectiles() {
        return (stack) -> stack.getItem() instanceof CsutomArrow;
    }// カスタム弾薬を使用する
}