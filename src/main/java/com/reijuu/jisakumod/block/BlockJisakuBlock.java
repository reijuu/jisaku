package com.reijuu.jisakumod.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;

public class BlockJisakuBlock extends Block {
    public BlockJisakuBlock() {
        super(Properties.of()
                .strength(5.0F, 1500)
                .strength(100F)
                .explosionResistance(10000)
                .instabreak()
                .sound(SoundType.ANVIL)
                .lightLevel((a) -> 15)
                .requiresCorrectToolForDrops()
        );
    }
}
