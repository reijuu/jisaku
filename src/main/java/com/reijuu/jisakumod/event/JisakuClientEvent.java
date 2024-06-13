package com.reijuu.jisakumod.event;

import com.reijuu.jisakumod.entity.projectile.AmmoItem;
import com.reijuu.jisakumod.item.SniperAmmo;
import com.reijuu.jisakumod.main.JisakuMod;
import com.reijuu.jisakumod.regi.JisakuModItems;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ComputeFovModifierEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = JisakuMod.MOD_ID,value = Dist.CLIENT)
public class JisakuClientEvent {
    @SubscribeEvent
    public static void fovModified(ComputeFovModifierEvent event) {
        Player player = event.getPlayer();
        ItemStack item = player.getMainHandItem();
        if (item.is(JisakuModItems.SNIPER_RIFLE.get()) && player.isUsingItem()) {
            event.setNewFovModifier(0.5F);
        }
    }
}