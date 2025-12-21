package net.ayfery.secret_arena;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.ayfery.secret_arena.block.SABlocks;
import net.ayfery.secret_arena.item.SAItems;
import net.ayfery.secret_arena.item.SAItemsGroup;
import net.ayfery.secret_arena.world.dimension.FallDamageHandler;
import net.ayfery.secret_arena.world.dimension.VoidTeleportHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SecretArena implements ModInitializer {
	public static final String MOD_ID = "secret_arena";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		FallDamageHandler.register();
		VoidTeleportHandler.register();
		SAItemsGroup.registerItemsGroup();
		SAItems.registerModItems();
		SABlocks.registerModBlocks();
		FuelRegistry.INSTANCE.add(SABlocks.WOOD_CRATE, 2400);
	}
}