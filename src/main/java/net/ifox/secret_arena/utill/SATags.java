package net.ifox.secret_arena.utill;

import net.ifox.secret_arena.SecretArena;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class SATags {
    public static class Blocks {
        public static final TagKey<Block> NEEDS_OTHERWORLD_TOOL = createTag("needs_otherworld_tool");
        public static final TagKey<Block> INCORRECT_FOR_OTHERWORLD_TOOL = createTag("incorrect_for_otherworld_tool");
        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(SecretArena.MOD_ID, name));
        }
    }
    public static class Items {

        public static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(SecretArena.MOD_ID, name));
        }
    }
}
