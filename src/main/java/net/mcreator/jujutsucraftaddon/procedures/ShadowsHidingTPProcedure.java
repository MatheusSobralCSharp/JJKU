package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.TagKey;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.ParticleTypes;

import net.mcreator.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;

import java.util.List;
import java.util.Comparator;

public class ShadowsHidingTPProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player || entity instanceof ServerPlayer) {
			if (!(ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()).startsWith("jujutsucraft")) {
				if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 6) {
					if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).InfusedDomain == true) {
						{
							final Vec3 _center = new Vec3(x, y, z);
							List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(30 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
							for (Entity entityiterator : _entfound) {
								if (entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("jujutsucraft:ten_shadows_technique"))) && new Object() {
									public double getValue() {
										CompoundTag dataIndex5 = new CompoundTag();
										entity.saveWithoutId(dataIndex5);
										return dataIndex5.getCompound("ForgeData").getDouble("friend_num");
									}
								}.getValue() == new Object() {
									public double getValue() {
										CompoundTag dataIndex6 = new CompoundTag();
										entityiterator.saveWithoutId(dataIndex6);
										return dataIndex6.getCompound("ForgeData").getDouble("friend_num");
									}
								}.getValue()) {
									if (entity.isShiftKeyDown() && (new Object() {
										public boolean getValue() {
											CompoundTag dataIndex8 = new CompoundTag();
											entity.saveWithoutId(dataIndex8);
											return dataIndex8.getCompound("ForgeData").getBoolean("PRESS_M");
										}
									}.getValue()) == true) {
										{
											Entity _ent = entity;
											_ent.teleportTo((entityiterator.getX()), (entityiterator.getY() + 0), (entityiterator.getZ() + 1));
											if (_ent instanceof ServerPlayer _serverPlayer)
												_serverPlayer.connection.teleport((entityiterator.getX()), (entityiterator.getY() + 0), (entityiterator.getZ() + 1), _ent.getYRot(), _ent.getXRot());
										}
										if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
											_entity.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 60, 200, false, false));
										if (world instanceof ServerLevel _level)
											_level.sendParticles(ParticleTypes.SQUID_INK, (entity.getX() + Mth.nextInt(RandomSource.create(), -2, 2)), (entity.getY()), (entity.getZ() + Mth.nextInt(RandomSource.create(), -2, 2)), 1, 0, 0, 0, 0.1);
										if (world instanceof ServerLevel _level)
											_level.sendParticles(ParticleTypes.SMOKE, (entity.getX() + Mth.nextInt(RandomSource.create(), -2, 2)), (entity.getY()), (entity.getZ() + Mth.nextInt(RandomSource.create(), -2, 2)), 3, 0, 0, 0, 0.1);
										if (world instanceof ServerLevel _level)
											_level.sendParticles(ParticleTypes.LARGE_SMOKE, (entity.getX() + Mth.nextInt(RandomSource.create(), -2, 2)), (entity.getY()), (entity.getZ() + Mth.nextInt(RandomSource.create(), -2, 2)), 3, 0, 0, 0, 0.1);
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
