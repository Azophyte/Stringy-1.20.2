package net.azo.stringy.item;

import net.azo.stringy.Stringy;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.ArrayList;

public class ModItems {
    public static final Item COTTON_BOLL = registerItem("cotton_boll", new Item(new FabricItemSettings()));
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Stringy.MOD_ID, name), item);
    }
    public static void registerModItems(){
        Stringy.LOGGER.info("Registering Mod Items for " + Stringy.MOD_ID);
    }
}
