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

import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.FastColor;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3f;



import java.util.EnumSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class HelperMethods {
	public static final RandomSource RANDOM = RandomSource.createThreadSafe();

	public static int getRGB24(Vector3f rgb) {
		return FastColor.ARGB32.color(255, Math.round(rgb.x * 255.0F), Math.round(rgb.y * 255.0F), Math.round(rgb.z * 255.0F));
	}

	public static boolean isDestroyable(ServerLevel level, Entity direct, @Nullable LivingEntity source, BlockPos pos) {
		return false;
	}

	public static <E> E getWeightedRandom(Map<E, Double> weights, RandomSource random) {
		E result = null;
		double bestValue = Double.MAX_VALUE;

		for (E element : weights.keySet()) {
			double value = -Math.log(random.nextDouble()) / weights.get(element);

			if (value < bestValue) {
				bestValue = value;
				result = element;
			}
		}

		return result;
	}

	public static int getLevenshteinDistance(String x, String y) {
		int m = x.length();
		int n = y.length();

		int[][] T = new int[m + 1][n + 1];

		for (int i = 1; i <= m; i++) {
			T[i][0] = i;
		}

		for (int j = 1; j <= n; j++) {
			T[0][j] = j;
		}

		int cost;

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				cost = x.charAt(i - 1) == y.charAt(j - 1) ? 0 : 1;
				T[i][j] = Integer.min(Integer.min(T[i - 1][j] + 1, T[i][j - 1] + 1),
						T[i - 1][j - 1] + cost);
			}
		}
		return T[m][n];
	}

	public static float strcmp(String x, String y) {
		float max = Float.max(x.length(), y.length());

		if (max > 0) {
			return 1.0F - ((max - getLevenshteinDistance(x, y)) / max);
		}
		return 0.0F;
	}

	public static <T extends Enum<?>> T randomEnum(Class<T> clazz) {
		return randomEnum(clazz, RANDOM);
	}

	public static <T extends Enum<?>> T randomEnum(Class<T> clazz, RandomSource random) {
		return clazz.getEnumConstants()[random.nextInt(clazz.getEnumConstants().length)];
	}

	public static <T extends Enum<T>> T randomEnum(Class<T> clazz, Set<T> excluded) {
		return randomEnum(clazz, excluded, RANDOM);
	}

	public static <T extends Enum<T>> T randomEnum(Class<T> clazz, Set<T> excluded, RandomSource random) {
		if (!excluded.isEmpty()) {
			EnumSet<T> available = EnumSet.complementOf(EnumSet.copyOf(excluded));

			if (!available.isEmpty()) {
				return (T) available.toArray()[random.nextInt(available.size())];
			}
		}
		return clazz.getEnumConstants()[random.nextInt(clazz.getEnumConstants().length)];
	}

	public static int toRGB24(int r, int g, int b, int a) {
		return ((a & 0xFF) << 24) |
				((r & 0xFF) << 16) |
				((g & 0xFF) << 8) |
				((b & 0xFF));
	}
}
