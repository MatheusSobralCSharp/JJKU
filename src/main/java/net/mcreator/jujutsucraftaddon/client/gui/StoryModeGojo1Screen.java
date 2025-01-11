package net.mcreator.jujutsucraftaddon.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.jujutsucraftaddon.world.inventory.StoryModeGojo1Menu;
import net.mcreator.jujutsucraftaddon.network.StoryModeGojo1ButtonMessage;
import net.mcreator.jujutsucraftaddon.JujutsucraftaddonMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class StoryModeGojo1Screen extends AbstractContainerScreen<StoryModeGojo1Menu> {
	private final static HashMap<String, Object> guistate = StoryModeGojo1Menu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_start;

	public StoryModeGojo1Screen(StoryModeGojo1Menu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("jujutsucraftaddon:textures/screens/story_mode_gojo_1.png");

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
		guiGraphics.drawString(this.font, Component.translatable("gui.jujutsucraftaddon.story_mode_gojo_1.label_beat_jogo_the_flame_god"), 20, 25, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.jujutsucraftaddon.story_mode_gojo_1.label_hard"), 65, 46, -52429, false);
	}

	@Override
	public void init() {
		super.init();
		button_start = Button.builder(Component.translatable("gui.jujutsucraftaddon.story_mode_gojo_1.button_start"), e -> {
			if (true) {
				JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new StoryModeGojo1ButtonMessage(0, x, y, z));
				StoryModeGojo1ButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 57, this.topPos + 67, 51, 20).build();
		guistate.put("button:button_start", button_start);
		this.addRenderableWidget(button_start);
	}
}
