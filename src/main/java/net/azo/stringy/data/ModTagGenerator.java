package net.azo.stringy.data;

import net.azo.stringy.Stringy;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;

import java.util.concurrent.CompletableFuture;

import static net.minecraft.registry.tag.TagKey.of;

public class ModTagGenerator extends FabricTagProvider.ItemTagProvider {

    private static final TagKey<Biome> HAS_COTTON_SHRUB_PATCHES = of(RegistryKeys.BIOME, new Identifier(Stringy.MOD_ID + "has_cotton_shrub_patches"));

    public ModTagGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {

    }
}