package net.ifox.secret_arena.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

public class SeasicknessStatusEffect extends StatusEffect {
    protected SeasicknessStatusEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }
    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }

    @Override
    public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity instanceof PlayerEntity player) {
            handleSeasicknessBreathing(player, amplifier);
        }
        return true;
    }

    private void handleSeasicknessBreathing(PlayerEntity player, int amplifier) {
        boolean isSubmerged = player.isSubmergedInWater();
        int airSupply = player.getAir();
        int maxAir = player.getMaxAir();

        // Check for conditions that should prevent air loss
        boolean shouldPreventAirLoss = shouldPreventAirLoss(player);

        if (!isSubmerged && !shouldPreventAirLoss) {
            // Lose air when NOT in water and conditions aren't met to prevent it
            int airLossRate = Math.max(1, 5 + amplifier);
            int newAir = airSupply - airLossRate;

            player.setAir(Math.max(newAir, -20));

            // Handle drowning damage
            if (player.getAir() <= -20) {
                player.setAir(0);
                player.damage(player.getDamageSources().drown(), 2.0F);
            }
        } else if (isSubmerged) {
            // Regain air when in water - works for all amplifier levels
            if (airSupply < maxAir) {
                int airGainRate = Math.max(1, 5);
                player.setAir(Math.min(airSupply + airGainRate, maxAir));
            }
        }
        // If shouldPreventAirLoss is true and player is not submerged, do nothing (no air loss)
    }

    private boolean shouldPreventAirLoss(PlayerEntity player) {
        World world = player.getWorld();

        // Check if player has Water Breathing effect
        if (player.hasStatusEffect(StatusEffects.WATER_BREATHING)) {
            return true;
        }

        // Check if player is being rained on
        if (world.isRaining() && player.isWet()) {
            return true;
        }
        return false;
    }
}
