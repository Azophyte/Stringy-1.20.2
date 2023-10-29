package net.azo.stringy;

import net.azo.stringy.block.ModBlocks;
import net.azo.stringy.misc.ModFuelRegistry;
import net.azo.stringy.world.gen.ModFeatureGeneration;
import net.azo.stringy.item.ModItemGroups;
import net.azo.stringy.item.ModItems;
import net.azo.stringy.misc.ModComposting;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Stringy implements ModInitializer {

	// Universal mod id.
	public static final String MOD_ID = "stringy";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		ModItems.registerModItems();
		ModItemGroups.registerModItemGroups();
		ModBlocks.RegisterModBlocks();
		ModComposting.AddItemsToCompostingRegistry();
		ModFeatureGeneration.generateVegetation();
		ModFeatureGeneration.generateOres();
		ModFuelRegistry.AddItemsToFuelRegistry();
		LOGGER.info(MOD_ID + " initialised successfully!!!! :D");
	}
}