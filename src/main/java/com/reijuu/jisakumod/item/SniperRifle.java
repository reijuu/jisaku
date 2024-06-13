package com.reijuu.jisakumod.item;

import net.minecraft.client.Minecraft;
import net.minecraft.core.Holder;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.jetbrains.annotations.NotNull;

import java.util.function.Predicate;

public class SniperRifle extends CrossbowItem implements SniperRifleItem {

        public SniperRifle() {
            super(new Properties());
        }


        @Override
        public void onUseTick(Level world, LivingEntity entity, ItemStack stack, int count) {
            if (world.isClientSide) {
                Minecraft.getInstance().options.fov(); // ズーム機能
            }
            super.onUseTick(world, entity, stack, count);
        }

        @Override
        public void releaseUsing(ItemStack stack, Level world, LivingEntity entity, int timeLeft) {
            if (world.isClientSide) {
                Minecraft.getInstance().options.fov() ;  // ズーム解除
            }
            super.releaseUsing(stack, world, entity, timeLeft);
        }

        @Override
        public UseAnim getUseAnimation(ItemStack stack) {
            return UseAnim.SPYGLASS;// アニメーションを使用
        }

        @Override
        public int getUseDuration(ItemStack stack) {
            return 72000;  // 使用時間を設定
        }

    // SniperRifleItemクラス内の矢の設定
    @Override
    public @NotNull Predicate<ItemStack> getAllSupportedProjectiles() {
        return (stack) -> {
            stack.getItem();
            return false;
        };  // カスタム弾薬を使用する
    }


    @Override
        public void onEntityHit(AbstractArrow arrow, Entity hitEntity, Entity shooter) {
            if (hitEntity instanceof LivingEntity livingEntity) {
                float damage = livingEntity.getMaxHealth() * -0.5F;

                if (hitEntity.getY() > livingEntity.getY() + 1.5) {  // 頭へのヒット判定
                    damage = livingEntity.getMaxHealth() * -1.0F;

                    // 頭防具の判定
                    ItemStack helmet = livingEntity.getItemBySlot(EquipmentSlot.HEAD);
                    if (helmet.is(Items.DIAMOND_HELMET)) {
                        damage *= 0.8F;
                    } else if (helmet.is(Items.NETHERITE_HELMET)) {
                        damage *= 0.6F;
                    }
                } else {  // 胴体へのヒット判定
                    // 胴体防具の判定
                    ItemStack chestplate = livingEntity.getItemBySlot(EquipmentSlot.CHEST);
                    if (chestplate.is(Items.LEATHER_CHESTPLATE)) {
                        damage *= 1.0F;
                    } else if (chestplate.is(Items.GOLDEN_CHESTPLATE)) {
                        damage *= 0.95F;
                    } else if (chestplate.is(Items.IRON_CHESTPLATE)) {
                        damage *= 0.90F;
                    } else if (chestplate.is(Items.DIAMOND_CHESTPLATE)) {
                        damage *= 0.85F;
                    } else if (chestplate.is(Items.NETHERITE_CHESTPLATE)) {
                        damage *= 0.80F;
                    }
                }

                livingEntity.hurt(new DamageSource((Holder<DamageType>) arrow, shooter), damage);
            }
        }
    @SubscribeEvent
    public static void onLeftClick(PlayerInteractEvent.LeftClickEmpty event) {
        Player player = event.getEntity();
        ItemStack itemStack = player.getMainHandItem();
        if (itemStack.getItem() instanceof SniperRifle) {
            Level world = player.level();
            if (!world.isClientSide) {
                // 発射処理をここに追加
                itemStack.getItem();
            }
            event.setCanceled(true); // デフォルトの左クリック動作をキャンセル
        }
    }
    }
