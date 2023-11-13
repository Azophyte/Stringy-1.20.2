package net.azo.stringy.block.custom;

import net.azo.stringy.block.custom.entity.ModBlockEntities;
import net.azo.stringy.block.custom.entity.WoodBurnerBlockEntity;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.apache.http.annotation.Obsolete;
import org.jetbrains.annotations.Nullable;

public class WoodBurnerBlock extends BlockWithEntity implements BlockEntityProvider {

    public WoodBurnerBlock(Settings settings) {
        super(settings);
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return BURNER_BOTTOM;
    }
    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state){
        return new WoodBurnerBlockEntity(pos, state);
    }

    @Override
    public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if (state.getBlock() != newState.getBlock()) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof WoodBurnerBlockEntity) {
                ItemScatterer.spawn(world, pos, (WoodBurnerBlockEntity)blockEntity);
                world.updateComparators(pos,this);
            }
            super.onStateReplaced(state, world, pos, newState, moved);
        }
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (!world.isClient) {
            NamedScreenHandlerFactory screenHandlerFactory = ((WoodBurnerBlockEntity) world.getBlockEntity(pos));

            if (screenHandlerFactory != null) {
                player.openHandledScreen(screenHandlerFactory);
            }
        }

        return ActionResult.SUCCESS;
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return validateTicker(type, ModBlockEntities.WOOD_BURNER_BLOCK_ENTITY,
                (world1, pos, state1, blockEntity) -> blockEntity.tick(world1, pos, state1));
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
