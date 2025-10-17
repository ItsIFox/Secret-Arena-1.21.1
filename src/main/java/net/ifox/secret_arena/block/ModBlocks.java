package net.ifox.secret_arena.block;

import net.ifox.secret_arena.SecretArena;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block CHECKER = registerBlock( "checker",
        new Block(AbstractBlock.Settings.create().strength(-1).resistance(6).mapColor(MapColor.PALE_YELLOW)));
    public static final Block CHECKER_SLAB = registerBlock( "checker_slab",
            new SlabBlock(AbstractBlock.Settings.create().strength(-1).resistance(6).mapColor(MapColor.PALE_YELLOW)));
    public static final Block CHECKER_STAIRS = registerBlock( "checker_stairs",
           new StairsBlock(CHECKER.getDefaultState(),AbstractBlock.Settings.create().strength(-1).resistance(6).mapColor(MapColor.PALE_YELLOW)));
    public static final Block DEV_ORANGE = registerBlock( "dev_orange",
            new Block(AbstractBlock.Settings.create().strength(8).resistance(600).mapColor(MapColor.ORANGE).requiresTool()));
    public static final Block DEV_GRAY = registerBlock( "dev_gray",
            new Block(AbstractBlock.Settings.create().strength(8).resistance(600).mapColor(MapColor.STONE_GRAY).requiresTool()));
    public static final Block CONE = registerBlock( "cone",
            new ConeBlock(AbstractBlock.Settings.create().strength(1).resistance(1).mapColor(MapColor.PALE_YELLOW).breakInstantly()));

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
