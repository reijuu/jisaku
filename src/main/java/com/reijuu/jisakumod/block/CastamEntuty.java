package com.reijuu.jisakumod.block;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

public abstract class CastamEntuty extends Entity {
    protected int use_DURATION = 1200;

    public CastamEntuty(EntityType<?> p_19870_, Level p_19871_) {
        super(p_19870_, p_19871_);
    }


    // 使用中の持続時間を取得するメソッド
    public int getUseDuration() {
        return this.use_DURATION;
    }

    // 使用中の持続時間を設定するメソッド
    public void setUseDuration(int duration) {
        this.use_DURATION = duration;
    }

    // 使用中の持続時間を更新するメソッド
    public void tickUseDuration() {
        if (this.use_DURATION > 0) {
            this.use_DURATION--;
        }
    }
}
