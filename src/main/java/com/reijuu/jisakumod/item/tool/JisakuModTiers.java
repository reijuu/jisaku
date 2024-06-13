package com.reijuu.jisakumod.item.tool;

import com.reijuu.jisakumod.main.JisakuMod;
import com.reijuu.jisakumod.regi.JisakuModItems;
import com.reijuu.jisakumod.regi.JisakuModTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class JisakuModTiers {
    public static final ForgeTier SAKURITE = new ForgeTier(5,5000,11.0F,5.0F,50, JisakuModTags.Blocks.NEEDS_SAKURITE_TOOL,() -> Ingredient.of(JisakuModItems.JISAKU_INGOD.get()));
    static {
        TierSortingRegistry.registerTier(SAKURITE,new ResourceLocation(JisakuMod.MOD_ID,"sakurite"),List.of(Tiers.NETHERITE),List.of());
    }
}
