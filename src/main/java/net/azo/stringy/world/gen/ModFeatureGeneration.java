package net.azo.stringy.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStep;

public class ModFeatureGeneration {
    public static final TagKey<Biome> HAS_COTTON_PATCHES = TagKey.of(RegistryKeys.BIOME, new Identifier("has_cotton_patches"));
    public static void generateVegetation() {
        BiomeModifications.addFeature(BiomeSelectors.tag(HAS_COTTON_PATCHES),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.PATCH_COTTON_SHRUB_PLACED_KEY);

    }

}
