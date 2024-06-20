package net.mcreator.jujutsucraftaddon.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.jujutsucraftaddon.world.inventory.TestrMenu;
import net.mcreator.jujutsucraftaddon.network.TestrButtonMessage;
import net.mcreator.jujutsucraftaddon.JujutsucraftaddonMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class TestrScreen extends AbstractContainerScreen<TestrMenu> {
	private final static HashMap<String, Object> guistate = TestrMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_nomiddle;
	ImageButton imagebutton_noleft;
	ImageButton imagebutton_noleftdown;
	ImageButton imagebutton_noright;
	ImageButton imagebutton_norightdown;

	public TestrScreen(TestrMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 200;
		this.imageHeight = 200;
	}

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
	public void containerTick() {
		super.containerTick();
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
	}

	@Override
	public void init() {
		super.init();
		imagebutton_nomiddle = new ImageButton(this.leftPos + 68, this.topPos + 7, 58, 132, 0, 0, 132, new ResourceLocation("jujutsucraftaddon:textures/screens/atlas/imagebutton_nomiddle.png"), 58, 264, e -> {
			if (true) {
				JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new TestrButtonMessage(0, x, y, z));
				TestrButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:imagebutton_nomiddle", imagebutton_nomiddle);
		this.addRenderableWidget(imagebutton_nomiddle);
		imagebutton_noleft = new ImageButton(this.leftPos + 10, this.topPos + 74, 81, 43, 0, 0, 43, new ResourceLocation("jujutsucraftaddon:textures/screens/atlas/imagebutton_noleft.png"), 81, 86, e -> {
			if (true) {
				JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new TestrButtonMessage(1, x, y, z));
				TestrButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:imagebutton_noleft", imagebutton_noleft);
		this.addRenderableWidget(imagebutton_noleft);
		imagebutton_noleftdown = new ImageButton(this.leftPos + 44, this.topPos + 108, 58, 73, 0, 0, 73, new ResourceLocation("jujutsucraftaddon:textures/screens/atlas/imagebutton_noleftdown.png"), 58, 146, e -> {
			if (true) {
				JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new TestrButtonMessage(2, x, y, z));
				TestrButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		});
		guistate.put("button:imagebutton_noleftdown", imagebutton_noleftdown);
		this.addRenderableWidget(imagebutton_noleftdown);
		imagebutton_noright = new ImageButton(this.leftPos + 104, this.topPos + 74, 81, 43, 0, 0, 43, new ResourceLocation("jujutsucraftaddon:textures/screens/atlas/imagebutton_noright.png"), 81, 86, e -> {
			if (true) {
				JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new TestrButtonMessage(3, x, y, z));
				TestrButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		});
		guistate.put("button:imagebutton_noright", imagebutton_noright);
		this.addRenderableWidget(imagebutton_noright);
		imagebutton_norightdown = new ImageButton(this.leftPos + 95, this.topPos + 112, 58, 69, 0, 0, 69, new ResourceLocation("jujutsucraftaddon:textures/screens/atlas/imagebutton_norightdown.png"), 58, 138, e -> {
			if (true) {
				JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new TestrButtonMessage(4, x, y, z));
				TestrButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		});
		guistate.put("button:imagebutton_norightdown", imagebutton_norightdown);
		this.addRenderableWidget(imagebutton_norightdown);
	}
}
