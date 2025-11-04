package net.ifox.secret_arena;

import net.fabricmc.fabric.api.client.rendering.v1.DimensionRenderingRegistry;
import net.ifox.secret_arena.block.SABlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.ifox.secret_arena.world.dimension.SADimensionsEffect;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.dimension.DimensionType;


public class SecretArenaClient implements ClientModInitializer {
    public static final RegistryKey<DimensionType> CUSTOM_DIMENSION =
            RegistryKey.of(RegistryKeys.DIMENSION_TYPE, Identifier.of("secret_arena", "custom_dimension"));

    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(SABlocks.CONE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(SABlocks.LUNAPLUSH, RenderLayer.getCutout());
        DimensionRenderingRegistry.registerDimensionEffects(
                Identifier.of("secret_arena", "super_void_effect"),
                new SADimensionsEffect()
        );
    }
}
