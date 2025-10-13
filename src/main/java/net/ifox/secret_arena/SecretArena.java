package net.ifox.secret_arena;

import net.fabricmc.api.ModInitializer;

import net.ifox.secret_arena.block.ModBlocks;
import net.ifox.secret_arena.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SecretArena implements ModInitializer {
	public static final String MOD_ID = "secret_arena";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}