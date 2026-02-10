package net.ayfery.secret_arena.sound;

import net.ayfery.secret_arena.SecretArena;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class SASounds {
    public static final SoundEvent AMBIENT_VOID_LOOP = registerSoundsEvent("ambient_void_loop");


    private static SoundEvent registerSoundsEvent(String name) {
        Identifier id = Identifier.of(SecretArena.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void registerSounds(){
        SecretArena.LOGGER.info("Registering Mod sounds for " + SecretArena.MOD_ID);
    }
}
