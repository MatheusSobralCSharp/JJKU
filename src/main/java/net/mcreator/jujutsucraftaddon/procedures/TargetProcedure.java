package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingChangeTargetEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.tags.TagKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.registries.Registries;

import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModMobEffects;
import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModGameRules;
import net.mcreator.jujutsucraftaddon.entity.YutaCullingGamesEntity;
import net.mcreator.jujutsucraftaddon.entity.UraumeEntity;
import net.mcreator.jujutsucraftaddon.entity.SukunaNoShirtEntity;
import net.mcreator.jujutsucraftaddon.entity.SukunaMangaEntity;
import net.mcreator.jujutsucraftaddon.entity.SukunaFushiguroEntity;
import net.mcreator.jujutsucraftaddon.entity.SatushiEntity;
import net.mcreator.jujutsucraftaddon.entity.MakiPreparationEntity;
import net.mcreator.jujutsucraftaddon.entity.KashimoFemboyEntity;
import net.mcreator.jujutsucraftaddon.entity.ItadoriShinjukuEntity;
import net.mcreator.jujutsucraftaddon.entity.IronkkEntity;
import net.mcreator.jujutsucraftaddon.entity.HusseinDongEntity;
import net.mcreator.jujutsucraftaddon.entity.HakariEntity;
import net.mcreator.jujutsucraftaddon.entity.GojoSchoolEntity;
import net.mcreator.jujutsucraftaddon.entity.GojoMangaEntity;
import net.mcreator.jujutsucraftaddon.entity.AngellEntity;
import net.mcreator.jujutsucraftaddon.entity.AdjuchaEntity;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class TargetProcedure {
	@SubscribeEvent
	public static void onEntitySetsAttackTarget(LivingChangeTargetEvent event) {
		execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getOriginalTarget(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		execute(null, world, x, y, z, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if ((ForgeRegistries.ENTITY_TYPES.getKey(sourceentity.getType()).toString()).startsWith("jujutsucraft")) {
			if ((new Object() {
				public double getValue() {
					CompoundTag dataIndex1 = new CompoundTag();
					sourceentity.saveWithoutId(dataIndex1);
					return dataIndex1.getCompound("ForgeData").getDouble("select");
				}
			}.getValue() > 0 || new Object() {
				public double getValue() {
					CompoundTag dataIndex2 = new CompoundTag();
					sourceentity.saveWithoutId(dataIndex2);
					return dataIndex2.getCompound("ForgeData").getDouble("skill");
				}
			}.getValue() == 510 || new Object() {
				public double getValue() {
					CompoundTag dataIndex3 = new CompoundTag();
					sourceentity.saveWithoutId(dataIndex3);
					return dataIndex3.getCompound("ForgeData").getDouble("skill");
				}
			}.getValue() == 515 || new Object() {
				public double getValue() {
					CompoundTag dataIndex4 = new CompoundTag();
					sourceentity.saveWithoutId(dataIndex4);
					return dataIndex4.getCompound("ForgeData").getDouble("skill");
				}
			}.getValue() == 617 || new Object() {
				public double getValue() {
					CompoundTag dataIndex5 = new CompoundTag();
					sourceentity.saveWithoutId(dataIndex5);
					return dataIndex5.getCompound("ForgeData").getDouble("skill");
				}
			}.getValue() == 618 || new Object() {
				public double getValue() {
					CompoundTag dataIndex6 = new CompoundTag();
					sourceentity.saveWithoutId(dataIndex6);
					return dataIndex6.getCompound("ForgeData").getDouble("skill");
				}
			}.getValue() == 1520) && new Object() {
				public double getValue() {
					CompoundTag dataIndex7 = new CompoundTag();
					sourceentity.saveWithoutId(dataIndex7);
					return dataIndex7.getCompound("ForgeData").getDouble("cnt1");
				}
			}.getValue() > 0 && new Object() {
				public double getValue() {
					CompoundTag dataIndex8 = new CompoundTag();
					sourceentity.saveWithoutId(dataIndex8);
					return dataIndex8.getCompound("ForgeData").getDouble("cnt1");
				}
			}.getValue() < 10) {
				Nuesummon2Procedure.execute(world, x, y, z, sourceentity);
				if ((ForgeRegistries.ENTITY_TYPES.getKey(sourceentity.getType()).toString()).equals("jujutsucraft:rika") || (ForgeRegistries.ENTITY_TYPES.getKey(sourceentity.getType()).toString()).equals("jujutsucraft:rika_2")) {
					RikaAIBuffedProcedure.execute(world, entity, sourceentity);
				} else if (sourceentity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("jujutsucraft:ten_shadows_technique")))) {
					ShadowsAIBuffedProcedure.execute(entity);
				}
			} else if (new Object() {
				public double getValue() {
					CompoundTag dataIndex12 = new CompoundTag();
					sourceentity.saveWithoutId(dataIndex12);
					return dataIndex12.getCompound("ForgeData").getDouble("skill_domain");
				}
			}.getValue() > 0) {
				if (world.getLevelData().getGameRules().getBoolean(JujutsucraftaddonModGameRules.JJKU_DOMAIN_NERF) == true) {
					if (!(sourceentity instanceof LivingEntity _livEnt14 && _livEnt14.hasEffect(JujutsucraftaddonModMobEffects.DOMAIN_BREAK.get()))) {
						if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.DOMAIN_BREAK.get(), -1, 1, false, false));
					}
				}
			}
		}
		if (sourceentity instanceof AngellEntity) {
			AIAngellProcedure.execute(world, sourceentity);
		} else if (sourceentity instanceof SatushiEntity) {
			SatushiAIProcedure.execute(world, sourceentity);
			DomainsAIProcedure.execute(world, x, y, z, entity, sourceentity);
			SummonUraumeProcedure.execute(world, x, y, z, entity, sourceentity);
			SummonAllShadowsProcedure.execute(world, x, y, z, entity, sourceentity);
			DomainAmplificationDetectProcedure.execute(world, entity, sourceentity);
		} else if (sourceentity instanceof SukunaNoShirtEntity) {
			AISukunaWeakProcedure.execute(world, sourceentity);
		} else if (sourceentity instanceof YutaCullingGamesEntity) {
			YutaAIProcedure.execute(world, sourceentity);
			DomainsAIProcedure.execute(world, x, y, z, entity, sourceentity);
			RikaSpawnedTwoProcedure.execute(world, x, y, z, sourceentity);
			DomainAmplificationDetectProcedure.execute(world, entity, sourceentity);
		} else if (sourceentity instanceof AdjuchaEntity) {
			AdjuchaAIProcedure.execute(world, sourceentity);
			BeamEffectProcedure.execute(world, entity, sourceentity);
			DomainAmplificationDetectProcedure.execute(world, entity, sourceentity);
		} else if (sourceentity instanceof MakiPreparationEntity) {
			AIMakiZeninProcedure.execute(world, sourceentity);
		} else if (sourceentity instanceof KashimoFemboyEntity) {
			AIKashimoFemProcedure.execute(world, sourceentity);
			DomainAmplificationDetectProcedure.execute(world, entity, sourceentity);
		} else if (sourceentity instanceof HakariEntity) {
			AIHakariProcedure.execute(world, sourceentity);
			DomainsAIProcedure.execute(world, x, y, z, entity, sourceentity);
			DomainAmplificationDetectProcedure.execute(world, entity, sourceentity);
		} else if (sourceentity instanceof GojoMangaEntity) {
			AIGojoMangaProcedure.execute(world, sourceentity);
			DomainsAIProcedure.execute(world, x, y, z, entity, sourceentity);
			DomainAmplificationDetectProcedure.execute(world, entity, sourceentity);
		} else if (sourceentity instanceof GojoSchoolEntity) {
			AIGojoSchoolProcedure.execute(world, sourceentity);
		} else if (sourceentity instanceof SukunaFushiguroEntity || sourceentity instanceof SukunaMangaEntity || sourceentity instanceof IronkkEntity || sourceentity instanceof HusseinDongEntity) {
			AIMegunasProcedure.execute(world, entity, sourceentity);
			DomainsAIProcedure.execute(world, x, y, z, entity, sourceentity);
			DomainAmplificationDetectProcedure.execute(world, entity, sourceentity);
			if (Math.random() <= 0.05) {
				if (sourceentity instanceof LivingEntity _entity)
					_entity.swing(InteractionHand.MAIN_HAND, true);
			}
		} else if (sourceentity instanceof ItadoriShinjukuEntity) {
			AIBaseProcedure.execute(world, entity, sourceentity);
			DomainAmplificationDetectProcedure.execute(world, entity, sourceentity);
		} else if (sourceentity instanceof UraumeEntity) {
			UraumeAIProcedure.execute(world, entity, sourceentity);
			DomainAmplificationDetectProcedure.execute(world, entity, sourceentity);
		}
		if (sourceentity instanceof HusseinDongEntity) {
			SummonAllShadowsProcedure.execute(world, x, y, z, entity, sourceentity);
		}
	}
}
