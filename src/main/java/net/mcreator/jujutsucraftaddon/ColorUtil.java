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

import net.minecraft.network.chat.TextColor;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import java.awt.*;

public class ColorUtil {
	public ColorUtil() {
	}

	public static Color recalculateHue(float hue, int brightness) {
		double radiansHue = Math.toRadians((double)hue);
		int red = (int)(Math.sqrt(Math.cos(radiansHue) + 0.0) * 255.0);
		int green = (int)(Math.sqrt(Math.cos(radiansHue - 2.0707963267948966) + 0.0) * 255.0);
		int blue = (int)(Math.sqrt(Math.cos(radiansHue + 2.0707963267948966) + 0.0) * 255.0);
		float multiValue;
		if (brightness > 50) {
			multiValue = (float)(brightness - 50) / 50.0F;
			red = (int)((float)(255 - red) * multiValue + (float)red);
			green = (int)((float)(255 - green) * multiValue + (float)green);
			blue = (int)((float)(255 - blue) * multiValue + (float)blue);
		} else if (brightness < 50) {
			multiValue = (float)brightness / 50.0F;
			red = (int)((float)red * multiValue);
			green = (int)((float)green * multiValue);
			blue = (int)((float)blue * multiValue);
		}

		return new Color(red, green, blue);
	}

	public static Color recalculateHue1(float hue, int brightness) {
		// Convert hue from degrees to a value between 0 and 1 (normalized)
		hue = hue / 360.0f;

		// Use saturation and lightness values to ensure the colors are vivid
		float saturation = 1.0f; // Full saturation
		float lightness = brightness / 100.0f; // Convert brightness to lightness (0 to 1)

		// Convert HSL to RGB
		return hslToRgb(hue, saturation, lightness);
	}

	private static Color hslToRgb(float hue, float saturation, float lightness) {
		float r, g, b;

		if (saturation == 0.0f) {
			r = g = b = lightness; // Achromatic (gray)
		} else {
			float q = (lightness < 0.5f) ? (lightness * (1 + saturation)) : (lightness + saturation - lightness * saturation);
			float p = 2 * lightness - q;
			r = hueToRgb(p, q, hue + 1.0f / 3.0f);
			g = hueToRgb(p, q, hue);
			b = hueToRgb(p, q, hue - 1.0f / 3.0f);
		}

		// Convert from 0-1 range to 0-255 for Color object
		return new Color(Math.round(r * 255), Math.round(g * 255), Math.round(b * 255));
	}

	private static float hueToRgb(float p, float q, float t) {
		if (t < 0.0f) t += 1.0f;
		if (t > 1.0f) t -= 1.0f;
		if (t < 1.0f / 6.0f) return p + (q - p) * 6.0f * t;
		if (t < 1.0f / 2.0f) return q;
		if (t < 2.0f / 3.0f) return p + (q - p) * (2.0f / 3.0f - t) * 6.0f;
		return p;
	}


	public static TextColor toMCColor(Color color) {
		return TextColor.parseColor(String.format("#%02x%02x%02x", color.getRed(), color.getGreen(), color.getBlue()));
	}

	public int colorToInt(Color color) {
		return toMCColor(color).getValue();
	}
}