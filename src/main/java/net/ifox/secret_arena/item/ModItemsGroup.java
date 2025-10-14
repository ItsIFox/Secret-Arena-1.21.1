package net.ifox.secret_arena.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.ifox.secret_arena.SecretArena;
import net.ifox.secret_arena.block.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemsGroup {
    public static final ItemGroup SECRET_ARENA_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(SecretArena.MOD_ID, "secret_arena_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.CROWBAR))
                    .displayName(Text.translatable("itemgroup.secret_arena_items_group"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.CROWBAR);
                        entries.add(ModBlocks.CHECKER);
                        entries.add(ModBlocks.CHECKER_STAIRS);
                        entries.add(ModBlocks.CHECKER_SLAB);
                        entries.add(ModBlocks.DEV_ORANGE);
                        entries.add(ModBlocks.DEV_GRAY);
                    }).build());

    public static void registerItemsGroup() {
        SecretArena.LOGGER.info("Registering items group for " + SecretArena.MOD_ID);
    }
}
