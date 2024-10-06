
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.jujutsucraftaddon.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;

import net.mcreator.jujutsucraftaddon.entity.YutaCullingGamesEntity;
import net.mcreator.jujutsucraftaddon.entity.YeEntity;
import net.mcreator.jujutsucraftaddon.entity.VeilEntity;
import net.mcreator.jujutsucraftaddon.entity.UraumeEntity;
import net.mcreator.jujutsucraftaddon.entity.UiUiEntity;
import net.mcreator.jujutsucraftaddon.entity.UEntity;
import net.mcreator.jujutsucraftaddon.entity.TestingVersionEntity;
import net.mcreator.jujutsucraftaddon.entity.TestingEntityEntity;
import net.mcreator.jujutsucraftaddon.entity.TestProjectileEntity;
import net.mcreator.jujutsucraftaddon.entity.TanjerinaEntity;
import net.mcreator.jujutsucraftaddon.entity.SukunaREntity;
import net.mcreator.jujutsucraftaddon.entity.SukunaNoShirtEntity;
import net.mcreator.jujutsucraftaddon.entity.SukunaMangaEntity;
import net.mcreator.jujutsucraftaddon.entity.SukunaFushiguroEntity;
import net.mcreator.jujutsucraftaddon.entity.ShokoIeriSchoolEntity;
import net.mcreator.jujutsucraftaddon.entity.Shadow1Entity;
import net.mcreator.jujutsucraftaddon.entity.SatushiEntity;
import net.mcreator.jujutsucraftaddon.entity.RikoAmanaiEntity;
import net.mcreator.jujutsucraftaddon.entity.RedOEntity;
import net.mcreator.jujutsucraftaddon.entity.RedEntityEntity;
import net.mcreator.jujutsucraftaddon.entity.OutlineEntity;
import net.mcreator.jujutsucraftaddon.entity.MaleniaEntity;
import net.mcreator.jujutsucraftaddon.entity.MakiPreparationEntity;
import net.mcreator.jujutsucraftaddon.entity.KashimoFemboyEntity;
import net.mcreator.jujutsucraftaddon.entity.ItadoriShinjukuEntity;
import net.mcreator.jujutsucraftaddon.entity.IronkkEntity;
import net.mcreator.jujutsucraftaddon.entity.IgrisEntity;
import net.mcreator.jujutsucraftaddon.entity.HusseinDongEntity;
import net.mcreator.jujutsucraftaddon.entity.HakariEntity;
import net.mcreator.jujutsucraftaddon.entity.GojoSchoolEntity;
import net.mcreator.jujutsucraftaddon.entity.GojoMangaEntity;
import net.mcreator.jujutsucraftaddon.entity.GegeAkutamiEntity;
import net.mcreator.jujutsucraftaddon.entity.FakeClonesEntity;
import net.mcreator.jujutsucraftaddon.entity.CloneEntity;
import net.mcreator.jujutsucraftaddon.entity.CleaveWebEntity;
import net.mcreator.jujutsucraftaddon.entity.CircleEntity;
import net.mcreator.jujutsucraftaddon.entity.BulletProjectileEntity;
import net.mcreator.jujutsucraftaddon.entity.BlueEntityEntity;
import net.mcreator.jujutsucraftaddon.entity.AntiVeilEntity;
import net.mcreator.jujutsucraftaddon.entity.AngellEntity;
import net.mcreator.jujutsucraftaddon.entity.AdjuchaEntity;
import net.mcreator.jujutsucraftaddon.JujutsucraftaddonMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class JujutsucraftaddonModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, JujutsucraftaddonMod.MODID);
	public static final RegistryObject<EntityType<MakiPreparationEntity>> MAKI_PREPARATION = register("maki_preparation",
			EntityType.Builder.<MakiPreparationEntity>of(MakiPreparationEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(MakiPreparationEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<SukunaMangaEntity>> SUKUNA_MANGA = register("sukuna_manga",
			EntityType.Builder.<SukunaMangaEntity>of(SukunaMangaEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(SukunaMangaEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<SukunaNoShirtEntity>> SUKUNA_NO_SHIRT = register("sukuna_no_shirt",
			EntityType.Builder.<SukunaNoShirtEntity>of(SukunaNoShirtEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(SukunaNoShirtEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<ItadoriShinjukuEntity>> ITADORI_SHINJUKU = register("itadori_shinjuku",
			EntityType.Builder.<ItadoriShinjukuEntity>of(ItadoriShinjukuEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(ItadoriShinjukuEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<YutaCullingGamesEntity>> YUTA_CULLING_GAMES = register("yuta_culling_games",
			EntityType.Builder.<YutaCullingGamesEntity>of(YutaCullingGamesEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(YutaCullingGamesEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<RedOEntity>> RED_O = register("red_o",
			EntityType.Builder.<RedOEntity>of(RedOEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(RedOEntity::new).fireImmune().sized(0.6f, 1f));
	public static final RegistryObject<EntityType<CleaveWebEntity>> CLEAVE_WEB = register("cleave_web",
			EntityType.Builder.<CleaveWebEntity>of(CleaveWebEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CleaveWebEntity::new)

					.sized(0.5f, 1.8f));
	public static final RegistryObject<EntityType<SukunaFushiguroEntity>> SUKUNA_FUSHIGURO = register("sukuna_fushiguro",
			EntityType.Builder.<SukunaFushiguroEntity>of(SukunaFushiguroEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(SukunaFushiguroEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<GegeAkutamiEntity>> GEGE_AKUTAMI = register("gege_akutami",
			EntityType.Builder.<GegeAkutamiEntity>of(GegeAkutamiEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(GegeAkutamiEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<CircleEntity>> CIRCLE = register("circle",
			EntityType.Builder.<CircleEntity>of(CircleEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CircleEntity::new).fireImmune().sized(0.5f, 1.8f));
	public static final RegistryObject<EntityType<ShokoIeriSchoolEntity>> SHOKO_IERI_SCHOOL = register("shoko_ieri_school",
			EntityType.Builder.<ShokoIeriSchoolEntity>of(ShokoIeriSchoolEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(ShokoIeriSchoolEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<GojoMangaEntity>> GOJO_MANGA = register("gojo_manga",
			EntityType.Builder.<GojoMangaEntity>of(GojoMangaEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(GojoMangaEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<RikoAmanaiEntity>> RIKO_AMANAI = register("riko_amanai",
			EntityType.Builder.<RikoAmanaiEntity>of(RikoAmanaiEntity::new, MobCategory.AMBIENT).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(RikoAmanaiEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<TanjerinaEntity>> TANJERINA = register("tanjerina", EntityType.Builder.<TanjerinaEntity>of(TanjerinaEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
			.setUpdateInterval(3).setCustomClientFactory(TanjerinaEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<Shadow1Entity>> SHADOW_1 = register("shadow_1",
			EntityType.Builder.<Shadow1Entity>of(Shadow1Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(Shadow1Entity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<IgrisEntity>> IGRIS = register("igris",
			EntityType.Builder.<IgrisEntity>of(IgrisEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(IgrisEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<UiUiEntity>> UI_UI = register("ui_ui",
			EntityType.Builder.<UiUiEntity>of(UiUiEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(UiUiEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<BulletProjectileEntity>> BULLET_PROJECTILE = register("bullet_projectile", EntityType.Builder.<BulletProjectileEntity>of(BulletProjectileEntity::new, MobCategory.MISC)
			.setCustomClientFactory(BulletProjectileEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<RedEntityEntity>> RED_ENTITY = register("red_entity",
			EntityType.Builder.<RedEntityEntity>of(RedEntityEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(RedEntityEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<BlueEntityEntity>> BLUE_ENTITY = register("blue_entity",
			EntityType.Builder.<BlueEntityEntity>of(BlueEntityEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(BlueEntityEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<IronkkEntity>> IRONKK = register("ironkk",
			EntityType.Builder.<IronkkEntity>of(IronkkEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(IronkkEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<HusseinDongEntity>> HUSSEIN_DONG = register("hussein_dong",
			EntityType.Builder.<HusseinDongEntity>of(HusseinDongEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(HusseinDongEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<GojoSchoolEntity>> GOJO_SCHOOL = register("gojo_school",
			EntityType.Builder.<GojoSchoolEntity>of(GojoSchoolEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(GojoSchoolEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<HakariEntity>> HAKARI = register("hakari",
			EntityType.Builder.<HakariEntity>of(HakariEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(HakariEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<AngellEntity>> ANGELL = register("angell",
			EntityType.Builder.<AngellEntity>of(AngellEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(AngellEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<KashimoFemboyEntity>> KASHIMO_FEMBOY = register("kashimo_femboy",
			EntityType.Builder.<KashimoFemboyEntity>of(KashimoFemboyEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(KashimoFemboyEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<UraumeEntity>> URAUME = register("uraume",
			EntityType.Builder.<UraumeEntity>of(UraumeEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(UraumeEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<AdjuchaEntity>> ADJUCHA = register("adjucha",
			EntityType.Builder.<AdjuchaEntity>of(AdjuchaEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(AdjuchaEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<VeilEntity>> VEIL = register("veil",
			EntityType.Builder.<VeilEntity>of(VeilEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(VeilEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<SatushiEntity>> SATUSHI = register("satushi",
			EntityType.Builder.<SatushiEntity>of(SatushiEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(SatushiEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<TestProjectileEntity>> TEST_PROJECTILE = register("test_projectile",
			EntityType.Builder.<TestProjectileEntity>of(TestProjectileEntity::new, MobCategory.MISC).setCustomClientFactory(TestProjectileEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<AntiVeilEntity>> ANTI_VEIL = register("anti_veil",
			EntityType.Builder.<AntiVeilEntity>of(AntiVeilEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(AntiVeilEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<MaleniaEntity>> MALENIA = register("malenia",
			EntityType.Builder.<MaleniaEntity>of(MaleniaEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(MaleniaEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<OutlineEntity>> OUTLINE = register("outline",
			EntityType.Builder.<OutlineEntity>of(OutlineEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(OutlineEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<TestingEntityEntity>> TESTING_ENTITY = register("testing_entity",
			EntityType.Builder.<TestingEntityEntity>of(TestingEntityEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(TestingEntityEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<UEntity>> U = register("u",
			EntityType.Builder.<UEntity>of(UEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(UEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<TestingVersionEntity>> TESTING_VERSION = register("testing_version",
			EntityType.Builder.<TestingVersionEntity>of(TestingVersionEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(TestingVersionEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<YeEntity>> YE = register("ye",
			EntityType.Builder.<YeEntity>of(YeEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(YeEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<FakeClonesEntity>> FAKE_CLONES = register("fake_clones", EntityType.Builder.<FakeClonesEntity>of(FakeClonesEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
			.setUpdateInterval(3).setCustomClientFactory(FakeClonesEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<CloneEntity>> CLONE = register("clone",
			EntityType.Builder.<CloneEntity>of(CloneEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CloneEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<SukunaREntity>> SUKUNA_R = register("sukuna_r",
			EntityType.Builder.<SukunaREntity>of(SukunaREntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(256).setUpdateInterval(3).setCustomClientFactory(SukunaREntity::new)

					.sized(0.6f, 1.8f));

	private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			MakiPreparationEntity.init();
			SukunaMangaEntity.init();
			SukunaNoShirtEntity.init();
			ItadoriShinjukuEntity.init();
			YutaCullingGamesEntity.init();
			RedOEntity.init();
			CleaveWebEntity.init();
			SukunaFushiguroEntity.init();
			GegeAkutamiEntity.init();
			CircleEntity.init();
			ShokoIeriSchoolEntity.init();
			GojoMangaEntity.init();
			RikoAmanaiEntity.init();
			TanjerinaEntity.init();
			Shadow1Entity.init();
			IgrisEntity.init();
			UiUiEntity.init();
			RedEntityEntity.init();
			BlueEntityEntity.init();
			IronkkEntity.init();
			HusseinDongEntity.init();
			GojoSchoolEntity.init();
			HakariEntity.init();
			AngellEntity.init();
			KashimoFemboyEntity.init();
			UraumeEntity.init();
			AdjuchaEntity.init();
			VeilEntity.init();
			SatushiEntity.init();
			AntiVeilEntity.init();
			MaleniaEntity.init();
			OutlineEntity.init();
			TestingEntityEntity.init();
			UEntity.init();
			TestingVersionEntity.init();
			YeEntity.init();
			FakeClonesEntity.init();
			CloneEntity.init();
			SukunaREntity.init();
		});
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(MAKI_PREPARATION.get(), MakiPreparationEntity.createAttributes().build());
		event.put(SUKUNA_MANGA.get(), SukunaMangaEntity.createAttributes().build());
		event.put(SUKUNA_NO_SHIRT.get(), SukunaNoShirtEntity.createAttributes().build());
		event.put(ITADORI_SHINJUKU.get(), ItadoriShinjukuEntity.createAttributes().build());
		event.put(YUTA_CULLING_GAMES.get(), YutaCullingGamesEntity.createAttributes().build());
		event.put(RED_O.get(), RedOEntity.createAttributes().build());
		event.put(CLEAVE_WEB.get(), CleaveWebEntity.createAttributes().build());
		event.put(SUKUNA_FUSHIGURO.get(), SukunaFushiguroEntity.createAttributes().build());
		event.put(GEGE_AKUTAMI.get(), GegeAkutamiEntity.createAttributes().build());
		event.put(CIRCLE.get(), CircleEntity.createAttributes().build());
		event.put(SHOKO_IERI_SCHOOL.get(), ShokoIeriSchoolEntity.createAttributes().build());
		event.put(GOJO_MANGA.get(), GojoMangaEntity.createAttributes().build());
		event.put(RIKO_AMANAI.get(), RikoAmanaiEntity.createAttributes().build());
		event.put(TANJERINA.get(), TanjerinaEntity.createAttributes().build());
		event.put(SHADOW_1.get(), Shadow1Entity.createAttributes().build());
		event.put(IGRIS.get(), IgrisEntity.createAttributes().build());
		event.put(UI_UI.get(), UiUiEntity.createAttributes().build());
		event.put(RED_ENTITY.get(), RedEntityEntity.createAttributes().build());
		event.put(BLUE_ENTITY.get(), BlueEntityEntity.createAttributes().build());
		event.put(IRONKK.get(), IronkkEntity.createAttributes().build());
		event.put(HUSSEIN_DONG.get(), HusseinDongEntity.createAttributes().build());
		event.put(GOJO_SCHOOL.get(), GojoSchoolEntity.createAttributes().build());
		event.put(HAKARI.get(), HakariEntity.createAttributes().build());
		event.put(ANGELL.get(), AngellEntity.createAttributes().build());
		event.put(KASHIMO_FEMBOY.get(), KashimoFemboyEntity.createAttributes().build());
		event.put(URAUME.get(), UraumeEntity.createAttributes().build());
		event.put(ADJUCHA.get(), AdjuchaEntity.createAttributes().build());
		event.put(VEIL.get(), VeilEntity.createAttributes().build());
		event.put(SATUSHI.get(), SatushiEntity.createAttributes().build());
		event.put(ANTI_VEIL.get(), AntiVeilEntity.createAttributes().build());
		event.put(MALENIA.get(), MaleniaEntity.createAttributes().build());
		event.put(OUTLINE.get(), OutlineEntity.createAttributes().build());
		event.put(TESTING_ENTITY.get(), TestingEntityEntity.createAttributes().build());
		event.put(U.get(), UEntity.createAttributes().build());
		event.put(TESTING_VERSION.get(), TestingVersionEntity.createAttributes().build());
		event.put(YE.get(), YeEntity.createAttributes().build());
		event.put(FAKE_CLONES.get(), FakeClonesEntity.createAttributes().build());
		event.put(CLONE.get(), CloneEntity.createAttributes().build());
		event.put(SUKUNA_R.get(), SukunaREntity.createAttributes().build());
	}
}
