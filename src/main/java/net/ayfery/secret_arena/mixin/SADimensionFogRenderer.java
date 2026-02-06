package net.ayfery.secret_arena.mixin;

import net.minecraft.client.render.BackgroundRenderer;
import net.minecraft.client.render.Camera;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BackgroundRenderer.class)
public class SADimensionFogRenderer {

    private static final Identifier SUPER_VOID_DIMENSION_ID = Identifier.of("secret_arena", "super_void");

    private static final float MIN_FOG_START = 7.0f;
    private static final float MIN_FOG_END = 11.0f;
    private static final int MIN_FOG_Y = -500;
    private static final int DEFAULT_FOG_Y = 0;

    @Inject(method = "applyFog", at = @At("HEAD"), cancellable = true)
    private static void applyShortRenderDistanceFog(Camera camera, BackgroundRenderer.FogType fogType, float viewDistance, boolean thickFog, float tickDelta, CallbackInfo ci) {
        World world = camera.getFocusedEntity().getWorld();
        if (world.getRegistryKey().getValue().equals(SUPER_VOID_DIMENSION_ID)) {
            if (camera.getFocusedEntity() instanceof PlayerEntity player) {
                if (player.isCreative() || player.isSpectator()) {
                    return;
                }
            }

            if (fogType == BackgroundRenderer.FogType.FOG_TERRAIN) {
                double cameraY = camera.getFocusedEntity().getY();
                double clampedY = Math.max(MIN_FOG_Y, Math.min(DEFAULT_FOG_Y, cameraY));
                float t = (float) ((DEFAULT_FOG_Y - clampedY) / (DEFAULT_FOG_Y - MIN_FOG_Y));
                float fogStart = lerp(viewDistance * 0.75f, MIN_FOG_START, t);
                float fogEnd = lerp(viewDistance, MIN_FOG_END, t);

                com.mojang.blaze3d.systems.RenderSystem.setShaderFogStart(fogStart);
                com.mojang.blaze3d.systems.RenderSystem.setShaderFogEnd(fogEnd);
                ci.cancel();
            }
        }
    }

    private static float lerp(float start, float end, float t) {
        return start + (end - start) * t;
    }
}