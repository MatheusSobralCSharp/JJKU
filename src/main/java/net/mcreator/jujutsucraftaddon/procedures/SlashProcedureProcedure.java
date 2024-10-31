package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModParticleTypes;

public class SlashProcedureProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
        if (entity == null || sourceentity == null)
            return;
        if (!sourceentity.isShiftKeyDown()) {
            if ((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).WorldSlash == false) {
                if (entity instanceof LivingEntity) {
                    if (new Object() {
                        public double getValue() {
                            CompoundTag dataIndex = new CompoundTag();
                            sourceentity.saveWithoutId(dataIndex);
                            return dataIndex.getCompound("ForgeData").getDouble("skill");
                        }
                    }.getValue() == 105) {
                        if (Math.random() < 0.5) {
                            if (world instanceof ServerLevel _level)
                                _level.sendParticles((SimpleParticleType) (JujutsucraftaddonModParticleTypes.HAITI_3.get()), (entity.getX()), (entity.getY() + 1), (entity.getZ()), 0, 0, 0, 0, 1);
                        } else if (Math.random() > 0.5) {
                            if (world instanceof ServerLevel _level)
                                _level.sendParticles((SimpleParticleType) (JujutsucraftaddonModParticleTypes.KAI_3.get()), (entity.getX()), (entity.getY() + 1), (entity.getZ()), 0, 0, 0, 0, 1);
                        }
                    }
                }
            } else if ((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).WorldSlash == true) {
                if (entity instanceof LivingEntity) {
                    if (new Object() {
                        public double getValue() {
                            CompoundTag dataIndex = new CompoundTag();
                            sourceentity.saveWithoutId(dataIndex);
                            return dataIndex.getCompound("ForgeData").getDouble("skill");
                        }
                    }.getValue() == 105) {
                        if (Math.random() < 0.5) {
                            if (world instanceof ServerLevel _level)
                                _level.sendParticles((SimpleParticleType) (JujutsucraftaddonModParticleTypes.KAI_5.get()), (entity.getX()), (entity.getY() + 1), (entity.getZ()), 0, 0, 0, 0, 1);
                        } else if (Math.random() > 0.5) {
                            if (world instanceof ServerLevel _level)
                                _level.sendParticles((SimpleParticleType) (JujutsucraftaddonModParticleTypes.HAITI_5.get()), (entity.getX()), (entity.getY() + 1), (entity.getZ()), 0, 0, 0, 0, 1);
                        }
                    }
                }
            }
        }
        if ((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).InfusedDomain == true) {
            if (sourceentity instanceof ServerPlayer _plr21 && _plr21.level() instanceof ServerLevel
                    && _plr21.getAdvancements().getOrStartProgress(_plr21.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:cleave_web_advancement"))).isDone()) {
                if (sourceentity.isShiftKeyDown()) {
                    if (entity instanceof LivingEntity) {
                        if (new Object() {
                            public double getValue() {
                                CompoundTag dataIndex = new CompoundTag();
                                sourceentity.saveWithoutId(dataIndex);
                                return dataIndex.getCompound("ForgeData").getDouble("skill");
                            }
                        }.getValue() == 105) {
                            for (int index0 = 0; index0 < 100; index0++) {
                                if (world instanceof ServerLevel _level)
                                    _level.sendParticles((SimpleParticleType) (JujutsucraftaddonModParticleTypes.HAITI_3.get()), (entity.getX() + Mth.nextInt(RandomSource.create(), -6, 6)), (entity.getY() + Mth.nextInt(RandomSource.create(), 0, 5)),
                                            (entity.getZ() + Mth.nextInt(RandomSource.create(), -6, 6)), 5, 0, 0, 0, 1);
                                if (world instanceof ServerLevel _level)
                                    _level.sendParticles((SimpleParticleType) (JujutsucraftaddonModParticleTypes.HAITI_3.get()), (entity.getX() + Mth.nextInt(RandomSource.create(), -6, 6)), (entity.getY() + Mth.nextInt(RandomSource.create(), 0, 5)),
                                            (entity.getZ() + Mth.nextInt(RandomSource.create(), -6, 6)), 5, 0, 0, 0, 1);
                                if (world instanceof ServerLevel _level)
                                    _level.sendParticles((SimpleParticleType) (JujutsucraftaddonModParticleTypes.VERTICAL_HAITI.get()), (entity.getX() + Mth.nextInt(RandomSource.create(), -6, 6)),
                                            (entity.getY() + Mth.nextInt(RandomSource.create(), 0, 5)), (entity.getZ() + Mth.nextInt(RandomSource.create(), -6, 6)), 5, 0, 0, 0, 1);
                                if (world instanceof ServerLevel _level)
                                    _level.sendParticles((SimpleParticleType) (JujutsucraftaddonModParticleTypes.VERTICAL_HAITI.get()), (entity.getX() + Mth.nextInt(RandomSource.create(), -6, 6)),
                                            (entity.getY() + Mth.nextInt(RandomSource.create(), 0, 5)), (entity.getZ() + Mth.nextInt(RandomSource.create(), -6, 6)), 5, 0, 0, 0, 1);
                                if (world instanceof ServerLevel _level)
                                    _level.sendParticles((SimpleParticleType) (JujutsucraftaddonModParticleTypes.KAI_3.get()), (entity.getX() + Mth.nextInt(RandomSource.create(), -6, 6)), (entity.getY() + Mth.nextInt(RandomSource.create(), 0, 5)),
                                            (entity.getZ() + Mth.nextInt(RandomSource.create(), -6, 6)), 5, 0, 0, 0, 1);
                                if (world instanceof ServerLevel _level)
                                    _level.sendParticles((SimpleParticleType) (JujutsucraftaddonModParticleTypes.KAI_3.get()), (entity.getX() + Mth.nextInt(RandomSource.create(), -6, 6)), (entity.getY() + Mth.nextInt(RandomSource.create(), 0, 5)),
                                            (entity.getZ() + Mth.nextInt(RandomSource.create(), -6, 6)), 5, 0, 0, 0, 1);
                                break;
                            }
                            entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.THORNS)),
                                    (float) (((LivingEntity) sourceentity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE).getValue() * (1 - Math.min(20,
                                            Math.max(((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR).getValue() / 5,
                                                    ((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR).getValue()
                                                            - (4 * ((LivingEntity) sourceentity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE).getValue())
                                                            / (((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR_TOUGHNESS).getValue() + 8)))
                                            / 25)));
                            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                _entity.addEffect(
                                        new MobEffectInstance(MobEffects.WEAKNESS, 60, entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.WEAKNESS) ? _livEnt.getEffect(MobEffects.WEAKNESS).getAmplifier() : 0, false, false));
                            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 60,
                                        entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.MOVEMENT_SLOWDOWN) ? _livEnt.getEffect(MobEffects.MOVEMENT_SLOWDOWN).getAmplifier() : 0, false, false));
                        }
                    }
                }
            }
            if (!(new Object() {
                public double getValue() {
                    CompoundTag dataIndex = new CompoundTag();
                    sourceentity.saveWithoutId(dataIndex);
                    return dataIndex.getCompound("ForgeData").getDouble("skill");
                }
            }.getValue() >= 1 || new Object() {
                public double getValue() {
                    CompoundTag dataIndex = new CompoundTag();
                    sourceentity.saveWithoutId(dataIndex);
                    return dataIndex.getCompound("ForgeData").getDouble("skill_domain");
                }
            }.getValue() > 0)) {
                if (Math.random() > 0.7 && Math.random() <= 1) {
                    if (world instanceof ServerLevel _level)
                        _level.sendParticles((SimpleParticleType) (JujutsucraftaddonModParticleTypes.HAITI_4.get()), (entity.getX()), (entity.getY() + 1), (entity.getZ()), 1, (Mth.nextDouble(RandomSource.create(), 0, 1)),
                                (Mth.nextDouble(RandomSource.create(), 0, 1)), (Mth.nextDouble(RandomSource.create(), 0, 1)), 0.1);
                    if (world instanceof Level _level) {
                        if (!_level.isClientSide()) {
                            _level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:strong")), SoundSource.NEUTRAL, 1, 1);
                        } else {
                            _level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:strong")), SoundSource.NEUTRAL, 1, 1, false);
                        }
                    }
                } else if (Math.random() > 0.45 && Math.random() <= 0.6) {
                    if (world instanceof ServerLevel _level)
                        _level.sendParticles((SimpleParticleType) (JujutsucraftaddonModParticleTypes.KAI_4.get()), (entity.getX()), (entity.getY() + 1), (entity.getZ()), 1, (Mth.nextDouble(RandomSource.create(), 0, 1)),
                                (Mth.nextDouble(RandomSource.create(), 0, 1)), (Mth.nextDouble(RandomSource.create(), 0, 1)), 0.1);
                    if (world instanceof Level _level) {
                        if (!_level.isClientSide()) {
                            _level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:strong")), SoundSource.NEUTRAL, 1, 1);
                        } else {
                            _level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:strong")), SoundSource.NEUTRAL, 1, 1, false);
                        }
                    }
                } else if (Math.random() > 0.2 && Math.random() <= 0.4) {
                    if (world instanceof ServerLevel _level)
                        _level.sendParticles((SimpleParticleType) (JujutsucraftaddonModParticleTypes.HAITI_3.get()), (entity.getX()), (entity.getY() + 1), (entity.getZ()), 2, (Mth.nextDouble(RandomSource.create(), 0, 1)),
                                (Mth.nextDouble(RandomSource.create(), 0, 1)), (Mth.nextDouble(RandomSource.create(), 0, 1)), 0.1);
                    if (world instanceof Level _level) {
                        if (!_level.isClientSide()) {
                            _level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:sword")), SoundSource.NEUTRAL, 1, 2);
                        } else {
                            _level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:sword")), SoundSource.NEUTRAL, 1, 2, false);
                        }
                    }
                } else {
                    if (world instanceof ServerLevel _level)
                        _level.sendParticles((SimpleParticleType) (JujutsucraftaddonModParticleTypes.KAI_3.get()), (entity.getX()), (entity.getY() + 1), (entity.getZ()), 2, (Mth.nextDouble(RandomSource.create(), 0, 1)),
                                (Mth.nextDouble(RandomSource.create(), 0, 1)), (Mth.nextDouble(RandomSource.create(), 0, 1)), 0.1);
                    if (world instanceof Level _level) {
                        if (!_level.isClientSide()) {
                            _level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:sword")), SoundSource.NEUTRAL, 1, 1);
                        } else {
                            _level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:sword")), SoundSource.NEUTRAL, 1, 1, false);
                        }
                    }
                }
            }
        }
        if ((ForgeRegistries.ITEMS.getKey((sourceentity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem()).toString()).equals("jujutsucraft:sukuna_body_chestplate")) {
            if (sourceentity instanceof ServerPlayer _plr114 && _plr114.level() instanceof ServerLevel
                    && _plr114.getAdvancements().getOrStartProgress(_plr114.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:ultimate_power"))).isDone()) {
                if ((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).InfusedDomain == true) {
                    if (sourceentity.isShiftKeyDown()) {
                        if (entity instanceof LivingEntity) {
                            if (new Object() {
                                public double getValue() {
                                    CompoundTag dataIndex = new CompoundTag();
                                    sourceentity.saveWithoutId(dataIndex);
                                    return dataIndex.getCompound("ForgeData").getDouble("skill");
                                }
                            }.getValue() == 105) {
                                for (int index1 = 0; index1 < 100; index1++) {
                                    if (world instanceof ServerLevel _level)
                                        _level.sendParticles((SimpleParticleType) (JujutsucraftaddonModParticleTypes.HAITI_2.get()), (entity.getX() + Mth.nextInt(RandomSource.create(), -6, 6)),
                                                (entity.getY() + Mth.nextInt(RandomSource.create(), 0, 5)), (entity.getZ() + Mth.nextInt(RandomSource.create(), -6, 6)), 5, 0, 0, 0, 1);
                                    if (world instanceof ServerLevel _level)
                                        _level.sendParticles((SimpleParticleType) (JujutsucraftaddonModParticleTypes.HAITI_2.get()), (entity.getX() + Mth.nextInt(RandomSource.create(), -6, 6)),
                                                (entity.getY() + Mth.nextInt(RandomSource.create(), 0, 5)), (entity.getZ() + Mth.nextInt(RandomSource.create(), -6, 6)), 5, 0, 0, 0, 1);
                                    if (world instanceof ServerLevel _level)
                                        _level.sendParticles((SimpleParticleType) (JujutsucraftaddonModParticleTypes.WAFFLE.get()), (entity.getX() + Mth.nextInt(RandomSource.create(), -6, 6)),
                                                (entity.getY() + Mth.nextInt(RandomSource.create(), 0, 5)), (entity.getZ() + Mth.nextInt(RandomSource.create(), -6, 6)), 5, 0, 0, 0, 1);
                                    if (world instanceof ServerLevel _level)
                                        _level.sendParticles((SimpleParticleType) (JujutsucraftaddonModParticleTypes.WAFFLE.get()), (entity.getX() + Mth.nextInt(RandomSource.create(), -6, 6)),
                                                (entity.getY() + Mth.nextInt(RandomSource.create(), 0, 5)), (entity.getZ() + Mth.nextInt(RandomSource.create(), -6, 6)), 5, 0, 0, 0, 1);
                                    if (world instanceof ServerLevel _level)
                                        _level.sendParticles((SimpleParticleType) (JujutsucraftaddonModParticleTypes.KAI_2.get()), (entity.getX() + Mth.nextInt(RandomSource.create(), -6, 6)),
                                                (entity.getY() + Mth.nextInt(RandomSource.create(), 0, 5)), (entity.getZ() + Mth.nextInt(RandomSource.create(), -6, 6)), 5, 0, 0, 0, 1);
                                    if (world instanceof ServerLevel _level)
                                        _level.sendParticles((SimpleParticleType) (JujutsucraftaddonModParticleTypes.KAI_2.get()), (entity.getX() + Mth.nextInt(RandomSource.create(), -6, 6)),
                                                (entity.getY() + Mth.nextInt(RandomSource.create(), 0, 5)), (entity.getZ() + Mth.nextInt(RandomSource.create(), -6, 6)), 5, 0, 0, 0, 1);
                                    break;
                                }
                                entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.THORNS)),
                                        (float) (((LivingEntity) sourceentity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE).getValue() * (2 - Math.min(20,
                                                Math.max(((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR).getValue() / 5,
                                                        ((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR).getValue()
                                                                - (4 * ((LivingEntity) sourceentity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE).getValue())
                                                                / (((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR_TOUGHNESS).getValue() + 8)))
                                                / 25)));
                                {
                                    Entity _ent = sourceentity;
                                    if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                        _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
                                                        _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
                                                "execute as @s run effect give @s jujutsucraft:unstable 30 0 true");
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
