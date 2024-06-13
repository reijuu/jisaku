package com.reijuu.jisakumod.regi;

import com.reijuu.jisakumod.main.JisakuMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class JisakuModTags {

    public static class Blocks{

        public static final TagKey<Block> NEEDS_SAKURITE_TOOL = tag("needs_sakurite_tool");
        private static TagKey<Block> tag (String name){
            return BlockTags.create(new ResourceLocation(JisakuMod.MOD_ID,name));
        }
    }
    public static class Items{

        public static final TagKey<Item> JISAKU_SERIES = tag("jisaku_series");
        private static TagKey<Item> tag (String name){
            return ItemTags.create(new ResourceLocation(JisakuMod.MOD_ID,name));
        }
    }
}
