
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.jujutsucraftaddon.init;

import org.lwjgl.glfw.GLFW;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;

import net.mcreator.jujutsucraftaddon.network.WorldSlashKeyMessage;
import net.mcreator.jujutsucraftaddon.network.WaterWalkingMessage;
import net.mcreator.jujutsucraftaddon.network.TestAnimationMessage;
import net.mcreator.jujutsucraftaddon.network.ReleaseTechniqueMessage;
import net.mcreator.jujutsucraftaddon.network.PassiveKeybindMessage;
import net.mcreator.jujutsucraftaddon.network.KeyWheelMessage;
import net.mcreator.jujutsucraftaddon.network.ExtensionKeybindMessage;
import net.mcreator.jujutsucraftaddon.network.DomainTypeMessage;
import net.mcreator.jujutsucraftaddon.network.DomainExpansionMessage;
import net.mcreator.jujutsucraftaddon.network.CursedFistsKeybindMessage;
import net.mcreator.jujutsucraftaddon.network.CursedEnergyShieldMessage;
import net.mcreator.jujutsucraftaddon.network.ChangeTechniqueMessage;
import net.mcreator.jujutsucraftaddon.network.BurnoutKeyMessage;
import net.mcreator.jujutsucraftaddon.network.ArmoryOrCopyMessage;
import net.mcreator.jujutsucraftaddon.network.AnimationKeybindMessage;
import net.mcreator.jujutsucraftaddon.JujutsucraftaddonMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class JujutsucraftaddonModKeyMappings {
	public static final KeyMapping WORLD_SLASH_KEY = new KeyMapping("key.jujutsucraftaddon.world_slash_key", GLFW.GLFW_KEY_F, "key.categories.jujutsucraftaddon") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new WorldSlashKeyMessage(0, 0));
				WorldSlashKeyMessage.pressAction(Minecraft.getInstance().player, 0, 0);
				WORLD_SLASH_KEY_LASTPRESS = System.currentTimeMillis();
			} else if (isDownOld != isDown && !isDown) {
				int dt = (int) (System.currentTimeMillis() - WORLD_SLASH_KEY_LASTPRESS);
				JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new WorldSlashKeyMessage(1, dt));
				WorldSlashKeyMessage.pressAction(Minecraft.getInstance().player, 1, dt);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping ARMORY_OR_COPY = new KeyMapping("key.jujutsucraftaddon.armory_or_copy", GLFW.GLFW_KEY_H, "key.categories.jujutsucraftaddon") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new ArmoryOrCopyMessage(0, 0));
				ArmoryOrCopyMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping KEY_WHEEL = new KeyMapping("key.jujutsucraftaddon.key_wheel", GLFW.GLFW_KEY_C, "key.categories.jujutsucraftaddon") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new KeyWheelMessage(0, 0));
				KeyWheelMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping ANIMATION_KEYBIND = new KeyMapping("key.jujutsucraftaddon.animation_keybind", GLFW.GLFW_KEY_B, "key.categories.jujutsucraftaddon") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new AnimationKeybindMessage(0, 0));
				AnimationKeybindMessage.pressAction(Minecraft.getInstance().player, 0, 0);
				ANIMATION_KEYBIND_LASTPRESS = System.currentTimeMillis();
			} else if (isDownOld != isDown && !isDown) {
				int dt = (int) (System.currentTimeMillis() - ANIMATION_KEYBIND_LASTPRESS);
				JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new AnimationKeybindMessage(1, dt));
				AnimationKeybindMessage.pressAction(Minecraft.getInstance().player, 1, dt);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping PASSIVE_KEYBIND = new KeyMapping("key.jujutsucraftaddon.passive_keybind", GLFW.GLFW_KEY_B, "key.categories.jujutsucraftaddon") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new PassiveKeybindMessage(0, 0));
				PassiveKeybindMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping DOMAIN_EXPANSION = new KeyMapping("key.jujutsucraftaddon.domain_expansion", GLFW.GLFW_KEY_UNKNOWN, "key.categories.jujutsucraftaddon") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new DomainExpansionMessage(0, 0));
				DomainExpansionMessage.pressAction(Minecraft.getInstance().player, 0, 0);
				DOMAIN_EXPANSION_LASTPRESS = System.currentTimeMillis();
			} else if (isDownOld != isDown && !isDown) {
				int dt = (int) (System.currentTimeMillis() - DOMAIN_EXPANSION_LASTPRESS);
				JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new DomainExpansionMessage(1, dt));
				DomainExpansionMessage.pressAction(Minecraft.getInstance().player, 1, dt);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping EXTENSION_KEYBIND = new KeyMapping("key.jujutsucraftaddon.extension_keybind", GLFW.GLFW_KEY_UNKNOWN, "key.categories.jujutsucraftaddon") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new ExtensionKeybindMessage(0, 0));
				ExtensionKeybindMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping TEST_ANIMATION = new KeyMapping("key.jujutsucraftaddon.test_animation", GLFW.GLFW_KEY_KP_DECIMAL, "key.categories.jujutsucraftaddon") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new TestAnimationMessage(0, 0));
				TestAnimationMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping BURNOUT_KEY = new KeyMapping("key.jujutsucraftaddon.burnout_key", GLFW.GLFW_KEY_UNKNOWN, "key.categories.jujutsucraftaddon") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new BurnoutKeyMessage(0, 0));
				BurnoutKeyMessage.pressAction(Minecraft.getInstance().player, 0, 0);
				BURNOUT_KEY_LASTPRESS = System.currentTimeMillis();
			} else if (isDownOld != isDown && !isDown) {
				int dt = (int) (System.currentTimeMillis() - BURNOUT_KEY_LASTPRESS);
				JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new BurnoutKeyMessage(1, dt));
				BurnoutKeyMessage.pressAction(Minecraft.getInstance().player, 1, dt);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping WATER_WALKING = new KeyMapping("key.jujutsucraftaddon.water_walking", GLFW.GLFW_KEY_UNKNOWN, "key.categories.jujutsucraftaddon") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new WaterWalkingMessage(0, 0));
				WaterWalkingMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping CURSED_ENERGY_SHIELD = new KeyMapping("key.jujutsucraftaddon.cursed_energy_shield", GLFW.GLFW_KEY_UNKNOWN, "key.categories.jujutsucraftaddon") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new CursedEnergyShieldMessage(0, 0));
				CursedEnergyShieldMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping DOMAIN_TYPE = new KeyMapping("key.jujutsucraftaddon.domain_type", GLFW.GLFW_KEY_UNKNOWN, "key.categories.jujutsucraftaddon") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new DomainTypeMessage(0, 0));
				DomainTypeMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping CHANGE_TECHNIQUE = new KeyMapping("key.jujutsucraftaddon.change_technique", GLFW.GLFW_KEY_V, "key.categories.jujutsucraftaddon") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new ChangeTechniqueMessage(0, 0));
				ChangeTechniqueMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping RELEASE_TECHNIQUE = new KeyMapping("key.jujutsucraftaddon.release_technique", GLFW.GLFW_KEY_UNKNOWN, "key.categories.jujutsucraftaddon") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new ReleaseTechniqueMessage(0, 0));
				ReleaseTechniqueMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping CURSED_FISTS_KEYBIND = new KeyMapping("key.jujutsucraftaddon.cursed_fists_keybind", GLFW.GLFW_KEY_UNKNOWN, "key.categories.jujutsucraftaddon") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				JujutsucraftaddonMod.PACKET_HANDLER.sendToServer(new CursedFistsKeybindMessage(0, 0));
				CursedFistsKeybindMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	private static long WORLD_SLASH_KEY_LASTPRESS = 0;
	private static long ANIMATION_KEYBIND_LASTPRESS = 0;
	private static long DOMAIN_EXPANSION_LASTPRESS = 0;
	private static long BURNOUT_KEY_LASTPRESS = 0;

	@SubscribeEvent
	public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
		event.register(WORLD_SLASH_KEY);
		event.register(ARMORY_OR_COPY);
		event.register(KEY_WHEEL);
		event.register(ANIMATION_KEYBIND);
		event.register(PASSIVE_KEYBIND);
		event.register(DOMAIN_EXPANSION);
		event.register(EXTENSION_KEYBIND);
		event.register(TEST_ANIMATION);
		event.register(BURNOUT_KEY);
		event.register(WATER_WALKING);
		event.register(CURSED_ENERGY_SHIELD);
		event.register(DOMAIN_TYPE);
		event.register(CHANGE_TECHNIQUE);
		event.register(RELEASE_TECHNIQUE);
		event.register(CURSED_FISTS_KEYBIND);
	}

	@Mod.EventBusSubscriber({Dist.CLIENT})
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onClientTick(TickEvent.ClientTickEvent event) {
			if (Minecraft.getInstance().screen == null) {
				WORLD_SLASH_KEY.consumeClick();
				ARMORY_OR_COPY.consumeClick();
				KEY_WHEEL.consumeClick();
				ANIMATION_KEYBIND.consumeClick();
				PASSIVE_KEYBIND.consumeClick();
				DOMAIN_EXPANSION.consumeClick();
				EXTENSION_KEYBIND.consumeClick();
				TEST_ANIMATION.consumeClick();
				BURNOUT_KEY.consumeClick();
				WATER_WALKING.consumeClick();
				CURSED_ENERGY_SHIELD.consumeClick();
				DOMAIN_TYPE.consumeClick();
				CHANGE_TECHNIQUE.consumeClick();
				RELEASE_TECHNIQUE.consumeClick();
				CURSED_FISTS_KEYBIND.consumeClick();
			}
		}
	}
}
