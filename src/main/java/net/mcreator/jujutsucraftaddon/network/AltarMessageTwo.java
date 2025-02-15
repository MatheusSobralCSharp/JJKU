package net.mcreator.jujutsucraftaddon.network;

import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraft.procedures.SkillBoogieWoogieProcedure;
import net.mcreator.jujutsucraft.procedures.StartCursedTechniqueProcedure;
import net.mcreator.jujutsucraftaddon.JujutsucraftaddonMod;
import net.mcreator.jujutsucraftaddon.procedures.SummonTodo;
import net.mcreator.jujutsucraftaddon.procedures.SwapTodo;
import net.mcreator.jujutsucraftaddon.procedures.SwapTodoProjectile;
import net.mcreator.jujutsucraftaddon.procedures.SwapVibraslap;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class AltarMessageTwo {
    int page;

    // Constructor
    public AltarMessageTwo(int page) {
        this.page = page;
    }

    // Decoder
    public AltarMessageTwo(FriendlyByteBuf buffer) {
        this.page = buffer.readInt();
    }

    // Encoder
    public static void buffer(AltarMessageTwo message, FriendlyByteBuf buffer) {
        buffer.writeInt(message.page);
    }

    // Handler
    public static void handler(AltarMessageTwo message, Supplier<NetworkEvent.Context> contextSupplier) {
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
        if (entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables()).PlayerCurseTechnique2 == 20 && entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables()).PlayerCursePower >= 500) {
            if (page == 1) {
                entity.getPersistentData().putDouble("skill", 502);
                StartCursedTechniqueProcedure.execute(world, x, y, z, entity);
            } else if (page == 0) {
                SkillBoogieWoogieProcedure.execute(world, x, y, z, entity);
            } else if (page == 3) {
                SummonTodo.execute(world, x, y, z, entity);
            } else if (page == 4) {
                SwapVibraslap.execute(entity, world, 30);
            } else if (page == 5) {
                entity.getPersistentData().putDouble("skill", 2015);
                StartCursedTechniqueProcedure.execute(world, x, y, z, entity);
                SwapTodo.execute(entity, world, 30);
            } else if (page == 2) {
                SwapTodo.execute(entity, world, 30);
            } else if (page == 6) {
                SwapTodoProjectile.execute(entity, world, 30);
            }
        }

    }
    // Registrando o Packet
    @SubscribeEvent
    public static void registerMessage(FMLCommonSetupEvent event) {
        JujutsucraftaddonMod.addNetworkMessage(AltarMessageTwo.class, AltarMessageTwo::buffer, AltarMessageTwo::new, AltarMessageTwo::handler);
    }
}