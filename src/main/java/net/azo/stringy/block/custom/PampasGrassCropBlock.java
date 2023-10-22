package net.azo.stringy.block.custom;

import net.azo.stringy.block.ModBlocks;
import net.azo.stringy.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CropBlock;
import net.minecraft.item.ItemConvertible;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

public class PampasGrassCropBlock extends CropBlock {
    public PampasGrassCropBlock(Settings settings) {
        super(settings);
    }



    protected ItemConvertible getSeedsItem() {
        return ModItems.PAMPAS_GRASS_SEEDS;
    }

    public void applyGrowth(World world, BlockPos pos, BlockState state) {
        int j;
        int i = this.getAge(state) + this.getGrowthAmount(world);
        if (i > (j = this.getMaxAge())) {
            i = j;
            world.setBlockState(pos.up(), ModBlocks.PAMPAS_GRASS_PLUME.getDefaultState());
        }
        world.setBlockState(pos, this.withAge(i), Block.NOTIFY_LISTENERS);
    }

    @Override
    public boolean isFertilizable(WorldView world, BlockPos pos, BlockState state) {
        return world.getBlockState(pos.up()).equals(Blocks.AIR.getDefaultState());
    }
}