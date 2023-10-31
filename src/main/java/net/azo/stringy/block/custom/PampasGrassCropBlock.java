package net.azo.stringy.block.custom;

import net.azo.stringy.block.ModBlocks;
import net.azo.stringy.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CropBlock;
import net.minecraft.item.ItemConvertible;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
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
            world.setBlockState(pos.up(), ModBlocks.PAMPAS_GRASS_PLUME.getDefaultState(), Block.NOTIFY_LISTENERS);
        }
        world.setBlockState(pos, this.withAge(i), Block.NOTIFY_LISTENERS);
    }

    @Override
    public boolean isFertilizable(WorldView world, BlockPos pos, BlockState state) {
        return world.getBlockState(pos.up()).equals(Blocks.AIR.getDefaultState());
    }

    @Override
    public boolean hasRandomTicks(BlockState state) {
        return true;
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        float f;
        int i;
        if (world.getBaseLightLevel(pos, 0) >= 9 && world.getBlockState(pos.up()).equals(Blocks.AIR.getDefaultState()) && random.nextInt((int)(25.0f / (f = CropBlock.getAvailableMoisture(this, world, pos))) + 1) == 0) {
            if ((i = this.getAge(state)) < this.getMaxAge()){
                world.setBlockState(pos, this.withAge(i + 1), Block.NOTIFY_LISTENERS);
            } else {
                world.setBlockState(pos.up(), ModBlocks.PAMPAS_GRASS_PLUME.getDefaultState(), Block.NOTIFY_LISTENERS);
            }
        }
    }
}