package net.azo.stringy.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import net.azo.stringy.Stringy;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class WoodBurnerScreen extends HandledScreen<WoodBurnerScreenHandler> {
    private static final Identifier TEXTURE = new Identifier(Stringy.MOD_ID, "textures/gui/container/wood_burner.png");


    public WoodBurnerScreen(WoodBurnerScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }

    @Override
    protected void init() {
        super.init();
        titleY = 6;
        playerInventoryTitleY = 108;
        backgroundHeight = 200;
    }

    protected int findXCenter(){
        return (width - backgroundWidth) / 2;
    }
    protected int findYCenter(){
        return (width - backgroundWidth) / 2;
    }

    @Override
    protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexProgram);
        RenderSystem.setShaderColor(1f, 1f, 1f, 1f);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - backgroundWidth) / 2;
        int y = (height - backgroundHeight) / 2;

        //offset = width / 2. Top should be offset + half of background height.

        context.drawTexture(TEXTURE, x, y, 0, 0, backgroundWidth, backgroundHeight);
        renderFillAmount(context, x, y);
    }

    private void renderFillAmount(DrawContext context, int x, int y) {

        context.drawTexture(TEXTURE, x + 85, y + 30, 176, 20, 8, handler.getScaledFill());

    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        renderBackground(context, mouseX, mouseY, delta);
        super.render(context, mouseX, mouseY, delta);
        drawMouseoverTooltip(context, mouseX, mouseY);
    }
}
