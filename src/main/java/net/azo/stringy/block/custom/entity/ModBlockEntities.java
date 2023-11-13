package net.azo.stringy.block.custom.entity;

import net.azo.stringy.Stringy;
import net.azo.stringy.block.ModBlocks;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntities {
    public static final BlockEntityType<WoodBurnerBlockEntity> WOOD_BURNER_BLOCK_ENTITY =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(Stringy.MOD_ID, "wood_burner_block_entity"),
                    FabricBlockEntityTypeBuilder.create(WoodBurnerBlockEntity::new,
                            ModBlocks.WOOD_BURNER_BOTTOM).build());


    public static void registerBlockEntities() {
        Stringy.LOGGER.info("Registering Block Entities for " + Stringy.MOD_ID);
    }
}
