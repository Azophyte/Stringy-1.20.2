package net.azo.stringy.item;

import net.azo.stringy.Stringy;
import net.azo.stringy.item.custom.*;
import net.fabricmc.fabric.api.item.v1.FabricItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static net.azo.stringy.block.ModBlocks.*;

public class ModItems {
    public static final Item COTTON_BOLL = registerItem("cotton_boll", new ModTooltipSeedItem(COTTON_CROP, new FabricItemSettings(), "cotton_boll"));
    public static final Item CANVAS = registerItem("canvas", new ModTooltipItem(new FabricItemSettings(), "canvas"));
    public static final Item PAMPAS_GRASS_SEEDS = registerItem("pampas_grass_seeds", new ModTooltipSeedItem(PAMPAS_GRASS_CROP, new FabricItemSettings(), "pampas_grass_seeds"));
    public static final Item GLOW_BERRY_INK = registerItem("glow_berry_ink", new ModGlowBerryInkItem(new FabricItemSettings().recipeRemainder(Items.GLASS_BOTTLE)));
    public static final Item CHARCOAL_INK = registerItem("charcoal_ink", new ModCharcoalInkItem(new FabricItemSettings().recipeRemainder(Items.GLASS_BOTTLE)));
    public static final Item APATITE = registerItem("apatite", new Item(new FabricItemSettings()));
    public static final Item APATITE_FERTILIZER = registerItem("apatite_fertilizer", new ModFertilizerItem(new FabricItemSettings(), "apatite_fertilizer"));
    public static final Item POTASH = registerItem("potash", new ModFertilizerItem(new FabricItemSettings(), "potash"));

    public static final Item WOOD_BURNER = registerItem("wood_burner", new AliasedBlockItem(WOOD_BURNER_BOTTOM, new FabricItemSettings()));



    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Stringy.MOD_ID, name), item);
    }

    public static void registerModItems(){
        Stringy.LOGGER.info("Registering Mod Items for " + Stringy.MOD_ID);
    }
}
