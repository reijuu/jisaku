package com.reijuu.jisakumod.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItem {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,"jisakumod");

    public static final RegistryObject<Item> BULLET = ITEMS.register("bullet",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> SNIPER_RIFLE = ITEMS.register("sniper_rifle",
            () -> new Item(new Item.Properties().durability(250)));
}
