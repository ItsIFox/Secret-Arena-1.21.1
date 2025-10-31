package net.ifox.secret_arena;

import net.ifox.secret_arena.block.SABlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;


public class SecretArenaClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(SABlocks.CONE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(SABlocks.LUNAPLUSH, RenderLayer.getCutout());
    }
}
