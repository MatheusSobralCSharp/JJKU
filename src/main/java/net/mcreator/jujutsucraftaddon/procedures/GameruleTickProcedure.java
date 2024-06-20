package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.nbt.CompoundTag;

import net.mcreator.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModMobEffects;
import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModGameRules;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;

import javax.annotation.Nullable;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;

@Mod.EventBusSubscriber
public class GameruleTickProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level(), event.player.getX(), event.player.getY(), event.player.getZ(), event.player);
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Timer1 == 1) {
			if (entity.isAlive()) {
				if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).water == 1) {
                    BlockPos belowPos = entity.blockPosition().below();
                    FluidState fluidStateBelow = entity.level().getFluidState(belowPos);
                    boolean isJustAboveWater = ((world.getBlockState(BlockPos.containing(entity.getX(), entity.getY() - 1, entity.getZ()))).getBlock()instanceof LiquidBlock);
                     if (isJustAboveWater && !entity.isInWater()) {
                        if (entity.getDeltaMovement().y() <= 0) {
                        entity.setDeltaMovement(entity.getDeltaMovement().multiply(1.0, 0.0, 1.0));
                        entity.setOnGround(true);
                        entity.setPos(entity.getX(), belowPos.getY() + 1.0, entity.getZ());

                        }
                     }
                 }
				if (((entity instanceof LivingEntity) && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) == false) {
					if (world.getLevelData().getGameRules().getBoolean(JujutsucraftaddonModGameRules.JJKU_CE_MODIFIER) == true) {
						if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerMAX != 20
								* ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerFormer
										+ (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).CEFormer)) {
							CEFixProcedure.execute(world, entity);
						}
					}
				}
				if (((entity instanceof LivingEntity) && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) == false) {
					if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 2
							|| (entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 1) {
						Animations2Procedure.execute(world, x, y, z, entity);
					}
					if (entity.isSprinting()) {
						AnimationsProcedure.execute(world, entity);
					}
					if (new Object() {
						public double getValue() {
							CompoundTag dataIndex10 = new CompoundTag();
							entity.saveWithoutId(dataIndex10);
							return dataIndex10.getCompound("ForgeData").getDouble("select");
						}
					}.getValue() > 0 && new Object() {
						public double getValue() {
							CompoundTag dataIndex11 = new CompoundTag();
							entity.saveWithoutId(dataIndex11);
							return dataIndex11.getCompound("ForgeData").getDouble("cnt1");
						}
					}.getValue() > 0 && new Object() {
						public double getValue() {
							CompoundTag dataIndex12 = new CompoundTag();
							entity.saveWithoutId(dataIndex12);
							return dataIndex12.getCompound("ForgeData").getDouble("cnt1");
						}
					}.getValue() < 5 || new Object() {
						public double getValue() {
							CompoundTag dataIndex13 = new CompoundTag();
							entity.saveWithoutId(dataIndex13);
							return dataIndex13.getCompound("ForgeData").getDouble("skill");
						}
					}.getValue() == 617 || new Object() {
						public double getValue() {
							CompoundTag dataIndex14 = new CompoundTag();
							entity.saveWithoutId(dataIndex14);
							return dataIndex14.getCompound("ForgeData").getDouble("skill");
						}
					}.getValue() == 618 || new Object() {
						public double getValue() {
							CompoundTag dataIndex15 = new CompoundTag();
							entity.saveWithoutId(dataIndex15);
							return dataIndex15.getCompound("ForgeData").getDouble("skill");
						}
					}.getValue() == 510 || new Object() {
						public double getValue() {
							CompoundTag dataIndex16 = new CompoundTag();
							entity.saveWithoutId(dataIndex16);
							return dataIndex16.getCompound("ForgeData").getDouble("skill");
						}
					}.getValue() == 515 || new Object() {
						public double getValue() {
							CompoundTag dataIndex17 = new CompoundTag();
							entity.saveWithoutId(dataIndex17);
							return dataIndex17.getCompound("ForgeData").getDouble("skill");
						}
					}.getValue() == 2920 || new Object() {
						public double getValue() {
							CompoundTag dataIndex18 = new CompoundTag();
							entity.saveWithoutId(dataIndex18);
							return dataIndex18.getCompound("ForgeData").getDouble("skill");
						}
					}.getValue() == 220) {
						NueSummonProcedure.execute(world, x, y, z, entity);
					}
				}
				if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Output > 0) {
					if (entity instanceof LivingEntity && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get())) {
						if (new Object() {
							public double getValue() {
								CompoundTag dataIndex20 = new CompoundTag();
								entity.saveWithoutId(dataIndex20);
								return dataIndex20.getCompound("ForgeData").getDouble("cnt6");
							}
						}.getValue() > 0 && new Object() {
							public double getValue() {
								CompoundTag dataIndex21 = new CompoundTag();
								entity.saveWithoutId(dataIndex21);
								return dataIndex21.getCompound("ForgeData").getDouble("cnt6");
							}
						}.getValue() < (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Output) {
							CompoundTag dataIndex23 = new CompoundTag();
							entity.saveWithoutId(dataIndex23);
							dataIndex23.getCompound("ForgeData").putDouble("cnt6", (new Object() {
								public double getValue() {
									CompoundTag dataIndex22 = new CompoundTag();
									entity.saveWithoutId(dataIndex22);
									return dataIndex22.getCompound("ForgeData").getDouble("cnt6");
								}
							}.getValue() + 10));
							entity.load(dataIndex23);
						}
					}
				}
				if (world.getLevelData().getGameRules().getBoolean(JujutsucraftaddonModGameRules.JJKU_DOMAIN_NERF) == true) {
					if ((entity instanceof LivingEntity) && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
						if (!(entity instanceof LivingEntity _livEnt26 && _livEnt26.hasEffect(JujutsucraftaddonModMobEffects.DOMAIN_BREAK.get()))) {
							if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.DOMAIN_BREAK.get(), -1, 1, false, false));
						}
					}
				}
				if (world.getLevelData().getGameRules().getBoolean(JujutsucraftaddonModGameRules.JJKU_NO_COOLDOWN) == true) {
					if (entity instanceof LivingEntity && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.COOLDOWN_TIME.get())) {
						if (entity instanceof LivingEntity _entity)
							_entity.removeEffect(JujutsucraftModMobEffects.UNSTABLE.get());
						if (entity instanceof LivingEntity _entity)
							_entity.removeEffect(JujutsucraftModMobEffects.COOLDOWN_TIME.get());
					}
				}
				if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).IsCursedSpirit == true) {
					if (!(entity instanceof LivingEntity _livEnt32 && _livEnt32.hasEffect(MobEffects.REGENERATION))) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, -1, 3, false, false));
					}
				}
				if (new Object() {
					public double getValue() {
						CompoundTag dataIndex34 = new CompoundTag();
						entity.saveWithoutId(dataIndex34);
						return dataIndex34.getCompound("ForgeData").getDouble("PRESS_M");
					}
				}.getValue() == 1) {
					if ((entity instanceof LivingEntity) && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.REVERSE_CURSED_TECHNIQUE.get())) {
						if (((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Clans).equals("Sukuna")
								|| ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Clans).equals("Gojo")) {
							RctprocedureProcedure.execute(world, entity);
						} else if (((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Clans).equals("Hakari")) {
							HakariClanProcedureProcedure.execute(entity);
						}
						RCTLevelProcedure.execute(world, entity);
					}
				}
				if (((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Clans).equals("Hakari")) {
					if (entity instanceof LivingEntity && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.JACKPOT.get())) {
						if ((entity instanceof LivingEntity && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.ZONE.get()) ? ((LivingEntity) entity).getEffect(JujutsucraftModMobEffects.ZONE.get()).getAmplifier() : 0) <= 5) {
							if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.JACKPOT.get(), 5020, 2, false, false));
							if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.ZONE.get(), 5021, (int) ((entity instanceof LivingEntity && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.ZONE.get())
										? ((LivingEntity) entity).getEffect(JujutsucraftModMobEffects.ZONE.get()).getAmplifier()
										: 0)
										+ ((entity instanceof LivingEntity && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.ZONE.get()) ? ((LivingEntity) entity).getEffect(JujutsucraftModMobEffects.ZONE.get()).getAmplifier() : 0) + 1)),
										false, false));
						}
					}
				}
				if (world.getLevelData().getGameRules().getBoolean(JujutsucraftaddonModGameRules.JJKU_CE_REGEN) == true) {
					CERegenProcedure.execute(world, entity);
				}
				if (world.getLevelData().getGameRules().getBoolean(JujutsucraftaddonModGameRules.JJKU_GOJO_ONLY_SIX_EYES) == true) {
					if ((entity instanceof LivingEntity) && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.SIX_EYES.get())) {
						NoSixEyesGojoProcedure.execute(world, entity);
					}
				}
				if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).pressed == 1) {
					TestKeyProcedure.execute(world, entity);
				}
				if ((entity instanceof LivingEntity) && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.SIX_EYES.get())) {
					DisplayOverlayProcedure.execute(world, entity);
					if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 2) {
						if (entity instanceof ServerPlayer _plr46 && _plr46.level() instanceof ServerLevel
								&& _plr46.getAdvancements().getOrStartProgress(_plr46.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:gojo_training_part_1"))).isDone()) {
							GojoMoveBlueProcedure.execute(world, x, y, z, entity);
						}
						if (entity instanceof ServerPlayer _plr47 && _plr47.level() instanceof ServerLevel
								&& _plr47.getAdvancements().getOrStartProgress(_plr47.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:gojo_training_part_3"))).isDone()) {
							GojoProcedureBlueProcedure.execute(world, x, y, z, entity);
						}
					}
				}
				if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).InfusedDomain == true) {
					ExtensionTickProcedure.execute(world, x, y, z, entity);
				}
				if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).BurnOutRCT == true) {
					RCTBurnoutProcedure.execute(world, entity);
				}
				if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).RCTMasteryOn == true) {
					RCTMasteryProcedure.execute(world, entity);
				}
				if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).RCTOutputActive == true) {
					RctOutputProcedure.execute(world, x, y, z, entity);
				}
				if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).BarrierlessDomain == true) {
					BarrierlessAndCompressedProcedure.execute(world, entity);
					if ((entity instanceof LivingEntity) && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
						if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).DomainSizeVariable != 22) {
							JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius = 22;
							JujutsucraftModVariables.MapVariables.get(world).syncData(world);
							{
								double _setval = 22;
								entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.DomainSizeVariable = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						}
					}
				}
				if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == -1) {
					HRRegenProcedure.execute(world, entity);
				}
			}
		}
	}
}
