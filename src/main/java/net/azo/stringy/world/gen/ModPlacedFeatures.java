package net.azo.stringy.world.gen;

import net.azo.stringy.Stringy;
import net.azo.stringy.world.ModConfiguredFeatures;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.*;

import java.util.List;

public class ModPlacedFeatures {

    public static final RegistryKey<PlacedFeature> PATCH_COTTON_SHRUB_PLACED_KEY = registerKey("patch_cotton_shrub_placed");
    public static final RegistryKey<PlacedFeature> PATCH_PAMPAS_GRASS_BOUQUET_PLACED_KEY = registerKey("patch_pampas_grass_bouquet_placed");
    public static final RegistryKey<PlacedFeature> APATITE_ORE_SURFACE_PLACED_KEY = registerKey("apatite_ore_surface_placed");
    public static final RegistryKey<PlacedFeature> APATITE_ORE_LUSH_PLACED_KEY = registerKey("apatite_ore_lush_placed");

    public static void bootstrap(Registerable<PlacedFeature> context) {
        var configuredFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        register(context, APATITE_ORE_SURFACE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.APATITE_ORE_SURFACE_KEY),
                ModOrePlacement.modifiersWithCount(13, // Veins per Chunk
                        HeightRangePlacementModifier.trapezoid(YOffset.fixed(40), YOffset.fixed(136))));

        register(context, APATITE_ORE_LUSH_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.APATITE_ORE_SURFACE_KEY),
                ModOrePlacement.modifiersWithCount(128, // Veins per Chunk
                        HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.getTop())));

        register(context, PATCH_COTTON_SHRUB_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.PATCH_COTTON_SHRUB_KEY),
                RarityFilterPlacementModifier.of(31), SquarePlacementModifier.of(), PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP,
                BiomePlacementModifier.of());

        register(context, PATCH_PAMPAS_GRASS_BOUQUET_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.PATCH_PAMPAS_GRASS_BOUQUET_KEY),
                RarityFilterPlacementModifier.of(31), SquarePlacementModifier.of(), PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP,
                BiomePlacementModifier.of());



    }

    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(Stringy.MOD_ID, name));

    }

    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<PlacedFeature> context,
                                                                                   RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> configuration, PlacementModifier... modifiers) {
        register(context, key, configuration, List.of(modifiers));
    }


}
