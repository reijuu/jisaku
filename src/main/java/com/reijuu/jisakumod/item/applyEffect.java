package com.reijuu.jisakumod.item;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

public interface applyEffect {
    void applyEffect(ItemStack stack, LivingEntity shooter, AbstractArrowEntity arrowEntity);
}
