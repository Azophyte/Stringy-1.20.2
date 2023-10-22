package net.azo.stringy.item;

import net.azo.stringy.Stringy;
import net.azo.stringy.item.custom.ModTooltipItem;
import net.azo.stringy.item.custom.ModTooltipSeedItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;


import static net.azo.stringy.block.ModBlocks.COTTON_CROP;
import static net.azo.stringy.block.ModBlocks.PAMPAS_GRASS_CROP;

public class ModItems {
    public static final Item COTTON_BOLL = registerItem("cotton_boll", new ModTooltipSeedItem(COTTON_CROP, new FabricItemSettings(), "cotton_boll"));
    public static final Item CANVAS = registerItem("canvas", new ModTooltipItem(new FabricItemSettings(), "canvas"));
    public static final Item PAMPAS_GRASS_SEEDS = registerItem("pampas_grass_seeds", new ModTooltipSeedItem(PAMPAS_GRASS_CROP, new FabricItemSettings(), "pampas_grass_seeds"));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Stringy.MOD_ID, name), item);
    }

    public static void registerModItems(){
        Stringy.LOGGER.info("Registering Mod Items for " + Stringy.MOD_ID);
    }
}
