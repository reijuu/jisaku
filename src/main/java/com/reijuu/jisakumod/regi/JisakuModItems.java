package com.reijuu.jisakumod.regi;

import com.reijuu.jisakumod.item.ItemJisakInGod;
import com.reijuu.jisakumod.item.ItemJisakuSpy;
import com.reijuu.jisakumod.item.SniperRifle;
import com.reijuu.jisakumod.item.SniperAmmo;
import com.reijuu.jisakumod.item.tool.ToolJisakuPickaxe;
import com.reijuu.jisakumod.main.JisakuMod;
import net.minecraft.world.item.CrossbowItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class JisakuModItems {
    //レジストリーを作成
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, JisakuMod.MOD_ID);
    //レジストリーにアイテムを追加
    public static final RegistryObject<Item> JISAKU_SPY = ITEMS.register("jisaku_spy", ItemJisakuSpy::new);
    public static final RegistryObject<Item> JISAKU_AMMO = ITEMS.register("jisaku_ammo", SniperAmmo::new);
    public static final RegistryObject<Item> RAW_ORIHALCON = ITEMS.register("raw_orihalcon", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ORIHALCON_INGOT = ITEMS.register("orihalcon_ingot", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> JISAKU_INGOD = ITEMS.register("jisaku_ingod", ItemJisakInGod::new);
    //Tool系
    public static final RegistryObject<PickaxeItem> JISAKU_PICKAXE = ITEMS.register("jisaku_pickaxe", ToolJisakuPickaxe::new);
    public static final RegistryObject<CrossbowItem> SNIPER_RIFLE = ITEMS.register("sniper_rifle", SniperRifle::new);

    public static void register(IEventBus eventBus) {
        // レジストリをイベントバスに登録
        ITEMS.register(eventBus);
    }
}