package com.reijuu.jisakumod.item;

import com.reijuu.jisakumod.entity.PlayerEntity;
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

    private Math MathHelper;

    public SniperRifle() {
        super(new Properties());
    }

    public int getDefaultProjectileRange() {
        return 1000;
    }

    @Override
    public void onUseTick(Level world, @NotNull LivingEntity entity, @NotNull ItemStack stack, int count) {
        ;
        if (world.isClientSide) {
            Minecraft.getInstance().options.fov();// ズーム機能;
        }
        super.onUseTick(world, entity, stack, count);
    }

    @Override
    public void releaseUsing(@NotNull ItemStack stack, Level world, @NotNull LivingEntity entity, int timeLeft) {
        if (world.isClientSide) {
            Minecraft.getInstance().options.fov();  // ズーム解除
        }
        super.releaseUsing(stack, world, entity, timeLeft);
    }
    public static float getShootingPower(){

        // ここで射撃パワーを計算するロジックを実装する
        float shootingPower = 10.0F; // 例として初期化

        // 何らかの計算やロジックを行い、shootingPowerに値をセットする
        return shootingPower;
    }
    @Override
    public @NotNull UseAnim getUseAnimation(@NotNull ItemStack stack) {
        return UseAnim.SPYGLASS;// アニメーションを使用
    }

    @Override
    public int getUseDuration(@NotNull ItemStack stack) {
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

    public void onEntityHit(AbstractArrow arrow, Entity hitEntity, Entity shooter) {
        // 射撃パワーを取得
        float shootingPower = getShootingPower();

        if (hitEntity instanceof LivingEntity livingEntity) {
            float damage = livingEntity.getMaxHealth() * shootingPower;

            if (hitEntity.getY() > livingEntity.getY() * 1.5) {  // 頭へのヒット判定
                damage = livingEntity.getMaxHealth() * shootingPower * 2.0F; // 例としてダメージを倍にする場合

                // 頭防具の判定
                ItemStack helmet = livingEntity.getItemBySlot(EquipmentSlot.HEAD);
                if (helmet.is(Items.DIAMOND_HELMET)) {
                    damage *= 0.8F;
                } else if (helmet.is(Items.NETHERITE_HELMET)) {
                    damage *= 0.6F;
                }
                livingEntity.hurt(new DamageSource((Holder<DamageType>) arrow, shooter), damage);
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

                livingEntity.hurt(new DamageSource((Holder<DamageType>) arrow, shooter), damage);
            }
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
    public float getShootingPower(Entity target, PlayerEntity shooter) {
        // プレイヤーとターゲットの距離を計算
        double distance = calculateDistance(target, shooter);

        // 初期の射撃パワーを設定
        float shootingPower = 10.0F; // 例として初期化
        shootingPower += (float) (distance / 100.0); // 距離に応じてパワーを増加

        return shootingPower;
    }
    private double calculateDistance(Entity target, PlayerEntity shooter) {
        double deltaX = target.getX() - shooter.getx();
        double deltaY = target.getY() - shooter.getY();
        double deltaZ = target.getZ() - shooter.getZ();
        return Math.sqrt(deltaX * deltaX + deltaY * deltaY + deltaZ * deltaZ);
    }
}

