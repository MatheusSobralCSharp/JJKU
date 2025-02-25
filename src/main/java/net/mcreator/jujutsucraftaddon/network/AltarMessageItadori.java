package net.mcreator.jujutsucraftaddon.network;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraft.procedures.CooldownTimeCombatEffectStartedappliedProcedure;
import net.mcreator.jujutsucraft.procedures.KeyStartTechniqueOnKeyPressedProcedure;
import net.mcreator.jujutsucraftaddon.JujutsucraftaddonMod;
import net.mcreator.jujutsucraftaddon.procedures.RemoveCE;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class AltarMessageItadori {
    int page;

    // Constructor
    public AltarMessageItadori(int page) {
        this.page = page;
    }

    // Decoder
    public AltarMessageItadori(FriendlyByteBuf buffer) {
        this.page = buffer.readInt();
    }

    // Encoder
    public static void buffer(AltarMessageItadori message, FriendlyByteBuf buffer) {
        buffer.writeInt(message.page);
    }

    // Handler
    public static void handler(AltarMessageItadori message, Supplier<NetworkEvent.Context> contextSupplier) {
        NetworkEvent.Context context = contextSupplier.get();
        context.enqueueWork(() -> {
            pressAction(context.getSender(), message.page);
        });
        context.setPacketHandled(true);
    }

    // Action logic based on type and pressed time
    public static void pressAction(Player entity, int page) {
        Level world = entity.level();
        double x = entity.getX();
        double y = entity.getY();
        double z = entity.getZ();

        // Check if the chunk is loaded
        if (!world.hasChunkAt(entity.blockPosition()))
            return;

        // Ações feitas, cada page = um index, lembrando que começa por 0, não por 1
        if (((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Clans).equals("Itadori") && entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables()).PlayerCurseTechnique2 == 21 && entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables()).PlayerCursePower >= 500) {
            if (page == 0) {
                entity.getPersistentData().putDouble("skill", -99);
                entity.getPersistentData().putBoolean("PRESS_Z", true);
                entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), 60, 3, false, false));
            } else if (page == 1) {
                entity.getPersistentData().putDouble("skill", -98);
                entity.getPersistentData().putBoolean("PRESS_Z", true);
                entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                    capability.PlayerSelectCurseTechniqueName = (Component.translatable("jujutsu.technique.attack3").getString());
                    capability.syncPlayerVariables(entity);
                });
                KeyStartTechniqueOnKeyPressedProcedure.execute(world, x, y, z, entity);
            } else if (page == 2) {
                entity.getPersistentData().putBoolean("PRESS_Z", true);
                entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                    capability.PlayerSelectCurseTechniqueName = (Component.translatable("jujutsu.technique.attack5").getString());
                    capability.syncPlayerVariables(entity);
                });
                KeyStartTechniqueOnKeyPressedProcedure.execute(world, x, y, z, entity);

            } else if (page == 3) {
                entity.getPersistentData().putBoolean("PRESS_Z", true);
                entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                    capability.PlayerSelectCurseTechniqueName = (Component.translatable("jujutsu.technique.attack4").getString());
                    capability.syncPlayerVariables(entity);
                });
                KeyStartTechniqueOnKeyPressedProcedure.execute(world, x, y, z, entity);

            } else if (page == 4) {
                if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables()).Subrace).equals("Death Painting")) {
                    entity.getPersistentData().putDouble("skill", 1007);
                    KeyStartTechniqueOnKeyPressedProcedure.execute(world, x, y, z, entity);
                }
            } else if (page == 5) {
               if (entity instanceof ServerPlayer _plr0 && _plr0.level() instanceof ServerLevel && _plr0.getAdvancements().getOrStartProgress(_plr0.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:enchained"))).isDone()
                       && entity instanceof ServerPlayer _plr1 && _plr1.level() instanceof ServerLevel
                       && _plr1.getAdvancements().getOrStartProgress(_plr1.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:soul_research"))).isDone()) {
                   entity.getPersistentData().putDouble("skill", 105);
                   entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                       capability.PlayerSelectCurseTechniqueName = "Soul Dismantle";
                       capability.syncPlayerVariables(entity);
                   });
                   KeyStartTechniqueOnKeyPressedProcedure.execute(world, x, y, z, entity);
               }
            } else if (page == 6) {
                if (entity instanceof ServerPlayer _plr0 && _plr0.level() instanceof ServerLevel && _plr0.getAdvancements().getOrStartProgress(_plr0.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:enchained"))).isDone()
                        && entity instanceof ServerPlayer _plr1 && _plr1.level() instanceof ServerLevel
                        && _plr1.getAdvancements().getOrStartProgress(_plr1.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:soul_research"))).isDone()) {
                    entity.getPersistentData().putDouble("skill", 106);
                    entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.PlayerSelectCurseTechniqueName = "Soul Cleave";
                        capability.syncPlayerVariables(entity);
                    });
                    KeyStartTechniqueOnKeyPressedProcedure.execute(world, x, y, z, entity);
                }
            } else if (page == 7) {
                if (entity instanceof ServerPlayer _plr0 && _plr0.level() instanceof ServerLevel && _plr0.getAdvancements().getOrStartProgress(_plr0.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:enchained"))).isDone()
                        && entity instanceof ServerPlayer _plr1 && _plr1.level() instanceof ServerLevel
                        && _plr1.getAdvancements().getOrStartProgress(_plr1.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:soul_research"))).isDone()) {
                    entity.getPersistentData().putDouble("skill", 120);
                    entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.PlayerSelectCurseTechniqueName = "Benevolent Shrine";
                        capability.syncPlayerVariables(entity);
                    });
                    RemoveCE.execute(entity, world);

                    KeyStartTechniqueOnKeyPressedProcedure.execute(world, x, y, z, entity);
                }
            }
            RemoveCE.execute(entity, world);
        }

    }
    // Registrando o Packet
    @SubscribeEvent
    public static void registerMessage(FMLCommonSetupEvent event) {
        JujutsucraftaddonMod.addNetworkMessage(AltarMessageItadori.class, AltarMessageItadori::buffer, AltarMessageItadori::new, AltarMessageItadori::handler);
    }
}