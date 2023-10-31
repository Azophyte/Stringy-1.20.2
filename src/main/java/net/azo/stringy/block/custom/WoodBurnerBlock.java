package net.azo.stringy.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class WoodBurnerBlock extends Block {

    public WoodBurnerBlock(Settings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return BURNER_BOTTOM;
    }



    protected static final VoxelShape LEG_1_SHAPE = Block.createCuboidShape(1.0, 0.0, 1.0, 3.0, 2.0, 3.0);
    protected static final VoxelShape LEG_2_SHAPE = Block.createCuboidShape(1.0, 0.0, 13.0, 3.0, 2.0, 15.0);
    protected static final VoxelShape LEG_3_SHAPE = Block.createCuboidShape(13.0, 0.0, 1.0, 15.0, 2.0, 3.0);
    protected static final VoxelShape LEG_4_SHAPE = Block.createCuboidShape(13.0, 0.0, 13.0, 15.0, 2.0, 15.0);

    protected static final VoxelShape BASIN_1_SHAPE = Block.createCuboidShape(1.0, 2.0, 1.0, 2.0, 16.0, 14.0);
    protected static final VoxelShape BASIN_2_SHAPE = Block.createCuboidShape(1.0, 2.0, 14.0, 14.0, 16.0, 15.0);
    protected static final VoxelShape BASIN_3_SHAPE = Block.createCuboidShape(14.0, 2.0, 2.0, 15.0, 16.0, 15.0);
    protected static final VoxelShape BASIN_4_SHAPE = Block.createCuboidShape(2.0, 2.0, 1.0, 15.0, 16.0, 2.0);
    protected static final VoxelShape BASIN_5_SHAPE = Block.createCuboidShape(2.0, 3.0, 2.0, 15.0, 4.0, 15.0);
    protected static final VoxelShape BURNER_BOTTOM = VoxelShapes.union(LEG_1_SHAPE, LEG_2_SHAPE, LEG_3_SHAPE, LEG_4_SHAPE, BASIN_1_SHAPE, BASIN_2_SHAPE, BASIN_3_SHAPE, BASIN_4_SHAPE, BASIN_5_SHAPE);
}
