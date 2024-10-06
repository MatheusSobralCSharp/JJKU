package net.mcreator.jujutsucraftaddon.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModParticleTypes;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.TagKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;
import net.minecraft.client.player.AbstractClientPlayer;

import net.mcreator.jujutsucraftaddon.item.WukongStaffItem;
import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModParticleTypes;

import java.util.List;
import java.util.Comparator;

import dev.kosmx.playerAnim.minecraftApi.PlayerAnimationRegistry;
import dev.kosmx.playerAnim.minecraftApi.PlayerAnimationAccess;
import dev.kosmx.playerAnim.api.layered.ModifierLayer;
import dev.kosmx.playerAnim.api.layered.KeyframeAnimationPlayer;
import dev.kosmx.playerAnim.api.layered.IAnimation;

public class WukongStaffEntitySwingsItemProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		double r = 0;
		double curve = 0;
		double deg = 0;
		double yoff = 0;
		itemstack.getOrCreateTag().putDouble("Test", (Mth.nextInt(RandomSource.create(), 1, 10)));
		itemstack.getOrCreateTag().putDouble("Test2", (itemstack.getOrCreateTag().getDouble("Test")));
		if (itemstack.getOrCreateTag().getDouble("Test") > 0) {
			if (world.isClientSide()) {
				if (entity instanceof AbstractClientPlayer player) {
					var animation = (ModifierLayer<IAnimation>) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
					if (animation != null && !animation.isActive()) {
						animation.setAnimation(
								new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", ("wu" + new java.text.DecimalFormat("##.##").format(itemstack.getOrCreateTag().getDouble("Test")))))));
					}
				}
			}
			{
				Entity _ent = entity;
				if (!_ent.level().isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
							_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
							("playsound jujutsucraftaddon:wu" + new java.text.DecimalFormat("##.##").format(itemstack.getOrCreateTag().getDouble("Test")) + " master @s"));
				}
			}
			if (itemstack.getOrCreateTag().getBoolean("Mode") == true) {
				if (itemstack.getItem() instanceof WukongStaffItem)
					itemstack.getOrCreateTag().putString("geckoAnim", ("wu" + new java.text.DecimalFormat("##.##").format(itemstack.getOrCreateTag().getDouble("Test"))));
			}
			itemstack.getOrCreateTag().putDouble("Test", 0);
		}
		if (itemstack.getOrCreateTag().getBoolean("Mode") == true) {
			itemstack.getOrCreateTag().putDouble("Reach", (Mth.nextInt(RandomSource.create(), 1, 5)));
			itemstack.getOrCreateTag().putDouble("Knockback", (Mth.nextInt(RandomSource.create(), 1, 5)));
			itemstack.getOrCreateTag().putDouble("Range", (Mth.nextInt(RandomSource.create(), 1, 5)));
			itemstack.getOrCreateTag().putDouble("CursePower", (Mth.nextInt(RandomSource.create(), -20, 20)));
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(30 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (!(entityiterator == entity)) {
						if (entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo_no_move")))) {
							if (!entityiterator.level().isClientSide())
								entityiterator.discard();
							if (world instanceof ServerLevel _level)
								_level.sendParticles((SimpleParticleType) (JujutsucraftaddonModParticleTypes.HAITI.get()), (entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), 1, 0, 0, 0, 1);
						} else if (entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo")))) {
							if (!entityiterator.level().isClientSide())
								entityiterator.discard();
							if (world instanceof ServerLevel _level)
								_level.sendParticles((SimpleParticleType) (JujutsucraftaddonModParticleTypes.KAI.get()), (entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), 1, 0, 0, 0, 1);
						}
					}
				}
			}
		} else {
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(15 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (!(entityiterator == entity)) {
						if (!(entityiterator.getPersistentData().getString("OWNER_UUID")).equals(entity.getStringUUID())){
							if (entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo_no_move")))) {
								if (!entityiterator.level().isClientSide())
									entityiterator.discard();
								if (world instanceof ServerLevel _level)
									_level.sendParticles((SimpleParticleType) (JujutsucraftaddonModParticleTypes.HAITI.get()), (entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), 1, 0, 0, 0, 1);
							} else if (entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo")))) {
								if (!entityiterator.level().isClientSide())
									entityiterator.discard();
								if (world instanceof ServerLevel _level)
									_level.sendParticles((SimpleParticleType) (JujutsucraftaddonModParticleTypes.KAI.get()), (entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), 1, 0, 0, 0, 1);
							}
						}
					}
				}
			}
			itemstack.getOrCreateTag().putDouble("Reach", (Mth.nextInt(RandomSource.create(), 1, 3)));
			itemstack.getOrCreateTag().putDouble("Knockback", (Mth.nextInt(RandomSource.create(), 1, 3)));
			itemstack.getOrCreateTag().putDouble("Range", (Mth.nextInt(RandomSource.create(), 1, 3)));
			itemstack.getOrCreateTag().putDouble("CursePower", (Mth.nextInt(RandomSource.create(), -10, 10)));
		}
		deg = entity.getYRot() - 90;
		r = 1;
		curve = Mth.nextDouble(RandomSource.create(), -10, 10);
		for (int index0 = 0; index0 < 5; index0++) {
			for (int index1 = 0; index1 < 11; index1++) {
				if (r == 2 || r == 3) {
					yoff = Math.sin(Math.toRadians(deg)) * curve;
					world.addParticle(JujutsucraftModParticleTypes.PARTICLE_BLACK_FLASH_1.get(), (x - r * Math.sin(Math.toRadians(deg))), (y + 1 + yoff), (z + r * Math.cos(Math.toRadians(deg))), ((-0.1) * Math.sin(Math.toRadians(deg))), 0, (0.1 * Math.cos(Math.toRadians(deg))));
				}
				deg = deg + 18;
			}
			if (r == 2 || r == 4) {
				deg = entity.getYRot() - 81;
			} else {
				deg = entity.getYRot() - 90;
			}
			r = r + 1;
		}
	}
}
