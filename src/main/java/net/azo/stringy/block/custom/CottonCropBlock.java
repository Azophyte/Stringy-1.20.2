package net.azo.stringy.block.custom;

import net.azo.stringy.item.ModItems;
import net.minecraft.block.CropBlock;
import net.minecraft.item.ItemConvertible;

public class CottonCropBlock extends CropBlock {
    public CottonCropBlock(Settings settings) {
        super(settings);
    }

    protected ItemConvertible getSeedsItem() {
        return ModItems.COTTON_BOLL;
    }
}