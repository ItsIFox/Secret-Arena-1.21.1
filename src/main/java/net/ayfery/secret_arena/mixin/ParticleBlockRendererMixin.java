package net.ayfery.secret_arena.mixin;

import net.ayfery.secret_arena.block.SABlocks;
import net.ayfery.secret_arena.item.SAItems;
import net.minecraft.block.Block;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.client.render.WorldRenderer;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.profiler.Profiler;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Supplier;

@Mixin(ClientWorld.class)
public abstract class ParticleBlockRendererMixin {
    @Shadow @Final
    private MinecraftClient client;

    @Shadow @Final @Mutable
    private static Set<Item> BLOCK_MARKER_ITEMS;

    @Unique
    private static Set<Item> CUSTOM_BLOCK_MARKER_ITEMS;

    @Unique
    private static final Map<Item, Block> ITEM_TO_BLOCK_MAP = new HashMap<>();

    @Inject(method = "<init>", at = @At("TAIL"))
    private void onInit(ClientPlayNetworkHandler networkHandler, ClientWorld.Properties properties,
                        RegistryKey<World> registryRef, RegistryEntry<DimensionType> dimensionTypeEntry,
                        int loadDistance, int simulationDistance, Supplier<Profiler> profiler,
                        WorldRenderer worldRenderer, boolean debugWorld, long seed, CallbackInfo ci) {
        CUSTOM_BLOCK_MARKER_ITEMS = new HashSet<>(BLOCK_MARKER_ITEMS);
        CUSTOM_BLOCK_MARKER_ITEMS.add(SABlocks.HURT_TRIGGER.asItem());
        ITEM_TO_BLOCK_MAP.put(SAItems.CROWBAR, SABlocks.HURT_TRIGGER);
    }

    @Inject(method = "getBlockParticle", at = @At("HEAD"), cancellable = true)
    private void onGetBlockParticle(CallbackInfoReturnable<Block> cir) {
        if (this.client.player == null) return;

        ItemStack itemStack = this.client.player.getMainHandStack();
        Item item = itemStack.getItem();

        if (CUSTOM_BLOCK_MARKER_ITEMS.contains(item) && item instanceof BlockItem) {
            cir.setReturnValue(((BlockItem) item).getBlock());
        }
        else if (ITEM_TO_BLOCK_MAP.containsKey(item)) {
            cir.setReturnValue(ITEM_TO_BLOCK_MAP.get(item));
        }
    }
}