package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModItems;

public class SwordOkkotsuLivingEntityIsHitWithToolProcedure {
	public static void execute(Entity entity, Entity sourceentity, ItemStack itemstack) {
		if (entity == null || sourceentity == null)
			return;
		if (entity instanceof LivingEntity) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 60, 5, false, false));
		}
		if (new Object() {
			public double getValue() {
				CompoundTag dataIndex2 = new CompoundTag();
				entity.saveWithoutId(dataIndex2);
				return dataIndex2.getCompound("ForgeData").getDouble("skill");
			}
		}.getValue() >= 2) {
			itemstack.getOrCreateTag().putDouble("skill", (new Object() {
				public double getValue() {
					CompoundTag dataIndex3 = new CompoundTag();
					entity.saveWithoutId(dataIndex3);
					return dataIndex3.getCompound("ForgeData").getDouble("skill");
				}
			}.getValue()));
			CompoundTag dataIndex8 = new CompoundTag();
			sourceentity.saveWithoutId(dataIndex8);
			dataIndex8.getCompound("ForgeData").putDouble("skill", (itemstack.getOrCreateTag().getDouble("skill")));
			sourceentity.load(dataIndex8);
			CompoundTag dataIndex9 = new CompoundTag();
			sourceentity.saveWithoutId(dataIndex9);
			dataIndex9.getCompound("ForgeData").putDouble("PRESS_Z", 1);
			sourceentity.load(dataIndex9);
			{
				Entity _ent = sourceentity;
				if (!_ent.level().isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
							_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run effect give @s jujutsucraft:cursed_technique");
				}
			}
			if (JujutsucraftaddonModItems.SWORD_OKKOTSU.get() == JujutsucraftaddonModItems.SWORD_OKKOTSU.get()) {
				if (sourceentity instanceof Player _player)
					_player.getCooldowns().addCooldown(itemstack.getItem(), 600);
			}
		}
	}
}
