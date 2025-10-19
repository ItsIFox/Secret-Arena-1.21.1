package net.ifox.secret_arena.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.FallingBlock;

public class CrateBlock extends FallingBlock {
    public static final MapCodec<CrateBlock> CODEC = createCodec(CrateBlock::new);
    @Override
    public MapCodec<CrateBlock> getCodec() {
        return CODEC;
    }

    public CrateBlock(AbstractBlock.Settings settings) {
        super(settings);

    }
}
