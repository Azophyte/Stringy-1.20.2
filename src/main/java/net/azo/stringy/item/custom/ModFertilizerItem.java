package net.azo.stringy.item.custom;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.BoneMealItem;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ModFertilizerItem extends BoneMealItem {
    String translationKey;

    public ModFertilizerItem(Settings settings, String translationID) {
        super(settings);
        translationKey = translationID;
    }
    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("tooltip.stringy." + translationKey));
        super.appendTooltip(stack, world, tooltip, context);

    }
}
