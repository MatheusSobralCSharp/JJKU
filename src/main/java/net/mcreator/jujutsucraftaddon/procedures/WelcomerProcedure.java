package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.AdvancementEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

import net.mcreator.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModItems;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class WelcomerProcedure {
	@SubscribeEvent
	public static void onAdvancement(AdvancementEvent event) {
		execute(event, event.getEntity().level(), event.getAdvancement(), event.getEntity());
	}

	public static void execute(LevelAccessor world, Advancement advancement, Entity entity) {
		execute(null, world, advancement, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Advancement advancement, Entity entity) {
		if (advancement == null || entity == null)
			return;
		if (world instanceof Level _lvl0 && _lvl0.getServer() != null && _lvl0.getServer().getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:start_jujutsu_craft")).equals(advancement)) {
			if (entity instanceof Player || entity instanceof ServerPlayer) {
				if (!(entity instanceof ServerPlayer _plr3 && _plr3.level() instanceof ServerLevel
						&& _plr3.getAdvancements().getOrStartProgress(_plr3.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:welcome_to_jujutsu_plus"))).isDone())) {
					if (entity instanceof ServerPlayer _player) {
						Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:welcome_to_jujutsu_plus"));
						AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
						if (!_ap.isDone()) {
							for (String criteria : _ap.getRemainingCriteria())
								_player.getAdvancements().award(_adv, criteria);
						}
					}
					if (entity instanceof Player _player) {
						ItemStack _setstack = new ItemStack(JujutsucraftaddonModItems.CLAN_CHANGER.get());
						_setstack.setCount(1);
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}

					if (entity instanceof Player _player) {
						ItemStack _setstack = new ItemStack(JujutsucraftaddonModItems.PROFESSION.get());
						_setstack.setCount(1);
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}

					if (entity instanceof Player _player) {
						ItemStack _setstack = new ItemStack(JujutsucraftaddonModItems.RACE_CHANGER.get());
						_setstack.setCount(1);
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
					if (entity instanceof Player _player) {
						ItemStack _setstack = new ItemStack(JujutsucraftaddonModItems.CELLPHONE.get());
						_setstack.setCount(1);
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
					BookProcedureProcedure.execute(entity);
					if (entity instanceof Player _player) {
						ItemStack _setstack = new ItemStack(JujutsucraftaddonModItems.RANDOM_CT_CHANGER.get());
						_setstack.setCount(1);
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
					if (Math.random() <= 0.05) {
						{
							String _setval = "Gifted";
							entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.Trait = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					} else if (Math.random() <= 0.1) {
						{
							String _setval = "Cursed";
							entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.Trait = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					} else if (Math.random() <= 0.2) {
						{
							String _setval = "Speedy";
							entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.Trait = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					} else if (Math.random() <= 0.3) {
						{
							String _setval = "Strong";
							entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.Trait = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					} else if (Math.random() <= 0.4) {
						{
							String _setval = "Resistant";
							entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.Trait = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					} else if (Math.random() <= 0.5) {
						{
							String _setval = "Healthy";
							entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.Trait = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
				}
			}
		}
	}
}
