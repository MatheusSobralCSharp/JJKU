package net.mcreator.jujutsucraftaddon.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.jujutsucraftaddon.world.inventory.KenjakuBodySwapMenu;
import net.mcreator.jujutsucraftaddon.procedures.Condition2Procedure;
import net.mcreator.jujutsucraftaddon.procedures.Condition1Procedure;
import net.mcreator.jujutsucraftaddon.procedures.CTNamesProcedure;
import net.mcreator.jujutsucraftaddon.procedures.CTNames2Procedure;
import net.mcreator.jujutsucraftaddon.network.KenjakuBodySwapButtonMessage;
import net.mcreator.jujutsucraftaddon.JujutsucraftaddonMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class KenjakuBodySwapScreen extends AbstractContainerScreen<KenjakuBodySwapMenu> {
	private final static HashMap<String, Object> guistate = KenjakuBodySwapMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_select;
	Button button_select1;
	Button button_select2;
	Button button_x;
	Button button_x1;

	public KenjakuBodySwapScreen(KenjakuBodySwapMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 200;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("jujutsucraftaddon:textures/screens/kenjaku_body_swap.png");

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
	public void containerTick() {
		super.containerTick();
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.jujutsucraftaddon.kenjaku_body_swap.label_geto_ct"), 10, 16, -12829636, false);
		guiGraphics.drawString(this.font,

				CTNamesProcedure.execute(entity), 9, 48, -12829636, false);
		guiGraphics.drawString(this.font,

				CTNames2Procedure.execute(entity), 9, 81, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		button_select = Button.builder(Component.translatable("gui.jujutsucraftaddon.kenjaku_body_swap.button_select"), e -> {
			if (true) {
				JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new KenjakuBodySwapButtonMessage(0, x, y, z));
				KenjakuBodySwapButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 99, this.topPos + 11, 56, 20).build();
		guistate.put("button:button_select", button_select);
		this.addRenderableWidget(button_select);
		button_select1 = Button.builder(Component.translatable("gui.jujutsucraftaddon.kenjaku_body_swap.button_select1"), e -> {
			if (Condition1Procedure.execute(entity)) {
				JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new KenjakuBodySwapButtonMessage(1, x, y, z));
				KenjakuBodySwapButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 81, this.topPos + 43, 56, 20).build(builder -> new Button(builder) {
			@Override
			public void render(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
				if (Condition1Procedure.execute(entity))
					super.render(guiGraphics, gx, gy, ticks);
			}
		});
		guistate.put("button:button_select1", button_select1);
		this.addRenderableWidget(button_select1);
		button_select2 = Button.builder(Component.translatable("gui.jujutsucraftaddon.kenjaku_body_swap.button_select2"), e -> {
			if (Condition2Procedure.execute(entity)) {
				JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new KenjakuBodySwapButtonMessage(2, x, y, z));
				KenjakuBodySwapButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}).bounds(this.leftPos + 81, this.topPos + 77, 56, 20).build(builder -> new Button(builder) {
			@Override
			public void render(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
				if (Condition2Procedure.execute(entity))
					super.render(guiGraphics, gx, gy, ticks);
			}
		});
		guistate.put("button:button_select2", button_select2);
		this.addRenderableWidget(button_select2);
		button_x = Button.builder(Component.translatable("gui.jujutsucraftaddon.kenjaku_body_swap.button_x"), e -> {
			if (Condition2Procedure.execute(entity)) {
				JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new KenjakuBodySwapButtonMessage(3, x, y, z));
				KenjakuBodySwapButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}).bounds(this.leftPos + 146, this.topPos + 77, 30, 20).build(builder -> new Button(builder) {
			@Override
			public void render(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
				if (Condition2Procedure.execute(entity))
					super.render(guiGraphics, gx, gy, ticks);
			}
		});
		guistate.put("button:button_x", button_x);
		this.addRenderableWidget(button_x);
		button_x1 = Button.builder(Component.translatable("gui.jujutsucraftaddon.kenjaku_body_swap.button_x1"), e -> {
			if (Condition1Procedure.execute(entity)) {
				JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new KenjakuBodySwapButtonMessage(4, x, y, z));
				KenjakuBodySwapButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		}).bounds(this.leftPos + 146, this.topPos + 43, 30, 20).build(builder -> new Button(builder) {
			@Override
			public void render(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
				if (Condition1Procedure.execute(entity))
					super.render(guiGraphics, gx, gy, ticks);
			}
		});
		guistate.put("button:button_x1", button_x1);
		this.addRenderableWidget(button_x1);
	}
}
