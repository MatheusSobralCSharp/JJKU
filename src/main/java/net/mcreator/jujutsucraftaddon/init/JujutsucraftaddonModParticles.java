
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.jujutsucraftaddon.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.mcreator.jujutsucraftaddon.client.particle.WaterParticle;
import net.mcreator.jujutsucraftaddon.client.particle.WaffleParticle;
import net.mcreator.jujutsucraftaddon.client.particle.VerticalHaitiParticle;
import net.mcreator.jujutsucraftaddon.client.particle.TsukumoPunchParticle;
import net.mcreator.jujutsucraftaddon.client.particle.ThunderWhiteParticle;
import net.mcreator.jujutsucraftaddon.client.particle.ThunderBlueeParticle;
import net.mcreator.jujutsucraftaddon.client.particle.ThunderBlueParticle;
import net.mcreator.jujutsucraftaddon.client.particle.ThunderBlackParticle;
import net.mcreator.jujutsucraftaddon.client.particle.SmokeWhiteParticle;
import net.mcreator.jujutsucraftaddon.client.particle.RedParticle;
import net.mcreator.jujutsucraftaddon.client.particle.PunchParticle;
import net.mcreator.jujutsucraftaddon.client.particle.Kokusen5Particle;
import net.mcreator.jujutsucraftaddon.client.particle.Kokusen4Particle;
import net.mcreator.jujutsucraftaddon.client.particle.Kokusen3Particle;
import net.mcreator.jujutsucraftaddon.client.particle.Kokusen2Particle;
import net.mcreator.jujutsucraftaddon.client.particle.Kokusen1Particle;
import net.mcreator.jujutsucraftaddon.client.particle.KaiParticle;
import net.mcreator.jujutsucraftaddon.client.particle.Kai6Particle;
import net.mcreator.jujutsucraftaddon.client.particle.Kai5Particle;
import net.mcreator.jujutsucraftaddon.client.particle.Kai4Particle;
import net.mcreator.jujutsucraftaddon.client.particle.Kai3Particle;
import net.mcreator.jujutsucraftaddon.client.particle.Kai2Particle;
import net.mcreator.jujutsucraftaddon.client.particle.Kai10Particle;
import net.mcreator.jujutsucraftaddon.client.particle.ImpactParticle;
import net.mcreator.jujutsucraftaddon.client.particle.IceParticle;
import net.mcreator.jujutsucraftaddon.client.particle.HorizontalSlashParticle;
import net.mcreator.jujutsucraftaddon.client.particle.HorizontalSlashBlackParticle;
import net.mcreator.jujutsucraftaddon.client.particle.HorizontalSlash2Particle;
import net.mcreator.jujutsucraftaddon.client.particle.HorizontalSlash1Particle;
import net.mcreator.jujutsucraftaddon.client.particle.HorizontalKaiParticle;
import net.mcreator.jujutsucraftaddon.client.particle.HitImpactParticle;
import net.mcreator.jujutsucraftaddon.client.particle.HaitiParticle;
import net.mcreator.jujutsucraftaddon.client.particle.Haiti9Particle;
import net.mcreator.jujutsucraftaddon.client.particle.Haiti8Particle;
import net.mcreator.jujutsucraftaddon.client.particle.Haiti7Particle;
import net.mcreator.jujutsucraftaddon.client.particle.Haiti6Particle;
import net.mcreator.jujutsucraftaddon.client.particle.Haiti5Particle;
import net.mcreator.jujutsucraftaddon.client.particle.Haiti4Particle;
import net.mcreator.jujutsucraftaddon.client.particle.Haiti3Particle;
import net.mcreator.jujutsucraftaddon.client.particle.Haiti2Particle;
import net.mcreator.jujutsucraftaddon.client.particle.Haiti10Particle;
import net.mcreator.jujutsucraftaddon.client.particle.GojoImbuedThunderParticle;
import net.mcreator.jujutsucraftaddon.client.particle.FlashBangParticle;
import net.mcreator.jujutsucraftaddon.client.particle.FistsParticle;
import net.mcreator.jujutsucraftaddon.client.particle.Dash1Particle;
import net.mcreator.jujutsucraftaddon.client.particle.CursedPowerSukunaParticle;
import net.mcreator.jujutsucraftaddon.client.particle.CursedPowerOkkotsuRingParticle;
import net.mcreator.jujutsucraftaddon.client.particle.CursedPowerOkkotsuParticle;
import net.mcreator.jujutsucraftaddon.client.particle.CursedPowerMahitoParticle;
import net.mcreator.jujutsucraftaddon.client.particle.CursedPowerItadoriParticle;
import net.mcreator.jujutsucraftaddon.client.particle.CursedPowerHakariParticle;
import net.mcreator.jujutsucraftaddon.client.particle.CursePowerBlueDarkParticle;
import net.mcreator.jujutsucraftaddon.client.particle.BlueeParticle;
import net.mcreator.jujutsucraftaddon.client.particle.BluePunchParticle;
import net.mcreator.jujutsucraftaddon.client.particle.BloodRedParticle;
import net.mcreator.jujutsucraftaddon.client.particle.BloodParticle;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class JujutsucraftaddonModParticles {
	@SubscribeEvent
	public static void registerParticles(RegisterParticleProvidersEvent event) {
		event.registerSpriteSet(JujutsucraftaddonModParticleTypes.THUNDER_BLUE.get(), ThunderBlueParticle::provider);
		event.registerSpriteSet(JujutsucraftaddonModParticleTypes.KAI.get(), KaiParticle::provider);
		event.registerSpriteSet(JujutsucraftaddonModParticleTypes.HAITI.get(), HaitiParticle::provider);
		event.registerSpriteSet(JujutsucraftaddonModParticleTypes.CURSE_POWER_BLUE_DARK.get(), CursePowerBlueDarkParticle::provider);
		event.registerSpriteSet(JujutsucraftaddonModParticleTypes.THUNDER_WHITE.get(), ThunderWhiteParticle::provider);
		event.registerSpriteSet(JujutsucraftaddonModParticleTypes.THUNDER_BLACK.get(), ThunderBlackParticle::provider);
		event.registerSpriteSet(JujutsucraftaddonModParticleTypes.THUNDER_BLUEE.get(), ThunderBlueeParticle::provider);
		event.registerSpriteSet(JujutsucraftaddonModParticleTypes.HIT_IMPACT.get(), HitImpactParticle::provider);
		event.registerSpriteSet(JujutsucraftaddonModParticleTypes.IMPACT.get(), ImpactParticle::provider);
		event.registerSpriteSet(JujutsucraftaddonModParticleTypes.RED.get(), RedParticle::provider);
		event.registerSpriteSet(JujutsucraftaddonModParticleTypes.FISTS.get(), FistsParticle::provider);
		event.registerSpriteSet(JujutsucraftaddonModParticleTypes.GOJO_IMBUED_THUNDER.get(), GojoImbuedThunderParticle::provider);
		event.registerSpriteSet(JujutsucraftaddonModParticleTypes.BLUE_PUNCH.get(), BluePunchParticle::provider);
		event.registerSpriteSet(JujutsucraftaddonModParticleTypes.BLOOD_RED.get(), BloodRedParticle::provider);
		event.registerSpriteSet(JujutsucraftaddonModParticleTypes.CURSED_POWER_MAHITO.get(), CursedPowerMahitoParticle::provider);
		event.registerSpriteSet(JujutsucraftaddonModParticleTypes.CURSED_POWER_ITADORI.get(), CursedPowerItadoriParticle::provider);
		event.registerSpriteSet(JujutsucraftaddonModParticleTypes.CURSED_POWER_OKKOTSU.get(), CursedPowerOkkotsuParticle::provider);
		event.registerSpriteSet(JujutsucraftaddonModParticleTypes.CURSED_POWER_SUKUNA.get(), CursedPowerSukunaParticle::provider);
		event.registerSpriteSet(JujutsucraftaddonModParticleTypes.CURSED_POWER_OKKOTSU_RING.get(), CursedPowerOkkotsuRingParticle::provider);
		event.registerSpriteSet(JujutsucraftaddonModParticleTypes.SMOKE_WHITE.get(), SmokeWhiteParticle::provider);
		event.registerSpriteSet(JujutsucraftaddonModParticleTypes.WATER.get(), WaterParticle::provider);
		event.registerSpriteSet(JujutsucraftaddonModParticleTypes.KAI_2.get(), Kai2Particle::provider);
		event.registerSpriteSet(JujutsucraftaddonModParticleTypes.HAITI_2.get(), Haiti2Particle::provider);
		event.registerSpriteSet(JujutsucraftaddonModParticleTypes.HAITI_3.get(), Haiti3Particle::provider);
		event.registerSpriteSet(JujutsucraftaddonModParticleTypes.KAI_3.get(), Kai3Particle::provider);
		event.registerSpriteSet(JujutsucraftaddonModParticleTypes.FLASH_BANG.get(), FlashBangParticle::provider);
		event.registerSpriteSet(JujutsucraftaddonModParticleTypes.HAITI_4.get(), Haiti4Particle::provider);
		event.registerSpriteSet(JujutsucraftaddonModParticleTypes.KAI_4.get(), Kai4Particle::provider);
		event.registerSpriteSet(JujutsucraftaddonModParticleTypes.BLOOD.get(), BloodParticle::provider);
		event.registerSpriteSet(JujutsucraftaddonModParticleTypes.PUNCH.get(), PunchParticle::provider);
		event.registerSpriteSet(JujutsucraftaddonModParticleTypes.ICE.get(), IceParticle::provider);
		event.registerSpriteSet(JujutsucraftaddonModParticleTypes.TSUKUMO_PUNCH.get(), TsukumoPunchParticle::provider);
		event.registerSpriteSet(JujutsucraftaddonModParticleTypes.KAI_5.get(), Kai5Particle::provider);
		event.registerSpriteSet(JujutsucraftaddonModParticleTypes.HAITI_5.get(), Haiti5Particle::provider);
		event.registerSpriteSet(JujutsucraftaddonModParticleTypes.HAITI_6.get(), Haiti6Particle::provider);
		event.registerSpriteSet(JujutsucraftaddonModParticleTypes.KAI_6.get(), Kai6Particle::provider);
		event.registerSpriteSet(JujutsucraftaddonModParticleTypes.DASH_1.get(), Dash1Particle::provider);
		event.registerSpriteSet(JujutsucraftaddonModParticleTypes.HAITI_7.get(), Haiti7Particle::provider);
		event.registerSpriteSet(JujutsucraftaddonModParticleTypes.HAITI_8.get(), Haiti8Particle::provider);
		event.registerSpriteSet(JujutsucraftaddonModParticleTypes.HAITI_9.get(), Haiti9Particle::provider);
		event.registerSpriteSet(JujutsucraftaddonModParticleTypes.WAFFLE.get(), WaffleParticle::provider);
		event.registerSpriteSet(JujutsucraftaddonModParticleTypes.HORIZONTAL_SLASH.get(), HorizontalSlashParticle::provider);
		event.registerSpriteSet(JujutsucraftaddonModParticleTypes.HORIZONTAL_SLASH_BLACK.get(), HorizontalSlashBlackParticle::provider);
		event.registerSpriteSet(JujutsucraftaddonModParticleTypes.HORIZONTAL_SLASH_2.get(), HorizontalSlash2Particle::provider);
		event.registerSpriteSet(JujutsucraftaddonModParticleTypes.HORIZONTAL_KAI.get(), HorizontalKaiParticle::provider);
		event.registerSpriteSet(JujutsucraftaddonModParticleTypes.VERTICAL_HAITI.get(), VerticalHaitiParticle::provider);
		event.registerSpriteSet(JujutsucraftaddonModParticleTypes.HAITI_10.get(), Haiti10Particle::provider);
		event.registerSpriteSet(JujutsucraftaddonModParticleTypes.KAI_10.get(), Kai10Particle::provider);
		event.registerSpriteSet(JujutsucraftaddonModParticleTypes.CURSED_POWER_HAKARI.get(), CursedPowerHakariParticle::provider);
		event.registerSpriteSet(JujutsucraftaddonModParticleTypes.BLUEE.get(), BlueeParticle::provider);
		event.registerSpriteSet(JujutsucraftaddonModParticleTypes.KOKUSEN_1.get(), Kokusen1Particle::provider);
		event.registerSpriteSet(JujutsucraftaddonModParticleTypes.KOKUSEN_2.get(), Kokusen2Particle::provider);
		event.registerSpriteSet(JujutsucraftaddonModParticleTypes.KOKUSEN_3.get(), Kokusen3Particle::provider);
		event.registerSpriteSet(JujutsucraftaddonModParticleTypes.KOKUSEN_4.get(), Kokusen4Particle::provider);
		event.registerSpriteSet(JujutsucraftaddonModParticleTypes.KOKUSEN_5.get(), Kokusen5Particle::provider);
		event.registerSpriteSet(JujutsucraftaddonModParticleTypes.HORIZONTAL_SLASH_1.get(), HorizontalSlash1Particle::provider);
	}
}
