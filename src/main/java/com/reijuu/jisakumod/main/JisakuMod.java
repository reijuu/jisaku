package com.reijuu.jisakumod.main;

import com.reijuu.jisakumod.item.SniperRifleItem;
import com.reijuu.jisakumod.regi.JisakuModBlocks;
import com.reijuu.jisakumod.regi.JisakuModItems;
import com.reijuu.jisakumod.regi.tab.JisakuModTabs;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("jisakumod")
public class JisakuMod {
    public static final String MOD_ID = "jisakumod";

    public JisakuMod() {

        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::addCreative);

        //アイテムレジストリーをイベントバスに登録

        JisakuModItems.ITEMS.register(bus);
        JisakuModBlocks.Blocks.BLOCKS.register(modEventBus);
        JisakuModBlocks.BlockItems.BLOCK_ITEMS.register(bus);
        JisakuModTabs.MOD_TABS.register(bus);

        modEventBus.addListener(this::setup);
        modEventBus.addListener(this::doClientStuff);
    }

    public void setup(final FMLClientSetupEvent event) {
        //コモンセットアップ
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(JisakuModItems.RAW_ORIHALCON);
            event.accept(JisakuModItems.ORIHALCON_INGOT);
        }
    }

    public void doClientStuff(final FMLClientSetupEvent event) {
        //クライアント専用セットアップ
    }

    SniperRifleItem sniperRifle = new SniperRifleItem() {
        @Override
        public void onEntityHit(AbstractArrow arrow, Entity hitEntity, Entity shooter) {
            sniperRifle.onEntityHit(arrow, hitEntity, shooter);
        }
    };
}