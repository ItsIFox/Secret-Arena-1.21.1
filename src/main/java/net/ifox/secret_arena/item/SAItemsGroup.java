package net.ifox.secret_arena.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.ifox.secret_arena.SecretArena;
import net.ifox.secret_arena.block.SABlocks;
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
                        entries.add(SABlocks.CONE);
                        entries.add(SABlocks.LUNAPLUSH);
                        entries.add(SABlocks.WOOD_CRATE);
                        entries.add(SABlocks.CHECKER);
                        entries.add(SABlocks.CHECKER_STAIRS);
                        entries.add(SABlocks.CHECKER_SLAB);
                        entries.add(SABlocks.DEV_ORANGE);
                        entries.add(SABlocks.DEV_GRAY);
                    }).build());

    public static void registerItemsGroup() {
        SecretArena.LOGGER.info("Registering items group for " + SecretArena.MOD_ID);
    }
}
