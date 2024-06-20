package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModMobEffects;
import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModEntities;
import net.mcreator.jujutsucraft.init.JujutsucraftModEntities;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;

public class BlackFlashChancesProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (sourceentity instanceof Player || sourceentity instanceof ServerPlayer) {
			if (!(ForgeRegistries.ENTITY_TYPES.getKey(sourceentity.getType()).toString()).startsWith("jujutsucraft")) {
				if ((sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PhysicalAttack == true) {
					if (new Object() {
						public double getValue() {
							CompoundTag dataIndex3 = new CompoundTag();
							sourceentity.saveWithoutId(dataIndex3);
							return dataIndex3.getCompound("ForgeData").getDouble("skill");
						}
					}.getValue() > 0) {
						if ((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).BFChance >= 1) {
							if (Math.random() <= 0.001 * (sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).BFChance) {
								if (world instanceof ServerLevel _serverLevel) {
									Entity entitytospawn = JujutsucraftModEntities.ENTITY_BLACK_FLASH.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
									if (entitytospawn != null) {
										entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
									}
									{
										Entity _ent = sourceentity;
										if (!_ent.level().isClientSide() && _ent.getServer() != null) {
											_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
													_ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
													"execute as @s run advancement grant @s only jujutsucraft:black_flash");
										}
									}
								}
							}
						}
					}
					if (sourceentity instanceof ServerPlayer _plr6 && _plr6.level() instanceof ServerLevel
							&& _plr6.getAdvancements().getOrStartProgress(_plr6.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:black_flash"))).isDone()) {
						if ((sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == 21) {
							if (Math.random() <= 0.01) {
								if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.BROKEN_BRAIN.get(), 1000,
											(int) ((sourceentity instanceof LivingEntity && ((LivingEntity) sourceentity).hasEffect(JujutsucraftModMobEffects.ZONE.get())
													? ((LivingEntity) sourceentity).getEffect(JujutsucraftModMobEffects.ZONE.get()).getAmplifier()
													: 0) + 1),
											false, false));
							} else if (Math.random() <= 0.1) {
								if (entity instanceof LivingEntity _entity)
									_entity.removeEffect(MobEffects.DAMAGE_BOOST);
								if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 1000,
											(int) ((sourceentity instanceof LivingEntity && ((LivingEntity) sourceentity).hasEffect(JujutsucraftModMobEffects.ZONE.get())
													? ((LivingEntity) sourceentity).getEffect(JujutsucraftModMobEffects.ZONE.get()).getAmplifier()
													: 0) + 1),
											false, false));
							} else if (Math.random() <= 0.2) {
								if (entity instanceof LivingEntity _entity)
									_entity.removeEffect(JujutsucraftModMobEffects.REVERSE_CURSED_TECHNIQUE.get());
								if (entity instanceof LivingEntity _entity)
									_entity.removeEffect(MobEffects.MOVEMENT_SPEED);
							} else if (Math.random() <= 0.3) {
								if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 1000,
											(int) ((sourceentity instanceof LivingEntity && ((LivingEntity) sourceentity).hasEffect(JujutsucraftModMobEffects.ZONE.get())
													? ((LivingEntity) sourceentity).getEffect(JujutsucraftModMobEffects.ZONE.get()).getAmplifier()
													: 0) + 1),
											false, false));
							} else if (Math.random() <= 0.4) {
								if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 1000,
											(int) ((sourceentity instanceof LivingEntity && ((LivingEntity) sourceentity).hasEffect(JujutsucraftModMobEffects.ZONE.get())
													? ((LivingEntity) sourceentity).getEffect(JujutsucraftModMobEffects.ZONE.get()).getAmplifier()
													: 0) + 1),
											false, false));
							}
						}
					}
				}
			}
		}
	}
}
