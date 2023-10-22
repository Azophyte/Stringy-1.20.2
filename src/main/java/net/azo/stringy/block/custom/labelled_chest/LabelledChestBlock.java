package net.azo.stringy.block.custom.labelled_chest;

import net.minecraft.block.ChestBlock;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.ChestBlockEntity;

import java.util.function.Supplier;

public class LabelledChestBlock extends ChestBlock {
    public LabelledChestBlock(Settings settings, Supplier<BlockEntityType<? extends ChestBlockEntity>> supplier) {
        super(settings, supplier);
    }
}
