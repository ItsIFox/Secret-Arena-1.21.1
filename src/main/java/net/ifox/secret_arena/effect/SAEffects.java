package net.ifox.secret_arena.effect;

import net.ifox.secret_arena.SecretArena;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class SAEffects {
    public static final RegistryEntry<StatusEffect> SEASICKNESS = registerStatusEffect("seasickness",
            new SeasicknessStatusEffect(StatusEffectCategory.NEUTRAL, 0x45B267));


    private static RegistryEntry<StatusEffect> registerStatusEffect(String name, StatusEffect statusEffect) {
        return Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(SecretArena.MOD_ID, name), statusEffect);
    }

    public static void registerEffects() {
        SecretArena.LOGGER.info("Registering Mod Effects for " + SecretArena.MOD_ID);
    }
}

