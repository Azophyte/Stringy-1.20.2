package net.azo.stringy.world;

import net.azo.stringy.Stringy;
import net.azo.stringy.block.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;

import java.util.List;

public class ModConfiguredFeatures {

    public static final RegistryKey<ConfiguredFeature<?, ?>> PATCH_COTTON_SHRUB_KEY = registerKey("patch_cotton_shrub");


    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {

        register(context, PATCH_COTTON_SHRUB_KEY, Feature.RANDOM_PATCH, ConfiguredFeatures.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK,
                new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.COTTON_SHRUB.getDefaultState())), List.of(Blocks.GRASS_BLOCK, Blocks.MOSS_BLOCK)));

    }

        public static RegistryKey<ConfiguredFeature<?, ?>> registerKey (String name){
            return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(Stringy.MOD_ID, name));
        }

        private static <FC extends FeatureConfig, F extends Feature<FC>>void register
        (Registerable < ConfiguredFeature < ?, ?>>context,
                RegistryKey < ConfiguredFeature < ?, ?>>key, F feature, FC configuration){
            context.register(key, new ConfiguredFeature<>(feature, configuration));
        }
    }