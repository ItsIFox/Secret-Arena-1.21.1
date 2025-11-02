package net.ifox.secret_arena.mixin;

import net.minecraft.client.render.BackgroundRenderer;
import net.minecraft.client.render.Camera;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BackgroundRenderer.class)
public class SADimensionFogRenderer {

    private static final Identifier SECRET_VOID_DIMENSION_ID = Identifier.of("secret_arena", "secret_void");

    @Inject(method = "applyFog", at = @At("HEAD"), cancellable = true)
    private static void applyShortRenderDistanceFog(Camera camera, BackgroundRenderer.FogType fogType, float viewDistance, boolean thickFog, float tickDelta, CallbackInfo ci) {
        World world = camera.getFocusedEntity().getWorld();

        // Check if we're in the secret_void dimension
        if (world.getRegistryKey().getValue().equals(SECRET_VOID_DIMENSION_ID)) {
            if (fogType == BackgroundRenderer.FogType.FOG_TERRAIN) {
                // Ultra-short fog distances to simulate render distance 2
                com.mojang.blaze3d.systems.RenderSystem.setShaderFogStart(12.0f);
                com.mojang.blaze3d.systems.RenderSystem.setShaderFogEnd(16.0f);
                ci.cancel();
            }
        }
    }
}