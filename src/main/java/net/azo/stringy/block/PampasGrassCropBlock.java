package net.azo.stringy.block;

import net.azo.stringy.item.ModItems;
import net.minecraft.block.CropBlock;
import net.minecraft.item.ItemConvertible;

public class PampasGrassCropBlock extends CropBlock {
    public PampasGrassCropBlock(Settings settings) {
        super(settings);
    }

    protected ItemConvertible getSeedsItem() {
        return ModItems.PAMPAS_GRASS_SEEDS;
    }
}