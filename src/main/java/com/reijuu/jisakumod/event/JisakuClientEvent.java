package com.reijuu.jisakumod.event;
import com.reijuu.jisakumod.item.SniperRifle;
import com.reijuu.jisakumod.main.JisakuMod;
import com.reijuu.jisakumod.regi.JisakuModItems;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ComputeFovModifierEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = JisakuMod.MOD_ID,value = Dist.CLIENT)
public class JisakuClientEvent {
    @SubscribeEvent
    public static void fovModified(ComputeFovModifierEvent event) {
        Player player = event.getPlayer();
        ItemStack item = player.getMainHandItem();
        if (item.is(JisakuModItems.SNIPER_RIFLE.get()) && SniperRifle.isCharged(item)) {
            // スナイパーライフルをメインハンドに持っており、かつチャージされている場合の処理
            event.setNewFovModifier(0.25F);//倍率0.5倍は0.5F,4倍は0.25F,
        }
    }
    private static float getShootingPower() {

        // ここで射撃パワーを計算するロジックを実装する
        float shootingPower = 10.0F; // 例として初期化

        // 何らかの計算やロジックを行い、shootingPowerに値をセットする
        return shootingPower;
    }
    public class Projectile {
        private static final int DEFAULT_PROJECTILE_RANGE = 100; // in meters

        public int getDefaultProjectileRange() {
            return DEFAULT_PROJECTILE_RANGE;
        }
    }
}
// デフォルトのFOVは70度
//float defaultFov = 70.0F;

// 4倍ズーム後のFOVを計算
//float zoomedFov = defaultFov / 4.0F; // 70度 / 4 = 17.5度

//FOVは相対的な倍率で設定されます。例えば、デフォルトのFOV（70度）を1.0とすると、
//float fovModifier = zoomedFov / defaultFov; // 17.5度 / 70度 = 0.25
