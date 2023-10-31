package net.azo.stringy.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class WoodBurnerTopBlock extends Block {

    public WoodBurnerTopBlock(Settings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return BURNER_BOTTOM;
    }

    protected static final VoxelShape BASIN_1_SHAPE = Block.createCuboidShape(1.0, 0.0, 1.0, 2.0, 2.0, 14.0);
    protected static final VoxelShape BASIN_2_SHAPE = Block.createCuboidShape(1.0, 0.0, 14.0, 14.0, 2.0, 15.0);
    protected static final VoxelShape BASIN_3_SHAPE = Block.createCuboidShape(14.0, 0.0, 2.0, 15.0, 2.0, 15.0);
    protected static final VoxelShape BASIN_4_SHAPE = Block.createCuboidShape(2.0, 0.0, 1.0, 15.0, 2.0, 2.0);
    protected static final VoxelShape BURNER_BOTTOM = VoxelShapes.union(BASIN_1_SHAPE, BASIN_2_SHAPE, BASIN_3_SHAPE, BASIN_4_SHAPE);
}
