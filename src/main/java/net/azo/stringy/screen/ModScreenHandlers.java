package net.azo.stringy.screen;

import net.azo.stringy.Stringy;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class ModScreenHandlers {
    public static final ScreenHandlerType<WoodBurnerScreenHandler> WOOD_BURNER_SCREEN_HANDLER =
            Registry.register(Registries.SCREEN_HANDLER, new Identifier(Stringy.MOD_ID, "wood_burner"),
                    new ExtendedScreenHandlerType<>(WoodBurnerScreenHandler::new));

    public static void registerScreenHandlers(){
        Stringy.LOGGER.info("Registering Screen Handlers for " + Stringy.MOD_ID);
    }
}
