package net.azo.stringy.world;

import net.azo.stringy.Stringy;
import net.azo.stringy.block.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;

import java.util.List;

public class ModConfiguredFeatures {

    public static final RegistryKey<ConfiguredFeature<?, ?>> APATITE_ORE_SURFACE_KEY = registerKey("apatite_ore_surface");
    public static final RegistryKey<ConfiguredFeature<?, ?>> APATITE_ORE_LUSH_KEY = registerKey("apatite_ore_lush");

    public static final RegistryKey<ConfiguredFeature<?, ?>> PATCH_COTTON_SHRUB_KEY = registerKey("patch_cotton_shrub");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PATCH_PAMPAS_GRASS_BOUQUET_KEY = registerKey("patch_pampas_grass_bouquet");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {

        //APATITE STUFF
        RuleTest stoneReplaceables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

        List<OreFeatureConfig.Target> surfaceApatiteOres =
                List.of(OreFeatureConfig.createTarget(stoneReplaceables, ModBlocks.APATITE_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplaceables, ModBlocks.DEEPSLATE_APATITE_ORE.getDefaultState()));

        register(context, APATITE_ORE_SURFACE_KEY, Feature.ORE, new OreFeatureConfig(surfaceApatiteOres, 12));
        register(context, APATITE_ORE_LUSH_KEY, Feature.ORE, new OreFeatureConfig(surfaceApatiteOres, 3));

        register(context, PATCH_COTTON_SHRUB_KEY, Feature.RANDOM_PATCH, ConfiguredFeatures.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK,
                new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.COTTON_SHRUB.getDefaultState())), List.of(Blocks.GRASS_BLOCK, Blocks.MOSS_BLOCK)));

        register(context, PATCH_PAMPAS_GRASS_BOUQUET_KEY, Feature.RANDOM_PATCH, ConfiguredFeatures.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK,
                new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.PAMPAS_GRASS_BOUQUET.getDefaultState())), List.of(Blocks.GRASS_BLOCK, Blocks.MOSS_BLOCK)));


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