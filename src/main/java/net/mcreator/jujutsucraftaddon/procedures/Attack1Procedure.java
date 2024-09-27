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
import net.minecraft.world.InteractionHand;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModMobEffects;
import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModItems;
import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModGameRules;
import net.mcreator.jujutsucraftaddon.entity.FakeClonesEntity;
import net.mcreator.jujutsucraftaddon.entity.CloneEntity;
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
		if (sourceentity instanceof CloneEntity || sourceentity instanceof FakeClonesEntity) {
			if (sourceentity instanceof LivingEntity _entity)
				_entity.swing(InteractionHand.MAIN_HAND, true);
		}
		if (sourceentity instanceof LivingEntity _livEnt3 && _livEnt3.hasEffect(JujutsucraftaddonModMobEffects.BERSERK.get())) {
			if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == JujutsucraftaddonModItems.YUUN.get()) {
				((LivingHurtEvent) event).setAmount(((float) (amount * 2)));
			}
		}
		if (entity.getPersistentData().getDouble("IsMahoraga") == 1
				&& (ForgeRegistries.ITEMS.getKey((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem()).toString()).contains("mahoraga")) {
			MahoragaLogicProcedure.execute(world, entity, sourceentity);
		}
		if (world.getLevelData().getGameRules().getBoolean(JujutsucraftaddonModGameRules.JJKM_WUKONG) == true) {
			if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Timer1 == 1) {
				if ((sourceentity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.DAMAGE_BOOST) ? _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier() : 0) > 19) {
					if (entity.getPersistentData().getDouble("Wukong") == 0) {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:wukongtheme")), SoundSource.MASTER, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:wukongtheme")), SoundSource.MASTER, 1, 1, false);
							}
						}
						entity.getPersistentData().putDouble("Wukong", 1);
					}
				}
			}
		}
		if ((ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()).equals("jujutsucraft:miwa_kasumi")) {
			if (((entity instanceof LivingEntity) && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) == false) {
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) < 40) {
					if (!(entity instanceof LivingEntity _livEnt18 && _livEnt18.hasEffect(JujutsucraftaddonModMobEffects.BINDING_VOW.get()))) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.BINDING_VOW.get(), 120, 1, false, false));
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
					CompoundTag dataIndex36 = new CompoundTag();
					sourceentity.saveWithoutId(dataIndex36);
					return dataIndex36.getCompound("ForgeData").getDouble("skill");
				}
			}.getValue()))) >= 100) {
				if (!(new Object() {
					public double getValue() {
						CompoundTag dataIndex40 = new CompoundTag();
						entity.saveWithoutId(dataIndex40);
						return dataIndex40.getCompound("ForgeData").getDouble(("adapted" + new java.text.DecimalFormat("##.##").format(new Object() {
							public double getValue() {
								CompoundTag dataIndex39 = new CompoundTag();
								sourceentity.saveWithoutId(dataIndex39);
								return dataIndex39.getCompound("ForgeData").getDouble("skill");
							}
						}.getValue())));
					}
				}.getValue() == 1)) {
					((LivingEntity) entity).getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size")))
							.setBaseValue((((LivingEntity) entity).getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).getBaseValue() + 1));
					CompoundTag dataIndex44 = new CompoundTag();
					entity.saveWithoutId(dataIndex44);
					dataIndex44.getCompound("ForgeData").putDouble(("adapted" + new java.text.DecimalFormat("##.##").format(new Object() {
						public double getValue() {
							CompoundTag dataIndex43 = new CompoundTag();
							sourceentity.saveWithoutId(dataIndex43);
							return dataIndex43.getCompound("ForgeData").getDouble("skill");
						}
					}.getValue())), 1);
					entity.load(dataIndex44);
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
				if (sourceentity instanceof ServerPlayer _plr48 && _plr48.level() instanceof ServerLevel
						&& _plr48.getAdvancements().getOrStartProgress(_plr48.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:cursed_fists"))).isDone()
						&& (sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).InfusedDomain == true) {
					if ((sourceentity instanceof LivingEntity) && ((LivingEntity) sourceentity).hasEffect(JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
						FistSukunaProcedure.execute(world, sourceentity);
					} else if (((sourceentity instanceof LivingEntity) && ((LivingEntity) sourceentity).hasEffect(JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) == false) {
						FistsProcedureProcedure.execute(world, x, y, z, entity, sourceentity);
					}
				}
				if ((sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 5) {
					if (sourceentity instanceof LivingEntity && ((LivingEntity) sourceentity).hasEffect(JujutsucraftModMobEffects.NEUTRALIZATION.get()) == false) {
						if (sourceentity instanceof ServerPlayer _plr53 && _plr53.level() instanceof ServerLevel
								&& _plr53.getAdvancements().getOrStartProgress(_plr53.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:sorcerer_strongest_of_modern"))).isDone()) {
							YutaConditionProcedure.execute(world, x, y, z, sourceentity);
						}
					}
				}
			} else if ((sourceentity instanceof LivingEntity) && ((LivingEntity) sourceentity).hasEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
				if (!(sourceentity instanceof LivingEntity _livEnt55 && _livEnt55.hasEffect(JujutsucraftaddonModMobEffects.SHRINE_EFFECT.get()))) {
					if ((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Timer1 == 1) {
						if (new Object() {
							public double getValue() {
								CompoundTag dataIndex56 = new CompoundTag();
								sourceentity.saveWithoutId(dataIndex56);
								return dataIndex56.getCompound("ForgeData").getDouble("skill_domain");
							}
						}.getValue() == 1) {
							if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.SHRINE_EFFECT.get(), -1, 1, false, false));
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
					if (!(sourceentity instanceof LivingEntity _livEnt64 && _livEnt64.hasEffect(JujutsucraftaddonModMobEffects.GOJO_IMBUED_POWER.get()))
							&& ((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Clans).equals("Gojo")) {
						if (world.getLevelData().getGameRules().getBoolean(JujutsucraftaddonModGameRules.JJKU_OVERPOWERED_STUFF) == true) {
							if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.GOJO_IMBUED_POWER.get(), -1, 1, false, false));
						}
					}
				} else if ((sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == 1) {
					if (!(sourceentity instanceof LivingEntity _livEnt68 && _livEnt68.hasEffect(JujutsucraftaddonModMobEffects.SUKUNA_POWERS.get()))
							&& ((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Clans).equals("Sukuna")) {
						if (world.getLevelData().getGameRules().getBoolean(JujutsucraftaddonModGameRules.JJKU_OVERPOWERED_STUFF) == true) {
							if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.SUKUNA_POWERS.get(), -1, 1, false, false));
						}
					}
				}
			}
		}
		if ((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Timer1 == 1) {
			if (((sourceentity instanceof LivingEntity) && ((LivingEntity) sourceentity).hasEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) == false) {
				if ((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).InfusedDomain == true) {
					if ((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).IsVessel == true) {
						if (((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Clans).equals("Gojo")
								|| ((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Clans).equals("Sukuna")) {
							if (new Object() {
								public double getValue() {
									CompoundTag dataIndex72 = new CompoundTag();
									sourceentity.saveWithoutId(dataIndex72);
									return dataIndex72.getCompound("ForgeData").getDouble("skill");
								}
							}.getValue() == 0 && new Object() {
								public double getValue() {
									CompoundTag dataIndex73 = new CompoundTag();
									sourceentity.saveWithoutId(dataIndex73);
									return dataIndex73.getCompound("ForgeData").getDouble("skill_domain");
								}
							}.getValue() == 0) {
								if (Math.random() <= 0.1) {
									{
										Entity _ent = sourceentity;
										if (!_ent.level().isClientSide() && _ent.getServer() != null) {
											_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
													_ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
													"execute as @s run jjc_cursepower 10 @s");
										}
									}
								}
							}
						}
					}
					if ((sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 27) {
						ConfiscationAndGuiltyProcedure.execute(world, entity, sourceentity);
					} else if ((sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 26) {
						if (entity instanceof LivingEntity _entity)
							_entity.removeEffect(JujutsucraftModMobEffects.REVERSE_CURSED_TECHNIQUE.get());
						entity.setSecondsOnFire(15);
						(sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)
								.setDamageValue((int) ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getDamageValue() - 1));
						((LivingHurtEvent) event).setAmount(((float) (amount + Mth.nextInt(RandomSource.create(), 1, 10))));
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
