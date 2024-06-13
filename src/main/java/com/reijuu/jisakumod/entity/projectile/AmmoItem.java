package com.reijuu.jisakumod.entity.projectile;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;

public class AmmoItem extends Projectile {
    private static net.minecraft.world.level.Level Ammo;
    private static final net.minecraft.world.level.Level Level = null;
    private double beseDamage;
    public AmmoItem(EntityType<? extends Projectile> player, Level world, double baseDamage) {
        super(player,world);
        this.beseDamage = baseDamage;
    }

    public AmmoItem(EntityType<? extends Projectile> entityType, java.util.logging.Level level, int baseDamage) {
        super(entityType,Level);
    }

    public double getBeseDamage() {
        return beseDamage;
    }

    public void setBeseDamage(double beseDamage){
        this.beseDamage = beseDamage;
    }

    @Override
    protected void defineSynchedData() {

    }
}
