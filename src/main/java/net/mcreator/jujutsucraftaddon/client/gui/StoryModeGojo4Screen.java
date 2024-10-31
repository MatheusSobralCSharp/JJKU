package net.mcreator.jujutsucraftaddon.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.jujutsucraftaddon.world.inventory.StoryModeGojo4Menu;
import net.mcreator.jujutsucraftaddon.network.StoryModeGojo4ButtonMessage;
import net.mcreator.jujutsucraftaddon.JujutsucraftaddonMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class StoryModeGojo4Screen extends AbstractContainerScreen<StoryModeGojo4Menu> {
    private final static HashMap<String, Object> guistate = StoryModeGojo4Menu.guistate;
    private final Level world;
    private final int x, y, z;
    private final Player entity;
    private final static HashMap<String, String> textstate = new HashMap<>();
    Button button_start;

    public StoryModeGojo4Screen(StoryModeGojo4Menu container, Inventory inventory, Component text) {
        super(container, inventory, text);
        this.world = container.world;
        this.x = container.x;
        this.y = container.y;
        this.z = container.z;
        this.entity = container.entity;
        this.imageWidth = 176;
        this.imageHeight = 166;
    }

    private static final ResourceLocation texture = new ResourceLocation("jujutsucraftaddon:textures/screens/story_mode_gojo_4.png");

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(guiGraphics);
        super.render(guiGraphics, mouseX, mouseY, partialTicks);
        this.renderTooltip(guiGraphics, mouseX, mouseY);
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
        RenderSystem.setShaderColor(1, 1, 1, 1);
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
        RenderSystem.disableBlend();
    }

    @Override
    public boolean keyPressed(int key, int b, int c) {
        if (key == 256) {
            this.minecraft.player.closeContainer();
            return true;
        }
        return super.keyPressed(key, b, c);
    }

    @Override
    protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
        guiGraphics.drawString(this.font, Component.translatable("gui.jujutsucraftaddon.story_mode_gojo_4.label_beat_the_disaster_curses"), 37, 28, -12829636, false);
        guiGraphics.drawString(this.font, Component.translatable("gui.jujutsucraftaddon.story_mode_gojo_4.label_hard"), 63, 49, -52429, false);
    }

    @Override
    public void init() {
        super.init();
        button_start = Button.builder(Component.translatable("gui.jujutsucraftaddon.story_mode_gojo_4.button_start"), e -> {
            if (true) {
                JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new StoryModeGojo4ButtonMessage(0, x, y, z, textstate));
                StoryModeGojo4ButtonMessage.handleButtonAction(entity, 0, x, y, z, textstate);
            }
        }).bounds(this.leftPos + 57, this.topPos + 73, 51, 20).build();
        guistate.put("button:button_start", button_start);
        this.addRenderableWidget(button_start);
    }
}
