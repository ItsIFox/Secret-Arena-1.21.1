package net.ifox.secret_arena;

import net.fabricmc.api.ModInitializer;

import net.ifox.secret_arena.block.SABlocks;
import net.ifox.secret_arena.item.SAItems;
import net.ifox.secret_arena.item.SAItemsGroup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SecretArena implements ModInitializer {
	public static final String MOD_ID = "secret_arena";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		SAItemsGroup.registerItemsGroup();
		SAItems.registerModItems();
		SABlocks.registerModBlocks();
	}
}