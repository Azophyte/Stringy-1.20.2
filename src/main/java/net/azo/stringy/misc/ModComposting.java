package net.azo.stringy.misc;

import net.azo.stringy.block.ModBlocks;
import net.azo.stringy.item.ModItems;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;

public class ModComposting {
    public static void AddItemsToCompostingRegistry(){
        CompostingChanceRegistry.INSTANCE.add(ModItems.COTTON_BOLL,0.30F);
        CompostingChanceRegistry.INSTANCE.add(ModBlocks.COTTON_SHRUB,0.65F);
        CompostingChanceRegistry.INSTANCE.add(ModItems.PAMPAS_GRASS_SEEDS,0.30F);
        CompostingChanceRegistry.INSTANCE.add(ModBlocks.PAMPAS_GRASS_BOUQUET,0.65F);
    }
}
