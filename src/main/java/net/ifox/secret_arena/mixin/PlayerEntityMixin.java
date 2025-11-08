package net.ifox.secret_arena.mixin;

import net.ifox.secret_arena.effect.SAEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public class PlayerEntityMixin {

    private void onTickWaterBreathingAir(int air, CallbackInfo ci) {
        PlayerEntity player = (PlayerEntity) (Object) this;

        // Only modify behavior if player has seasickness and is wearing turtle helmet
        if (player.hasStatusEffect(SAEffects.SEASICKNESS) &&
                player.getInventory().getArmorStack(3).isOf(Items.TURTLE_HELMET)) {

            boolean isSubmerged = player.isSubmergedInWater();

            if (isSubmerged) {
                // When underwater with seasickness + turtle helmet, use normal turtle helmet behavior
                // Don't cancel - let vanilla logic handle water breathing
                return;
            } else {
                // When in air with seasickness + turtle helmet, cancel the water breathing effect
                ci.cancel();
            }
        }
    }
}