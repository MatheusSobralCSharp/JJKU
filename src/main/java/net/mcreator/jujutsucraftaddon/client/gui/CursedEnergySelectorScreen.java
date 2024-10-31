package net.mcreator.jujutsucraftaddon.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.jujutsucraftaddon.world.inventory.CursedEnergySelectorMenu;
import net.mcreator.jujutsucraftaddon.network.CursedEnergySelectorButtonMessage;
import net.mcreator.jujutsucraftaddon.JujutsucraftaddonMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class CursedEnergySelectorScreen extends AbstractContainerScreen<CursedEnergySelectorMenu> {
    private final static HashMap<String, Object> guistate = CursedEnergySelectorMenu.guistate;
    private final Level world;
    private final int x, y, z;
    private final Player entity;
    private final static HashMap<String, String> textstate = new HashMap<>();
    Button button_imbue_with_negative_energy;
    Button button_imbue_with_positive_energy;
    Button button_heal_with_ce;

    public CursedEnergySelectorScreen(CursedEnergySelectorMenu container, Inventory inventory, Component text) {
        super(container, inventory, text);
        this.world = container.world;
        this.x = container.x;
        this.y = container.y;
        this.z = container.z;
        this.entity = container.entity;
        this.imageWidth = 190;
        this.imageHeight = 166;
    }

    private static final ResourceLocation texture = new ResourceLocation("jujutsucraftaddon:textures/screens/cursed_energy_selector.png");

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
    }

    @Override
    public void init() {
        super.init();
        button_imbue_with_negative_energy = Button.builder(Component.translatable("gui.jujutsucraftaddon.cursed_energy_selector.button_imbue_with_negative_energy"), e -> {
            if (true) {
                JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new CursedEnergySelectorButtonMessage(0, x, y, z, textstate));
                CursedEnergySelectorButtonMessage.handleButtonAction(entity, 0, x, y, z, textstate);
            }
        }).bounds(this.leftPos + 13, this.topPos + 27, 160, 20).build();
        guistate.put("button:button_imbue_with_negative_energy", button_imbue_with_negative_energy);
        this.addRenderableWidget(button_imbue_with_negative_energy);
        button_imbue_with_positive_energy = Button.builder(Component.translatable("gui.jujutsucraftaddon.cursed_energy_selector.button_imbue_with_positive_energy"), e -> {
            if (true) {
                JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new CursedEnergySelectorButtonMessage(1, x, y, z, textstate));
                CursedEnergySelectorButtonMessage.handleButtonAction(entity, 1, x, y, z, textstate);
            }
        }).bounds(this.leftPos + 14, this.topPos + 107, 160, 20).build();
        guistate.put("button:button_imbue_with_positive_energy", button_imbue_with_positive_energy);
        this.addRenderableWidget(button_imbue_with_positive_energy);
        button_heal_with_ce = Button.builder(Component.translatable("gui.jujutsucraftaddon.cursed_energy_selector.button_heal_with_ce"), e -> {
            if (true) {
                JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new CursedEnergySelectorButtonMessage(2, x, y, z, textstate));
                CursedEnergySelectorButtonMessage.handleButtonAction(entity, 2, x, y, z, textstate);
            }
        }).bounds(this.leftPos + 46, this.topPos + 65, 87, 20).build();
        guistate.put("button:button_heal_with_ce", button_heal_with_ce);
        this.addRenderableWidget(button_heal_with_ce);
    }
}
