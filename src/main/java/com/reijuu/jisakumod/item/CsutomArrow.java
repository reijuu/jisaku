package com.reijuu.jisakumod.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class CsutomArrow extends Item {

    public CsutomArrow() {
        super(new Item.Properties());
    }

    @Override
    public int getDamage(ItemStack stack) {
        return 1000;  // ダメージを1000に設定
    }
    @Override
    public void setDamage(ItemStack stack, int getdamage) {
        // ここでは何もしないか、必要に応じて設定する処理を追加する
        // 通常は耐久値を設定するなどの用途で使われますが、今回は固定の値を返すだけです
    }
}

