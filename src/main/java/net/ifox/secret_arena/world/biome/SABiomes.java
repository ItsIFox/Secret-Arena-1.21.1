package net.ifox.secret_arena.world.biome;

import net.ifox.secret_arena.SecretArena;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.SpawnSettings;


public class SABiomes {
    public static final RegistryKey<Biome> LIGHT_VOID = RegistryKey.of(RegistryKeys.BIOME,
            Identifier.of(SecretArena.MOD_ID,"light_void"));
    public static final RegistryKey<Biome> DARK_VOID = RegistryKey.of(RegistryKeys.BIOME,
            Identifier.of(SecretArena.MOD_ID,"dark_void"));

    public static void bootstrap(Registerable<Biome> context) {
        context.register(LIGHT_VOID, secretBiome(context));
    }
    public static Biome secretBiome(Registerable<Biome> context) {
        SpawnSettings.Builder spawnBuilder = new SpawnSettings.Builder();

        return new Biome.Builder()
                .precipitation(true)
                .downfall(0.5f)
                .temperature(0.5f)
                .spawnSettings(spawnBuilder.build())
                .effects((new BiomeEffects.Builder())
                        .build())
                .build();
    }
}
