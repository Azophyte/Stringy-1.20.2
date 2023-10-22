package net.azo.stringy.misc;

import net.azo.stringy.block.ModBlocks;
import net.azo.stringy.item.ModItems;
import net.fabricmc.fabric.api.registry.FuelRegistry;

public class ModFuelRegistry {
    public static void AddItemsToFuelRegistry(){
        FuelRegistry.INSTANCE.add(ModItems.COTTON_BOLL, 25);
        FuelRegistry.INSTANCE.add(ModBlocks.COTTON_SHRUB, 100);
        FuelRegistry.INSTANCE.add(ModItems.CANVAS, 200);
    }
}
