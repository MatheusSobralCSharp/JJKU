package net.mcreator.jujutsucraftaddon.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.jujutsucraftaddon.world.inventory.StoryModeSukuna5Menu;
import net.mcreator.jujutsucraftaddon.network.StoryModeSukuna5ButtonMessage;
import net.mcreator.jujutsucraftaddon.JujutsucraftaddonMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class StoryModeSukuna5Screen extends AbstractContainerScreen<StoryModeSukuna5Menu> {
	private final static HashMap<String, Object> guistate = StoryModeSukuna5Menu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_start;

	public StoryModeSukuna5Screen(StoryModeSukuna5Menu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("jujutsucraftaddon:textures/screens/story_mode_sukuna_5.png");

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
		guiGraphics.drawString(this.font, Component.translatable("gui.jujutsucraftaddon.story_mode_sukuna_5.label_beat_the_disaster_curses"), 54, 28, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.jujutsucraftaddon.story_mode_sukuna_5.label_hard"), 63, 49, -52429, false);
	}

	@Override
	public void init() {
		super.init();
		button_start = Button.builder(Component.translatable("gui.jujutsucraftaddon.story_mode_sukuna_5.button_start"), e -> {
			if (true) {
				JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new StoryModeSukuna5ButtonMessage(0, x, y, z));
				StoryModeSukuna5ButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 57, this.topPos + 73, 51, 20).build();
		guistate.put("button:button_start", button_start);
		this.addRenderableWidget(button_start);
	}
}
