package net.azo.stringy.block;

import net.azo.stringy.Stringy;
import net.azo.stringy.block.custom.CottonCropBlock;
import net.azo.stringy.block.custom.CottonShrubBlock;
import net.azo.stringy.block.custom.PampasGrassCropBlock;
import net.azo.stringy.block.custom.labelled_chest.LabelledChestBlock;
import net.azo.stringy.block.custom.labelled_chest.PampasGrassPlumeBlock;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block COTTON_SHRUB = registerBlock("cotton_shrub",
            new CottonShrubBlock(FabricBlockSettings.create().mapColor(MapColor.OFF_WHITE).
                    noCollision().breakInstantly().sounds(BlockSoundGroup.CROP)
                    .offset(AbstractBlock.OffsetType.XZ).burnable()
                    .pistonBehavior(PistonBehavior.DESTROY)));

    public static final Block POTTED_COTTON = registerBlockWithoutItem("potted_cotton_shrub",
            new FlowerPotBlock(COTTON_SHRUB, FabricBlockSettings.copy(Blocks.POTTED_FERN).mapColor(MapColor.OFF_WHITE)));

    public static final Block COTTON_CROP = registerBlockWithoutItem("cotton_crop",
            new CottonCropBlock(FabricBlockSettings.create().mapColor(MapColor.OFF_WHITE).noCollision().ticksRandomly()
                    .breakInstantly().sounds(BlockSoundGroup.CROP).pistonBehavior(PistonBehavior.DESTROY).burnable()));



    public static final Block PAMPAS_GRASS_PLUME = registerBlockWithoutItem("pampas_grass_plume",
            new PampasGrassPlumeBlock(FabricBlockSettings.create().mapColor(MapColor.WHITE).noCollision().ticksRandomly()
                    .breakInstantly().sounds(BlockSoundGroup.GRASS).pistonBehavior(PistonBehavior.DESTROY).burnable()));
    public static final Block PAMPAS_GRASS_CROP = registerBlockWithoutItem("pampas_grass_crop",
            new PampasGrassCropBlock(FabricBlockSettings.create().mapColor(MapColor.GREEN).noCollision().ticksRandomly()
                    .breakInstantly().sounds(BlockSoundGroup.GRASS).pistonBehavior(PistonBehavior.DESTROY).burnable()));


    public static final Block LABELLED_CHEST = registerBlock("labelled_chest",
            new LabelledChestBlock(FabricBlockSettings.copy(Blocks.CHEST), () -> BlockEntityType.CHEST));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(Stringy.MOD_ID, name), block);
    }

    private static Block registerBlockWithoutItem(String name, Block block) {
        return Registry.register(Registries.BLOCK, new Identifier(Stringy.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(Stringy.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }
    public static void RegisterModBlocks() {
        Stringy.LOGGER.info("Registering ModBlocks for " + Stringy.MOD_ID);
    }
}
