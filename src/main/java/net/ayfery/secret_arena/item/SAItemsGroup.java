package net.ayfery.secret_arena.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.ayfery.secret_arena.SecretArena;
import net.ayfery.secret_arena.block.SABlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class SAItemsGroup {
    public static final ItemGroup SECRET_ARENA_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(SecretArena.MOD_ID, "secret_arena_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(SAItems.CROWBAR))
                    .displayName(Text.translatable("itemgroup.secret_arena_items_group"))
                    .entries((displayContext, entries) -> {
                        entries.add(SAItems.CROWBAR);
                        entries.add(SABlocks.LUNAPLUSH);
                        entries.add(SABlocks.CONE);
                        entries.add(SABlocks.WOOD_CRATE);
                        entries.add(SABlocks.CHECKER_TILES);
                        entries.add(SABlocks.CHECKER_TILE_STAIRS);
                        entries.add(SABlocks.CHECKER_TILE_SLAB);
                        entries.add(SABlocks.CHECKER_TILE_WALL);
                        entries.add(SABlocks.MISSING_TILES);
                        entries.add(SABlocks.MISSING_TILE_STAIRS);
                        entries.add(SABlocks.MISSING_TILE_SLAB);
                        entries.add(SABlocks.MISSING_TILE_WALL);
                        entries.add(SABlocks.ORANGE_TILES);
                        entries.add(SABlocks.GENERIC_TILES);
                    }).build());

    public static void registerItemsGroup() {
        SecretArena.LOGGER.info("Registering items group for " + SecretArena.MOD_ID);
    }
}
