package net.ifox.secret_arena.world.dimension;

import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.minecraft.util.Identifier;

public class FallDamageHandler {
    private static final Identifier SUPER_VOID_DIMENSION_ID = Identifier.of("secret_arena", "super_void");
    private static final float MAX_FALL_DAMAGE = 15.0f;

    public static void register() {
        ServerLivingEntityEvents.ALLOW_DAMAGE.register((entity, source, amount) -> {
            if (source.isOf(net.minecraft.entity.damage.DamageTypes.FALL)) {
                if (entity.getWorld().getRegistryKey().getValue().equals(SUPER_VOID_DIMENSION_ID)) {
                    float cappedDamage = Math.min(amount, MAX_FALL_DAMAGE);
                    entity.damage(entity.getDamageSources().outOfWorld(), cappedDamage);
                    return false;
                }
            }
            return true;
        });
    }
}