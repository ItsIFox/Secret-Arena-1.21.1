package net.ayfery.secret_arena.world.dimension;

import net.ayfery.secret_arena.SAGamerules;
import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;

public class VoidTeleportHandler {
    private static final Identifier SUPER_VOID_DIMENSION_ID = Identifier.of("secret_arena", "super_void");

    public static void register() {
        ServerLivingEntityEvents.ALLOW_DAMAGE.register((entity, source, amount) -> {
            if (entity instanceof ServerPlayerEntity player &&
                    source.isOf(net.minecraft.entity.damage.DamageTypes.OUT_OF_WORLD) &&
                    !player.getWorld().getRegistryKey().getValue().equals(SUPER_VOID_DIMENSION_ID)) {

                // Check if the gamerule is enabled
                if (player.getWorld().getGameRules().getBoolean(SAGamerules.VOID_TELEPORT)) {
                    teleportToSuperVoid(player);
                    return false;
                }
            }
            return true;
        });
    }

    private static void teleportToSuperVoid(ServerPlayerEntity player) {
        ServerWorld superVoidWorld = player.getServer().getWorld(
                net.minecraft.registry.RegistryKey.of(RegistryKeys.WORLD, SUPER_VOID_DIMENSION_ID)
        );

        if (superVoidWorld != null) {
            double x = player.getX();
            double z = player.getZ();
            player.teleport(
                    superVoidWorld,
                    x, 0.0, z,
                    player.getYaw(), player.getPitch()
            );
            player.sendMessage(net.minecraft.text.Text.translatable("message.secret_arena.welcome"), true);
        }
    }
}