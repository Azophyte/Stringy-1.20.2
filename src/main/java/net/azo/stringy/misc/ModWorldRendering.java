package net.azo.stringy.misc;

import net.azo.stringy.block.ModBlocks;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.block.Block;
import net.minecraft.client.color.world.BiomeColors;
import net.minecraft.client.color.world.FoliageColors;
import net.minecraft.client.render.RenderLayer;

public class ModWorldRendering {
    static Block[] tintedBlocks = {ModBlocks.COTTON_SHRUB, ModBlocks.POTTED_COTTON, ModBlocks.COTTON_CROP};
    static Block[] cutOutBlocks = {ModBlocks.COTTON_SHRUB, ModBlocks.POTTED_COTTON, ModBlocks.COTTON_CROP,
            ModBlocks.PAMPAS_GRASS_CROP, ModBlocks.PAMPAS_GRASS_PLUME, ModBlocks.PAMPAS_GRASS_BOUQUET, ModBlocks.POTTED_PAMPAS_GRASS_BOUQUET};

    //Makes blocks in this array transparent (otherwise transparent textures will be black)
    public static void CutOutBlocks(){
        for (Block cutOutBlock : cutOutBlocks){
            BlockRenderLayerMap.INSTANCE.putBlock(cutOutBlock, RenderLayer.getCutout());
        }
    }

    //Colour Registry Stuff - for blocks that should change colours in biome
    public static void Colourise(){
        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> {
            if (world == null || pos == null) {
                return FoliageColors.getColor(0.5, 1.0);
            }
            return BiomeColors.getGrassColor(world, pos);
        }, tintedBlocks);
    }
}
