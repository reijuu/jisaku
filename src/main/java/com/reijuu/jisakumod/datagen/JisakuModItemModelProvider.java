package com.reijuu.jisakumod.datagen;

import com.reijuu.jisakumod.main.JisakuMod;
import com.reijuu.jisakumod.regi.JisakuModItems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class JisakuModItemModelProvider extends ItemModelProvider {
    public JisakuModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, JisakuMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(JisakuModItems.JISAKU_ARROW.get());
    }
}
