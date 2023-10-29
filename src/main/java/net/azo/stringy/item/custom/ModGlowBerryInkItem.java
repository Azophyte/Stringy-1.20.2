package net.azo.stringy.item.custom;

import net.minecraft.block.entity.SignBlockEntity;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ModGlowBerryInkItem extends Item implements SignChangingItem {

    public ModGlowBerryInkItem(Settings settings) {
        super(settings);
    }

    public boolean useOnSign(World world, SignBlockEntity signBlockEntity, boolean front, PlayerEntity player) {
        if (signBlockEntity.changeText(text -> text.withGlowing(true), front)) {
            world.playSound(null, signBlockEntity.getPos(), SoundEvents.ITEM_INK_SAC_USE, SoundCategory.BLOCKS, 1.0f, 1.0f);

            player.giveItemStack(Items.GLASS_BOTTLE.getDefaultStack());
            return true;
        }
        return false;
    }

    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("tooltip.stringy.glow_berry_ink"));
        super.appendTooltip(stack, world, tooltip, context);
    }
}
