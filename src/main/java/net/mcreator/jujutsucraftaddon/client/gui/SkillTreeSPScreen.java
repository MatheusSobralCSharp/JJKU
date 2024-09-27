package net.mcreator.jujutsucraftaddon.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.InventoryScreen;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.Checkbox;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.Minecraft;

import net.mcreator.jujutsucraftaddon.world.inventory.SkillTreeSPMenu;
import net.mcreator.jujutsucraftaddon.procedures.ReturnSkillPointsProcedure;
import net.mcreator.jujutsucraftaddon.procedures.ReturnSimpleProcedure;
import net.mcreator.jujutsucraftaddon.procedures.ReturnSecretProcedure;
import net.mcreator.jujutsucraftaddon.procedures.ReturnSecret2Procedure;
import net.mcreator.jujutsucraftaddon.procedures.ReturnEntityProcedure;
import net.mcreator.jujutsucraftaddon.procedures.ReturnBurnoutExpProcedure;
import net.mcreator.jujutsucraftaddon.procedures.ReturnBarrierlessExpProcedure;
import net.mcreator.jujutsucraftaddon.procedures.ReturnAmountProcedure;
import net.mcreator.jujutsucraftaddon.network.SkillTreeSPButtonMessage;
import net.mcreator.jujutsucraftaddon.JujutsucraftaddonMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class SkillTreeSPScreen extends AbstractContainerScreen<SkillTreeSPMenu> {
	private final static HashMap<String, Object> guistate = SkillTreeSPMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private final static HashMap<String, String> textstate = new HashMap<>();
	public static EditBox speedslider;
	public static Checkbox checkspeed;
	Button button_empty;
	Button button_empty1;
	Button button_empty2;
	Button button_fight_your_spirit;
	Button button_rct_mastery_quest;
	Button button_unlock_extension_technique;

	public SkillTreeSPScreen(SkillTreeSPMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 500;
		this.imageHeight = 500;
	}

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		speedslider.render(guiGraphics, mouseX, mouseY, partialTicks);
		if (ReturnEntityProcedure.execute(entity) instanceof LivingEntity livingEntity) {
			InventoryScreen.renderEntityInInventoryFollowsAngle(guiGraphics, this.leftPos + 250, this.topPos + 314, 60, 0f + (float) Math.atan((this.leftPos + 250 - mouseX) / 40.0), (float) Math.atan((this.topPos + 265 - mouseY) / 40.0),
					livingEntity);
		}
		this.renderTooltip(guiGraphics, mouseX, mouseY);
		if (mouseX > leftPos + 127 && mouseX < leftPos + 151 && mouseY > topPos + 235 && mouseY < topPos + 259)
			guiGraphics.renderTooltip(font, Component.translatable("gui.jujutsucraftaddon.skill_tree_sp.tooltip_changes_your_health_attribute"), mouseX, mouseY);
		if (mouseX > leftPos + 127 && mouseX < leftPos + 151 && mouseY > topPos + 271 && mouseY < topPos + 295)
			guiGraphics.renderTooltip(font, Component.translatable("gui.jujutsucraftaddon.skill_tree_sp.tooltip_changes_your_ce_cursed_energ"), mouseX, mouseY);
		if (mouseX > leftPos + 126 && mouseX < leftPos + 150 && mouseY > topPos + 306 && mouseY < topPos + 330)
			guiGraphics.renderTooltip(font, Component.translatable("gui.jujutsucraftaddon.skill_tree_sp.tooltip_doubles_your_base_speed"), mouseX, mouseY);
		if (mouseX > leftPos + 367 && mouseX < leftPos + 391 && mouseY > topPos + 252 && mouseY < topPos + 276)
			guiGraphics.renderTooltip(font, Component.translatable("gui.jujutsucraftaddon.skill_tree_sp.tooltip_meditate_agressive_with_your_spi"), mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();

		guiGraphics.blit(new ResourceLocation("jujutsucraftaddon:textures/screens/healer.png"), this.leftPos + 125, this.topPos + 204, 0, 0, 32, 32, 32, 32);

		guiGraphics.blit(new ResourceLocation("jujutsucraftaddon:textures/screens/teste3.png"), this.leftPos + 101, this.topPos + 224, 0, 0, 82, 46, 82, 46);

		guiGraphics.blit(new ResourceLocation("jujutsucraftaddon:textures/screens/ce.png"), this.leftPos + 101, this.topPos + 260, 0, 0, 82, 46, 82, 46);

		guiGraphics.blit(new ResourceLocation("jujutsucraftaddon:textures/screens/speed.png"), this.leftPos + 101, this.topPos + 295, 0, 0, 82, 46, 82, 46);

		guiGraphics.blit(new ResourceLocation("jujutsucraftaddon:textures/screens/sukunaspirit.png"), this.leftPos + 348, this.topPos + 217, 0, 0, 60, 60, 60, 60);

		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		if (speedslider.isFocused())
			return speedslider.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
		speedslider.tick();
	}

	@Override
	public void resize(Minecraft minecraft, int width, int height) {
		String speedsliderValue = speedslider.getValue();
		super.resize(minecraft, width, height);
		speedslider.setValue(speedsliderValue);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font,

				ReturnSkillPointsProcedure.execute(entity), 309, 350, -16711690, false);
		guiGraphics.drawString(this.font,

				ReturnBurnoutExpProcedure.execute(entity), 42, 157, -4325121, false);
		if (ReturnSecret2Procedure.execute(entity))
			guiGraphics.drawString(this.font,

					ReturnAmountProcedure.execute(entity), 291, 329, -65536, false);
		guiGraphics.drawString(this.font,

				ReturnBarrierlessExpProcedure.execute(entity), 41, 180, -12139777, false);
		guiGraphics.drawString(this.font,

				ReturnSimpleProcedure.execute(entity), 43, 138, -3342337, false);
	}

	@Override
	public void init() {
		super.init();
		speedslider = new EditBox(this.font, this.leftPos + 69, this.topPos + 343, 118, 18, Component.translatable("gui.jujutsucraftaddon.skill_tree_sp.speedslider")) {
			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.jujutsucraftaddon.skill_tree_sp.speedslider").getString());
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.jujutsucraftaddon.skill_tree_sp.speedslider").getString());
				else
					setSuggestion(null);
			}
		};
		speedslider.setSuggestion(Component.translatable("gui.jujutsucraftaddon.skill_tree_sp.speedslider").getString());
		speedslider.setMaxLength(32767);
		guistate.put("text:speedslider", speedslider);
		this.addWidget(this.speedslider);
		button_empty = Button.builder(Component.translatable("gui.jujutsucraftaddon.skill_tree_sp.button_empty"), e -> {
			if (true) {
				textstate.put("textin:speedslider", speedslider.getValue());
				textstate.put("checkboxin:checkspeed", checkspeed.selected() ? "true" : "false");
				JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new SkillTreeSPButtonMessage(0, x, y, z, textstate));
				SkillTreeSPButtonMessage.handleButtonAction(entity, 0, x, y, z, textstate);
			}
		}).bounds(this.leftPos + 69, this.topPos + 238, 30, 20).build();
		guistate.put("button:button_empty", button_empty);
		this.addRenderableWidget(button_empty);
		button_empty1 = Button.builder(Component.translatable("gui.jujutsucraftaddon.skill_tree_sp.button_empty1"), e -> {
			if (true) {
				textstate.put("textin:speedslider", speedslider.getValue());
				textstate.put("checkboxin:checkspeed", checkspeed.selected() ? "true" : "false");
				JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new SkillTreeSPButtonMessage(1, x, y, z, textstate));
				SkillTreeSPButtonMessage.handleButtonAction(entity, 1, x, y, z, textstate);
			}
		}).bounds(this.leftPos + 69, this.topPos + 273, 30, 20).build();
		guistate.put("button:button_empty1", button_empty1);
		this.addRenderableWidget(button_empty1);
		button_empty2 = Button.builder(Component.translatable("gui.jujutsucraftaddon.skill_tree_sp.button_empty2"), e -> {
			if (true) {
				textstate.put("textin:speedslider", speedslider.getValue());
				textstate.put("checkboxin:checkspeed", checkspeed.selected() ? "true" : "false");
				JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new SkillTreeSPButtonMessage(2, x, y, z, textstate));
				SkillTreeSPButtonMessage.handleButtonAction(entity, 2, x, y, z, textstate);
			}
		}).bounds(this.leftPos + 69, this.topPos + 309, 30, 20).build();
		guistate.put("button:button_empty2", button_empty2);
		this.addRenderableWidget(button_empty2);
		button_fight_your_spirit = Button.builder(Component.translatable("gui.jujutsucraftaddon.skill_tree_sp.button_fight_your_spirit"), e -> {
			if (true) {
				textstate.put("textin:speedslider", speedslider.getValue());
				textstate.put("checkboxin:checkspeed", checkspeed.selected() ? "true" : "false");
				JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new SkillTreeSPButtonMessage(3, x, y, z, textstate));
				SkillTreeSPButtonMessage.handleButtonAction(entity, 3, x, y, z, textstate);
			}
		}).bounds(this.leftPos + 322, this.topPos + 277, 113, 20).build();
		guistate.put("button:button_fight_your_spirit", button_fight_your_spirit);
		this.addRenderableWidget(button_fight_your_spirit);
		button_rct_mastery_quest = Button.builder(Component.translatable("gui.jujutsucraftaddon.skill_tree_sp.button_rct_mastery_quest"), e -> {
			if (ReturnSecretProcedure.execute(entity)) {
				textstate.put("textin:speedslider", speedslider.getValue());
				textstate.put("checkboxin:checkspeed", checkspeed.selected() ? "true" : "false");
				JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new SkillTreeSPButtonMessage(4, x, y, z, textstate));
				SkillTreeSPButtonMessage.handleButtonAction(entity, 4, x, y, z, textstate);
			}
		}).bounds(this.leftPos + 322, this.topPos + 175, 113, 20).build(builder -> new Button(builder) {
			@Override
			public void render(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
				if (ReturnSecretProcedure.execute(entity))
					super.render(guiGraphics, gx, gy, ticks);
			}
		});
		guistate.put("button:button_rct_mastery_quest", button_rct_mastery_quest);
		this.addRenderableWidget(button_rct_mastery_quest);
		button_unlock_extension_technique = Button.builder(Component.translatable("gui.jujutsucraftaddon.skill_tree_sp.button_unlock_extension_technique"), e -> {
			if (true) {
				textstate.put("textin:speedslider", speedslider.getValue());
				textstate.put("checkboxin:checkspeed", checkspeed.selected() ? "true" : "false");
				JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new SkillTreeSPButtonMessage(5, x, y, z, textstate));
				SkillTreeSPButtonMessage.handleButtonAction(entity, 5, x, y, z, textstate);
			}
		}).bounds(this.leftPos + 299, this.topPos + 302, 161, 20).build();
		guistate.put("button:button_unlock_extension_technique", button_unlock_extension_technique);
		this.addRenderableWidget(button_unlock_extension_technique);
		checkspeed = new Checkbox(this.leftPos + 44, this.topPos + 342, 20, 20, Component.translatable("gui.jujutsucraftaddon.skill_tree_sp.checkspeed"), false);
		guistate.put("checkbox:checkspeed", checkspeed);
		this.addRenderableWidget(checkspeed);
	}
}
