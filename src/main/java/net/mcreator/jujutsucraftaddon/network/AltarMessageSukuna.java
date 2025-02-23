package net.mcreator.jujutsucraftaddon.network;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
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
public class AltarMessageSukuna {
    int page;

    // Constructor
    public AltarMessageSukuna(int page) {
        this.page = page;
    }

    // Decoder
    public AltarMessageSukuna(FriendlyByteBuf buffer) {
        this.page = buffer.readInt();
    }

    // Encoder
    public static void buffer(AltarMessageSukuna message, FriendlyByteBuf buffer) {
        buffer.writeInt(message.page);
    }

    // Handler
    public static void handler(AltarMessageSukuna message, Supplier<NetworkEvent.Context> contextSupplier) {
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
        if (entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables()).PlayerCurseTechnique2 == 1 && entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables()).PlayerCursePower >= 500) {
            // Execute actions based on the type
            if (page == 0) {
                entity.getPersistentData().putDouble("skill", 100);
                entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                    capability.PlayerSelectCurseTechniqueName = (Component.translatable("jujutsu.technique.attack1").getString());
                    capability.syncPlayerVariables(entity);
                });
                KeyStartTechniqueOnKeyPressedProcedure.execute(world, x, y, z, entity);

            } else if (page == 1) {
                entity.getPersistentData().putDouble("skill", 101);
                entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                    capability.PlayerSelectCurseTechniqueName = (Component.translatable("jujutsu.technique.attack2").getString());
                    capability.syncPlayerVariables(entity);
                });
                KeyStartTechniqueOnKeyPressedProcedure.execute(world, x, y, z, entity);

            } else if (page == 2) {
                entity.getPersistentData().putDouble("skill", 102);
                entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                    capability.PlayerSelectCurseTechniqueName = (Component.translatable("jujutsu.technique.attack3").getString());
                    capability.syncPlayerVariables(entity);
                });
                KeyStartTechniqueOnKeyPressedProcedure.execute(world, x, y, z, entity);

            } else if (page == 3) {
                entity.getPersistentData().putDouble("skill", 105);
                KeyStartTechniqueOnKeyPressedProcedure.execute(world, x, y, z, entity);
                entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                    capability.PlayerSelectCurseTechniqueName = (Component.translatable("jujutsu.technique.dismantle").getString());
                    capability.syncPlayerVariables(entity);
                });

            } else if (page == 4) {
                entity.getPersistentData().putDouble("skill", 106);
                KeyStartTechniqueOnKeyPressedProcedure.execute(world, x, y, z, entity);
                entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                    capability.PlayerSelectCurseTechniqueName = (Component.translatable("jujutsu.technique.cleave").getString());
                    capability.syncPlayerVariables(entity);
                });

            } else if (page == 5) {
                entity.getPersistentData().putDouble("skill", 107);
                KeyStartTechniqueOnKeyPressedProcedure.execute(world, x, y, z, entity);
                entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                    capability.PlayerSelectCurseTechniqueName = (Component.translatable("jujutsu.technique.open").getString());
                    capability.syncPlayerVariables(entity);
                });

            } else if (page == 6) {
                if (entity instanceof ServerPlayer _plr0 && _plr0.level() instanceof ServerLevel && _plr0.getAdvancements().getOrStartProgress(_plr0.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:skill_dismantle_cut_the_world"))).isDone())
                         {
                    entity.getPersistentData().putDouble("skill", 1619);
                    entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.PlayerSelectCurseTechniqueName = "jujutsu.technique.dismantle";
                        entity.getPersistentData().putDouble("cnt6", 45);
                        capability.syncPlayerVariables(entity);
                    });
                    KeyStartTechniqueOnKeyPressedProcedure.execute(world, x, y, z, entity);
                }
            } } else if (page == 7) {
            entity.getPersistentData().putDouble("skill", 220);
            entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                capability.PlayerSelectCurseTechniqueName = "jujutsu.technique.malevolent_shrine";
                capability.syncPlayerVariables(entity);
            });
            KeyStartTechniqueOnKeyPressedProcedure.execute(world, x, y, z, entity);


        }
        RemoveCE.execute(entity, world);
    }
    // Registrando o Packet
    @SubscribeEvent
    public static void registerMessage(FMLCommonSetupEvent event) {
        JujutsucraftaddonMod.addNetworkMessage(AltarMessageSukuna.class, AltarMessageSukuna::buffer, AltarMessageSukuna::new, AltarMessageSukuna::handler);
    }
}
