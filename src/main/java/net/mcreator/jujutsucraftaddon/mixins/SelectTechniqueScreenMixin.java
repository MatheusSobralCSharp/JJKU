package net.mcreator.jujutsucraftaddon.mixins;

import net.mcreator.jujutsucraft.JujutsucraftMod;
import net.mcreator.jujutsucraft.client.gui.SelectTechniqueScreen;
import net.mcreator.jujutsucraft.network.SelectTechniqueButtonMessage;
import net.mcreator.jujutsucraft.world.inventory.SelectTechniqueMenu;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.HashMap;

@Mixin(value = SelectTechniqueScreen.class, priority = 3000)
public abstract class SelectTechniqueScreenMixin extends AbstractContainerScreen<SelectTechniqueMenu> {
    @Unique
    Button second_technique;

    /**
     * @author Satushi
     */

    public SelectTechniqueScreenMixin(SelectTechniqueMenu container, Inventory inventory, Component text) {
        super(container, inventory, text);
    }

    // Example: Inject into the init() method to add a custom button
    @Inject(
            method = {"init"},
            at = {@At("TAIL")}
    )
    public void onInit(CallbackInfo ci) {
        TechniqueGuiAccessorMixin accessor = (TechniqueGuiAccessorMixin)this;
        Level world = accessor.getWorld();
        int x = accessor.getX();
        int y = accessor.getY();
        int z = accessor.getZ();
        Player entity = accessor.getEntity();
        HashMap<String, Object> guistate = accessor.getGuistate();
        this.second_technique = Button.builder(Component.literal("Second Technique"), (e) -> {
            JujutsucraftMod.PACKET_HANDLER.sendToServer(new SelectTechniqueButtonMessage(100, x, y, z));
            SelectTechniqueButtonMessage.handleButtonAction(entity, 100, x, y, z);
        }).bounds(this.leftPos + 11, this.topPos + 180, 75, 20).build();
        guistate.put("button:second_technique", this.second_technique);
        this.addRenderableWidget(this.second_technique);
    }

    @Inject(
            method = "render",
            at = @At("TAIL")
    )
    public void renderTooltip(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks, CallbackInfo ci) {
        if (this.second_technique != null && this.second_technique.isMouseOver(mouseX, mouseY)) {
            guiGraphics.renderTooltip(this.font, Component.literal("This will Change your second Technique grabbing your technique, for enable use /jjkuSecondTechnique @s true "), mouseX, mouseY);
        }
    }
}