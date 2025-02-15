package net.mcreator.jujutsucraftaddon.client.gui;

import com.mojang.blaze3d.systems.RenderSystem;
import net.mcreator.jujutsucraftaddon.JujutsucraftaddonMod;
import net.mcreator.jujutsucraftaddon.network.NewTabButtonMessage;
import net.mcreator.jujutsucraftaddon.world.inventory.NewTabMenu;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

import java.util.HashMap;

public class NewTabScreen extends AbstractContainerScreen<NewTabMenu> {
    private final static HashMap<String, Object> guistate = NewTabMenu.guistate;
    private final Level world;
    private final int x, y, z;
    private final Player entity;
    Button button_unlock_extension;
    Button button_toggle_map_navigation;
    Button button_history_mode;
    Button button_cursed_weapon_menu;
    Button button_toggle_water_walking;
    Button button_profession_tree;
    Button button_toggle_music_ost;
    Button button_toggle_impact_frames;
    Button button_toggle_dash;
    Button button_toggle_combat_animations;
    Button button_history_mode_gojosukuna;

    public NewTabScreen(NewTabMenu container, Inventory inventory, Component text) {
        super(container, inventory, text);
        this.world = container.world;
        this.x = container.x;
        this.y = container.y;
        this.z = container.z;
        this.entity = container.entity;
        this.imageWidth = 350;
        this.imageHeight = 220;
    }

