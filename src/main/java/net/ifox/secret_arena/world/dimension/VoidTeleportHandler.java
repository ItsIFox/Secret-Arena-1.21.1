package net.ifox.secret_arena.world.dimension;

import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;

public class VoidTeleportHandler {
    private static final Identifier SECRET_VOID_DIMENSION_ID = Identifier.of("secret_arena", "secret_void");

    public static void register() {
        ServerLivingEntityEvents.ALLOW_DAMAGE.register((entity, source, amount) -> {
            // Only handle players and void damage
            if (entity instanceof ServerPlayerEntity player &&
                    source.isOf(net.minecraft.entity.damage.DamageTypes.OUT_OF_WORLD) &&
                    !player.getWorld().getRegistryKey().getValue().equals(SECRET_VOID_DIMENSION_ID)) {

                teleportToSecretVoid(player);
                return false; // Cancel the damage
            }
            return true; // Allow normal damage processing
        });
    }

    private static void teleportToSecretVoid(ServerPlayerEntity player) {
        ServerWorld secretVoidWorld = player.getServer().getWorld(
                net.minecraft.registry.RegistryKey.of(RegistryKeys.WORLD, SECRET_VOID_DIMENSION_ID)
        );

        if (secretVoidWorld != null) {
            // Keep X and Z coordinates, teleport to exact Y=0 in secret_void
            double x = player.getX();
            double z = player.getZ();

            // Direct teleport to Y=0 - player will fall if there's no ground!
            player.teleport(
                    secretVoidWorld,
                    x, 0.0, z, // Exact Y=0 - no safety checks!
                    player.getYaw(), player.getPitch()
            );

            player.sendMessage(net.minecraft.text.Text.literal("CONGRATULATIONS AND WELCOME PLEASE ENTER WITH CAUTION YOU ARE NOT WELCOME HERE"), false);
        }
    }
}