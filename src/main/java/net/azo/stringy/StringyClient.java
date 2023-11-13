package net.azo.stringy;

import net.azo.stringy.misc.ModWorldRendering;
import net.azo.stringy.screen.ModScreenHandlers;
import net.azo.stringy.screen.WoodBurnerScreen;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.gui.screen.ingame.HandledScreens;

public class StringyClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ModWorldRendering.CutOutBlocks();
        ModWorldRendering.Colourise();
        HandledScreens.register(ModScreenHandlers.WOOD_BURNER_SCREEN_HANDLER, WoodBurnerScreen::new);
    }
}
