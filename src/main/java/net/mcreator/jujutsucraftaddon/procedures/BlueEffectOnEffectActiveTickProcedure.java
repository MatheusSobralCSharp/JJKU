package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
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
import net.mcreator.jujutsucraftaddon.JujutsucraftaddonMod;

import java.util.List;
import java.util.Comparator;

public class BlueEffectOnEffectActiveTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (new Object() {
			public double getValue() {
				CompoundTag dataIndex0 = new CompoundTag();
				entity.saveWithoutId(dataIndex0);
				return dataIndex0.getCompound("ForgeData").getDouble("blue");
			}
		}.getValue() == 1) {
			CompoundTag dataIndex1 = new CompoundTag();
			entity.saveWithoutId(dataIndex1);
			dataIndex1.getCompound("ForgeData").putDouble("cnt1", 28);
			entity.load(dataIndex1);
			CompoundTag dataIndex2 = new CompoundTag();
			entity.saveWithoutId(dataIndex2);
			dataIndex2.getCompound("ForgeData").putDouble("cnt2", 1);
			entity.load(dataIndex2);
			CompoundTag dataIndex3 = new CompoundTag();
			entity.saveWithoutId(dataIndex3);
			dataIndex3.getCompound("ForgeData").putDouble("cnt6", 5);
			entity.load(dataIndex3);
			JujutsucraftaddonMod.queueServerWork(300, () -> {
				for (int index0 = 0; index0 < 1; index0++) {
					{
						Entity _ent = entity;
						if (!_ent.level().isClientSide() && _ent.getServer() != null) {
							_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
									_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "kill");
						}
					}
				}
			});
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(30 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator.isShiftKeyDown() && new Object() {
						public double getValue() {
							CompoundTag dataIndex7 = new CompoundTag();
							entityiterator.saveWithoutId(dataIndex7);
							return dataIndex7.getCompound("ForgeData").getDouble("skill");
						}
					}.getValue() == 200) {
						if (entityiterator instanceof LivingEntity _livEnt8 && _livEnt8.hasEffect(JujutsucraftaddonModMobEffects.GOJO_IMBUED_POWER.get())) {
							{
								Entity _ent = entity;
								_ent.teleportTo(
										(entityiterator.level()
												.clip(new ClipContext(entityiterator.getEyePosition(1f), entityiterator.getEyePosition(1f).add(entityiterator.getViewVector(1f).scale(10)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE,
														entityiterator))
												.getBlockPos().getX()),
										(entityiterator.level()
												.clip(new ClipContext(entityiterator.getEyePosition(1f), entityiterator.getEyePosition(1f).add(entityiterator.getViewVector(1f).scale(10)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE,
														entityiterator))
												.getBlockPos().getY()),
										(entityiterator.level().clip(
												new ClipContext(entityiterator.getEyePosition(1f), entityiterator.getEyePosition(1f).add(entityiterator.getViewVector(1f).scale(10)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entityiterator))
												.getBlockPos().getZ()));
								if (_ent instanceof ServerPlayer _serverPlayer)
									_serverPlayer.connection.teleport(
											(entityiterator.level()
													.clip(new ClipContext(entityiterator.getEyePosition(1f), entityiterator.getEyePosition(1f).add(entityiterator.getViewVector(1f).scale(10)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE,
															entityiterator))
													.getBlockPos().getX()),
											(entityiterator.level()
													.clip(new ClipContext(entityiterator.getEyePosition(1f), entityiterator.getEyePosition(1f).add(entityiterator.getViewVector(1f).scale(10)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE,
															entityiterator))
													.getBlockPos().getY()),
											(entityiterator.level().clip(new ClipContext(entityiterator.getEyePosition(1f), entityiterator.getEyePosition(1f).add(entityiterator.getViewVector(1f).scale(10)), ClipContext.Block.OUTLINE,
													ClipContext.Fluid.NONE, entityiterator)).getBlockPos().getZ()),
											_ent.getYRot(), _ent.getXRot());
							}
						}
					} else if ((entityiterator.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Purple > 0
							&& (entityiterator.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Purple < 800) {
						CompoundTag dataIndex14 = new CompoundTag();
						entity.saveWithoutId(dataIndex14);
						dataIndex14.getCompound("ForgeData").putString("OWNER_UUID", (new Object() {
							public String getValue() {
								CompoundTag dataIndex13 = new CompoundTag();
								entityiterator.saveWithoutId(dataIndex13);
								return dataIndex13.getCompound("ForgeData").getString("OWNER_UUID");
							}
						}.getValue()));
						entity.load(dataIndex14);
						CompoundTag dataIndex16 = new CompoundTag();
						entity.saveWithoutId(dataIndex16);
						dataIndex16.getCompound("ForgeData").putDouble("friend_num", (new Object() {
							public double getValue() {
								CompoundTag dataIndex15 = new CompoundTag();
								entityiterator.saveWithoutId(dataIndex15);
								return dataIndex15.getCompound("ForgeData").getDouble("friend_num");
							}
						}.getValue()));
						entity.load(dataIndex16);
						CompoundTag dataIndex18 = new CompoundTag();
						entity.saveWithoutId(dataIndex18);
						dataIndex18.getCompound("ForgeData").putDouble("friend_num2", (new Object() {
							public double getValue() {
								CompoundTag dataIndex17 = new CompoundTag();
								entity.saveWithoutId(dataIndex17);
								return dataIndex17.getCompound("ForgeData").getDouble("friend_num");
							}
						}.getValue()));
						entity.load(dataIndex18);
						CompoundTag dataIndex20 = new CompoundTag();
						entity.saveWithoutId(dataIndex20);
						dataIndex20.getCompound("ForgeData").putDouble("friend_num_worker", (new Object() {
							public double getValue() {
								CompoundTag dataIndex19 = new CompoundTag();
								entity.saveWithoutId(dataIndex19);
								return dataIndex19.getCompound("ForgeData").getDouble("friend_num");
							}
						}.getValue()));
						entity.load(dataIndex20);
					}
				}
			}
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(8 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (new Object() {
						public double getValue() {
							CompoundTag dataIndex22 = new CompoundTag();
							entityiterator.saveWithoutId(dataIndex22);
							return dataIndex22.getCompound("ForgeData").getDouble("red");
						}
					}.getValue() == 2) {
						if (!entity.level().isClientSide())
							entity.discard();
						{
							Entity _ent = entity;
							if (!_ent.level().isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(
										new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
												_ent.getDisplayName(), _ent.level().getServer(), _ent),
										"execute as @s at @s unless entity @e[nbt={ForgeData:{purple:2d}},distance=..300] run summon jujutsucraft:purple ~ ~ ~ {ForgeData:{BlockDamage:0.0d,BlockRange:0.0d,COOLDOWN_TICKS:10.0d,Damage:378000d,DomainAttack:0b,ExtinctionBlock:0b,attack:0b,NameRanged_ranged:0.8395166333921098d,cnt1:1.0d,cnt3:1.0d,cnt6:5001.0d,cnt_brokenBrain:0.0d,cnt_bullet_hit:-4.0d,cnt_life:6.0d,cnt_target:0.0d,effect:0.0d,effectConfirm:0.0d,explode:1b,ignore:0b,knockback:0.0d,noEffect:0b,noParticle:0b,projectile_type:0.0d,skill:215.0d,swing:0b},Attributes:[{Name:\"minecraft:generic.max_health\",Base:20000.0d}],ActiveEffects:[{Id:5,Amplifier:27,Duration:-1,ShowParticles:false}]}");
							}
						}
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:purplexplode")), SoundSource.NEUTRAL, 5, 1);
							} else {
								_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:purplexplode")), SoundSource.NEUTRAL, 5, 1, false);
							}
						}
						if (!entityiterator.level().isClientSide())
							entityiterator.discard();
					}
				}
			}
		} else if (new Object() {
			public double getValue() {
				CompoundTag dataIndex28 = new CompoundTag();
				entity.saveWithoutId(dataIndex28);
				return dataIndex28.getCompound("ForgeData").getDouble("blue");
			}
		}.getValue() == 3) {
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(8 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					CompoundTag dataIndex29 = new CompoundTag();
					entity.saveWithoutId(dataIndex29);
					dataIndex29.getCompound("ForgeData").putDouble("cnt1", 28);
					entity.load(dataIndex29);
					CompoundTag dataIndex30 = new CompoundTag();
					entity.saveWithoutId(dataIndex30);
					dataIndex30.getCompound("ForgeData").putDouble("cnt2", 1);
					entity.load(dataIndex30);
					CompoundTag dataIndex31 = new CompoundTag();
					entity.saveWithoutId(dataIndex31);
					dataIndex31.getCompound("ForgeData").putDouble("cnt6", 5);
					entity.load(dataIndex31);
					if ((ForgeRegistries.ENTITY_TYPES.getKey(entityiterator.getType()).toString()).equals("jujutsucraft:red")) {
						if (!entity.level().isClientSide())
							entity.discard();
						{
							Entity _ent = entity;
							if (!_ent.level().isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(
										new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
												_ent.getDisplayName(), _ent.level().getServer(), _ent),
										"execute as @s at @s unless entity @e[nbt={ForgeData:{purple:2d}},distance=..300] run summon jujutsucraft:purple ~ ~ ~ {ForgeData:{BlockDamage:0.0d,BlockRange:0.0d,COOLDOWN_TICKS:10.0d,Damage:378000d,DomainAttack:0b,ExtinctionBlock:0b,attack:0b,NameRanged_ranged:0.8395166333921098d,cnt1:1.0d,cnt3:1.0d,cnt6:5001.0d,cnt_brokenBrain:0.0d,cnt_bullet_hit:-4.0d,cnt_life:6.0d,cnt_target:0.0d,effect:0.0d,effectConfirm:0.0d,explode:1b,ignore:0b,knockback:0.0d,noEffect:0b,noParticle:0b,projectile_type:0.0d,skill:215.0d,swing:0b},Attributes:[{Name:\"minecraft:generic.max_health\",Base:20000.0d}],ActiveEffects:[{Id:5,Amplifier:27,Duration:-1,ShowParticles:false}]}");
							}
						}
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:purplexplode")), SoundSource.NEUTRAL, 5, 1);
							} else {
								_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:purplexplode")), SoundSource.NEUTRAL, 5, 1, false);
							}
						}
						if (!entityiterator.level().isClientSide())
							entityiterator.discard();
					}
				}
			}
		}
	}
}
