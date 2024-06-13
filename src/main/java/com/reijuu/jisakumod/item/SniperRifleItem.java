package com.reijuu.jisakumod.item;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.projectile.AbstractArrow;

public interface SniperRifleItem {
    void onEntityHit(AbstractArrow arrow, Entity hitEntity, Entity shooter);
}
