package net.mcreator.jujutsucraftaddon.procedures;

import dev.kosmx.playerAnim.api.layered.IAnimation;
import dev.kosmx.playerAnim.api.layered.KeyframeAnimationPlayer;
import dev.kosmx.playerAnim.api.layered.ModifierLayer;
import dev.kosmx.playerAnim.minecraftApi.PlayerAnimationAccess;
import dev.kosmx.playerAnim.minecraftApi.PlayerAnimationRegistry;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraft.procedures.ThinIceBreakerProcedure;
import net.mcreator.jujutsucraftaddon.JujutsucraftaddonMod;
import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModMobEffects;
import net.mcreator.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.network.Connection;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;

import net.mcreator.jujutsucraftaddon.entity.ErroEntity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.network.NetworkDirection;

import java.util.Iterator;
import java.util.List;

public class SukunaAttackAnimationsProcedure {
	public static void execute(Entity sourceentity, Entity entity, LevelAccessor world, double x, double y, double z) {
		if (sourceentity == null)
			return;


		if (!(sourceentity instanceof LivingEntity && ((LivingEntity) sourceentity).hasEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()))) {
			if (!(sourceentity.getPersistentData().getDouble("skill") == 105 || sourceentity.getPersistentData().getDouble("skill") == 106)) {
				if (sourceentity instanceof ErroEntity) {
					((ErroEntity) sourceentity).setAnimation(("animation.sukuna.attack" + Mth.nextInt(RandomSource.create(), 1, 9)));
				}
			} else {
				if (sourceentity.getPersistentData().getDouble("skill") == 105) {
					if (sourceentity.onGround()) {
						if (sourceentity instanceof ErroEntity) {
							((ErroEntity) sourceentity).setAnimation(("animation.dismantle_maximum" + Mth.nextInt(RandomSource.create(), 1, 4)));
						}
					} else {
						if (sourceentity instanceof ErroEntity) {
							((ErroEntity) sourceentity).setAnimation("animation.dismantle_backwards");
						}
					}
				}
				if (sourceentity.getPersistentData().getDouble("skill") == 106) {
					if (sourceentity.onGround()) {
						if (sourceentity instanceof ErroEntity) {
							((ErroEntity) sourceentity).setAnimation(("animation.cleave.attack" + Mth.nextInt(RandomSource.create(), 1, 5)));
						}
					} else {
						if (sourceentity instanceof ErroEntity) {
							((ErroEntity) sourceentity).setAnimation("animation.dissect");
						}
					}
				}
			}
		} else {
			
		}
	}
}
