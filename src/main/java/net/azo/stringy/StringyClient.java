package net.azo.stringy;

import net.azo.stringy.misc.ModWorldRendering;
import net.fabricmc.api.ClientModInitializer;

public class StringyClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ModWorldRendering.CutOutBlocks();
        ModWorldRendering.Colourise();
    }
}
