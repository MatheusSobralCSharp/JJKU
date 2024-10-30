/**
 * The code of this mod element is always locked.
 *
 * You can register new events in this class too.
 *
 * If you want to make a plain independent class, create it using
 * Project Browser -> New... and make sure to make the class
 * outside net.mcreator.jujutsucraftaddon as this package is managed by MCreator.
 *
 * If you change workspace package, modid or prefix, you will need
 * to manually adapt this file to these changes or remake it.
 *
 * This class will be added in the mod root package.
*/
package net.mcreator.jujutsucraftaddon;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

public class ParticleHelper {
	public static void applyTextureAnimation(ClientLevel level, TextureAnimator particle, RandomSource random) {
		particle.roll = (random.nextFloat() - 0.5F) * 360.0F;

		if (particle.entity == null) {
			particle.entity = level.getEntity(particle.entityId);
		} else {
			particle.quadSize = 0.1F * (random.nextFloat() * 0.5F + 0.5F) *
					(particle.entity.getBbWidth() + particle.entity.getBbHeight()) * 20.0F;
			particle.updateSize(particle.quadSize, particle.quadSize);  // Call the new method

			Vec3 center = particle.entity.position().add(0.0D, particle.entity.getBbHeight() / 2, 0.0D);
			particle.offset = center.add(
					(HelperMethods.RANDOM.nextDouble() - 0.5D) * particle.entity.getBbWidth(),
					(HelperMethods.RANDOM.nextDouble() - 0.5D) * particle.entity.getBbHeight(),
					(HelperMethods.RANDOM.nextDouble() - 0.5D) * particle.entity.getBbWidth());

			particle.setPos(particle.offset.x, particle.offset.y, particle.offset.z);
		}

		if (particle.entity == null || particle.entity.isRemoved() || !particle.entity.isAlive()) {
			particle.remove();
		}
	}
}