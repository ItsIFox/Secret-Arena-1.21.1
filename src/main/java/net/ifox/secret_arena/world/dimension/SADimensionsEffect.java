package net.ifox.secret_arena.world.dimension;

import net.minecraft.client.render.DimensionEffects;
import net.minecraft.util.math.Vec3d;
import org.jetbrains.annotations.Nullable;

public class SADimensionsEffect extends DimensionEffects {
    public SADimensionsEffect() {
        super(Float.NaN, false, DimensionEffects.SkyType.NORMAL, false, false);
    }

    @Override
    public Vec3d adjustFogColor(Vec3d color, float sunHeight) {
        return color.multiply(0.15F);
    }

    @Override
    public boolean useThickFog(int camX, int camY) {
        return false;
    }

    @Nullable
    @Override
    public float[] getFogColorOverride(float skyAngle, float tickDelta) {
        return null;
    }

    @Override
    public boolean isAlternateSkyColor() {
        return false;
    }
}