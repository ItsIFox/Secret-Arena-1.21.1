package net.ayfery.secret_arena;

import net.fabricmc.fabric.api.gamerule.v1.GameRuleFactory;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleRegistry;
import net.minecraft.world.GameRules;

public class SAGamerules {
    public static GameRules.Key<GameRules.BooleanRule> VOID_TELEPORT;


    public static void register() {
        VOID_TELEPORT = GameRuleRegistry.register("doVoidTeleporting", GameRules.Category.PLAYER,
                GameRuleFactory.createBooleanRule(true));
    }
}