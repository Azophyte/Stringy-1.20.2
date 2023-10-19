package net.azo.stringy;

import net.azo.stringy.block.ModBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.block.Block;
import net.minecraft.client.color.world.BiomeColors;
import net.minecraft.client.color.world.FoliageColors;
import net.minecraft.client.render.RenderLayer;

public class StringyClient implements ClientModInitializer {

    static Block[] tintedBlocks = {ModBlocks.COTTON_SHRUB};
    static Block[] cutOutBlocks = {ModBlocks.COTTON_SHRUB};

    @Override
    public void onInitializeClient() {

        //Makes blocks in this array transparent (otherwise transparent textures will be black)
        for (Block cutOutBlock : cutOutBlocks){
            BlockRenderLayerMap.INSTANCE.putBlock(cutOutBlock, RenderLayer.getCutout());
        }

        //Colour Registry Stuff - for blocks that should change colours in biome
        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> {
            if (world == null || pos == null) {
                return FoliageColors.getColor(0.5, 1.0);
            }
            return BiomeColors.getGrassColor(world, pos);
        }, tintedBlocks);
    }
}