    private static final ResourceLocation texture = new ResourceLocation("jujutsucraftaddon:textures/screens/new_tab.png");

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(guiGraphics);
        super.render(guiGraphics, mouseX, mouseY, partialTicks);
        this.renderTooltip(guiGraphics, mouseX, mouseY);
        if (mouseX > leftPos + 241 && mouseX < leftPos + 265 && mouseY > topPos + 20 && mouseY < topPos + 44)
            guiGraphics.renderTooltip(font, Component.translatable("gui.jujutsucraftaddon.new_tab.tooltip_for_unlock_extension_just_click"), mouseX, mouseY);
        if (mouseX > leftPos + 72 && mouseX < leftPos + 96 && mouseY > topPos + 175 && mouseY < topPos + 199)
            guiGraphics.renderTooltip(font, Component.translatable("gui.jujutsucraftaddon.new_tab.tooltip_toggle_overlay_map_navigation_fo"), mouseX, mouseY);
        if (mouseX > leftPos + 241 && mouseX < leftPos + 265 && mouseY > topPos + 111 && mouseY < topPos + 135)
            guiGraphics.renderTooltip(font, Component.translatable("gui.jujutsucraftaddon.new_tab.tooltip_here_is_where_history_mode_quest"), mouseX, mouseY);
        if (mouseX > leftPos + 241 && mouseX < leftPos + 265 && mouseY > topPos + 50 && mouseY < topPos + 74)
            guiGraphics.renderTooltip(font, Component.translatable("gui.jujutsucraftaddon.new_tab.tooltip_display_cursed_weapon_menu_encha"), mouseX, mouseY);
        if (mouseX > leftPos + 73 && mouseX < leftPos + 97 && mouseY > topPos + 112 && mouseY < topPos + 136)
            guiGraphics.renderTooltip(font, Component.translatable("gui.jujutsucraftaddon.new_tab.tooltip_enable_or_disable_water_walking"), mouseX, mouseY);
        if (mouseX > leftPos + 241 && mouseX < leftPos + 265 && mouseY > topPos + 81 && mouseY < topPos + 105)
            guiGraphics.renderTooltip(font, Component.translatable("gui.jujutsucraftaddon.new_tab.tooltip_display_your_profession_skill_tr"), mouseX, mouseY);
        if (mouseX > leftPos + 72 && mouseX < leftPos + 96 && mouseY > topPos + 144 && mouseY < topPos + 168)
            guiGraphics.renderTooltip(font, Component.translatable("gui.jujutsucraftaddon.new_tab.tooltip_disable_jjk_songsosts_from_bein"), mouseX, mouseY);
        if (mouseX > leftPos + 73 && mouseX < leftPos + 97 && mouseY > topPos + 82 && mouseY < topPos + 106)
            guiGraphics.renderTooltip(font, Component.translatable("gui.jujutsucraftaddon.new_tab.tooltip_disableenable_impact_frames"), mouseX, mouseY);
        if (mouseX > leftPos + 73 && mouseX < leftPos + 97 && mouseY > topPos + 51 && mouseY < topPos + 75)
            guiGraphics.renderTooltip(font, Component.translatable("gui.jujutsucraftaddon.new_tab.tooltip_enabledisable_dashing"), mouseX, mouseY);
        if (mouseX > leftPos + 73 && mouseX < leftPos + 97 && mouseY > topPos + 21 && mouseY < topPos + 45)
            guiGraphics.renderTooltip(font, Component.translatable("gui.jujutsucraftaddon.new_tab.tooltip_disable_or_enable_combat_animati"), mouseX, mouseY);
        if (mouseX > leftPos + 241 && mouseX < leftPos + 265 && mouseY > topPos + 140 && mouseY < topPos + 164)
            guiGraphics.renderTooltip(font, Component.translatable("gui.jujutsucraftaddon.new_tab.tooltip_empty"), mouseX, mouseY);
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
        button_unlock_extension = Button.builder(Component.translatable("gui.jujutsucraftaddon.new_tab.button_unlock_extension"), e -> {
            if (true) {
                JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new NewTabButtonMessage(0, x, y, z));
                NewTabButtonMessage.handleButtonAction(entity, 0, x, y, z);
            }
        }).bounds(this.leftPos + 201, this.topPos + 23, 108, 20).build();
        guistate.put("button:button_unlock_extension", button_unlock_extension);
        this.addRenderableWidget(button_unlock_extension);
        button_toggle_map_navigation = Button.builder(Component.translatable("gui.jujutsucraftaddon.new_tab.button_toggle_map_navigation"), e -> {
            if (true) {
                JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new NewTabButtonMessage(1, x, y, z));
                NewTabButtonMessage.handleButtonAction(entity, 1, x, y, z);
            }
        }).bounds(this.leftPos + 24, this.topPos + 176, 134, 20).build();
        guistate.put("button:button_toggle_map_navigation", button_toggle_map_navigation);
        this.addRenderableWidget(button_toggle_map_navigation);
        button_history_mode = Button.builder(Component.translatable("gui.jujutsucraftaddon.new_tab.button_history_mode"), e -> {
            if (true) {
                JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new NewTabButtonMessage(2, x, y, z));
                NewTabButtonMessage.handleButtonAction(entity, 2, x, y, z);
            }
        }).bounds(this.leftPos + 210, this.topPos + 113, 87, 20).build();
        guistate.put("button:button_history_mode", button_history_mode);
        this.addRenderableWidget(button_history_mode);
        button_cursed_weapon_menu = Button.builder(Component.translatable("gui.jujutsucraftaddon.new_tab.button_cursed_weapon_menu"), e -> {
            if (true) {
                JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new NewTabButtonMessage(3, x, y, z));
                NewTabButtonMessage.handleButtonAction(entity, 3, x, y, z);
            }
        }).bounds(this.leftPos + 197, this.topPos + 53, 119, 20).build();
        guistate.put("button:button_cursed_weapon_menu", button_cursed_weapon_menu);
        this.addRenderableWidget(button_cursed_weapon_menu);
        button_toggle_water_walking = Button.builder(Component.translatable("gui.jujutsucraftaddon.new_tab.button_toggle_water_walking"), e -> {
            if (true) {
                JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new NewTabButtonMessage(4, x, y, z));
                NewTabButtonMessage.handleButtonAction(entity, 4, x, y, z);
            }
        }).bounds(this.leftPos + 27, this.topPos + 116, 129, 20).build();
        guistate.put("button:button_toggle_water_walking", button_toggle_water_walking);
        this.addRenderableWidget(button_toggle_water_walking);
        button_profession_tree = Button.builder(Component.translatable("gui.jujutsucraftaddon.new_tab.button_profession_tree"), e -> {
            if (true) {
                JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new NewTabButtonMessage(5, x, y, z));
                NewTabButtonMessage.handleButtonAction(entity, 5, x, y, z);
            }
        }).bounds(this.leftPos + 202, this.topPos + 83, 103, 20).build();
        guistate.put("button:button_profession_tree", button_profession_tree);
        this.addRenderableWidget(button_profession_tree);
        button_toggle_music_ost = Button.builder(Component.translatable("gui.jujutsucraftaddon.new_tab.button_toggle_music_ost"), e -> {
            if (true) {
                JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new NewTabButtonMessage(6, x, y, z));
                NewTabButtonMessage.handleButtonAction(entity, 6, x, y, z);
            }
        }).bounds(this.leftPos + 35, this.topPos + 147, 108, 20).build();
        guistate.put("button:button_toggle_music_ost", button_toggle_music_ost);
        this.addRenderableWidget(button_toggle_music_ost);
        button_toggle_impact_frames = Button.builder(Component.translatable("gui.jujutsucraftaddon.new_tab.button_toggle_impact_frames"), e -> {
            if (true) {
                JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new NewTabButtonMessage(7, x, y, z));
                NewTabButtonMessage.handleButtonAction(entity, 7, x, y, z);
            }
        }).bounds(this.leftPos + 27, this.topPos + 84, 129, 20).build();
        guistate.put("button:button_toggle_impact_frames", button_toggle_impact_frames);
        this.addRenderableWidget(button_toggle_impact_frames);
        button_toggle_dash = Button.builder(Component.translatable("gui.jujutsucraftaddon.new_tab.button_toggle_dash"), e -> {
            if (true) {
                JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new NewTabButtonMessage(8, x, y, z));
                NewTabButtonMessage.handleButtonAction(entity, 8, x, y, z);
            }
        }).bounds(this.leftPos + 47, this.topPos + 52, 82, 20).build();
        guistate.put("button:button_toggle_dash", button_toggle_dash);
        this.addRenderableWidget(button_toggle_dash);
        button_toggle_combat_animations = Button.builder(Component.translatable("gui.jujutsucraftaddon.new_tab.button_toggle_combat_animations"), e -> {
            if (true) {
                JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new NewTabButtonMessage(9, x, y, z));
                NewTabButtonMessage.handleButtonAction(entity, 9, x, y, z);
            }
        }).bounds(this.leftPos + 17, this.topPos + 23, 150, 20).build();
        guistate.put("button:button_toggle_combat_animations", button_toggle_combat_animations);
        this.addRenderableWidget(button_toggle_combat_animations);
        button_history_mode_gojosukuna = Button.builder(Component.translatable("gui.jujutsucraftaddon.new_tab.button_history_mode_gojosukuna"), e -> {
            if (true) {
                JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new NewTabButtonMessage(10, x, y, z));
                NewTabButtonMessage.handleButtonAction(entity, 10, x, y, z);
            }
        }).bounds(this.leftPos + 182, this.topPos + 142, 150, 20).build();
        guistate.put("button:button_history_mode_gojosukuna", button_history_mode_gojosukuna);
        this.addRenderableWidget(button_history_mode_gojosukuna);
    }
}
