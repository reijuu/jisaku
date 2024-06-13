package com.reijuu.jisakumod.regi.tab;

import com.reijuu.jisakumod.main.JisakuMod;
import com.reijuu.jisakumod.regi.JisakuModBlocks;
import com.reijuu.jisakumod.regi.JisakuModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class JisakuModTabs {

    public static final DeferredRegister<CreativeModeTab> MOD_TABS =DeferredRegister.create(Registries.CREATIVE_MODE_TAB, JisakuMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> JISAKU_MOD = MOD_TABS.register("jisaku_main",
            ()-> {return CreativeModeTab.builder()
                    .icon(()->new ItemStack(JisakuModItems.JISAKU_INGOD.get()))
                    .title(Component.translatable("itemGroup.jisaku_main"))
                    .displayItems((pParameters, poutput) -> {
                        for(Item item:JisakuMain.items){
                            poutput.accept(item);
                            poutput.accept(JisakuModBlocks.Blocks.ORIHALCON_BLOCK.get());
                        }
                    })
                    .build();
            });

    public static final RegistryObject<CreativeModeTab> JISAKU_SUB = MOD_TABS.register("jisaku_sub",
            ()-> {return CreativeModeTab.builder()
                    .icon(()->new ItemStack(Blocks.CHERRY_PLANKS))
                    .title(Component.translatable("itemGroup.jisaku_sub"))
                    .withTabsBefore(JisakuModTabs.JISAKU_MOD.getId())
                    .displayItems((Parameters, output) ->{
                        for(Item item:JisakuMain.items){
                            output.accept(item);
                        }
                    })
                    .build();
            });
}
