package net.ifox.secret_arena.block;

import net.ifox.secret_arena.SecretArena;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block CHECKER = registerBlock( "checker",
        new Block(AbstractBlock.Settings.create().strength(-1).mapColor(MapColor.PALE_YELLOW).resistance(6)));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(SecretArena.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(SecretArena.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        SecretArena.LOGGER.info("Registering Mod Blocks for " + SecretArena.MOD_ID);
    }
}
