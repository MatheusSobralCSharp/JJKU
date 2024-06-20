package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.BlockPos;

import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModMobEffects;
import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModEntities;
import net.mcreator.jujutsucraft.init.JujutsucraftModEntities;


import java.util.List;
import java.util.Comparator;

public class TodoHitProcedureProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity sourceentity) {
		if (sourceentity == null)
			return;
		if (Math.random() <= 0.05) {
			if (!(sourceentity instanceof ServerPlayer _plr0 && _plr0.level() instanceof ServerLevel
					&& _plr0.getAdvancements().getOrStartProgress(_plr0.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:sorcerer_strongest_of_modern"))).isDone())) {
				if (world instanceof ServerLevel _serverLevel) {
					Entity entitytospawn = JujutsucraftModEntities.ITADORI_YUJI_SHIBUYA.get().spawn(_serverLevel, BlockPos.containing((sourceentity.getX()), (sourceentity.getY()), (sourceentity.getZ())), MobSpawnType.MOB_SUMMONED);
					if (entitytospawn != null) {
						entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
					}
					CompoundTag dataIndex1 = new CompoundTag();
					(entitytospawn).saveWithoutId(dataIndex1);
					dataIndex1.getCompound("ForgeData").putString("OWNER_UUID", (sourceentity.getStringUUID()));
					(entitytospawn).load(dataIndex1);
					CompoundTag dataIndex3 = new CompoundTag();
					(entitytospawn).saveWithoutId(dataIndex3);
					dataIndex3.getCompound("ForgeData").putDouble("friend_num", (new Object() {
						public double getValue() {
							CompoundTag dataIndex2 = new CompoundTag();
							sourceentity.saveWithoutId(dataIndex2);
							return dataIndex2.getCompound("ForgeData").getDouble("friend_num");
						}
					}.getValue()));
					(entitytospawn).load(dataIndex3);
					if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.MANIFESTATION.get(), 100, 1));
					((LivingEntity) (entitytospawn)).getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).setBaseValue(2);
					if (sourceentity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("MY BROTHER!"), false);
				}
			} else if (sourceentity instanceof ServerPlayer _plr12 && _plr12.level() instanceof ServerLevel
					&& _plr12.getAdvancements().getOrStartProgress(_plr12.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:sorcerer_strongest_of_modern"))).isDone()) {
				if (world instanceof ServerLevel _serverLevel) {
					Entity entitytospawn = JujutsucraftaddonModEntities.ITADORI_SHINJUKU.get().spawn(_serverLevel, BlockPos.containing((sourceentity.getX()), (sourceentity.getY()), (sourceentity.getZ())), MobSpawnType.MOB_SUMMONED);
					if (entitytospawn != null) {
						entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
					}
					CompoundTag dataIndex1 = new CompoundTag();
					(entitytospawn).saveWithoutId(dataIndex1);
					dataIndex1.getCompound("ForgeData").putString("OWNER_UUID", (sourceentity.getStringUUID()));
					(entitytospawn).load(dataIndex1);
					CompoundTag dataIndex3 = new CompoundTag();
					(entitytospawn).saveWithoutId(dataIndex3);
					dataIndex3.getCompound("ForgeData").putDouble("friend_num", (new Object() {
						public double getValue() {
							CompoundTag dataIndex2 = new CompoundTag();
							sourceentity.saveWithoutId(dataIndex2);
							return dataIndex2.getCompound("ForgeData").getDouble("friend_num");
						}
					}.getValue()));
					(entitytospawn).load(dataIndex3);
					if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.MANIFESTATION.get(), 100, 1));
					((LivingEntity) (entitytospawn)).getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).setBaseValue(2);
					if (sourceentity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("BROTHER!"), false);
				}
			}
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(30 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if ((new Object() {
						public String getValue() {
							CompoundTag dataIndex24 = new CompoundTag();
							entityiterator.saveWithoutId(dataIndex24);
							return dataIndex24.getCompound("ForgeData").getString("OWNER_UUID");
						}
					}.getValue()).equals(sourceentity.getStringUUID())) {
						{
							Entity _ent = entityiterator;
							_ent.teleportTo((sourceentity.getX()), (sourceentity.getY()), (sourceentity.getZ()));
							if (_ent instanceof ServerPlayer _serverPlayer)
								_serverPlayer.connection.teleport((sourceentity.getX()), (sourceentity.getY()), (sourceentity.getZ()), _ent.getYRot(), _ent.getXRot());
						}
						{
							Entity _ent = sourceentity;
							_ent.teleportTo((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()));
							if (_ent instanceof ServerPlayer _serverPlayer)
								_serverPlayer.connection.teleport((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), _ent.getYRot(), _ent.getXRot());
						}
					}
				}
			}
		}
	}
}
