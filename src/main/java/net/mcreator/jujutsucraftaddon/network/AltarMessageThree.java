package net.mcreator.jujutsucraftaddon.network;

import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraft.procedures.StartCursedTechniqueProcedure;
import net.mcreator.jujutsucraftaddon.JujutsucraftaddonMod;
import net.mcreator.jujutsucraftaddon.procedures.BloodHitProcedure;
import net.mcreator.jujutsucraftaddon.procedures.BloodRecoverRegen;
import net.mcreator.jujutsucraftaddon.procedures.RemoveCE;
import net.mcreator.jujutsucraftaddon.procedures.SummonTodo;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class AltarMessageThree {
    int page;

    // Constructor
    public AltarMessageThree(int page) {
        this.page = page;
    }

    // Decoder
    public AltarMessageThree(FriendlyByteBuf buffer) {
        this.page = buffer.readInt();
    }

    // Encoder
    public static void buffer(AltarMessageThree message, FriendlyByteBuf buffer) {
        buffer.writeInt(message.page);
    }

    // Handler
    public static void handler(AltarMessageThree message, Supplier<NetworkEvent.Context> contextSupplier) {
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
        if (entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables()).PlayerCurseTechnique2 == 10 && entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables()).PlayerCursePower >= 500) {
            if (page == 1) {
                entity.getPersistentData().putDouble("skill", 1007.0);
                StartCursedTechniqueProcedure.execute(world, x, y, z, entity);
            } else if (page == 0) {
                entity.getPersistentData().putDouble("skill", 1005.0);
                StartCursedTechniqueProcedure.execute(world, x, y, z, entity);
            } else if (page == 3) {
                entity.getPersistentData().putDouble("skill", 1009.0);
                StartCursedTechniqueProcedure.execute(world, x, y, z, entity);
            } else if (page == 4) {
                SummonTodo.execute(world, x, y, z, entity);
            } else if (page == 5) {
                BloodRecoverRegen.execute(world, x, y, z, entity);
            } else if (page == 2) {
                entity.getPersistentData().putDouble("skill", 1019.0);
                StartCursedTechniqueProcedure.execute(world, x, y, z, entity);
            } else if (page == 6) {
                BloodHitProcedure.execute(world, entity);
            } else if (page == 7) {
                entity.getPersistentData().putDouble("skill", 1006.0);
                StartCursedTechniqueProcedure.execute(world, x, y, z, entity);
            } else if (page == 8) {
                entity.getPersistentData().putDouble("skill", 1008.0);
                StartCursedTechniqueProcedure.execute(world, x, y, z, entity);
            }

            RemoveCE.execute(entity, world);
        }

    }
    // Registrando o Packet
    @SubscribeEvent
    public static void registerMessage(FMLCommonSetupEvent event) {
        JujutsucraftaddonMod.addNetworkMessage(AltarMessageThree.class, AltarMessageThree::buffer, AltarMessageThree::new, AltarMessageThree::handler);
    }
}