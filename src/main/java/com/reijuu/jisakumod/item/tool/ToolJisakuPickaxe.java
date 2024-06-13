package com.reijuu.jisakumod.item.tool;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.level.Level;

public class ToolJisakuPickaxe extends PickaxeItem {
    public ToolJisakuPickaxe() {
        super(JisakuModTiers.SAKURITE, 1, -2.8F, new Properties().fireResistant());
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
       ItemStack stack = player.getItemInHand(hand);
        if (player.isSteppingCarefully()) {
            player.startUsingItem(hand);
            modeChange(stack);
            world.playSound(player,player, SoundEvents.IRON_DOOR_OPEN, SoundSource.PLAYERS,1.0F,1.0F);
        }
        return InteractionResultHolder.consume(stack);
    }
    //確認用
    @Override
    public boolean isFoil(ItemStack stack) {
        if (modeNum(stack)==0){return false;};
        return true;
    }

    private void modeChange(ItemStack stack){
        if (stack.getTag() == null){
            stack.setTag(new CompoundTag());
        }
        stack.getTag().putInt("mode", modeNum(stack) < 1 ? modeNum(stack) + 1 : 0);
    }

    public int modeNum(ItemStack stack){
        if (stack.getTag() == null) {
            return 0;
        }
        return stack.getTag().getInt("mode");
    }
}
