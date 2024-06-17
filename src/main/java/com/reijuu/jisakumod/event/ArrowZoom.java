package com.reijuu.jisakumod.event;

import com.reijuu.jisakumod.main.JisakuMod;
import com.reijuu.jisakumod.regi.JisakuModItems;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ComputeFovModifierEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = JisakuMod.MOD_ID,value = Dist.CLIENT)
public class ArrowZoom {
    @SubscribeEvent
    public static void fovModified(ComputeFovModifierEvent event) {
        Player player = event.getPlayer();
        ItemStack item = player.getMainHandItem();
        if (item.is(JisakuModItems.JISAKU_BOW.get())) {
            event.setNewFovModifier(0.25F);
        }
    }
}