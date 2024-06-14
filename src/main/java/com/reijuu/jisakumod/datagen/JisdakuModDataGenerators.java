package com.reijuu.jisakumod.datagen;

import com.reijuu.jisakumod.main.JisakuMod;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = JisakuMod.MOD_ID,bus = Mod.EventBusSubscriber.Bus.MOD)


public class JisdakuModDataGenerators {
    @SubscribeEvent
    public static void generateData(GatherDataEvent event){
        DataGenerator generator = event.getGenerator();
        PackOutput PackOutput = generator.getPackOutput();
        ExistingFileHelper ExistingFileHelper = event.getExistingFileHelper();

        generator.addProvider(event.includeClient(), new JisakuModItemModelProvider(PackOutput,ExistingFileHelper));
    }
}
