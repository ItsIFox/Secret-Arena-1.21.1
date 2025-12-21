package net.ayfery.secret_arena.mixin;

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

    private static final Identifier SUPER_VOID_DIMENSION_ID = Identifier.of("secret_arena", "super_void");

    @Inject(method = "applyFog", at = @At("HEAD"), cancellable = true)
    private static void applyShortRenderDistanceFog(Camera camera, BackgroundRenderer.FogType fogType, float viewDistance, boolean thickFog, float tickDelta, CallbackInfo ci) {
        World world = camera.getFocusedEntity().getWorld();
        if (world.getRegistryKey().getValue().equals(SUPER_VOID_DIMENSION_ID)) {
            if (fogType == BackgroundRenderer.FogType.FOG_TERRAIN) {
                com.mojang.blaze3d.systems.RenderSystem.setShaderFogStart(8.0f);
                com.mojang.blaze3d.systems.RenderSystem.setShaderFogEnd(16.0f);
                ci.cancel();
            }
        }
    }
}