package net.azo.stringy.block.custom.labelled_chest;

import net.azo.stringy.block.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.PlantBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

public class PampasGrassPlumeBlock extends PlantBlock {
    public PampasGrassPlumeBlock(Settings settings) {
        super(settings);
    }

    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isOf(ModBlocks.PAMPAS_GRASS_CROP);
    }
}
