package net.azo.stringy.block;

import net.azo.stringy.Stringy;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.MapColor;
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
                    noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS)
                    .offset(AbstractBlock.OffsetType.XZ).burnable()
                    .pistonBehavior(PistonBehavior.DESTROY)));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
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
