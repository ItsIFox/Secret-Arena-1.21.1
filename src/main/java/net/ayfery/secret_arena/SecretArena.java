package net.ayfery.secret_arena;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.ayfery.secret_arena.block.SABlocks;
import net.ayfery.secret_arena.item.SAItems;
import net.ayfery.secret_arena.item.SAItemsGroup;
import net.ayfery.secret_arena.world.dimension.FallDamageHandler;
import net.ayfery.secret_arena.world.dimension.VoidTeleportHandler;
import net.ayfery.secret_arena.sound.SASounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SecretArena implements ModInitializer {
	public static final String MOD_ID = "secret_arena";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		SAGamerules.register();
		FallDamageHandler.register();
		VoidTeleportHandler.register();
		SAItemsGroup.registerItemsGroup();
		SAItems.registerModItems();
		SABlocks.registerModBlocks();
		SASounds.registerSounds();
		FuelRegistry.INSTANCE.add(SABlocks.WOOD_CRATE, 2400);
	}
}