package net.azo.stringy.block;

import net.azo.stringy.Stringy;
import net.azo.stringy.block.custom.*;
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
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {

    //APATITE BLOCKS
        public static final Block APATITE_BLOCK = registerBlock("apatite_block",
                new Block(FabricBlockSettings.copyOf(Blocks.COAL_BLOCK).mapColor(MapColor.CYAN)));
        public static final Block APATITE_ORE = registerBlock("apatite_ore",
                new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.COAL_ORE).mapColor(MapColor.CYAN), UniformIntProvider.create(0, 4)));
        public static final Block DEEPSLATE_APATITE_ORE = registerBlock("deepslate_apatite_ore",
                new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.DEEPSLATE_COAL_ORE).mapColor(MapColor.CYAN), UniformIntProvider.create(0, 4)));

    //COTTON BLOCKS
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

    //PAMPAS GRASS BLOCKS

        public static final Block PAMPAS_GRASS_PLUME = registerBlockWithoutItem("pampas_grass_plume",
                new PampasGrassPlumeBlock(FabricBlockSettings.create().mapColor(MapColor.WHITE).noCollision().ticksRandomly()
                        .breakInstantly().sounds(BlockSoundGroup.GRASS).pistonBehavior(PistonBehavior.DESTROY).burnable()));
        public static final Block PAMPAS_GRASS_CROP = registerBlockWithoutItem("pampas_grass_crop",
                new PampasGrassCropBlock(FabricBlockSettings.create().mapColor(MapColor.GREEN).noCollision().ticksRandomly()
                        .breakInstantly().sounds(BlockSoundGroup.GRASS).pistonBehavior(PistonBehavior.DESTROY).burnable()));

        public static final Block PAMPAS_GRASS_BOUQUET = registerBlock("pampas_grass_bouquet",
                new TallPlantBlock(FabricBlockSettings.copyOf(PAMPAS_GRASS_PLUME)));

        public static final Block POTTED_PAMPAS_GRASS_BOUQUET = registerBlockWithoutItem("potted_pampas_grass_bouquet",
                new FlowerPotBlock(PAMPAS_GRASS_BOUQUET, FabricBlockSettings.copy(Blocks.POTTED_FERN).mapColor(MapColor.OFF_WHITE)));

    //WOOD BURNER BLOCKS

        public static final Block WOOD_BURNER_BOTTOM = registerBlockWithoutItem("wood_burner_bottom",
                new WoodBurnerBlock(FabricBlockSettings.create().mapColor(MapColor.TERRACOTTA_WHITE).requiresTool().strength(25f, 600f).sounds(BlockSoundGroup.METAL).nonOpaque()));
        public static final Block WOOD_BURNER_TOP = registerBlockWithoutItem("wood_burner_top",
                new WoodBurnerTopBlock(FabricBlockSettings.copyOf(WOOD_BURNER_BOTTOM)));


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
