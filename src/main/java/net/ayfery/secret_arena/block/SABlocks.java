package net.ayfery.secret_arena.block;

import net.ayfery.secret_arena.SecretArena;
import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class SABlocks {

    public static final Block CONE = registerBlock( "cone",
            new ConeBlock(AbstractBlock.Settings.create()
                    .strength(0.2F).resistance(3)
                    .mapColor(MapColor.TERRACOTTA_RED).sounds(BlockSoundGroup.BAMBOO_WOOD))
    );
    public static final Block WOOD_CRATE = registerBlock( "wood_crate",
            new CrateBlock(AbstractBlock.Settings.create()
                    .strength(2).resistance(2)
                    .mapColor(MapColor.OAK_TAN).sounds(BlockSoundGroup.WOOD).burnable())
    );
    public static final Block CHECKER_TILES = registerBlock( "checker_tiles",
        new Block(AbstractBlock.Settings.create()
                .strength(-1).resistance(6)
                .mapColor(MapColor.PALE_YELLOW))
    );
    public static final Block CHECKER_TILE_STAIRS = registerBlock( "checker_tile_stairs",
           new StairsBlock(CHECKER_TILES.getDefaultState(),AbstractBlock.Settings.copy(CHECKER_TILES))
    );
    public static final Block CHECKER_TILE_SLAB = registerBlock( "checker_tile_slab",
            new SlabBlock(AbstractBlock.Settings.copy(CHECKER_TILES))
    );
    public static final Block CHECKER_TILE_WALL = registerBlock( "checker_tile_wall",
            new WallBlock(AbstractBlock.Settings.copy(CHECKER_TILES)
                    .solid())
    );

    public static final Block MISSING_TILES = registerBlock( "missing_tiles",
            new Block(AbstractBlock.Settings.create()
                    .strength(-1).resistance(6)
                    .mapColor(MapColor.MAGENTA))
    );
    public static final Block MISSING_TILE_STAIRS = registerBlock( "missing_tile_stairs",
            new StairsBlock(MISSING_TILES.getDefaultState(),AbstractBlock.Settings.copy(MISSING_TILES))
    );
    public static final Block MISSING_TILE_SLAB = registerBlock( "missing_tile_slab",
            new SlabBlock(AbstractBlock.Settings.copy(MISSING_TILES))
    );
    public static final Block MISSING_TILE_WALL = registerBlock( "missing_tile_wall",
            new WallBlock(AbstractBlock.Settings.copy(MISSING_TILES)
                    .solid())
    );

    public static final Block ORANGE_TILES = registerBlock( "orange_tiles",
            new Block(AbstractBlock.Settings.create()
                    .strength(8).resistance(600)
                    .mapColor(MapColor.ORANGE).requiresTool())
    );
    public static final Block CUT_ORANGE_TILES = registerBlock( "cut_orange_tiles",
            new Block(AbstractBlock.Settings.copy(ORANGE_TILES))
    );
    public static final Block CUT_ORANGE_TILE_STAIRS = registerBlock( "cut_orange_tile_stairs",
            new StairsBlock(ORANGE_TILES.getDefaultState(),AbstractBlock.Settings.copy(ORANGE_TILES))
    );
    public static final Block CUT_ORANGE_TILE_SLAB = registerBlock( "cut_orange_tile_slab",
            new SlabBlock(AbstractBlock.Settings.copy(ORANGE_TILES))
    );
    public static final Block GENERIC_TILES = registerBlock( "generic_tiles",
            new Block(AbstractBlock.Settings.create()
                    .strength(8).resistance(600)
                    .mapColor(MapColor.STONE_GRAY).requiresTool())
    );
    public static final Block CUT_GENERIC_TILES = registerBlock( "cut_generic_tiles",
            new Block(AbstractBlock.Settings.copy(GENERIC_TILES))
    );
    public static final Block CUT_GENERIC_TILE_STAIRS = registerBlock( "cut_generic_tile_stairs",
            new StairsBlock(GENERIC_TILES.getDefaultState(),AbstractBlock.Settings.copy(GENERIC_TILES))
    );
    public static final Block CUT_GENERIC_TILE_SLAB = registerBlock( "cut_generic_tile_slab",
            new SlabBlock(AbstractBlock.Settings.copy(GENERIC_TILES))
    );
    public static final Block LUNAPLUSH = registerBlock( "lunaplush",
            new PlushBlock(AbstractBlock.Settings.create()
                    .strength(0.2F)
                    .mapColor(MapColor.PURPLE).sounds(BlockSoundGroup.WOOL).burnable().pistonBehavior(PistonBehavior.DESTROY))
    );
    public static final Block HURT_TRIGGER = registerBlock( "hurt_trigger",
            new HurtBlock(AbstractBlock.Settings.create()
                    .mapColor(MapColor.CLEAR).noCollision().allowsSpawning(Blocks::never).noBlockBreakParticles().pistonBehavior(PistonBehavior.DESTROY))
    );


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
