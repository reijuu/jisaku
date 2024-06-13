package com.reijuu.jisakumod.regi;

import com.reijuu.jisakumod.block.BlockJisakuBlock;
import com.reijuu.jisakumod.main.JisakuMod;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

import static com.reijuu.jisakumod.regi.JisakuModBlocks.Blocks.BLOCKS;

public class JisakuModBlocks {
    public static class Blocks {
        public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, JisakuMod.MOD_ID);

        public static final RegistryObject<Block> JISAKU_BLOCK = BLOCKS.register("jisaku_block", BlockJisakuBlock::new);
        public static final RegistryObject<Block> ORIHALCON_BLOCK = registryBlockItem("orihalcon_block",
                () -> new Block(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.DIAMOND_BLOCK).sound(SoundType.ANVIL)));
    }

    private static <T extends Block> RegistryObject<T> registryBlockItem(String name
                                                                                  ,Supplier<T>Supplier){
        RegistryObject<T> block = BLOCKS.register(name,Supplier);
        JisakuModItems.ITEMS.register(name,() -> new BlockItem(block.get(),new Item.Properties()));
        return block;
    }

    public static class BlockItems {
        public static final DeferredRegister<Item> BLOCK_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, JisakuMod.MOD_ID);
        public static final RegistryObject<Item> JISAKU_BLOCK = BLOCK_ITEMS.register("jisaku_block"
                , () -> new BlockItem(Blocks.JISAKU_BLOCK.get(), new Item.Properties().fireResistant()));
    }
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
