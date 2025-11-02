package net.ifox.secret_arena.world.dimension;

import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.minecraft.util.Identifier;

public class FallDamageHandler {
    private static final Identifier SECRET_VOID_DIMENSION_ID = Identifier.of("secret_arena", "secret_void");

    public static void register() {
        ServerLivingEntityEvents.ALLOW_DAMAGE.register((entity, source, amount) -> {
            if (source.isOf(net.minecraft.entity.damage.DamageTypes.FALL)) {
                if (entity.getWorld().getRegistryKey().getValue().equals(SECRET_VOID_DIMENSION_ID)) {
                    // Apply reduced damage and cancel the original
                    entity.damage(source, amount * 0.5f);
                    return false; // Cancel original damage
                }
            }
            return true; // Allow normal damage
        });
    }
}
