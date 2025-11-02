package net.ifox.secret_arena.world.dimension;

import net.minecraft.client.render.DimensionEffects;
import net.minecraft.util.math.Vec3d;
import org.jetbrains.annotations.Nullable;

public class SADimensionsEffect extends DimensionEffects {
    public SADimensionsEffect() {
        // Parameters: cloudsHeight, alternateSkyColor, skyType, brightenLighting, darkened
        super(Float.NaN, false, DimensionEffects.SkyType.NORMAL, false, false);
    }

    @Override
    public Vec3d adjustFogColor(Vec3d color, float sunHeight) {
        // Completely override with pure black, ignoring the original color and sun height
        return new Vec3d(0.0, 0.0, 0.0);
    }

    @Override
    public boolean useThickFog(int camX, int camY) {
        return true;
    }

    @Nullable
    @Override
    public float[] getFogColorOverride(float skyAngle, float tickDelta) {
        // Return null to prevent any fog color overrides (like sunrise/sunset colors)
        return null;
    }

    @Override
    public boolean isAlternateSkyColor() {
        // Return false to use normal sky color calculations
        return false;
    }
}