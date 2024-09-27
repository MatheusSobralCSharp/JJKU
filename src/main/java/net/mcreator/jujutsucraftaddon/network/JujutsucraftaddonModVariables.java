package net.mcreator.jujutsucraftaddon.network;

import org.jline.reader.History;

import org.apache.http.conn.util.DomainType;

import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.Capability;

import net.minecraft.world.scores.Team;
import net.minecraft.world.level.saveddata.SavedData;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.nbt.Tag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Direction;
import net.minecraft.client.Minecraft;

import net.mcreator.jujutsucraftaddon.JujutsucraftaddonMod;

import java.util.function.Supplier;

import com.ibm.icu.util.Output;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class JujutsucraftaddonModVariables {
	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		JujutsucraftaddonMod.addNetworkMessage(SavedDataSyncMessage.class, SavedDataSyncMessage::buffer, SavedDataSyncMessage::new, SavedDataSyncMessage::handler);
		JujutsucraftaddonMod.addNetworkMessage(PlayerVariablesSyncMessage.class, PlayerVariablesSyncMessage::buffer, PlayerVariablesSyncMessage::new, PlayerVariablesSyncMessage::handler);
	}

	@SubscribeEvent
	public static void init(RegisterCapabilitiesEvent event) {
		event.register(PlayerVariables.class);
	}

	@Mod.EventBusSubscriber
	public static class EventBusVariableHandlers {
		@SubscribeEvent
		public static void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
			if (!event.getEntity().level().isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
			if (!event.getEntity().level().isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (!event.getEntity().level().isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void clonePlayer(PlayerEvent.Clone event) {
			event.getOriginal().revive();
			PlayerVariables original = ((PlayerVariables) event.getOriginal().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
			PlayerVariables clone = ((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
			clone.InventoryArmorySlot1 = original.InventoryArmorySlot1;
			clone.slot0 = original.slot0;
			clone.slot1 = original.slot1;
			clone.slot2 = original.slot2;
			clone.slot3 = original.slot3;
			clone.slot4 = original.slot4;
			clone.slot5 = original.slot5;
			clone.slot6 = original.slot6;
			clone.slot7 = original.slot7;
			clone.slot8 = original.slot8;
			clone.slot9 = original.slot9;
			clone.slot10 = original.slot10;
			clone.slot11 = original.slot11;
			clone.slot12 = original.slot12;
			clone.slot13 = original.slot13;
			clone.slot14 = original.slot14;
			clone.slot15 = original.slot15;
			clone.slot16 = original.slot16;
			clone.slot17 = original.slot17;
			clone.slot18 = original.slot18;
			clone.slot19 = original.slot19;
			clone.DomainAmplification = original.DomainAmplification;
			clone.RCTOutput = original.RCTOutput;
			clone.NueTotality = original.NueTotality;
			clone.AgitoBeast = original.AgitoBeast;
			clone.Hakari = original.Hakari;
			clone.Higuruma = original.Higuruma;
			clone.BarrierlessDomain = original.BarrierlessDomain;
			clone.BurnOutRCT = original.BurnOutRCT;
			clone.MasteryRCT = original.MasteryRCT;
			clone.BarrierDomainForMegumi = original.BarrierDomainForMegumi;
			clone.YutaDomainAdvanced = original.YutaDomainAdvanced;
			clone.RCTMasteryOn = original.RCTMasteryOn;
			clone.SimpleDomain = original.SimpleDomain;
			clone.ChantsMastery = original.ChantsMastery;
			clone.IsJujutsuSorcerer = original.IsJujutsuSorcerer;
			clone.IsCursedSpirit = original.IsCursedSpirit;
			clone.InfusedDomain = original.InfusedDomain;
			clone.IsVessel = original.IsVessel;
			clone.WorldSlash = original.WorldSlash;
			clone.IsSukuna = original.IsSukuna;
			clone.save = original.save;
			clone.IsInumaki = original.IsInumaki;
			clone.FutureSight = original.FutureSight;
			clone.Flying = original.Flying;
			clone.Fly = original.Fly;
			clone.Fallings = original.Fallings;
			clone.Running = original.Running;
			clone.save1 = original.save1;
			clone.Sneaking = original.Sneaking;
			clone.RidingCursedSpirit = original.RidingCursedSpirit;
			clone.BarrierlessDomainNumber = original.BarrierlessDomainNumber;
			clone.RCTMastery = original.RCTMastery;
			clone.MimicryKatana = original.MimicryKatana;
			clone.DomainKatana = original.DomainKatana;
			clone.FutureSightNumber = original.FutureSightNumber;
			clone.CE = original.CE;
			clone.sokamona = original.sokamona;
			clone.Murasaki = original.Murasaki;
			clone.Purple = original.Purple;
			clone.CT = original.CT;
			clone.Limb = original.Limb;
			clone.RCTRegen = original.RCTRegen;
			clone.GojoQuest = original.GojoQuest;
			clone.CursedSpiritsKilled = original.CursedSpiritsKilled;
			clone.GojoFlight = original.GojoFlight;
			clone.Fist = original.Fist;
			clone.RCTCount = original.RCTCount;
			clone.TeleportX = original.TeleportX;
			clone.TeleportY = original.TeleportY;
			clone.TeleportZ = original.TeleportZ;
			clone.ItadoriCount = original.ItadoriCount;
			clone.CursedLevel = original.CursedLevel;
			clone.Clans = original.Clans;
			clone.RecoveryCooldown = original.RecoveryCooldown;
			clone.BrainCooldown = original.BrainCooldown;
			clone.RCTOutputActive = original.RCTOutputActive;
			clone.Yukuzi = original.Yukuzi;
			clone.AnimationYuzuki = original.AnimationYuzuki;
			clone.AnimationDefense = original.AnimationDefense;
			clone.AttackAnimation = original.AttackAnimation;
			clone.AirAnimation = original.AirAnimation;
			clone.Kokusen = original.Kokusen;
			clone.RecoverAnimation = original.RecoverAnimation;
			clone.LockON = original.LockON;
			clone.LockOn = original.LockOn;
			clone.HealthAttribute = original.HealthAttribute;
			clone.DomainCounter = original.DomainCounter;
			clone.gojosund = original.gojosund;
			clone.ability = original.ability;
			clone.GUI = original.GUI;
			clone.GUIWHEEL = original.GUIWHEEL;
			clone.AnimationSlash = original.AnimationSlash;
			clone.Season1 = original.Season1;
			clone.fixadose = original.fixadose;
			clone.Team = original.Team;
			clone.barrierless = original.barrierless;
			clone.timerburnout = original.timerburnout;
			clone.rctmastery = original.rctmastery;
			clone.worldslashtimer = original.worldslashtimer;
			clone.gojoimbuedtick = original.gojoimbuedtick;
			clone.HRREGEN = original.HRREGEN;
			clone.Clantick = original.Clantick;
			clone.tickgeneral = original.tickgeneral;
			clone.mahoragacontrol = original.mahoragacontrol;
			clone.ticklevel = original.ticklevel;
			clone.brainburnout = original.brainburnout;
			clone.timerhakari = original.timerhakari;
			clone.fuga = original.fuga;
			clone.rctouput = original.rctouput;
			clone.ItadoriAwakening = original.ItadoriAwakening;
			clone.Trait = original.Trait;
			clone.ClanSlot1 = original.ClanSlot1;
			clone.ClanSlot2 = original.ClanSlot2;
			clone.ClanSlot3 = original.ClanSlot3;
			clone.FingerCount = original.FingerCount;
			clone.Running1 = original.Running1;
			clone.PlayerLevel = original.PlayerLevel;
			clone.CTName = original.CTName;
			clone.NamePlayer = original.NamePlayer;
			clone.CEFormer = original.CEFormer;
			clone.CERet = original.CERet;
			clone.BFChance = original.BFChance;
			clone.KenjakuCT1 = original.KenjakuCT1;
			clone.KenjakuCT2 = original.KenjakuCT2;
			clone.Copy1 = original.Copy1;
			clone.Copy2 = original.Copy2;
			clone.Copy3 = original.Copy3;
			clone.Copy4 = original.Copy4;
			clone.Subrace = original.Subrace;
			clone.Output = original.Output;
			clone.Mode = original.Mode;
			clone.Run = original.Run;
			clone.TeamName = original.TeamName;
			clone.DomainVariable = original.DomainVariable;
			clone.rctlevel = original.rctlevel;
			clone.keycheck = original.keycheck;
			clone.Damage = original.Damage;
			clone.water = original.water;
			clone.CEShield = original.CEShield;
			clone.pressed = original.pressed;
			clone.locker = original.locker;
			clone.YutaCheck = original.YutaCheck;
			clone.MahoragaCanAdapt = original.MahoragaCanAdapt;
			clone.RadiusDomain = original.RadiusDomain;
			clone.RCTLimitLevel = original.RCTLimitLevel;
			clone.SimpleDomainLevel = original.SimpleDomainLevel;
			clone.friend_num = original.friend_num;
			clone.blackflashmastery = original.blackflashmastery;
			clone.Profession = original.Profession;
			clone.ProfessionEXP = original.ProfessionEXP;
			clone.Element = original.Element;
			clone.Level = original.Level;
			clone.History = original.History;
			clone.VowPower = original.VowPower;
			clone.Vow2 = original.Vow2;
			clone.Vow3 = original.Vow3;
			clone.sp = original.sp;
			clone.QuestOutput = original.QuestOutput;
			clone.QuestActive = original.QuestActive;
			clone.Description = original.Description;
			clone.Healed = original.Healed;
			clone.SimpleQuest = original.SimpleQuest;
			clone.CooldownExp = original.CooldownExp;
			clone.Mastery = original.Mastery;
			clone.RCTCount2 = original.RCTCount2;
			clone.CEPlus = original.CEPlus;
			clone.BarrierlessCount = original.BarrierlessCount;
			clone.random = original.random;
			clone.CECap = original.CECap;
			clone.GH = original.GH;
			clone.SH = original.SH;
			clone.Mahoraga = original.Mahoraga;
			clone.TrueTechnique = original.TrueTechnique;
			if (!event.isWasDeath()) {
				clone.InventoryArmorySlot0 = original.InventoryArmorySlot0;
				clone.InventoryArmorySlot2 = original.InventoryArmorySlot2;
				clone.InventoryArmorySlot3 = original.InventoryArmorySlot3;
				clone.InventoryArmorySlot4 = original.InventoryArmorySlot4;
				clone.BarrierLessCD = original.BarrierLessCD;
				clone.CooldownAgain = original.CooldownAgain;
				clone.BrainDamage = original.BrainDamage;
				clone.timer = original.timer;
				clone.DataSixEyesOne = original.DataSixEyesOne;
				clone.Technique = original.Technique;
				clone.TickCounter = original.TickCounter;
				clone.TickCounter2 = original.TickCounter2;
				clone.tickcounter3 = original.tickcounter3;
				clone.Timer1 = original.Timer1;
				clone.Points = original.Points;
				clone.cd1 = original.cd1;
				clone.cd2 = original.cd2;
				clone.OutputLevel = original.OutputLevel;
				clone.TimeLeft = original.TimeLeft;
				clone.DomainType = original.DomainType;
				clone.DomainSizeVariable = original.DomainSizeVariable;
				clone.Vow4 = original.Vow4;
			}
		}

		@SubscribeEvent
		public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
			if (!event.getEntity().level().isClientSide()) {
				SavedData mapdata = MapVariables.get(event.getEntity().level());
				SavedData worlddata = WorldVariables.get(event.getEntity().level());
				if (mapdata != null)
					JujutsucraftaddonMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getEntity()), new SavedDataSyncMessage(0, mapdata));
				if (worlddata != null)
					JujutsucraftaddonMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getEntity()), new SavedDataSyncMessage(1, worlddata));
			}
		}

		@SubscribeEvent
		public static void onPlayerChangedDimension(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (!event.getEntity().level().isClientSide()) {
				SavedData worlddata = WorldVariables.get(event.getEntity().level());
				if (worlddata != null)
					JujutsucraftaddonMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getEntity()), new SavedDataSyncMessage(1, worlddata));
			}
		}
	}

	public static class WorldVariables extends SavedData {
		public static final String DATA_NAME = "jujutsucraftaddon_worldvars";

		public static WorldVariables load(CompoundTag tag) {
			WorldVariables data = new WorldVariables();
			data.read(tag);
			return data;
		}

		public void read(CompoundTag nbt) {
		}

		@Override
		public CompoundTag save(CompoundTag nbt) {
			return nbt;
		}

		public void syncData(LevelAccessor world) {
			this.setDirty();
			if (world instanceof Level level && !level.isClientSide())
				JujutsucraftaddonMod.PACKET_HANDLER.send(PacketDistributor.DIMENSION.with(level::dimension), new SavedDataSyncMessage(1, this));
		}

		static WorldVariables clientSide = new WorldVariables();

		public static WorldVariables get(LevelAccessor world) {
			if (world instanceof ServerLevel level) {
				return level.getDataStorage().computeIfAbsent(e -> WorldVariables.load(e), WorldVariables::new, DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public static class MapVariables extends SavedData {
		public static final String DATA_NAME = "jujutsucraftaddon_mapvars";
		public double HR = 0;
		public BlockState BlockType = Blocks.AIR.defaultBlockState();
		public Direction BlockDirection = Direction.NORTH;
		public double DomainExpansion = 0;
		public double map = 0;
		public double Setup = 0;

		public static MapVariables load(CompoundTag tag) {
			MapVariables data = new MapVariables();
			data.read(tag);
			return data;
		}

		public void read(CompoundTag nbt) {
			HR = nbt.getDouble("HR");
			BlockType = NbtUtils.readBlockState(BuiltInRegistries.BLOCK.asLookup(), nbt.getCompound("BlockType"));
			BlockDirection = Direction.from3DDataValue(nbt.getInt("BlockDirection"));
			DomainExpansion = nbt.getDouble("DomainExpansion");
			map = nbt.getDouble("map");
			Setup = nbt.getDouble("Setup");
		}

		@Override
		public CompoundTag save(CompoundTag nbt) {
			nbt.putDouble("HR", HR);
			nbt.put("BlockType", NbtUtils.writeBlockState(BlockType));
			nbt.putInt("BlockDirection", BlockDirection.get3DDataValue());
			nbt.putDouble("DomainExpansion", DomainExpansion);
			nbt.putDouble("map", map);
			nbt.putDouble("Setup", Setup);
			return nbt;
		}

		public void syncData(LevelAccessor world) {
			this.setDirty();
			if (world instanceof Level && !world.isClientSide())
				JujutsucraftaddonMod.PACKET_HANDLER.send(PacketDistributor.ALL.noArg(), new SavedDataSyncMessage(0, this));
		}

		static MapVariables clientSide = new MapVariables();

		public static MapVariables get(LevelAccessor world) {
			if (world instanceof ServerLevelAccessor serverLevelAcc) {
				return serverLevelAcc.getLevel().getServer().getLevel(Level.OVERWORLD).getDataStorage().computeIfAbsent(e -> MapVariables.load(e), MapVariables::new, DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public static class SavedDataSyncMessage {
		private final int type;
		private SavedData data;

		public SavedDataSyncMessage(FriendlyByteBuf buffer) {
			this.type = buffer.readInt();
			CompoundTag nbt = buffer.readNbt();
			if (nbt != null) {
				this.data = this.type == 0 ? new MapVariables() : new WorldVariables();
				if (this.data instanceof MapVariables mapVariables)
					mapVariables.read(nbt);
				else if (this.data instanceof WorldVariables worldVariables)
					worldVariables.read(nbt);
			}
		}

		public SavedDataSyncMessage(int type, SavedData data) {
			this.type = type;
			this.data = data;
		}

		public static void buffer(SavedDataSyncMessage message, FriendlyByteBuf buffer) {
			buffer.writeInt(message.type);
			if (message.data != null)
				buffer.writeNbt(message.data.save(new CompoundTag()));
		}

		public static void handler(SavedDataSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer() && message.data != null) {
					if (message.type == 0)
						MapVariables.clientSide = (MapVariables) message.data;
					else
						WorldVariables.clientSide = (WorldVariables) message.data;
				}
			});
			context.setPacketHandled(true);
		}
	}

	public static final Capability<PlayerVariables> PLAYER_VARIABLES_CAPABILITY = CapabilityManager.get(new CapabilityToken<PlayerVariables>() {
	});

	@Mod.EventBusSubscriber
	private static class PlayerVariablesProvider implements ICapabilitySerializable<Tag> {
		@SubscribeEvent
		public static void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event) {
			if (event.getObject() instanceof Player && !(event.getObject() instanceof FakePlayer))
				event.addCapability(new ResourceLocation("jujutsucraftaddon", "player_variables"), new PlayerVariablesProvider());
		}

		private final PlayerVariables playerVariables = new PlayerVariables();
		private final LazyOptional<PlayerVariables> instance = LazyOptional.of(() -> playerVariables);

		@Override
		public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
			return cap == PLAYER_VARIABLES_CAPABILITY ? instance.cast() : LazyOptional.empty();
		}

		@Override
		public Tag serializeNBT() {
			return playerVariables.writeNBT();
		}

		@Override
		public void deserializeNBT(Tag nbt) {
			playerVariables.readNBT(nbt);
		}
	}

	public static class PlayerVariables {
		public ItemStack InventoryArmorySlot0 = ItemStack.EMPTY;
		public ItemStack InventoryArmorySlot1 = ItemStack.EMPTY;
		public ItemStack InventoryArmorySlot2 = ItemStack.EMPTY;
		public ItemStack InventoryArmorySlot3 = ItemStack.EMPTY;
		public ItemStack InventoryArmorySlot4 = ItemStack.EMPTY;
		public ItemStack slot0 = ItemStack.EMPTY;
		public ItemStack slot1 = ItemStack.EMPTY;
		public ItemStack slot2 = ItemStack.EMPTY;
		public ItemStack slot3 = ItemStack.EMPTY;
		public ItemStack slot4 = ItemStack.EMPTY;
		public ItemStack slot5 = ItemStack.EMPTY;
		public ItemStack slot6 = ItemStack.EMPTY;
		public ItemStack slot7 = ItemStack.EMPTY;
		public ItemStack slot8 = ItemStack.EMPTY;
		public ItemStack slot9 = ItemStack.EMPTY;
		public ItemStack slot10 = ItemStack.EMPTY;
		public ItemStack slot11 = ItemStack.EMPTY;
		public ItemStack slot12 = ItemStack.EMPTY;
		public ItemStack slot13 = ItemStack.EMPTY;
		public ItemStack slot14 = ItemStack.EMPTY;
		public ItemStack slot15 = ItemStack.EMPTY;
		public ItemStack slot16 = ItemStack.EMPTY;
		public ItemStack slot17 = ItemStack.EMPTY;
		public ItemStack slot18 = ItemStack.EMPTY;
		public ItemStack slot19 = ItemStack.EMPTY;
		public boolean DomainAmplification = false;
		public boolean RCTOutput = false;
		public boolean NueTotality = false;
		public boolean AgitoBeast = false;
		public boolean Hakari = false;
		public boolean Higuruma = false;
		public boolean BarrierlessDomain = false;
		public boolean BurnOutRCT = false;
		public boolean MasteryRCT = false;
		public boolean BarrierDomainForMegumi = false;
		public boolean YutaDomainAdvanced = false;
		public boolean RCTMasteryOn = false;
		public boolean SimpleDomain = false;
		public boolean ChantsMastery = false;
		public boolean IsJujutsuSorcerer = false;
		public boolean IsCursedSpirit = false;
		public boolean InfusedDomain = false;
		public boolean IsVessel = false;
		public boolean WorldSlash = false;
		public boolean IsSukuna = false;
		public boolean save = true;
		public boolean IsInumaki = false;
		public boolean FutureSight = false;
		public boolean Flying = false;
		public boolean Fly = false;
		public boolean Fallings = false;
		public boolean Running = false;
		public boolean save1 = false;
		public boolean Sneaking = false;
		public boolean RidingCursedSpirit = false;
		public double BarrierlessDomainNumber = 0;
		public double RCTMastery = 0;
		public double MimicryKatana = 0;
		public double DomainKatana = 0;
		public double FutureSightNumber = 0;
		public double CE = 0;
		public double sokamona = 9999.0;
		public double Murasaki = 9999.0;
		public double Purple = 9990.0;
		public double CT = 0;
		public double Limb = 0;
		public double RCTRegen = 0;
		public double GojoQuest = 0;
		public double CursedSpiritsKilled = 0;
		public double GojoFlight = 0;
		public double Fist = 0;
		public double BarrierLessCD = 0;
		public double CooldownAgain = 0.0;
		public double RCTCount = 0;
		public double TeleportX = 0;
		public double TeleportY = 0;
		public double TeleportZ = 0;
		public double ItadoriCount = 0;
		public double CursedLevel = 0.0;
		public String Clans = "None";
		public double RecoveryCooldown = 0;
		public double BrainDamage = 0;
		public double BrainCooldown = 0;
		public boolean RCTOutputActive = false;
		public boolean Yukuzi = false;
		public double AnimationYuzuki = 0;
		public double AnimationDefense = 0;
		public double AttackAnimation = 0;
		public double AirAnimation = 0;
		public double Kokusen = 0;
		public double RecoverAnimation = 0;
		public boolean LockON = false;
		public double LockOn = 0;
		public double HealthAttribute = 0;
		public double DomainCounter = 0;
		public double gojosund = 0;
		public String ability = "\"\"";
		public double GUI = 0;
		public boolean GUIWHEEL = false;
		public double AnimationSlash = 0;
		public double timer = 0;
		public boolean Season1 = false;
		public boolean fixadose = false;
		public String Team = "\"\"";
		public double barrierless = 0;
		public double timerburnout = 0;
		public double rctmastery = 0;
		public double worldslashtimer = 0;
		public double gojoimbuedtick = 0;
		public double HRREGEN = 0;
		public double Clantick = 0;
		public double tickgeneral = 0;
		public double mahoragacontrol = 0;
		public double ticklevel = 0;
		public double brainburnout = 0;
		public double timerhakari = 0;
		public double fuga = 0;
		public double rctouput = 0;
		public double ItadoriAwakening = 0;
		public String Trait = "\"\"";
		public String ClanSlot1 = "\"\"";
		public String ClanSlot2 = "\"\"";
		public String ClanSlot3 = "\"\"";
		public double FingerCount = 0;
		public String DataSixEyesOne = "\"\"";
		public String Technique = "\"\"";
		public String Running1 = "\"\"";
		public double PlayerLevel = 0;
		public String CTName = "\"\"";
		public String NamePlayer = "\"\"";
		public double CEFormer = 0;
		public double CERet = 0;
		public double TickCounter = 0;
		public double TickCounter2 = 0;
		public double tickcounter3 = 0;
		public double BFChance = 0;
		public double KenjakuCT1 = 0;
		public double KenjakuCT2 = 0;
		public double Copy1 = 0;
		public double Copy2 = 0;
		public double Copy3 = 0.0;
		public double Copy4 = 0;
		public String Subrace = "\"\"";
		public double Timer1 = 1.0;
		public double Points = 0;
		public double Output = 0;
		public String Mode = "\"\"";
		public double cd1 = 0;
		public double cd2 = 0;
		public double Run = 0;
		public String TeamName = "\"\"";
		public double OutputLevel = 1.0;
		public double DomainVariable = 0;
		public double rctlevel = 0.0;
		public double TimeLeft = 6000.0;
		public double keycheck = 0;
		public String Damage = "\"\"";
		public double water = 0;
		public double CEShield = 0;
		public double pressed = 0;
		public double DomainType = 0;
		public double locker = 0.0;
		public double YutaCheck = 0;
		public double MahoragaCanAdapt = 0;
		public double DomainSizeVariable = 0;
		public double RadiusDomain = 0;
		public double RCTLimitLevel = 0;
		public double SimpleDomainLevel = 1.0;
		public double friend_num = 0;
		public double blackflashmastery = 1.0;
		public String Profession = "\"\"";
		public double ProfessionEXP = 0;
		public String Element = "\"\"";
		public double Level = 0;
		public double History = 0.0;
		public double VowPower = 1.0;
		public double Vow2 = 1.0;
		public double Vow3 = 1.0;
		public double Vow4 = 0.0;
		public double sp = 0;
		public double QuestOutput = 0;
		public String QuestActive = "\"\"";
		public String Description = "\"\"";
		public double Healed = 0;
		public double SimpleQuest = 0;
		public double CooldownExp = 0;
		public double Mastery = 0;
		public double RCTCount2 = 0;
		public double CEPlus = 0;
		public double BarrierlessCount = 0;
		public double random = 0;
		public double CECap = 0;
		public double GH = 0;
		public double SH = 0;
		public double Mahoraga = 0;
		public double TrueTechnique = 0;

		public void syncPlayerVariables(Entity entity) {
			if (entity instanceof ServerPlayer serverPlayer)
				JujutsucraftaddonMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> serverPlayer), new PlayerVariablesSyncMessage(this));
		}

		public Tag writeNBT() {
			CompoundTag nbt = new CompoundTag();
			nbt.put("InventoryArmorySlot0", InventoryArmorySlot0.save(new CompoundTag()));
			nbt.put("InventoryArmorySlot1", InventoryArmorySlot1.save(new CompoundTag()));
			nbt.put("InventoryArmorySlot2", InventoryArmorySlot2.save(new CompoundTag()));
			nbt.put("InventoryArmorySlot3", InventoryArmorySlot3.save(new CompoundTag()));
			nbt.put("InventoryArmorySlot4", InventoryArmorySlot4.save(new CompoundTag()));
			nbt.put("slot0", slot0.save(new CompoundTag()));
			nbt.put("slot1", slot1.save(new CompoundTag()));
			nbt.put("slot2", slot2.save(new CompoundTag()));
			nbt.put("slot3", slot3.save(new CompoundTag()));
			nbt.put("slot4", slot4.save(new CompoundTag()));
			nbt.put("slot5", slot5.save(new CompoundTag()));
			nbt.put("slot6", slot6.save(new CompoundTag()));
			nbt.put("slot7", slot7.save(new CompoundTag()));
			nbt.put("slot8", slot8.save(new CompoundTag()));
			nbt.put("slot9", slot9.save(new CompoundTag()));
			nbt.put("slot10", slot10.save(new CompoundTag()));
			nbt.put("slot11", slot11.save(new CompoundTag()));
			nbt.put("slot12", slot12.save(new CompoundTag()));
			nbt.put("slot13", slot13.save(new CompoundTag()));
			nbt.put("slot14", slot14.save(new CompoundTag()));
			nbt.put("slot15", slot15.save(new CompoundTag()));
			nbt.put("slot16", slot16.save(new CompoundTag()));
			nbt.put("slot17", slot17.save(new CompoundTag()));
			nbt.put("slot18", slot18.save(new CompoundTag()));
			nbt.put("slot19", slot19.save(new CompoundTag()));
			nbt.putBoolean("DomainAmplification", DomainAmplification);
			nbt.putBoolean("RCTOutput", RCTOutput);
			nbt.putBoolean("NueTotality", NueTotality);
			nbt.putBoolean("AgitoBeast", AgitoBeast);
			nbt.putBoolean("Hakari", Hakari);
			nbt.putBoolean("Higuruma", Higuruma);
			nbt.putBoolean("BarrierlessDomain", BarrierlessDomain);
			nbt.putBoolean("BurnOutRCT", BurnOutRCT);
			nbt.putBoolean("MasteryRCT", MasteryRCT);
			nbt.putBoolean("BarrierDomainForMegumi", BarrierDomainForMegumi);
			nbt.putBoolean("YutaDomainAdvanced", YutaDomainAdvanced);
			nbt.putBoolean("RCTMasteryOn", RCTMasteryOn);
			nbt.putBoolean("SimpleDomain", SimpleDomain);
			nbt.putBoolean("ChantsMastery", ChantsMastery);
			nbt.putBoolean("IsJujutsuSorcerer", IsJujutsuSorcerer);
			nbt.putBoolean("IsCursedSpirit", IsCursedSpirit);
			nbt.putBoolean("InfusedDomain", InfusedDomain);
			nbt.putBoolean("IsVessel", IsVessel);
			nbt.putBoolean("WorldSlash", WorldSlash);
			nbt.putBoolean("IsSukuna", IsSukuna);
			nbt.putBoolean("save", save);
			nbt.putBoolean("IsInumaki", IsInumaki);
			nbt.putBoolean("FutureSight", FutureSight);
			nbt.putBoolean("Flying", Flying);
			nbt.putBoolean("Fly", Fly);
			nbt.putBoolean("Fallings", Fallings);
			nbt.putBoolean("Running", Running);
			nbt.putBoolean("save1", save1);
			nbt.putBoolean("Sneaking", Sneaking);
			nbt.putBoolean("RidingCursedSpirit", RidingCursedSpirit);
			nbt.putDouble("BarrierlessDomainNumber", BarrierlessDomainNumber);
			nbt.putDouble("RCTMastery", RCTMastery);
			nbt.putDouble("MimicryKatana", MimicryKatana);
			nbt.putDouble("DomainKatana", DomainKatana);
			nbt.putDouble("FutureSightNumber", FutureSightNumber);
			nbt.putDouble("CE", CE);
			nbt.putDouble("sokamona", sokamona);
			nbt.putDouble("Murasaki", Murasaki);
			nbt.putDouble("Purple", Purple);
			nbt.putDouble("CT", CT);
			nbt.putDouble("Limb", Limb);
			nbt.putDouble("RCTRegen", RCTRegen);
			nbt.putDouble("GojoQuest", GojoQuest);
			nbt.putDouble("CursedSpiritsKilled", CursedSpiritsKilled);
			nbt.putDouble("GojoFlight", GojoFlight);
			nbt.putDouble("Fist", Fist);
			nbt.putDouble("BarrierLessCD", BarrierLessCD);
			nbt.putDouble("CooldownAgain", CooldownAgain);
			nbt.putDouble("RCTCount", RCTCount);
			nbt.putDouble("TeleportX", TeleportX);
			nbt.putDouble("TeleportY", TeleportY);
			nbt.putDouble("TeleportZ", TeleportZ);
			nbt.putDouble("ItadoriCount", ItadoriCount);
			nbt.putDouble("CursedLevel", CursedLevel);
			nbt.putString("Clans", Clans);
			nbt.putDouble("RecoveryCooldown", RecoveryCooldown);
			nbt.putDouble("BrainDamage", BrainDamage);
			nbt.putDouble("BrainCooldown", BrainCooldown);
			nbt.putBoolean("RCTOutputActive", RCTOutputActive);
			nbt.putBoolean("Yukuzi", Yukuzi);
			nbt.putDouble("AnimationYuzuki", AnimationYuzuki);
			nbt.putDouble("AnimationDefense", AnimationDefense);
			nbt.putDouble("AttackAnimation", AttackAnimation);
			nbt.putDouble("AirAnimation", AirAnimation);
			nbt.putDouble("Kokusen", Kokusen);
			nbt.putDouble("RecoverAnimation", RecoverAnimation);
			nbt.putBoolean("LockON", LockON);
			nbt.putDouble("LockOn", LockOn);
			nbt.putDouble("HealthAttribute", HealthAttribute);
			nbt.putDouble("DomainCounter", DomainCounter);
			nbt.putDouble("gojosund", gojosund);
			nbt.putString("ability", ability);
			nbt.putDouble("GUI", GUI);
			nbt.putBoolean("GUIWHEEL", GUIWHEEL);
			nbt.putDouble("AnimationSlash", AnimationSlash);
			nbt.putDouble("timer", timer);
			nbt.putBoolean("Season1", Season1);
			nbt.putBoolean("fixadose", fixadose);
			nbt.putString("Team", Team);
			nbt.putDouble("barrierless", barrierless);
			nbt.putDouble("timerburnout", timerburnout);
			nbt.putDouble("rctmastery", rctmastery);
			nbt.putDouble("worldslashtimer", worldslashtimer);
			nbt.putDouble("gojoimbuedtick", gojoimbuedtick);
			nbt.putDouble("HRREGEN", HRREGEN);
			nbt.putDouble("Clantick", Clantick);
			nbt.putDouble("tickgeneral", tickgeneral);
			nbt.putDouble("mahoragacontrol", mahoragacontrol);
			nbt.putDouble("ticklevel", ticklevel);
			nbt.putDouble("brainburnout", brainburnout);
			nbt.putDouble("timerhakari", timerhakari);
			nbt.putDouble("fuga", fuga);
			nbt.putDouble("rctouput", rctouput);
			nbt.putDouble("ItadoriAwakening", ItadoriAwakening);
			nbt.putString("Trait", Trait);
			nbt.putString("ClanSlot1", ClanSlot1);
			nbt.putString("ClanSlot2", ClanSlot2);
			nbt.putString("ClanSlot3", ClanSlot3);
			nbt.putDouble("FingerCount", FingerCount);
			nbt.putString("DataSixEyesOne", DataSixEyesOne);
			nbt.putString("Technique", Technique);
			nbt.putString("Running1", Running1);
			nbt.putDouble("PlayerLevel", PlayerLevel);
			nbt.putString("CTName", CTName);
			nbt.putString("NamePlayer", NamePlayer);
			nbt.putDouble("CEFormer", CEFormer);
			nbt.putDouble("CERet", CERet);
			nbt.putDouble("TickCounter", TickCounter);
			nbt.putDouble("TickCounter2", TickCounter2);
			nbt.putDouble("tickcounter3", tickcounter3);
			nbt.putDouble("BFChance", BFChance);
			nbt.putDouble("KenjakuCT1", KenjakuCT1);
			nbt.putDouble("KenjakuCT2", KenjakuCT2);
			nbt.putDouble("Copy1", Copy1);
			nbt.putDouble("Copy2", Copy2);
			nbt.putDouble("Copy3", Copy3);
			nbt.putDouble("Copy4", Copy4);
			nbt.putString("Subrace", Subrace);
			nbt.putDouble("Timer1", Timer1);
			nbt.putDouble("Points", Points);
			nbt.putDouble("Output", Output);
			nbt.putString("Mode", Mode);
			nbt.putDouble("cd1", cd1);
			nbt.putDouble("cd2", cd2);
			nbt.putDouble("Run", Run);
			nbt.putString("TeamName", TeamName);
			nbt.putDouble("OutputLevel", OutputLevel);
			nbt.putDouble("DomainVariable", DomainVariable);
			nbt.putDouble("rctlevel", rctlevel);
			nbt.putDouble("TimeLeft", TimeLeft);
			nbt.putDouble("keycheck", keycheck);
			nbt.putString("Damage", Damage);
			nbt.putDouble("water", water);
			nbt.putDouble("CEShield", CEShield);
			nbt.putDouble("pressed", pressed);
			nbt.putDouble("DomainType", DomainType);
			nbt.putDouble("locker", locker);
			nbt.putDouble("YutaCheck", YutaCheck);
			nbt.putDouble("MahoragaCanAdapt", MahoragaCanAdapt);
			nbt.putDouble("DomainSizeVariable", DomainSizeVariable);
			nbt.putDouble("RadiusDomain", RadiusDomain);
			nbt.putDouble("RCTLimitLevel", RCTLimitLevel);
			nbt.putDouble("SimpleDomainLevel", SimpleDomainLevel);
			nbt.putDouble("friend_num", friend_num);
			nbt.putDouble("blackflashmastery", blackflashmastery);
			nbt.putString("Profession", Profession);
			nbt.putDouble("ProfessionEXP", ProfessionEXP);
			nbt.putString("Element", Element);
			nbt.putDouble("Level", Level);
			nbt.putDouble("History", History);
			nbt.putDouble("VowPower", VowPower);
			nbt.putDouble("Vow2", Vow2);
			nbt.putDouble("Vow3", Vow3);
			nbt.putDouble("Vow4", Vow4);
			nbt.putDouble("sp", sp);
			nbt.putDouble("QuestOutput", QuestOutput);
			nbt.putString("QuestActive", QuestActive);
			nbt.putString("Description", Description);
			nbt.putDouble("Healed", Healed);
			nbt.putDouble("SimpleQuest", SimpleQuest);
			nbt.putDouble("CooldownExp", CooldownExp);
			nbt.putDouble("Mastery", Mastery);
			nbt.putDouble("RCTCount2", RCTCount2);
			nbt.putDouble("CEPlus", CEPlus);
			nbt.putDouble("BarrierlessCount", BarrierlessCount);
			nbt.putDouble("random", random);
			nbt.putDouble("CECap", CECap);
			nbt.putDouble("GH", GH);
			nbt.putDouble("SH", SH);
			nbt.putDouble("Mahoraga", Mahoraga);
			nbt.putDouble("TrueTechnique", TrueTechnique);
			return nbt;
		}

		public void readNBT(Tag tag) {
			CompoundTag nbt = (CompoundTag) tag;
			InventoryArmorySlot0 = ItemStack.of(nbt.getCompound("InventoryArmorySlot0"));
			InventoryArmorySlot1 = ItemStack.of(nbt.getCompound("InventoryArmorySlot1"));
			InventoryArmorySlot2 = ItemStack.of(nbt.getCompound("InventoryArmorySlot2"));
			InventoryArmorySlot3 = ItemStack.of(nbt.getCompound("InventoryArmorySlot3"));
			InventoryArmorySlot4 = ItemStack.of(nbt.getCompound("InventoryArmorySlot4"));
			slot0 = ItemStack.of(nbt.getCompound("slot0"));
			slot1 = ItemStack.of(nbt.getCompound("slot1"));
			slot2 = ItemStack.of(nbt.getCompound("slot2"));
			slot3 = ItemStack.of(nbt.getCompound("slot3"));
			slot4 = ItemStack.of(nbt.getCompound("slot4"));
			slot5 = ItemStack.of(nbt.getCompound("slot5"));
			slot6 = ItemStack.of(nbt.getCompound("slot6"));
			slot7 = ItemStack.of(nbt.getCompound("slot7"));
			slot8 = ItemStack.of(nbt.getCompound("slot8"));
			slot9 = ItemStack.of(nbt.getCompound("slot9"));
			slot10 = ItemStack.of(nbt.getCompound("slot10"));
			slot11 = ItemStack.of(nbt.getCompound("slot11"));
			slot12 = ItemStack.of(nbt.getCompound("slot12"));
			slot13 = ItemStack.of(nbt.getCompound("slot13"));
			slot14 = ItemStack.of(nbt.getCompound("slot14"));
			slot15 = ItemStack.of(nbt.getCompound("slot15"));
			slot16 = ItemStack.of(nbt.getCompound("slot16"));
			slot17 = ItemStack.of(nbt.getCompound("slot17"));
			slot18 = ItemStack.of(nbt.getCompound("slot18"));
			slot19 = ItemStack.of(nbt.getCompound("slot19"));
			DomainAmplification = nbt.getBoolean("DomainAmplification");
			RCTOutput = nbt.getBoolean("RCTOutput");
			NueTotality = nbt.getBoolean("NueTotality");
			AgitoBeast = nbt.getBoolean("AgitoBeast");
			Hakari = nbt.getBoolean("Hakari");
			Higuruma = nbt.getBoolean("Higuruma");
			BarrierlessDomain = nbt.getBoolean("BarrierlessDomain");
			BurnOutRCT = nbt.getBoolean("BurnOutRCT");
			MasteryRCT = nbt.getBoolean("MasteryRCT");
			BarrierDomainForMegumi = nbt.getBoolean("BarrierDomainForMegumi");
			YutaDomainAdvanced = nbt.getBoolean("YutaDomainAdvanced");
			RCTMasteryOn = nbt.getBoolean("RCTMasteryOn");
			SimpleDomain = nbt.getBoolean("SimpleDomain");
			ChantsMastery = nbt.getBoolean("ChantsMastery");
			IsJujutsuSorcerer = nbt.getBoolean("IsJujutsuSorcerer");
			IsCursedSpirit = nbt.getBoolean("IsCursedSpirit");
			InfusedDomain = nbt.getBoolean("InfusedDomain");
			IsVessel = nbt.getBoolean("IsVessel");
			WorldSlash = nbt.getBoolean("WorldSlash");
			IsSukuna = nbt.getBoolean("IsSukuna");
			save = nbt.getBoolean("save");
			IsInumaki = nbt.getBoolean("IsInumaki");
			FutureSight = nbt.getBoolean("FutureSight");
			Flying = nbt.getBoolean("Flying");
			Fly = nbt.getBoolean("Fly");
			Fallings = nbt.getBoolean("Fallings");
			Running = nbt.getBoolean("Running");
			save1 = nbt.getBoolean("save1");
			Sneaking = nbt.getBoolean("Sneaking");
			RidingCursedSpirit = nbt.getBoolean("RidingCursedSpirit");
			BarrierlessDomainNumber = nbt.getDouble("BarrierlessDomainNumber");
			RCTMastery = nbt.getDouble("RCTMastery");
			MimicryKatana = nbt.getDouble("MimicryKatana");
			DomainKatana = nbt.getDouble("DomainKatana");
			FutureSightNumber = nbt.getDouble("FutureSightNumber");
			CE = nbt.getDouble("CE");
			sokamona = nbt.getDouble("sokamona");
			Murasaki = nbt.getDouble("Murasaki");
			Purple = nbt.getDouble("Purple");
			CT = nbt.getDouble("CT");
			Limb = nbt.getDouble("Limb");
			RCTRegen = nbt.getDouble("RCTRegen");
			GojoQuest = nbt.getDouble("GojoQuest");
			CursedSpiritsKilled = nbt.getDouble("CursedSpiritsKilled");
			GojoFlight = nbt.getDouble("GojoFlight");
			Fist = nbt.getDouble("Fist");
			BarrierLessCD = nbt.getDouble("BarrierLessCD");
			CooldownAgain = nbt.getDouble("CooldownAgain");
			RCTCount = nbt.getDouble("RCTCount");
			TeleportX = nbt.getDouble("TeleportX");
			TeleportY = nbt.getDouble("TeleportY");
			TeleportZ = nbt.getDouble("TeleportZ");
			ItadoriCount = nbt.getDouble("ItadoriCount");
			CursedLevel = nbt.getDouble("CursedLevel");
			Clans = nbt.getString("Clans");
			RecoveryCooldown = nbt.getDouble("RecoveryCooldown");
			BrainDamage = nbt.getDouble("BrainDamage");
			BrainCooldown = nbt.getDouble("BrainCooldown");
			RCTOutputActive = nbt.getBoolean("RCTOutputActive");
			Yukuzi = nbt.getBoolean("Yukuzi");
			AnimationYuzuki = nbt.getDouble("AnimationYuzuki");
			AnimationDefense = nbt.getDouble("AnimationDefense");
			AttackAnimation = nbt.getDouble("AttackAnimation");
			AirAnimation = nbt.getDouble("AirAnimation");
			Kokusen = nbt.getDouble("Kokusen");
			RecoverAnimation = nbt.getDouble("RecoverAnimation");
			LockON = nbt.getBoolean("LockON");
			LockOn = nbt.getDouble("LockOn");
			HealthAttribute = nbt.getDouble("HealthAttribute");
			DomainCounter = nbt.getDouble("DomainCounter");
			gojosund = nbt.getDouble("gojosund");
			ability = nbt.getString("ability");
			GUI = nbt.getDouble("GUI");
			GUIWHEEL = nbt.getBoolean("GUIWHEEL");
			AnimationSlash = nbt.getDouble("AnimationSlash");
			timer = nbt.getDouble("timer");
			Season1 = nbt.getBoolean("Season1");
			fixadose = nbt.getBoolean("fixadose");
			Team = nbt.getString("Team");
			barrierless = nbt.getDouble("barrierless");
			timerburnout = nbt.getDouble("timerburnout");
			rctmastery = nbt.getDouble("rctmastery");
			worldslashtimer = nbt.getDouble("worldslashtimer");
			gojoimbuedtick = nbt.getDouble("gojoimbuedtick");
			HRREGEN = nbt.getDouble("HRREGEN");
			Clantick = nbt.getDouble("Clantick");
			tickgeneral = nbt.getDouble("tickgeneral");
			mahoragacontrol = nbt.getDouble("mahoragacontrol");
			ticklevel = nbt.getDouble("ticklevel");
			brainburnout = nbt.getDouble("brainburnout");
			timerhakari = nbt.getDouble("timerhakari");
			fuga = nbt.getDouble("fuga");
			rctouput = nbt.getDouble("rctouput");
			ItadoriAwakening = nbt.getDouble("ItadoriAwakening");
			Trait = nbt.getString("Trait");
			ClanSlot1 = nbt.getString("ClanSlot1");
			ClanSlot2 = nbt.getString("ClanSlot2");
			ClanSlot3 = nbt.getString("ClanSlot3");
			FingerCount = nbt.getDouble("FingerCount");
			DataSixEyesOne = nbt.getString("DataSixEyesOne");
			Technique = nbt.getString("Technique");
			Running1 = nbt.getString("Running1");
			PlayerLevel = nbt.getDouble("PlayerLevel");
			CTName = nbt.getString("CTName");
			NamePlayer = nbt.getString("NamePlayer");
			CEFormer = nbt.getDouble("CEFormer");
			CERet = nbt.getDouble("CERet");
			TickCounter = nbt.getDouble("TickCounter");
			TickCounter2 = nbt.getDouble("TickCounter2");
			tickcounter3 = nbt.getDouble("tickcounter3");
			BFChance = nbt.getDouble("BFChance");
			KenjakuCT1 = nbt.getDouble("KenjakuCT1");
			KenjakuCT2 = nbt.getDouble("KenjakuCT2");
			Copy1 = nbt.getDouble("Copy1");
			Copy2 = nbt.getDouble("Copy2");
			Copy3 = nbt.getDouble("Copy3");
			Copy4 = nbt.getDouble("Copy4");
			Subrace = nbt.getString("Subrace");
			Timer1 = nbt.getDouble("Timer1");
			Points = nbt.getDouble("Points");
			Output = nbt.getDouble("Output");
			Mode = nbt.getString("Mode");
			cd1 = nbt.getDouble("cd1");
			cd2 = nbt.getDouble("cd2");
			Run = nbt.getDouble("Run");
			TeamName = nbt.getString("TeamName");
			OutputLevel = nbt.getDouble("OutputLevel");
			DomainVariable = nbt.getDouble("DomainVariable");
			rctlevel = nbt.getDouble("rctlevel");
			TimeLeft = nbt.getDouble("TimeLeft");
			keycheck = nbt.getDouble("keycheck");
			Damage = nbt.getString("Damage");
			water = nbt.getDouble("water");
			CEShield = nbt.getDouble("CEShield");
			pressed = nbt.getDouble("pressed");
			DomainType = nbt.getDouble("DomainType");
			locker = nbt.getDouble("locker");
			YutaCheck = nbt.getDouble("YutaCheck");
			MahoragaCanAdapt = nbt.getDouble("MahoragaCanAdapt");
			DomainSizeVariable = nbt.getDouble("DomainSizeVariable");
			RadiusDomain = nbt.getDouble("RadiusDomain");
			RCTLimitLevel = nbt.getDouble("RCTLimitLevel");
			SimpleDomainLevel = nbt.getDouble("SimpleDomainLevel");
			friend_num = nbt.getDouble("friend_num");
			blackflashmastery = nbt.getDouble("blackflashmastery");
			Profession = nbt.getString("Profession");
			ProfessionEXP = nbt.getDouble("ProfessionEXP");
			Element = nbt.getString("Element");
			Level = nbt.getDouble("Level");
			History = nbt.getDouble("History");
			VowPower = nbt.getDouble("VowPower");
			Vow2 = nbt.getDouble("Vow2");
			Vow3 = nbt.getDouble("Vow3");
			Vow4 = nbt.getDouble("Vow4");
			sp = nbt.getDouble("sp");
			QuestOutput = nbt.getDouble("QuestOutput");
			QuestActive = nbt.getString("QuestActive");
			Description = nbt.getString("Description");
			Healed = nbt.getDouble("Healed");
			SimpleQuest = nbt.getDouble("SimpleQuest");
			CooldownExp = nbt.getDouble("CooldownExp");
			Mastery = nbt.getDouble("Mastery");
			RCTCount2 = nbt.getDouble("RCTCount2");
			CEPlus = nbt.getDouble("CEPlus");
			BarrierlessCount = nbt.getDouble("BarrierlessCount");
			random = nbt.getDouble("random");
			CECap = nbt.getDouble("CECap");
			GH = nbt.getDouble("GH");
			SH = nbt.getDouble("SH");
			Mahoraga = nbt.getDouble("Mahoraga");
			TrueTechnique = nbt.getDouble("TrueTechnique");
		}
	}

	public static class PlayerVariablesSyncMessage {
		private final PlayerVariables data;

		public PlayerVariablesSyncMessage(FriendlyByteBuf buffer) {
			this.data = new PlayerVariables();
			this.data.readNBT(buffer.readNbt());
		}

		public PlayerVariablesSyncMessage(PlayerVariables data) {
			this.data = data;
		}

		public static void buffer(PlayerVariablesSyncMessage message, FriendlyByteBuf buffer) {
			buffer.writeNbt((CompoundTag) message.data.writeNBT());
		}

		public static void handler(PlayerVariablesSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer()) {
					PlayerVariables variables = ((PlayerVariables) Minecraft.getInstance().player.getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
					variables.InventoryArmorySlot0 = message.data.InventoryArmorySlot0;
					variables.InventoryArmorySlot1 = message.data.InventoryArmorySlot1;
					variables.InventoryArmorySlot2 = message.data.InventoryArmorySlot2;
					variables.InventoryArmorySlot3 = message.data.InventoryArmorySlot3;
					variables.InventoryArmorySlot4 = message.data.InventoryArmorySlot4;
					variables.slot0 = message.data.slot0;
					variables.slot1 = message.data.slot1;
					variables.slot2 = message.data.slot2;
					variables.slot3 = message.data.slot3;
					variables.slot4 = message.data.slot4;
					variables.slot5 = message.data.slot5;
					variables.slot6 = message.data.slot6;
					variables.slot7 = message.data.slot7;
					variables.slot8 = message.data.slot8;
					variables.slot9 = message.data.slot9;
					variables.slot10 = message.data.slot10;
					variables.slot11 = message.data.slot11;
					variables.slot12 = message.data.slot12;
					variables.slot13 = message.data.slot13;
					variables.slot14 = message.data.slot14;
					variables.slot15 = message.data.slot15;
					variables.slot16 = message.data.slot16;
					variables.slot17 = message.data.slot17;
					variables.slot18 = message.data.slot18;
					variables.slot19 = message.data.slot19;
					variables.DomainAmplification = message.data.DomainAmplification;
					variables.RCTOutput = message.data.RCTOutput;
					variables.NueTotality = message.data.NueTotality;
					variables.AgitoBeast = message.data.AgitoBeast;
					variables.Hakari = message.data.Hakari;
					variables.Higuruma = message.data.Higuruma;
					variables.BarrierlessDomain = message.data.BarrierlessDomain;
					variables.BurnOutRCT = message.data.BurnOutRCT;
					variables.MasteryRCT = message.data.MasteryRCT;
					variables.BarrierDomainForMegumi = message.data.BarrierDomainForMegumi;
					variables.YutaDomainAdvanced = message.data.YutaDomainAdvanced;
					variables.RCTMasteryOn = message.data.RCTMasteryOn;
					variables.SimpleDomain = message.data.SimpleDomain;
					variables.ChantsMastery = message.data.ChantsMastery;
					variables.IsJujutsuSorcerer = message.data.IsJujutsuSorcerer;
					variables.IsCursedSpirit = message.data.IsCursedSpirit;
					variables.InfusedDomain = message.data.InfusedDomain;
					variables.IsVessel = message.data.IsVessel;
					variables.WorldSlash = message.data.WorldSlash;
					variables.IsSukuna = message.data.IsSukuna;
					variables.save = message.data.save;
					variables.IsInumaki = message.data.IsInumaki;
					variables.FutureSight = message.data.FutureSight;
					variables.Flying = message.data.Flying;
					variables.Fly = message.data.Fly;
					variables.Fallings = message.data.Fallings;
					variables.Running = message.data.Running;
					variables.save1 = message.data.save1;
					variables.Sneaking = message.data.Sneaking;
					variables.RidingCursedSpirit = message.data.RidingCursedSpirit;
					variables.BarrierlessDomainNumber = message.data.BarrierlessDomainNumber;
					variables.RCTMastery = message.data.RCTMastery;
					variables.MimicryKatana = message.data.MimicryKatana;
					variables.DomainKatana = message.data.DomainKatana;
					variables.FutureSightNumber = message.data.FutureSightNumber;
					variables.CE = message.data.CE;
					variables.sokamona = message.data.sokamona;
					variables.Murasaki = message.data.Murasaki;
					variables.Purple = message.data.Purple;
					variables.CT = message.data.CT;
					variables.Limb = message.data.Limb;
					variables.RCTRegen = message.data.RCTRegen;
					variables.GojoQuest = message.data.GojoQuest;
					variables.CursedSpiritsKilled = message.data.CursedSpiritsKilled;
					variables.GojoFlight = message.data.GojoFlight;
					variables.Fist = message.data.Fist;
					variables.BarrierLessCD = message.data.BarrierLessCD;
					variables.CooldownAgain = message.data.CooldownAgain;
					variables.RCTCount = message.data.RCTCount;
					variables.TeleportX = message.data.TeleportX;
					variables.TeleportY = message.data.TeleportY;
					variables.TeleportZ = message.data.TeleportZ;
					variables.ItadoriCount = message.data.ItadoriCount;
					variables.CursedLevel = message.data.CursedLevel;
					variables.Clans = message.data.Clans;
					variables.RecoveryCooldown = message.data.RecoveryCooldown;
					variables.BrainDamage = message.data.BrainDamage;
					variables.BrainCooldown = message.data.BrainCooldown;
					variables.RCTOutputActive = message.data.RCTOutputActive;
					variables.Yukuzi = message.data.Yukuzi;
					variables.AnimationYuzuki = message.data.AnimationYuzuki;
					variables.AnimationDefense = message.data.AnimationDefense;
					variables.AttackAnimation = message.data.AttackAnimation;
					variables.AirAnimation = message.data.AirAnimation;
					variables.Kokusen = message.data.Kokusen;
					variables.RecoverAnimation = message.data.RecoverAnimation;
					variables.LockON = message.data.LockON;
					variables.LockOn = message.data.LockOn;
					variables.HealthAttribute = message.data.HealthAttribute;
					variables.DomainCounter = message.data.DomainCounter;
					variables.gojosund = message.data.gojosund;
					variables.ability = message.data.ability;
					variables.GUI = message.data.GUI;
					variables.GUIWHEEL = message.data.GUIWHEEL;
					variables.AnimationSlash = message.data.AnimationSlash;
					variables.timer = message.data.timer;
					variables.Season1 = message.data.Season1;
					variables.fixadose = message.data.fixadose;
					variables.Team = message.data.Team;
					variables.barrierless = message.data.barrierless;
					variables.timerburnout = message.data.timerburnout;
					variables.rctmastery = message.data.rctmastery;
					variables.worldslashtimer = message.data.worldslashtimer;
					variables.gojoimbuedtick = message.data.gojoimbuedtick;
					variables.HRREGEN = message.data.HRREGEN;
					variables.Clantick = message.data.Clantick;
					variables.tickgeneral = message.data.tickgeneral;
					variables.mahoragacontrol = message.data.mahoragacontrol;
					variables.ticklevel = message.data.ticklevel;
					variables.brainburnout = message.data.brainburnout;
					variables.timerhakari = message.data.timerhakari;
					variables.fuga = message.data.fuga;
					variables.rctouput = message.data.rctouput;
					variables.ItadoriAwakening = message.data.ItadoriAwakening;
					variables.Trait = message.data.Trait;
					variables.ClanSlot1 = message.data.ClanSlot1;
					variables.ClanSlot2 = message.data.ClanSlot2;
					variables.ClanSlot3 = message.data.ClanSlot3;
					variables.FingerCount = message.data.FingerCount;
					variables.DataSixEyesOne = message.data.DataSixEyesOne;
					variables.Technique = message.data.Technique;
					variables.Running1 = message.data.Running1;
					variables.PlayerLevel = message.data.PlayerLevel;
					variables.CTName = message.data.CTName;
					variables.NamePlayer = message.data.NamePlayer;
					variables.CEFormer = message.data.CEFormer;
					variables.CERet = message.data.CERet;
					variables.TickCounter = message.data.TickCounter;
					variables.TickCounter2 = message.data.TickCounter2;
					variables.tickcounter3 = message.data.tickcounter3;
					variables.BFChance = message.data.BFChance;
					variables.KenjakuCT1 = message.data.KenjakuCT1;
					variables.KenjakuCT2 = message.data.KenjakuCT2;
					variables.Copy1 = message.data.Copy1;
					variables.Copy2 = message.data.Copy2;
					variables.Copy3 = message.data.Copy3;
					variables.Copy4 = message.data.Copy4;
					variables.Subrace = message.data.Subrace;
					variables.Timer1 = message.data.Timer1;
					variables.Points = message.data.Points;
					variables.Output = message.data.Output;
					variables.Mode = message.data.Mode;
					variables.cd1 = message.data.cd1;
					variables.cd2 = message.data.cd2;
					variables.Run = message.data.Run;
					variables.TeamName = message.data.TeamName;
					variables.OutputLevel = message.data.OutputLevel;
					variables.DomainVariable = message.data.DomainVariable;
					variables.rctlevel = message.data.rctlevel;
					variables.TimeLeft = message.data.TimeLeft;
					variables.keycheck = message.data.keycheck;
					variables.Damage = message.data.Damage;
					variables.water = message.data.water;
					variables.CEShield = message.data.CEShield;
					variables.pressed = message.data.pressed;
					variables.DomainType = message.data.DomainType;
					variables.locker = message.data.locker;
					variables.YutaCheck = message.data.YutaCheck;
					variables.MahoragaCanAdapt = message.data.MahoragaCanAdapt;
					variables.DomainSizeVariable = message.data.DomainSizeVariable;
					variables.RadiusDomain = message.data.RadiusDomain;
					variables.RCTLimitLevel = message.data.RCTLimitLevel;
					variables.SimpleDomainLevel = message.data.SimpleDomainLevel;
					variables.friend_num = message.data.friend_num;
					variables.blackflashmastery = message.data.blackflashmastery;
					variables.Profession = message.data.Profession;
					variables.ProfessionEXP = message.data.ProfessionEXP;
					variables.Element = message.data.Element;
					variables.Level = message.data.Level;
					variables.History = message.data.History;
					variables.VowPower = message.data.VowPower;
					variables.Vow2 = message.data.Vow2;
					variables.Vow3 = message.data.Vow3;
					variables.Vow4 = message.data.Vow4;
					variables.sp = message.data.sp;
					variables.QuestOutput = message.data.QuestOutput;
					variables.QuestActive = message.data.QuestActive;
					variables.Description = message.data.Description;
					variables.Healed = message.data.Healed;
					variables.SimpleQuest = message.data.SimpleQuest;
					variables.CooldownExp = message.data.CooldownExp;
					variables.Mastery = message.data.Mastery;
					variables.RCTCount2 = message.data.RCTCount2;
					variables.CEPlus = message.data.CEPlus;
					variables.BarrierlessCount = message.data.BarrierlessCount;
					variables.random = message.data.random;
					variables.CECap = message.data.CECap;
					variables.GH = message.data.GH;
					variables.SH = message.data.SH;
					variables.Mahoraga = message.data.Mahoraga;
					variables.TrueTechnique = message.data.TrueTechnique;
				}
			});
			context.setPacketHandled(true);
		}
	}
}
