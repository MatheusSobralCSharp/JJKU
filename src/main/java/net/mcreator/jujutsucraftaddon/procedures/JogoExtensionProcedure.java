package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.jujutsucraftaddon.entity.GegeAkutamiEntity;
import net.mcreator.jujutsucraft.entity.MeteorEntity;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;

public class JogoExtensionProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		double Grow = 0;
		double TrackZ = 0;
		double TrackY = 0;
		double TrackX = 0;
		if ((sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 4) {
			if (!(!world.getEntitiesOfClass(MeteorEntity.class, AABB.ofSize(new Vec3(x, y, z), 20, 20, 20), e -> true).isEmpty())) {
				if (new Object() {
					public double getValue() {
						CompoundTag dataIndex2 = new CompoundTag();
						sourceentity.saveWithoutId(dataIndex2);
						return dataIndex2.getCompound("ForgeData").getDouble("skill");
					}
				}.getValue() == 0 && new Object() {
					public double getValue() {
						CompoundTag dataIndex3 = new CompoundTag();
						sourceentity.saveWithoutId(dataIndex3);
						return dataIndex3.getCompound("ForgeData").getDouble("skill_domain");
					}
				}.getValue() == 0) {
					if (Math.random() < 0.05) {
						TrackX = sourceentity.getX() - entity.getX();
						TrackY = sourceentity.getY() - entity.getY() + sourceentity.getBbHeight() * 0.75 - entity.getBbHeight() * 0.75;
						TrackZ = sourceentity.getZ() - entity.getZ();
						Grow = 1;
						for (int index0 = 0; index0 < 20; index0++) {
							if (world instanceof ServerLevel _level)
								_level.sendParticles(ParticleTypes.SOUL_FIRE_FLAME, (entity.getX() + TrackX * Grow), (entity.getY() + entity.getBbHeight() * 0.75 + TrackY * Grow), (entity.getZ() + TrackZ * Grow), 5, 0.15, 0.15, 0.15, 0);
							Grow = Grow - 0.05;
						}
						for (int index1 = 0; index1 < 20; index1++) {
							if (world instanceof ServerLevel _level)
								_level.sendParticles(ParticleTypes.FLAME, (entity.getX() + TrackX * Grow), (entity.getY() + entity.getBbHeight() * 0.75 + TrackY * Grow), (entity.getZ() + TrackZ * Grow), 5, 0.15, 0.15, 0.15, 0);
							Grow = Grow - 0.05;
						}
						if (world instanceof Level _level && !_level.isClientSide()) {
							_level.explode(sourceentity, (entity.getX()), (entity.getY()), (entity.getZ()), 4, true, Level.ExplosionInteraction.MOB);
						}
						{
							Entity _ent = entity;
							if (!_ent.level().isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
										_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run effect give @s jujutsucraft:cancel_cursed_technique 2 1 true");
							}
						}
					}
				}
				entity.setSecondsOnFire(15);
			}
		}
	}
}
