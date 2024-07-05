package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

import net.mcreator.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModParticleTypes;
import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModMobEffects;
import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModGameRules;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class Attack1Procedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingHurtEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity(), event.getSource().getEntity(), event.getAmount());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity, double amount) {
		execute(null, world, x, y, z, entity, sourceentity, amount);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity, double amount) {
		if (entity == null || sourceentity == null)
			return;
		double xRadius = 0;
		double loop = 0;
		double zRadius = 0;
		double particleAmount = 0;
		double particleRadius = 0;
		if ((ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()).equals("jujutsucraft:miwa_kasumi")) {
			if (((entity instanceof LivingEntity) && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) == false) {
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) < 40) {
					if (!(entity instanceof LivingEntity _livEnt3 && _livEnt3.hasEffect(JujutsucraftaddonModMobEffects.BINDING_VOW.get()))) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.BINDING_VOW.get(), 120, 1, false, false));
					}
				}
			}
		} else if ((ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()).equals("jujutsucraft:dagon_2")) {
			if (((entity instanceof LivingEntity) && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) == false) {
				loop = 0;
				particleAmount = 16;
				xRadius = 2;
				zRadius = 2;
				while (loop < particleAmount) {
					world.addParticle((SimpleParticleType) (JujutsucraftaddonModParticleTypes.WATER.get()), (entity.getX() + 0.5 + Math.cos(((Math.PI * 2) / particleAmount) * loop) * xRadius), (entity.getY() + 1.25),
							(entity.getZ() + 0.5 + Math.sin(((Math.PI * 2) / particleAmount) * loop) * zRadius), 0, 0.05, 0);
					loop = loop + 1;
				}
				if ((sourceentity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.DAMAGE_BOOST) ? _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier() : 0) < 19) {
					if (!(new Object() {
						public double getValue() {
							CompoundTag dataIndex12 = new CompoundTag();
							entity.saveWithoutId(dataIndex12);
							return dataIndex12.getCompound("ForgeData").getDouble("skill");
						}
					}.getValue() >= 1 || new Object() {
						public double getValue() {
							CompoundTag dataIndex13 = new CompoundTag();
							entity.saveWithoutId(dataIndex13);
							return dataIndex13.getCompound("ForgeData").getDouble("PRESS_Z");
						}
					}.getValue() == 1)) {
						if (event != null && event.isCancelable()) {
							event.setCanceled(true);
						}
					}
				}
			}
		}
		if (world.getLevelData().getGameRules().getBoolean(JujutsucraftaddonModGameRules.JJKU_NPC_FISTS) == true) {
			if ((ForgeRegistries.ENTITY_TYPES.getKey(sourceentity.getType()).toString()).startsWith("jujutsucraft")) {
				if (((sourceentity instanceof LivingEntity) && ((LivingEntity) sourceentity).hasEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) == false) {
					if ((ForgeRegistries.ENTITY_TYPES.getKey(sourceentity.getType()).toString()).equals("jujutsucraft:okkotsu_yuta")
							|| (ForgeRegistries.ENTITY_TYPES.getKey(sourceentity.getType()).toString()).equals("jujutsucraft:okkotsu_yuta_culling_game")) {
						FistYutaProcedure.execute(world, sourceentity);
					} else if ((ForgeRegistries.ENTITY_TYPES.getKey(sourceentity.getType()).toString()).equals("jujutsucraft:itadori_yuji_shibuya")
							|| (ForgeRegistries.ENTITY_TYPES.getKey(sourceentity.getType()).toString()).equals("jujutsucraft:itadori_yuji")) {
						FistItadoriProcedure.execute(world, sourceentity);
					} else if ((ForgeRegistries.ENTITY_TYPES.getKey(sourceentity.getType()).toString()).equals("jujutsucraft:gojo_satoru")) {
						FistGojoProcedure.execute(world, sourceentity);
					} else if ((ForgeRegistries.ENTITY_TYPES.getKey(sourceentity.getType()).toString()).equals("jujutsucraft:sukuna")
							|| (ForgeRegistries.ENTITY_TYPES.getKey(sourceentity.getType()).toString()).equals("jujutsucraft:sukuna_fushiguro")) {
						FistSukunaProcedure.execute(world, sourceentity);
					} else if ((ForgeRegistries.ENTITY_TYPES.getKey(sourceentity.getType()).toString()).equals("jujutsucraft:mahito")) {
						FistMahitoProcedure.execute(world, sourceentity);
					} else if ((ForgeRegistries.ENTITY_TYPES.getKey(sourceentity.getType()).toString()).equals("jujutsucraft:hakari_kinji")) {
						FistHakariProcedure.execute(world, entity, sourceentity);
					} else if ((ForgeRegistries.ENTITY_TYPES.getKey(sourceentity.getType()).toString()).equals("jujutsucraft:kashimo_hajime")) {
						FistKashimoProcedure.execute(world, entity, sourceentity);
					} else if ((ForgeRegistries.ENTITY_TYPES.getKey(sourceentity.getType()).toString()).equals("jujutsucraft:choso")) {
						FistChosoProcedure.execute(world, sourceentity);
					} else if ((ForgeRegistries.ENTITY_TYPES.getKey(sourceentity.getType()).toString()).equals("jujutsucraft:jogo")) {
						FistJogoProcedure.execute(world, entity, sourceentity);
					}
				}
			}
		}
		if ((ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()).equals("jujutsucraft:eight_handled_swrod_divergent_sila_divine_general_mahoraga")) {
			if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getOrCreateTag().getDouble(("skill" + new java.text.DecimalFormat("##.##").format(new Object() {
				public double getValue() {
					CompoundTag dataIndex30 = new CompoundTag();
					sourceentity.saveWithoutId(dataIndex30);
					return dataIndex30.getCompound("ForgeData").getDouble("skill");
				}
			}.getValue()))) >= 100) {
				if (!(new Object() {
					public double getValue() {
						CompoundTag dataIndex34 = new CompoundTag();
						entity.saveWithoutId(dataIndex34);
						return dataIndex34.getCompound("ForgeData").getDouble(("adapted" + new java.text.DecimalFormat("##.##").format(new Object() {
							public double getValue() {
								CompoundTag dataIndex33 = new CompoundTag();
								sourceentity.saveWithoutId(dataIndex33);
								return dataIndex33.getCompound("ForgeData").getDouble("skill");
							}
						}.getValue())));
					}
				}.getValue() == 1)) {
					((LivingEntity) entity).getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size")))
							.setBaseValue((((LivingEntity) entity).getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).getBaseValue() + 1));
					CompoundTag dataIndex38 = new CompoundTag();
					entity.saveWithoutId(dataIndex38);
					dataIndex38.getCompound("ForgeData").putDouble(("adapted" + new java.text.DecimalFormat("##.##").format(new Object() {
						public double getValue() {
							CompoundTag dataIndex37 = new CompoundTag();
							sourceentity.saveWithoutId(dataIndex37);
							return dataIndex37.getCompound("ForgeData").getDouble("skill");
						}
					}.getValue())), 1);
					entity.load(dataIndex38);
				}
			}
		}
		if ((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Timer1 == 1) {
			if (((sourceentity instanceof LivingEntity) && ((LivingEntity) sourceentity).hasEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) == false) {
				if ((sourceentity instanceof LivingEntity) && ((LivingEntity) sourceentity).hasEffect(JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
					SlashProcedureProcedure.execute(world, x, y, z, entity, sourceentity);
				}
				if (world.getLevelData().getGameRules().getBoolean(JujutsucraftaddonModGameRules.JJKU_OST_PLAYER) == true) {
					SongsProcedure.execute(world, x, y, z, entity, sourceentity);
				}
				if (sourceentity instanceof ServerPlayer _plr42 && _plr42.level() instanceof ServerLevel
						&& _plr42.getAdvancements().getOrStartProgress(_plr42.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:cursed_fists"))).isDone()
						&& (sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).InfusedDomain == true) {
					if ((sourceentity instanceof LivingEntity) && ((LivingEntity) sourceentity).hasEffect(JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
						FistSukunaProcedure.execute(world, sourceentity);
					} else if (((sourceentity instanceof LivingEntity) && ((LivingEntity) sourceentity).hasEffect(JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) == false) {
						FistsProcedureProcedure.execute(world, x, y, z, entity, sourceentity);
					}
				}
				if ((sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 5) {
					if (sourceentity instanceof LivingEntity && ((LivingEntity) sourceentity).hasEffect(JujutsucraftModMobEffects.NEUTRALIZATION.get()) == false) {
						if (sourceentity instanceof ServerPlayer _plr47 && _plr47.level() instanceof ServerLevel
								&& _plr47.getAdvancements().getOrStartProgress(_plr47.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:sorcerer_strongest_of_modern"))).isDone()) {
							YutaConditionProcedure.execute(world, x, y, z, sourceentity);
						}
					}
				}
			} else if ((sourceentity instanceof LivingEntity) && ((LivingEntity) sourceentity).hasEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
				if (!(sourceentity instanceof LivingEntity _livEnt49 && _livEnt49.hasEffect(JujutsucraftaddonModMobEffects.SHRINE_EFFECT.get()))) {
					if ((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Timer1 == 1) {
						if (new Object() {
							public double getValue() {
								CompoundTag dataIndex50 = new CompoundTag();
								sourceentity.saveWithoutId(dataIndex50);
								return dataIndex50.getCompound("ForgeData").getDouble("skill_domain");
							}
						}.getValue() == 1) {
							if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.SHRINE_EFFECT.get(), -1, 1, false, false));
						}
					}
				}
				if ((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Timer1 == 1) {
					if (new Object() {
						public double getValue() {
							CompoundTag dataIndex52 = new CompoundTag();
							entity.saveWithoutId(dataIndex52);
							return dataIndex52.getCompound("ForgeData").getDouble("skill_domain");
						}
					}.getValue() == 0 && new Object() {
						public double getValue() {
							CompoundTag dataIndex53 = new CompoundTag();
							sourceentity.saveWithoutId(dataIndex53);
							return dataIndex53.getCompound("ForgeData").getDouble("skill_domain");
						}
					}.getValue() > 0) {
						if ((ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()).equals("jujutsucraft:kenjaku")) {
							if (!(sourceentity instanceof ServerPlayer _plr55 && _plr55.level() instanceof ServerLevel
									&& _plr55.getAdvancements().getOrStartProgress(_plr55.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:barrierless_domain_perfected"))).isDone())) {
								if (sourceentity instanceof ServerPlayer _player) {
									Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:barrierless_domain_perfected"));
									AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
									if (!_ap.isDone()) {
										for (String criteria : _ap.getRemainingCriteria())
											_player.getAdvancements().award(_adv, criteria);
									}
								}
							}
						} else if ((ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()).equals("jujutsucraft:sukuna")) {
							if (!(sourceentity instanceof ServerPlayer _plr58 && _plr58.level() instanceof ServerLevel
									&& _plr58.getAdvancements().getOrStartProgress(_plr58.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:barrierless_domain_perfected"))).isDone())) {
								if (sourceentity instanceof ServerPlayer _player) {
									Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:barrierless_domain_perfected"));
									AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
									if (!_ap.isDone()) {
										for (String criteria : _ap.getRemainingCriteria())
											_player.getAdvancements().award(_adv, criteria);
									}
								}
							}
						}
					}
				}
			}
		}
		if (((sourceentity instanceof LivingEntity) && ((LivingEntity) sourceentity).hasEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) == false) {
			if ((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Timer1 == 1) {
				if ((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).InfusedDomain == true) {
					WhenHitPlayerProcedure.execute(world, x, y, z, entity, sourceentity);
					if ((sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 4) {
						JogoExtensionProcedure.execute(world, x, y, z, entity, sourceentity);
					} else if ((sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 10) {
						ChosoExtensionProcedure.execute(world, entity, sourceentity);
					} else if ((sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 15) {
						CutRCTProcedure.execute(world, entity);
					} else if ((sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 24) {
						if (((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Clans).equals("Uraume")) {
							WhenHitUraumeProcedure.execute(world, entity);
						}
					}
				}
				if ((sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 2) {
					if (!(sourceentity instanceof LivingEntity _livEnt66 && _livEnt66.hasEffect(JujutsucraftaddonModMobEffects.GOJO_IMBUED_POWER.get()))
							&& ((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Clans).equals("Gojo")) {
						if (world.getLevelData().getGameRules().getBoolean(JujutsucraftaddonModGameRules.JJKU_OVERPOWERED_STUFF) == true) {
							if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.GOJO_IMBUED_POWER.get(), -1, 1, false, false));
						}
					}
				} else if ((sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == 1) {
					if (!(sourceentity instanceof LivingEntity _livEnt70 && _livEnt70.hasEffect(JujutsucraftaddonModMobEffects.SUKUNA_POWERS.get()))
							&& ((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Clans).equals("Sukuna")) {
						if (world.getLevelData().getGameRules().getBoolean(JujutsucraftaddonModGameRules.JJKU_OVERPOWERED_STUFF) == true) {
							if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.SUKUNA_POWERS.get(), -1, 1, false, false));
						}
					}
				}
			}
		}
		if (((sourceentity instanceof LivingEntity) && ((LivingEntity) sourceentity).hasEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) == false) {
			if ((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Timer1 == 1) {
				if ((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).IsVessel == true) {
					if (new Object() {
						public double getValue() {
							CompoundTag dataIndex74 = new CompoundTag();
							sourceentity.saveWithoutId(dataIndex74);
							return dataIndex74.getCompound("ForgeData").getDouble("skill");
						}
					}.getValue() == 0 && new Object() {
						public double getValue() {
							CompoundTag dataIndex75 = new CompoundTag();
							sourceentity.saveWithoutId(dataIndex75);
							return dataIndex75.getCompound("ForgeData").getDouble("skill_domain");
						}
					}.getValue() == 0) {
						if (Math.random() <= 0.05) {
							{
								Entity _ent = sourceentity;
								if (!_ent.level().isClientSide() && _ent.getServer() != null) {
									_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null,
											4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run jjc_cursepower 1 @s");
								}
							}
						}
					}
				} else if ((sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 14
						&& (sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).InfusedDomain == true) {
					if (new Object() {
						public double getValue() {
							CompoundTag dataIndex78 = new CompoundTag();
							sourceentity.saveWithoutId(dataIndex78);
							return dataIndex78.getCompound("ForgeData").getDouble("skill");
						}
					}.getValue() == 0 && new Object() {
						public double getValue() {
							CompoundTag dataIndex79 = new CompoundTag();
							sourceentity.saveWithoutId(dataIndex79);
							return dataIndex79.getCompound("ForgeData").getDouble("skill_domain");
						}
					}.getValue() == 0) {
						if (Math.random() <= 0.05) {
							{
								Entity _ent = sourceentity;
								if (!_ent.level().isClientSide() && _ent.getServer() != null) {
									_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null,
											4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run jjc_cursepower 1 @s");
								}
							}
						}
					}
				} else if (((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Clans).equals("Gojo")
						|| ((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Clans).equals("Sukuna")) {
					if (new Object() {
						public double getValue() {
							CompoundTag dataIndex81 = new CompoundTag();
							sourceentity.saveWithoutId(dataIndex81);
							return dataIndex81.getCompound("ForgeData").getDouble("skill");
						}
					}.getValue() == 0 && new Object() {
						public double getValue() {
							CompoundTag dataIndex82 = new CompoundTag();
							sourceentity.saveWithoutId(dataIndex82);
							return dataIndex82.getCompound("ForgeData").getDouble("skill_domain");
						}
					}.getValue() == 0) {
						if (Math.random() <= 0.1) {
							{
								Entity _ent = sourceentity;
								if (!_ent.level().isClientSide() && _ent.getServer() != null) {
									_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null,
											4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run jjc_cursepower 10 @s");
								}
							}
						}
					}
				}
			}
		}
		if (((sourceentity instanceof LivingEntity) && ((LivingEntity) sourceentity).hasEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) == false) {
			if ((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Timer1 == 1) {
				if ((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).InfusedDomain == true) {
					if ((sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 27) {
						ConfiscationAndGuiltyProcedure.execute(world, entity, sourceentity);
					} else if ((sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 26) {
						if (entity instanceof LivingEntity _entity)
							_entity.removeEffect(JujutsucraftModMobEffects.REVERSE_CURSED_TECHNIQUE.get());
						entity.setSecondsOnFire(15);
						(sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)
								.setDamageValue((int) ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getDamageValue() - 1));
						((LivingHurtEvent) event).setAmount(((float) (amount + Mth.nextInt(RandomSource.create(), 1, 10))));
						if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.GUARD.get(), 40,
									(int) ((entity instanceof LivingEntity && ((LivingEntity) sourceentity).hasEffect(JujutsucraftModMobEffects.GUARD.get())
											? ((LivingEntity) sourceentity).getEffect(JujutsucraftModMobEffects.GUARD.get()).getAmplifier()
											: 0) + 0),
									false, false));
						particleAmount = 4;
						particleRadius = 4;
						for (int index1 = 0; index1 < (int) particleAmount; index1++) {
							world.addParticle(ParticleTypes.SOUL_FIRE_FLAME, (x + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * particleRadius), (y + 0 + Mth.nextDouble(RandomSource.create(), -0.5, 0.5)),
									(z + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * particleRadius), 0, 0, 0);
						}
					} else if ((sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 6) {
						MegumiHit2Procedure.execute(world, entity, sourceentity);
						if ((sourceentity instanceof LivingEntity) && ((LivingEntity) sourceentity).hasEffect(JujutsucraftModMobEffects.ZONE.get())) {
							if ((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).OutputLevel >= 3) {
								if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= 20) {
									SummonAllShadowsProcedure.execute(world, x, y, z, entity, sourceentity);
									{
										double _setval = 0;
										sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.OutputLevel = _setval;
											capability.syncPlayerVariables(sourceentity);
										});
									}
								}
							}
						}
					} else if ((sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == -1) {
						TojiRCTCutProcedure.execute(world, x, y, z, entity, sourceentity);
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.BLACK_FLASH_CUT.get(), 60, 1, false, false));
						((LivingHurtEvent) event).setAmount(((float) (amount + Mth.nextInt(RandomSource.create(), 1, 10))));
					}
				}
				if (((sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName).equals("Explosive Human Bullet")) {
					if (Math.random() <= 0.09) {
						if (world instanceof Level _level && !_level.isClientSide())
							_level.explode(null, x, y, z, 4, Level.ExplosionInteraction.NONE);
					}
				}
				if (((sourceentity instanceof LivingEntity) && ((LivingEntity) sourceentity).hasEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) == false) {
					if (world.getLevelData().getGameRules().getBoolean(JujutsucraftaddonModGameRules.JJKU_AIR_COMBAT) == true) {
						AirCombatProcedure.execute(world, x, y, z, entity, sourceentity);
					}
				}
			}
		}
	}
}
