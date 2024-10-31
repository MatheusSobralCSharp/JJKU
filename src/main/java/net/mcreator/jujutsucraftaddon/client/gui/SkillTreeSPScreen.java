package net.mcreator.jujutsucraftaddon.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.jujutsucraftaddon.world.inventory.SkillTreeSPMenu;
import net.mcreator.jujutsucraftaddon.procedures.ReturnSkillPointsProcedure;
import net.mcreator.jujutsucraftaddon.procedures.ReturnSimpleProcedure;
import net.mcreator.jujutsucraftaddon.procedures.ReturnSecretProcedure;
import net.mcreator.jujutsucraftaddon.procedures.ReturnSecret2Procedure;
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
    Button button_empty;
    Button button_empty1;
    Button button_empty2;
    Button button_fight_your_spirit;
    Button button_rct_mastery_quest;
    Button button_toggle_dash;
    Button button_toggle_impact_frames;
    Button button_toggle_music_ost;
    Button button_unlock_extension;

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
        return super.keyPressed(key, b, c);
    }

    @Override
    protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
        guiGraphics.drawString(this.font,

                ReturnSkillPointsProcedure.execute(entity), 320, 350, -16711690, false);
        guiGraphics.drawString(this.font,

                ReturnBurnoutExpProcedure.execute(entity), 42, 157, -4325121, false);
        if (ReturnSecret2Procedure.execute(entity))
            guiGraphics.drawString(this.font,

                    ReturnAmountProcedure.execute(entity), 104, 351, -65536, false);
        guiGraphics.drawString(this.font,

                ReturnBarrierlessExpProcedure.execute(entity), 41, 180, -12139777, false);
        guiGraphics.drawString(this.font,

                ReturnSimpleProcedure.execute(entity), 43, 138, -3342337, false);
    }

    @Override
    public void init() {
        super.init();
        button_empty = Button.builder(Component.translatable("gui.jujutsucraftaddon.skill_tree_sp.button_empty"), e -> {
            if (true) {
                JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new SkillTreeSPButtonMessage(0, x, y, z, textstate));
                SkillTreeSPButtonMessage.handleButtonAction(entity, 0, x, y, z, textstate);
            }
        }).bounds(this.leftPos + 69, this.topPos + 238, 30, 20).build();
        guistate.put("button:button_empty", button_empty);
        this.addRenderableWidget(button_empty);
        button_empty1 = Button.builder(Component.translatable("gui.jujutsucraftaddon.skill_tree_sp.button_empty1"), e -> {
            if (true) {
                JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new SkillTreeSPButtonMessage(1, x, y, z, textstate));
                SkillTreeSPButtonMessage.handleButtonAction(entity, 1, x, y, z, textstate);
            }
        }).bounds(this.leftPos + 69, this.topPos + 273, 30, 20).build();
        guistate.put("button:button_empty1", button_empty1);
        this.addRenderableWidget(button_empty1);
        button_empty2 = Button.builder(Component.translatable("gui.jujutsucraftaddon.skill_tree_sp.button_empty2"), e -> {
            if (true) {
                JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new SkillTreeSPButtonMessage(2, x, y, z, textstate));
                SkillTreeSPButtonMessage.handleButtonAction(entity, 2, x, y, z, textstate);
            }
        }).bounds(this.leftPos + 69, this.topPos + 309, 30, 20).build();
        guistate.put("button:button_empty2", button_empty2);
        this.addRenderableWidget(button_empty2);
        button_fight_your_spirit = Button.builder(Component.translatable("gui.jujutsucraftaddon.skill_tree_sp.button_fight_your_spirit"), e -> {
            if (true) {
                JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new SkillTreeSPButtonMessage(3, x, y, z, textstate));
                SkillTreeSPButtonMessage.handleButtonAction(entity, 3, x, y, z, textstate);
            }
        }).bounds(this.leftPos + 322, this.topPos + 277, 113, 20).build();
        guistate.put("button:button_fight_your_spirit", button_fight_your_spirit);
        this.addRenderableWidget(button_fight_your_spirit);
        button_rct_mastery_quest = Button.builder(Component.translatable("gui.jujutsucraftaddon.skill_tree_sp.button_rct_mastery_quest"), e -> {
            if (ReturnSecretProcedure.execute(entity)) {
                JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new SkillTreeSPButtonMessage(4, x, y, z, textstate));
                SkillTreeSPButtonMessage.handleButtonAction(entity, 4, x, y, z, textstate);
            }
        }).bounds(this.leftPos + 322, this.topPos + 194, 113, 20).build(builder -> new Button(builder) {
            @Override
            public void render(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
                if (ReturnSecretProcedure.execute(entity))
                    super.render(guiGraphics, gx, gy, ticks);
            }
        });
        guistate.put("button:button_rct_mastery_quest", button_rct_mastery_quest);
        this.addRenderableWidget(button_rct_mastery_quest);
        button_toggle_dash = Button.builder(Component.translatable("gui.jujutsucraftaddon.skill_tree_sp.button_toggle_dash"), e -> {
            if (true) {
                JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new SkillTreeSPButtonMessage(5, x, y, z, textstate));
                SkillTreeSPButtonMessage.handleButtonAction(entity, 5, x, y, z, textstate);
            }
        }).bounds(this.leftPos + 206, this.topPos + 308, 82, 20).build();
        guistate.put("button:button_toggle_dash", button_toggle_dash);
        this.addRenderableWidget(button_toggle_dash);
        button_toggle_impact_frames = Button.builder(Component.translatable("gui.jujutsucraftaddon.skill_tree_sp.button_toggle_impact_frames"), e -> {
            if (true) {
                JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new SkillTreeSPButtonMessage(6, x, y, z, textstate));
                SkillTreeSPButtonMessage.handleButtonAction(entity, 6, x, y, z, textstate);
            }
        }).bounds(this.leftPos + 186, this.topPos + 276, 129, 20).build();
        guistate.put("button:button_toggle_impact_frames", button_toggle_impact_frames);
        this.addRenderableWidget(button_toggle_impact_frames);
        button_toggle_music_ost = Button.builder(Component.translatable("gui.jujutsucraftaddon.skill_tree_sp.button_toggle_music_ost"), e -> {
            if (true) {
                JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new SkillTreeSPButtonMessage(7, x, y, z, textstate));
                SkillTreeSPButtonMessage.handleButtonAction(entity, 7, x, y, z, textstate);
            }
        }).bounds(this.leftPos + 195, this.topPos + 247, 108, 20).build();
        guistate.put("button:button_toggle_music_ost", button_toggle_music_ost);
        this.addRenderableWidget(button_toggle_music_ost);
        button_unlock_extension = Button.builder(Component.translatable("gui.jujutsucraftaddon.skill_tree_sp.button_unlock_extension"), e -> {
            if (true) {
                JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new SkillTreeSPButtonMessage(8, x, y, z, textstate));
                SkillTreeSPButtonMessage.handleButtonAction(entity, 8, x, y, z, textstate);
            }
        }).bounds(this.leftPos + 324, this.topPos + 304, 108, 20).build();
        guistate.put("button:button_unlock_extension", button_unlock_extension);
        this.addRenderableWidget(button_unlock_extension);
    }
}
