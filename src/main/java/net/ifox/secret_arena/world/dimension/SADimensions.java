package net.ifox.secret_arena.world.dimension;

import net.ifox.secret_arena.SecretArena;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionOptions;
import net.minecraft.world.dimension.DimensionType;

public class SADimensions {
    public static final RegistryKey<DimensionOptions> SECRET_VOID_KEY = RegistryKey.of(RegistryKeys.DIMENSION,
            Identifier.of(SecretArena.MOD_ID, "secret_void"));
    public static final RegistryKey<World> SECRET_VOID_LEVEL_KEY = RegistryKey.of(RegistryKeys.WORLD,
            Identifier.of(SecretArena.MOD_ID, "secret_void"));
    public static final RegistryKey<DimensionType> SECRET_VOID_DIM_TYPE = RegistryKey.of(RegistryKeys.DIMENSION_TYPE,
            Identifier.of(SecretArena.MOD_ID, "secret_void_type"));
}
