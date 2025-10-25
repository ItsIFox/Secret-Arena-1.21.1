package net.ifox.secret_arena.item;

import net.ifox.secret_arena.SecretArena;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item CROWBAR = registerItems("crowbar", new CrowbarItem(ModMaterials.OTHERWORLD, new Item.Settings().attributeModifiers(CrowbarItem.createAttributeModifiers(ModMaterials.OTHERWORLD, 2, -0F))));

    private static Item registerItems(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(SecretArena.MOD_ID, name), item);
    }

    public static void registerModItems(){
        SecretArena.LOGGER.info("Registering Mod Itmes for " + SecretArena.MOD_ID);
    }
}
