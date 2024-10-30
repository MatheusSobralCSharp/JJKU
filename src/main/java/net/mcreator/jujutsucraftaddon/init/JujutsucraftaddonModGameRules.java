
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.jujutsucraftaddon.init;

import net.minecraftforge.fml.common.Mod;

import net.minecraft.world.level.GameRules;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class JujutsucraftaddonModGameRules {
	public static final GameRules.Key<GameRules.IntegerValue> JJKU_DIFFICULTY = GameRules.register("jjkuDifficulty", GameRules.Category.MISC, GameRules.IntegerValue.create(100));
	public static final GameRules.Key<GameRules.BooleanValue> JJKU_GOJO_ONLY_SIX_EYES = GameRules.register("jjkuGojoOnlySixEyes", GameRules.Category.MISC, GameRules.BooleanValue.create(false));
	public static final GameRules.Key<GameRules.BooleanValue> JJKU_HARDCORE_MODE = GameRules.register("jjkuHardcoreMode", GameRules.Category.MOBS, GameRules.BooleanValue.create(false));
	public static final GameRules.Key<GameRules.BooleanValue> JJKU_ANIMATIONS = GameRules.register("jjkuAnimations", GameRules.Category.MISC, GameRules.BooleanValue.create(true));
	public static final GameRules.Key<GameRules.BooleanValue> JJKU_SPAWN_OVERWORLD = GameRules.register("jjkuSpawnOverworld", GameRules.Category.MISC, GameRules.BooleanValue.create(false));
	public static final GameRules.Key<GameRules.IntegerValue> JJKU_SUKUNA_RATE = GameRules.register("jjkuSukunaRate", GameRules.Category.SPAWNING, GameRules.IntegerValue.create(100));
	public static final GameRules.Key<GameRules.IntegerValue> JJKU_GOJO_RATE = GameRules.register("jjkuGojoRate", GameRules.Category.MISC, GameRules.IntegerValue.create(100));
	public static final GameRules.Key<GameRules.BooleanValue> JJKU_NO_OPEN_FOR_SUKUNA = GameRules.register("jjkuNoOpenForSukuna", GameRules.Category.MISC, GameRules.BooleanValue.create(false));
	public static final GameRules.Key<GameRules.BooleanValue> JJKU_SPAWN_CHANGER = GameRules.register("jjkuSpawnChanger", GameRules.Category.SPAWNING, GameRules.BooleanValue.create(false));
	public static final GameRules.Key<GameRules.IntegerValue> JJKU_CURSED_SPIRIT_RATE = GameRules.register("jjkuCursedSpiritRate", GameRules.Category.SPAWNING, GameRules.IntegerValue.create(100));
	public static final GameRules.Key<GameRules.IntegerValue> JJKU_CURSE_USERS_RATE = GameRules.register("jjkuCurseUsersRate", GameRules.Category.SPAWNING, GameRules.IntegerValue.create(100));
	public static final GameRules.Key<GameRules.IntegerValue> JJKU_SORCERERS_RATE = GameRules.register("jjkuSorcerersRate", GameRules.Category.SPAWNING, GameRules.IntegerValue.create(100));
	public static final GameRules.Key<GameRules.IntegerValue> JJKU_TOJI_RATE = GameRules.register("jjkuTojiRate", GameRules.Category.SPAWNING, GameRules.IntegerValue.create(100));
	public static final GameRules.Key<GameRules.BooleanValue> JJKU_NO_VANILLA = GameRules.register("jjkuNoVanilla", GameRules.Category.SPAWNING, GameRules.BooleanValue.create(false));
	public static final GameRules.Key<GameRules.BooleanValue> JJKU_CE_REGEN = GameRules.register("jjkuCERegen", GameRules.Category.MISC, GameRules.BooleanValue.create(false));
	public static final GameRules.Key<GameRules.BooleanValue> JJKU_DOMAIN_NERF = GameRules.register("jjkuDomainNerf", GameRules.Category.MISC, GameRules.BooleanValue.create(true));
	public static final GameRules.Key<GameRules.BooleanValue> JJKU_KENJAKU_LIMIT = GameRules.register("jjkuKenjakuLimit", GameRules.Category.MISC, GameRules.BooleanValue.create(false));
	public static final GameRules.Key<GameRules.BooleanValue> JJKU_ZONE_STACK = GameRules.register("jjkuZoneStack", GameRules.Category.MISC, GameRules.BooleanValue.create(true));
	public static final GameRules.Key<GameRules.IntegerValue> JJKU_DROP_RATE = GameRules.register("jjkuDropRate", GameRules.Category.DROPS, GameRules.IntegerValue.create(100));
	public static final GameRules.Key<GameRules.BooleanValue> JJKU_NO_BLACK_FLASH_CUTSCENE = GameRules.register("jjkuNoBlackFlashCutscene", GameRules.Category.MISC, GameRules.BooleanValue.create(false));
	public static final GameRules.Key<GameRules.BooleanValue> JJKU_NO_STEVENSON = GameRules.register("jjkuNoStevenson", GameRules.Category.SPAWNING, GameRules.BooleanValue.create(false));
	public static final GameRules.Key<GameRules.BooleanValue> JJKU_NO_ARMORY_SPIRIT = GameRules.register("jjkuNoArmorySpirit", GameRules.Category.SPAWNING, GameRules.BooleanValue.create(false));
	public static final GameRules.Key<GameRules.BooleanValue> JJKU_CULLING_GAMES = GameRules.register("jjkuCullingGames", GameRules.Category.MISC, GameRules.BooleanValue.create(false));
	public static final GameRules.Key<GameRules.BooleanValue> JJKU_RANDOM_CT = GameRules.register("jjkuRandomCT", GameRules.Category.MISC, GameRules.BooleanValue.create(false));
	public static final GameRules.Key<GameRules.BooleanValue> JJKU_SUKUNA_POSSESSION_ENABLED = GameRules.register("jjkuSukunaPossessionEnabled", GameRules.Category.MISC, GameRules.BooleanValue.create(true));
	public static final GameRules.Key<GameRules.BooleanValue> JJKU_OST_PLAYER = GameRules.register("jjkuOstPlayer", GameRules.Category.MISC, GameRules.BooleanValue.create(true));
	public static final GameRules.Key<GameRules.BooleanValue> JJKU_SUKUNA_POSSESSION_PER_LIFE = GameRules.register("jjkuSukunaPossessionPerLife", GameRules.Category.MISC, GameRules.BooleanValue.create(true));
	public static final GameRules.Key<GameRules.BooleanValue> JJKU_MOB_OSTS = GameRules.register("jjkuMobOsts", GameRules.Category.MISC, GameRules.BooleanValue.create(true));
	public static final GameRules.Key<GameRules.BooleanValue> JJKU_NPC_FISTS = GameRules.register("jjkuNpcFists", GameRules.Category.MOBS, GameRules.BooleanValue.create(true));
	public static final GameRules.Key<GameRules.BooleanValue> JJKU_LIMB_LOSS = GameRules.register("jjkuLimbLoss", GameRules.Category.MISC, GameRules.BooleanValue.create(false));
	public static final GameRules.Key<GameRules.BooleanValue> JJKU_AIR_COMBAT = GameRules.register("jjkuAirCombat", GameRules.Category.MISC, GameRules.BooleanValue.create(false));
	public static final GameRules.Key<GameRules.IntegerValue> JJKU_LIMB_LOSS_SPEED = GameRules.register("jjkuLimbLossSpeed", GameRules.Category.MISC, GameRules.IntegerValue.create(1));
	public static final GameRules.Key<GameRules.IntegerValue> JJKU_CURSED_SPIRIT_REGEN = GameRules.register("jjkuCursedSpiritRegen", GameRules.Category.MOBS, GameRules.IntegerValue.create(0));
	public static final GameRules.Key<GameRules.BooleanValue> JJKU_OVERPOWERED_STUFF = GameRules.register("jjkuOverpoweredStuff", GameRules.Category.MISC, GameRules.BooleanValue.create(true));
	public static final GameRules.Key<GameRules.BooleanValue> JJKU_CAN_TAME_SUKUNA = GameRules.register("jjkuCanTameSukuna", GameRules.Category.MISC, GameRules.BooleanValue.create(false));
	public static final GameRules.Key<GameRules.BooleanValue> JJKU_CE_MODIFIER = GameRules.register("jjkuCEModifier", GameRules.Category.MISC, GameRules.BooleanValue.create(true));
	public static final GameRules.Key<GameRules.IntegerValue> JJKU_SUKUNA_POSSESSION_RATE = GameRules.register("jjkuSukunaPossessionRate", GameRules.Category.MISC, GameRules.IntegerValue.create(1));
	public static final GameRules.Key<GameRules.BooleanValue> JJKU_RCT_LIMIT = GameRules.register("jjkuRCTLimit", GameRules.Category.MISC, GameRules.BooleanValue.create(true));
	public static final GameRules.Key<GameRules.BooleanValue> JJKU_TAKABA_REMOVE_ARMOR = GameRules.register("jjkuTakabaRemoveArmor", GameRules.Category.MISC, GameRules.BooleanValue.create(true));
	public static final GameRules.Key<GameRules.BooleanValue> JJKU_NO_COOLDOWN = GameRules.register("jjkuNoCooldown", GameRules.Category.MISC, GameRules.BooleanValue.create(false));
	public static final GameRules.Key<GameRules.IntegerValue> JJKU_ZONE_STACK_CAP = GameRules.register("jjkuZoneStackCap", GameRules.Category.MISC, GameRules.IntegerValue.create(100));
	public static final GameRules.Key<GameRules.BooleanValue> JJKU_WATER_WALK = GameRules.register("jjkuWaterWalk", GameRules.Category.MISC, GameRules.BooleanValue.create(false));
	public static final GameRules.Key<GameRules.BooleanValue> JJKU_AUTO_RCT = GameRules.register("jjkuAutoRCT", GameRules.Category.MISC, GameRules.BooleanValue.create(true));
	public static final GameRules.Key<GameRules.BooleanValue> JJKU_CAN_STEAL_GOJO = GameRules.register("jjkuCanStealGojo", GameRules.Category.MISC, GameRules.BooleanValue.create(true));
	public static final GameRules.Key<GameRules.IntegerValue> JJKU_SUKUNA_HEALTH_POSSESSION = GameRules.register("jjkuSukunaHealthPossession", GameRules.Category.MISC, GameRules.IntegerValue.create(40));
	public static final GameRules.Key<GameRules.BooleanValue> JJKU_MAHORAGA_CAN_ADAPT_EVERYTHING = GameRules.register("jjkuMahoragaCanAdaptEverything", GameRules.Category.MISC, GameRules.BooleanValue.create(false));
	public static final GameRules.Key<GameRules.IntegerValue> JJKU_HP_CAP = GameRules.register("jjkuHPCap", GameRules.Category.MISC, GameRules.IntegerValue.create(1000));
	public static final GameRules.Key<GameRules.IntegerValue> JJKU_RCT_LEVEL_CAP = GameRules.register("jjkuRCTLevelCap", GameRules.Category.MISC, GameRules.IntegerValue.create(20));
	public static final GameRules.Key<GameRules.BooleanValue> ENABLE_SUKUNA_PVP = GameRules.register("enableSukunaPVP", GameRules.Category.MISC, GameRules.BooleanValue.create(false));
	public static final GameRules.Key<GameRules.BooleanValue> JJKU_CAN_SUKUNA_GET_ADVANCEMENTS = GameRules.register("jjkuCanSukunaGetAdvancements", GameRules.Category.MISC, GameRules.BooleanValue.create(false));
	public static final GameRules.Key<GameRules.IntegerValue> JJKU_PURPLE_RANGE = GameRules.register("jjkuPurpleRange", GameRules.Category.MISC, GameRules.IntegerValue.create(200));
	public static final GameRules.Key<GameRules.IntegerValue> JJKU_DESTRUCTION_LEVEL = GameRules.register("jjkuDestructionLevel", GameRules.Category.MISC, GameRules.IntegerValue.create(1));
	public static final GameRules.Key<GameRules.IntegerValue> JJKU_SIX_EYES_LEVEL = GameRules.register("jjkuSixEyesLevel", GameRules.Category.MISC, GameRules.IntegerValue.create(1));
	public static final GameRules.Key<GameRules.IntegerValue> JJKU_SUKUNA_LEVEL = GameRules.register("jjkuSukunaLevel", GameRules.Category.MISC, GameRules.IntegerValue.create(5));
	public static final GameRules.Key<GameRules.BooleanValue> JJKU_TUCA_DONCA = GameRules.register("jjkuTucaDonca", GameRules.Category.MISC, GameRules.BooleanValue.create(true));
	public static final GameRules.Key<GameRules.IntegerValue> JJKU_YOROZU_SPHERE_LIMIT = GameRules.register("jjkuYorozuSphereLimit", GameRules.Category.MISC, GameRules.IntegerValue.create(30));
	public static final GameRules.Key<GameRules.IntegerValue> JJKU_IDLE_TRANSFIGURATION_LEVEL = GameRules.register("jjkuIdleTransfigurationLevel", GameRules.Category.MISC, GameRules.IntegerValue.create(1));
	public static final GameRules.Key<GameRules.BooleanValue> JJKU_BLACK_FLASH_REWORKED = GameRules.register("jjkuBlackFlashReworked", GameRules.Category.MISC, GameRules.BooleanValue.create(true));
	public static final GameRules.Key<GameRules.IntegerValue> JJKU_RIKA_PURE_LOVE = GameRules.register("jjkuRikaPureLove", GameRules.Category.PLAYER, GameRules.IntegerValue.create(2));
	public static final GameRules.Key<GameRules.IntegerValue> JJKU_FATIGUE_RATE = GameRules.register("jjkuFatigueRate", GameRules.Category.MISC, GameRules.IntegerValue.create(20));
	public static final GameRules.Key<GameRules.BooleanValue> JJKU_CURSED_SPIRIT_RCT = GameRules.register("jjkuCursedSpiritRCT", GameRules.Category.MISC, GameRules.BooleanValue.create(false));
	public static final GameRules.Key<GameRules.BooleanValue> JJKU_HISTORY_MODE = GameRules.register("jjkuHistoryMode", GameRules.Category.MISC, GameRules.BooleanValue.create(true));
	public static final GameRules.Key<GameRules.IntegerValue> JJKU_CE_CAP = GameRules.register("jjkuCECap", GameRules.Category.MISC, GameRules.IntegerValue.create(2400));
	public static final GameRules.Key<GameRules.BooleanValue> JJKM_NO_DROPS = GameRules.register("jjkmNoDrops", GameRules.Category.MISC, GameRules.BooleanValue.create(false));
	public static final GameRules.Key<GameRules.BooleanValue> JJKM_NO_POWER_PROGRESSION = GameRules.register("jjkmNoPowerProgression", GameRules.Category.MISC, GameRules.BooleanValue.create(false));
	public static final GameRules.Key<GameRules.BooleanValue> JJKM_WUKONG = GameRules.register("jjkmWukong", GameRules.Category.MISC, GameRules.BooleanValue.create(false));
	public static final GameRules.Key<GameRules.IntegerValue> JJKU_MOB_SPAWNING_RATE = GameRules.register("jjkuMobSpawningRate", GameRules.Category.SPAWNING, GameRules.IntegerValue.create(1));
	public static final GameRules.Key<GameRules.BooleanValue> JJKU_ONLY_ONE_SUKUNA = GameRules.register("jjkuOnlyOneSukuna", GameRules.Category.MISC, GameRules.BooleanValue.create(false));
	public static final GameRules.Key<GameRules.BooleanValue> JJKU_BGM = GameRules.register("jjkuBGM", GameRules.Category.MISC, GameRules.BooleanValue.create(false));
	public static final GameRules.Key<GameRules.BooleanValue> JJKU_CAN_STEAL_SKIN = GameRules.register("jjkuCanStealSkin", GameRules.Category.MISC, GameRules.BooleanValue.create(false));
	public static final GameRules.Key<GameRules.IntegerValue> JJKUR_SYSTEM_DIFFICULTY = GameRules.register("jjkurSystemDifficulty", GameRules.Category.MISC, GameRules.IntegerValue.create(1));
	public static final GameRules.Key<GameRules.BooleanValue> JJKUR_REGENERATE_SHIKIGAMI = GameRules.register("jjkurRegenerateShikigami", GameRules.Category.MISC, GameRules.BooleanValue.create(true));
	public static final GameRules.Key<GameRules.IntegerValue> JJKU_GOJO_TP = GameRules.register("jjkuGojoTP", GameRules.Category.MISC, GameRules.IntegerValue.create(20));
}
