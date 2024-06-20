package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModMobEffects;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;

import java.util.List;
import java.util.Comparator;

public class ProcedureGetoProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName)
				.equals("Cursed Spirit Grade Semi 1 (Mammoth) \u00D7" + new java.text.DecimalFormat("##.##").format(Mth.nextInt(RandomSource.create(), 1, 10)))) {
			CompoundTag dataIndex2 = new CompoundTag();
			entity.saveWithoutId(dataIndex2);
			dataIndex2.getCompound("ForgeData").putDouble("skill", 150);
			entity.load(dataIndex2);
			if (new Object() {
				public double getValue() {
					CompoundTag dataIndex3 = new CompoundTag();
					entity.saveWithoutId(dataIndex3);
					return dataIndex3.getCompound("ForgeData").getDouble("skill");
				}
			}.getValue() > 0) {
				if (!(entity instanceof LivingEntity _livEnt4 && _livEnt4.hasEffect(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get()))) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), 100, 1, false, false));
				}
			}
		} else if (((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName)
				.equals("Cursed Spirit Grade Semi 1 (Slug) \u00D7" + new java.text.DecimalFormat("##.##").format(Mth.nextInt(RandomSource.create(), 1, 10)))) {
			CompoundTag dataIndex8 = new CompoundTag();
			entity.saveWithoutId(dataIndex8);
			dataIndex8.getCompound("ForgeData").putDouble("skill", 159);
			entity.load(dataIndex8);
			if (new Object() {
				public double getValue() {
					CompoundTag dataIndex9 = new CompoundTag();
					entity.saveWithoutId(dataIndex9);
					return dataIndex9.getCompound("ForgeData").getDouble("skill");
				}
			}.getValue() > 0) {
				if (!(entity instanceof LivingEntity _livEnt10 && _livEnt10.hasEffect(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get()))) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), 100, 1, false, false));
				}
			}
		} else if (((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName)
				.equals("Cursed Spirit Grade 1 (Blindness) \u00D7" + new java.text.DecimalFormat("##.##").format(Mth.nextInt(RandomSource.create(), 1, 10)))) {
			if (entity.isShiftKeyDown()) {
				CompoundTag dataIndex15 = new CompoundTag();
				entity.saveWithoutId(dataIndex15);
				dataIndex15.getCompound("ForgeData").putDouble("skill", 2305);
				entity.load(dataIndex15);
				if (new Object() {
					public double getValue() {
						CompoundTag dataIndex16 = new CompoundTag();
						entity.saveWithoutId(dataIndex16);
						return dataIndex16.getCompound("ForgeData").getDouble("skill");
					}
				}.getValue() > 0) {
					if (!(entity instanceof LivingEntity _livEnt17 && _livEnt17.hasEffect(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get()))) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), 100, 1, false, false));
					}
				}
			} else if (!entity.isShiftKeyDown()) {
				CompoundTag dataIndex21 = new CompoundTag();
				entity.saveWithoutId(dataIndex21);
				dataIndex21.getCompound("ForgeData").putDouble("skill", (Mth.nextInt(RandomSource.create(), 151, 152)));
				entity.load(dataIndex21);
				if (new Object() {
					public double getValue() {
						CompoundTag dataIndex22 = new CompoundTag();
						entity.saveWithoutId(dataIndex22);
						return dataIndex22.getCompound("ForgeData").getDouble("skill");
					}
				}.getValue() > 0) {
					if (!(entity instanceof LivingEntity _livEnt23 && _livEnt23.hasEffect(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get()))) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), 100, 1, false, false));
					}
				}
			}
		} else if (((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName)
				.equals("Samurai in Armor \u00D7" + new java.text.DecimalFormat("##.##").format(Mth.nextInt(RandomSource.create(), 1, 10)))) {
			if (entity.isShiftKeyDown()) {
				CompoundTag dataIndex28 = new CompoundTag();
				entity.saveWithoutId(dataIndex28);
				dataIndex28.getCompound("ForgeData").putDouble("skill", 2204);
				entity.load(dataIndex28);
				if (new Object() {
					public double getValue() {
						CompoundTag dataIndex29 = new CompoundTag();
						entity.saveWithoutId(dataIndex29);
						return dataIndex29.getCompound("ForgeData").getDouble("skill");
					}
				}.getValue() > 0) {
					if (!(entity instanceof LivingEntity _livEnt30 && _livEnt30.hasEffect(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get()))) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), 100, 1, false, false));
					}
				}
			} else if (!entity.isShiftKeyDown()) {
				CompoundTag dataIndex33 = new CompoundTag();
				entity.saveWithoutId(dataIndex33);
				dataIndex33.getCompound("ForgeData").putDouble("skill", 1516);
				entity.load(dataIndex33);
				if (new Object() {
					public double getValue() {
						CompoundTag dataIndex34 = new CompoundTag();
						entity.saveWithoutId(dataIndex34);
						return dataIndex34.getCompound("ForgeData").getDouble("skill");
					}
				}.getValue() > 0) {
					if (!(entity instanceof LivingEntity _livEnt35 && _livEnt35.hasEffect(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get()))) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), 100, 1, false, false));
					}
				}
			}
		} else if (((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName)
				.equals("Tamamo-no-Mae Incarnate \u00D7" + new java.text.DecimalFormat("##.##").format(Mth.nextInt(RandomSource.create(), 1, 10)))) {
			if (entity.isShiftKeyDown()) {
				CompoundTag dataIndex40 = new CompoundTag();
				entity.saveWithoutId(dataIndex40);
				dataIndex40.getCompound("ForgeData").putDouble("skill", 155);
				entity.load(dataIndex40);
				if (new Object() {
					public double getValue() {
						CompoundTag dataIndex41 = new CompoundTag();
						entity.saveWithoutId(dataIndex41);
						return dataIndex41.getCompound("ForgeData").getDouble("skill");
					}
				}.getValue() > 0) {
					if (!(entity instanceof LivingEntity _livEnt42 && _livEnt42.hasEffect(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get()))) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), 100, 1, false, false));
					}
				}
			} else if (!entity.isShiftKeyDown()) {
				CompoundTag dataIndex45 = new CompoundTag();
				entity.saveWithoutId(dataIndex45);
				dataIndex45.getCompound("ForgeData").putDouble("skill", 156);
				entity.load(dataIndex45);
				if (new Object() {
					public double getValue() {
						CompoundTag dataIndex46 = new CompoundTag();
						entity.saveWithoutId(dataIndex46);
						return dataIndex46.getCompound("ForgeData").getDouble("skill");
					}
				}.getValue() > 0) {
					if (!(entity instanceof LivingEntity _livEnt47 && _livEnt47.hasEffect(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get()))) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), 100, 1, false, false));
					}
				}
			}
		} else if (((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName)
				.equals("Ganesha x" + new java.text.DecimalFormat("##.##").format(Mth.nextInt(RandomSource.create(), 1, 10)))) {
			if (!entity.isShiftKeyDown()) {
				CompoundTag dataIndex52 = new CompoundTag();
				entity.saveWithoutId(dataIndex52);
				dataIndex52.getCompound("ForgeData").putDouble("skill", 160);
				entity.load(dataIndex52);
				if (new Object() {
					public double getValue() {
						CompoundTag dataIndex53 = new CompoundTag();
						entity.saveWithoutId(dataIndex53);
						return dataIndex53.getCompound("ForgeData").getDouble("skill");
					}
				}.getValue() > 0) {
					if (!(entity instanceof LivingEntity _livEnt54 && _livEnt54.hasEffect(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get()))) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), 100, 1, false, false));
					}
				}
			}
		}
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(4 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (!(entityiterator == entity)) {
					if (new Object() {
						public double getValue() {
							CompoundTag dataIndex57 = new CompoundTag();
							entityiterator.saveWithoutId(dataIndex57);
							return dataIndex57.getCompound("ForgeData").getDouble("CursedSpirit");
						}
					}.getValue() == 1 && (new Object() {
						public String getValue() {
							CompoundTag dataIndex58 = new CompoundTag();
							entityiterator.saveWithoutId(dataIndex58);
							return dataIndex58.getCompound("ForgeData").getString("OWNER_UUID");
						}
					}.getValue()).equals(entity.getStringUUID()) && (new Object() {
						public boolean getValue() {
							CompoundTag dataIndex60 = new CompoundTag();
							entityiterator.saveWithoutId(dataIndex60);
							return dataIndex60.getCompound("ForgeData").getBoolean("Buffed");
						}
					}.getValue()) == false) {
						if (world instanceof ServerLevel _level) {
							System.out.println(entityiterator.getStringUUID());
							_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(0, 0, 0), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
									"scale add pehkui:height 0.5 " + entityiterator.getStringUUID());
						}
						if (world instanceof ServerLevel _level) {
							System.out.println(entityiterator.getStringUUID());
							_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(0, 0, 0), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
									"scale add pehkui:width 0.5 " + entityiterator.getStringUUID());
						}
						((LivingEntity) entityiterator).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH)
								.setBaseValue((((LivingEntity) entityiterator).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).getBaseValue() * 2.5));
						{
							Entity _ent = entityiterator;
							if (!_ent.level().isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
										_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s unless predicate jujutsucraftaddon:effects/orca/sixeyes run jjc_cursepower -500 @s");
							}
						}
						if (entityiterator instanceof LivingEntity _entity)
							_entity.setHealth(entityiterator instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
						CompoundTag dataIndex68 = new CompoundTag();
						entityiterator.saveWithoutId(dataIndex68);
						dataIndex68.getCompound("ForgeData").putBoolean("Buffed", true);
						entityiterator.load(dataIndex68);
					}
				}
			}
		}
	}
}
