package net.mcreator.jujutsucraftaddon.procedures;

import net.mcreator.jujutsucraft.procedures.SelectGetoProcedure;
import net.mcreator.jujutsucraft.procedures.*;
import net.mcreator.jujutsucraftaddon.configuration.JogoatConfiguration;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModItems;
import java.util.HashMap;

public class TestProcedureeProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Player entity, HashMap guistate) {
		if (entity != null && guistate != null) {

			double random = Math.random();

			if (random <= 0.01 * (double) JogoatConfiguration.SUKUNA.get()) {
				SelectSukunaProcedure.execute(world, (double) x, (double) y, (double) z, entity, guistate);
			} else if (random <= 0.01 * (double) JogoatConfiguration.GOJO.get()) {
				SelectGojoProcedure.execute(world, (double) x, (double) y, (double) z, entity, guistate);
			} else if (random <= 0.01 * (double) JogoatConfiguration.OGI.get()) {
				SelectOgiProcedure.execute(world, (double) x, (double) y, (double) z, entity, guistate);
			} else if (random <= 0.01 * (double) JogoatConfiguration.MAKI.get()) {
				SelectMakiProcedure.execute(world, (double) x, (double) y, (double) z, entity, guistate);
			} else if (random <= 0.01 * (double) JogoatConfiguration.DHRUV.get()) {
				SelectDhruvLakdawallaProcedure.execute(world, (double) x, (double) y, (double) z, entity, guistate);
			} else if (random <= 0.01 * (double) JogoatConfiguration.MAHORAGA.get()) {
				SelectMahoragaProcedure.execute(world, (double) x, (double) y, (double) z, entity, guistate);
			} else if (random <= 0.01 * (double) JogoatConfiguration.TSUKUMO.get()) {
				SelectTsukumoProcedure.execute(world, (double) x, (double) y, (double) z, entity, guistate);
			} else if (random <= 0.01 * (double) JogoatConfiguration.YAGA.get()) {
				SelectYagaProcedure.execute(world, (double) x, (double) y, (double) z, entity, guistate);
			} else if (random <= 0.01 * (double) JogoatConfiguration.KUROURUSHI.get()) {
				SelectKurourushiProcedure.execute(world, (double) x, (double) y, (double) z, entity, guistate);
			} else if (random <= 0.01 * (double) JogoatConfiguration.ISHIGORI.get()) {
				SelectIshigoriProcedure.execute(world, (double) x, (double) y, (double) z, entity, guistate);
			} else if (random <= 0.01 * (double) JogoatConfiguration.NISHIMIYA.get()) {
				SelectNishimiyaProcedure.execute(world, (double) x, (double) y, (double) z, entity, guistate);
			}  else if (random <= 0.01 * (double) JogoatConfiguration.TODO.get()) {
				SelectTodoProcedure.execute(world, (double) x, (double) y, (double) z, entity, guistate);
			} else if (random <= 0.01 * (double) JogoatConfiguration.DAGON.get()) {
				SelectDagonProcedure.execute(world, (double) x, (double) y, (double) z, entity, guistate);
			} else if (random <= 0.01 * (double) JogoatConfiguration.MIGUEL.get()) {
				SelectMiguelProcedure.execute(world, (double) x, (double) y, (double) z, entity, guistate);
			} else if (random <= 0.01 * (double) JogoatConfiguration.OKKOTSU.get()) {
				SelectOkkotsuProcedure.execute(world, (double) x, (double) y, (double) z, entity, guistate);
			} else if (random <= 0.01 * (double) JogoatConfiguration.MEIMEI.get()) {
				SelectMeiMeiProcedure.execute(world, (double) x, (double) y, (double) z, entity, guistate);
			} else if (random <= 0.01 * (double) JogoatConfiguration.YOROZU.get()) {
				SelectYorozuProcedure.execute(world, (double) x, (double) y, (double) z, entity, guistate);
			} else if (random <= 0.01 * (double) JogoatConfiguration.URAUME.get()) {
				SelectUraumeProcedure.execute(world, (double) x, (double) y, (double) z, entity, guistate);
			} else if (random <= 0.01 * (double) JogoatConfiguration.GETO.get()) {
				SelectGetoProcedure.execute(world, (double) x, (double) y, (double) z, entity, guistate);
			} else if (random <= 0.01 * (double) JogoatConfiguration.CHOSO.get()) {
				SelectChosoProcedure.execute(world, (double) x, (double) y, (double) z, entity, guistate);
			} else if (random <= 0.01 * (double) JogoatConfiguration.TAKAKOURO.get()) {
				SelectTakakoUroProcedure.execute(world, (double) x, (double) y, (double) z, entity, guistate);
			} else if (random <= 0.01 * (double) JogoatConfiguration.ITADORI.get()) {
				SelectItadoriProcedure.execute(world, (double) x, (double) y, (double) z, entity, guistate);
			} else if (random <= 0.01 * (double) JogoatConfiguration.KUSAKABE.get()) {
				SelectKusakabeProcedure.execute(world, (double) x, (double) y, (double) z, entity, guistate);
			} else if (random <= 0.01 * (double) JogoatConfiguration.JUNPE.get()) {
				SelectJunpeProcedure.execute(world, (double) x, (double) y, (double) z, entity, guistate);
			} else if (random <= 0.01 * (double) JogoatConfiguration.JOGO.get()) {
				SelectJogoProcedure.execute(world, (double) x, (double) y, (double) z, entity, guistate);
			} else if (random <= 0.01 * (double) JogoatConfiguration.TAKABA.get()) {
				SelectTakabaProcedure.execute(world, (double) x, (double) y, (double) z, entity, guistate);
			} else if (random <= 0.01 * (double) JogoatConfiguration.HIGURUMA.get()) {
				SelectHigurumaProcedure.execute(world, (double) x, (double) y, (double) z, entity, guistate);
			} else if (random <= 0.01 * (double) JogoatConfiguration.ANGEL.get()) {
				SelectAngelProcedure.execute(world, (double) x, (double) y, (double) z, entity, guistate);
			} else if (random <= 0.01 * (double) JogoatConfiguration.HAKARI.get()) {
				SelectHakariProcedure.execute(world, (double) x, (double) y, (double) z, entity, guistate);
			} else if (random <= 0.01 * (double) JogoatConfiguration.MAHITO.get()) {
				SelectMahitoProcedure.execute(world, (double) x, (double) y, (double) z, entity, guistate);
			} else if (random <= 0.01 * (double) JogoatConfiguration.CHOJURO.get()) {
				SelectChojuroProcedure.execute(world, (double) x, (double) y, (double) z, entity, guistate);
			} else if (random <= 0.01 * (double) JogoatConfiguration.NANAMI.get()) {
				SelectNanamiProcedure.execute(world, (double) x, (double) y, (double) z, entity, guistate);
			} else if (random <= 0.01 * (double) JogoatConfiguration.FUSHIGURO.get()) {
				SelectFushiguroProcedure.execute(world, (double) x, (double) y, (double) z, entity, guistate);
			} else if (random <= 0.01 * (double) JogoatConfiguration.SMALLPOXDEITY.get()) {
				SelectSmallpoxDeityProcedure.execute(world, (double) x, (double) y, (double) z, entity, guistate);
			} else if (random <= 0.01 * (double) JogoatConfiguration.INUMAKI.get()) {
				SelectInumakiProcedure.execute(world, (double) x, (double) y, (double) z, entity, guistate);
			} else if (random <= 0.01 * (double) JogoatConfiguration.KUGISAKI.get()) {
				SelectKugisakiProcedure.execute(world, (double) x, (double) y, (double) z, entity, guistate);
			} else if (random <= 0.01 * (double) JogoatConfiguration.HANAMI.get()) {
				SelectHanamiProcedure.execute(world, (double) x, (double) y, (double) z, entity, guistate);
			} else if (random <= 0.01 * (double) JogoatConfiguration.KASHIMO.get()) {
				SelectKashimoProcedure.execute(world, (double) x, (double) y, (double) z, entity, guistate);
			} else if (random <= 0.01 * (double) JogoatConfiguration.JINICHI.get()) {
				SelectJinichiProcedure.execute(world, (double) x, (double) y, (double) z, entity, guistate);
			} else if (random <= 0.01 * (double) JogoatConfiguration.NAOYA.get()) {
				SelectNaoyaProcedure.execute(world, (double) x, (double) y, (double) z, entity, guistate);
			}

			if (entity instanceof Player) {
				Player player = (Player) entity;
				ItemStack stackToRemove = new ItemStack(JujutsucraftaddonModItems.RANDOM_CT_CHANGER.get());
				player.getInventory().clearOrCountMatchingItems(p -> stackToRemove.getItem() == p.getItem(), 1, player.inventoryMenu.getCraftSlots());

			}

		}
	}
}