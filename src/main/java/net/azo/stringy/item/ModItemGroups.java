package net.azo.stringy.item;

import net.azo.stringy.Stringy;
import net.azo.stringy.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup STRINGY_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(Stringy.MOD_ID, "stringy"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.stringy"))
                    .icon(() -> new ItemStack(ModItems.COTTON_BOLL)).entries((displayContext, entries) -> {

                        //Put items here lol
                        entries.add(ModItems.COTTON_BOLL);
                        entries.add(ModBlocks.COTTON_SHRUB);

                    }).build());

    public static void registerModItemGroups(){
        Stringy.LOGGER.info("Registering Mod Item Groups for " + Stringy.MOD_ID);
    }
}
