package net.azo.stringy.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;

import static net.azo.stringy.world.gen.ModPlacedFeatures.APATITE_ORE_LUSH_PLACED_KEY;

public class ModFeatureGeneration {
    public static final TagKey<Biome> HAS_COTTON_PATCHES = TagKey.of(RegistryKeys.BIOME, new Identifier("has_cotton_patches"));
    public static final TagKey<Biome> HAS_PAMPAS_GRASS_BOUQUET_PATCHES = TagKey.of(RegistryKeys.BIOME, new Identifier("has_pampas_grass_bouquet_patches"));

    public static void generateOres() {
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.UNDERGROUND_ORES, ModPlacedFeatures.APATITE_ORE_SURFACE_PLACED_KEY);

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.LUSH_CAVES),
                GenerationStep.Feature.UNDERGROUND_ORES, APATITE_ORE_LUSH_PLACED_KEY);
    }

    public static void generateVegetation() {
        BiomeModifications.addFeature(BiomeSelectors.tag(HAS_COTTON_PATCHES),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.PATCH_COTTON_SHRUB_PLACED_KEY);

        BiomeModifications.addFeature(BiomeSelectors.tag(HAS_PAMPAS_GRASS_BOUQUET_PATCHES),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.PATCH_PAMPAS_GRASS_BOUQUET_PLACED_KEY);
    }

}
