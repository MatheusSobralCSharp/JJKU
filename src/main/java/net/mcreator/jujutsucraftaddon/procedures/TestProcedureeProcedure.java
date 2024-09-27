package net.mcreator.jujutsucraftaddon.procedures;

import net.mcreator.jujutsucraft.procedures.SelectGetoProcedure;
import net.mcreator.jujutsucraft.procedures.*;
import net.mcreator.jujutsucraftaddon.configuration.JogoatConfiguration;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModItems;
import java.util.HashMap;

public class TestProcedureeProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Player entity, HashMap guistate) {
		if (entity != null && guistate != null) {

			double random = Mth.nextInt(RandomSource.create(), 1, 100);

			if (random <= (double) JogoatConfiguration.SUKUNA.get()) {
				SelectSukunaProcedure.execute(world, (double) x, (double) y, (double) z, entity, guistate);
				RandomizedSelectionProcedure.execute(entity);
			} else if (random <= (double) JogoatConfiguration.GOJO.get()) {
				SelectGojoProcedure.execute(world, (double) x, (double) y, (double) z, entity, guistate);
				RandomizedSelectionProcedure.execute(entity);
			} else if (random <= (double) JogoatConfiguration.OGI.get()) {
				SelectOgiProcedure.execute(world, (double) x, (double) y, (double) z, entity, guistate);
				RandomizedSelectionProcedure.execute(entity);
			} else if (random <=  (double) JogoatConfiguration.MAKI.get()) {
				SelectMakiProcedure.execute(world, (double) x, (double) y, (double) z, entity, guistate);
				RandomizedSelectionProcedure.execute(entity);
			} else if (random <= (double) JogoatConfiguration.DHRUV.get()) {
				SelectDhruvLakdawallaProcedure.execute(world, (double) x, (double) y, (double) z, entity, guistate);
				RandomizedSelectionProcedure.execute(entity);
			} else if (random <= JogoatConfiguration.MAHORAGA.get()) {
				SelectMahoragaProcedure.execute(world, (double) x, (double) y, (double) z, entity, guistate);
				RandomizedSelectionProcedure.execute(entity);
			} else if (random <= JogoatConfiguration.TSUKUMO.get()) {
				SelectTsukumoProcedure.execute(world, (double) x, (double) y, (double) z, entity, guistate);
				RandomizedSelectionProcedure.execute(entity);
			} else if (random <= JogoatConfiguration.YAGA.get()) {
				SelectYagaProcedure.execute(world, (double) x, (double) y, (double) z, entity, guistate);
				RandomizedSelectionProcedure.execute(entity);
			} else if (random <= JogoatConfiguration.KUROURUSHI.get()) {
				SelectKurourushiProcedure.execute(world, (double) x, (double) y, (double) z, entity, guistate);
				RandomizedSelectionProcedure.execute(entity);
			} else if (random <= JogoatConfiguration.ISHIGORI.get()) {
				SelectIshigoriProcedure.execute(world, (double) x, (double) y, (double) z, entity, guistate);
				RandomizedSelectionProcedure.execute(entity);
			} else if (random <= JogoatConfiguration.NISHIMIYA.get()) {
				SelectNishimiyaProcedure.execute(world, (double) x, (double) y, (double) z, entity, guistate);
				RandomizedSelectionProcedure.execute(entity);
			}  else if (random <= JogoatConfiguration.TODO.get()) {
				SelectTodoProcedure.execute(world, (double) x, (double) y, (double) z, entity, guistate);
				RandomizedSelectionProcedure.execute(entity);
			} else if (random <= JogoatConfiguration.DAGON.get()) {
				SelectDagonProcedure.execute(world, (double) x, (double) y, (double) z, entity, guistate);
				RandomizedSelectionProcedure.execute(entity);
			} else if (random <= JogoatConfiguration.MIGUEL.get()) {
				SelectMiguelProcedure.execute(world, (double) x, (double) y, (double) z, entity, guistate);
				RandomizedSelectionProcedure.execute(entity);
			} else if (random <= JogoatConfiguration.OKKOTSU.get()) {
				SelectOkkotsuProcedure.execute(world, (double) x, (double) y, (double) z, entity, guistate);
				RandomizedSelectionProcedure.execute(entity);
			} else if (random <= JogoatConfiguration.MEIMEI.get()) {
				SelectMeiMeiProcedure.execute(world, (double) x, (double) y, (double) z, entity, guistate);
				RandomizedSelectionProcedure.execute(entity);
			} else if (random <= JogoatConfiguration.YOROZU.get()) {
				SelectYorozuProcedure.execute(world, (double) x, (double) y, (double) z, entity, guistate);
				RandomizedSelectionProcedure.execute(entity);
			} else if (random <= JogoatConfiguration.URAUME.get()) {
				SelectUraumeProcedure.execute(world, (double) x, (double) y, (double) z, entity, guistate);
				RandomizedSelectionProcedure.execute(entity);
			} else if (random <= JogoatConfiguration.GETO.get()) {
				SelectGetoProcedure.execute(world, (double) x, (double) y, (double) z, entity, guistate);
				RandomizedSelectionProcedure.execute(entity);
			} else if (random <= JogoatConfiguration.CHOSO.get()) {
				SelectChosoProcedure.execute(world, (double) x, (double) y, (double) z, entity, guistate);
				RandomizedSelectionProcedure.execute(entity);
			} else if (random <= JogoatConfiguration.TAKAKOURO.get()) {
				SelectTakakoUroProcedure.execute(world, (double) x, (double) y, (double) z, entity, guistate);
				RandomizedSelectionProcedure.execute(entity);
			} else if (random <= JogoatConfiguration.ITADORI.get()) {
				SelectItadoriProcedure.execute(world, (double) x, (double) y, (double) z, entity, guistate);
				RandomizedSelectionProcedure.execute(entity);
			} else if (random <= JogoatConfiguration.KUSAKABE.get()) {
				SelectKusakabeProcedure.execute(world, (double) x, (double) y, (double) z, entity, guistate);
				RandomizedSelectionProcedure.execute(entity);
			} else if (random <= JogoatConfiguration.JUNPE.get()) {
				SelectJunpeProcedure.execute(world, (double) x, (double) y, (double) z, entity, guistate);
				RandomizedSelectionProcedure.execute(entity);
			} else if (random <= JogoatConfiguration.JOGO.get()) {
				SelectJogoProcedure.execute(world, (double) x, (double) y, (double) z, entity, guistate);
				RandomizedSelectionProcedure.execute(entity);
			} else if (random <= JogoatConfiguration.TAKABA.get()) {
				SelectTakabaProcedure.execute(world, (double) x, (double) y, (double) z, entity, guistate);
				RandomizedSelectionProcedure.execute(entity);
			} else if (random <= JogoatConfiguration.HIGURUMA.get()) {
				SelectHigurumaProcedure.execute(world, (double) x, (double) y, (double) z, entity, guistate);
				RandomizedSelectionProcedure.execute(entity);
			} else if (random <= JogoatConfiguration.ANGEL.get()) {
				SelectAngelProcedure.execute(world, (double) x, (double) y, (double) z, entity, guistate);
				RandomizedSelectionProcedure.execute(entity);
			} else if (random <= JogoatConfiguration.HAKARI.get()) {
				SelectHakariProcedure.execute(world, (double) x, (double) y, (double) z, entity, guistate);
				RandomizedSelectionProcedure.execute(entity);
			} else if (random <= JogoatConfiguration.MAHITO.get()) {
				SelectMahitoProcedure.execute(world, (double) x, (double) y, (double) z, entity, guistate);
				RandomizedSelectionProcedure.execute(entity);
			} else if (random <= JogoatConfiguration.CHOJURO.get()) {
				SelectChojuroProcedure.execute(world, (double) x, (double) y, (double) z, entity, guistate);
				RandomizedSelectionProcedure.execute(entity);
			} else if (random <= JogoatConfiguration.NANAMI.get()) {
				SelectNanamiProcedure.execute(world, (double) x, (double) y, (double) z, entity, guistate);
				RandomizedSelectionProcedure.execute(entity);
			} else if (random <= JogoatConfiguration.FUSHIGURO.get()) {
				SelectFushiguroProcedure.execute(world, (double) x, (double) y, (double) z, entity, guistate);
				RandomizedSelectionProcedure.execute(entity);
			} else if (random <= JogoatConfiguration.SMALLPOXDEITY.get()) {
				SelectSmallpoxDeityProcedure.execute(world, (double) x, (double) y, (double) z, entity, guistate);
				RandomizedSelectionProcedure.execute(entity);
			} else if (random <= JogoatConfiguration.INUMAKI.get()) {
				RandomizedSelectionProcedure.execute(entity);
				SelectInumakiProcedure.execute(world, (double) x, (double) y, (double) z, entity, guistate);
			} else if (random <= JogoatConfiguration.KUGISAKI.get()) {
				SelectKugisakiProcedure.execute(world, (double) x, (double) y, (double) z, entity, guistate);
				RandomizedSelectionProcedure.execute(entity);
			} else if (random <= JogoatConfiguration.HANAMI.get()) {
				SelectHanamiProcedure.execute(world, (double) x, (double) y, (double) z, entity, guistate);
				RandomizedSelectionProcedure.execute(entity);
			} else if (random <= JogoatConfiguration.KASHIMO.get()) {
				SelectKashimoProcedure.execute(world, (double) x, (double) y, (double) z, entity, guistate);
				RandomizedSelectionProcedure.execute(entity);
			} else if (random <= JogoatConfiguration.JINICHI.get()) {
				SelectJinichiProcedure.execute(world, (double) x, (double) y, (double) z, entity, guistate);
				RandomizedSelectionProcedure.execute(entity);
			} else if (random <= JogoatConfiguration.NAOYA.get()) {
				SelectNaoyaProcedure.execute(world, (double) x, (double) y, (double) z, entity, guistate);
				RandomizedSelectionProcedure.execute(entity);
			} else if (random <= JogoatConfiguration.INO.get()) {
				SelectInoProcedure.execute(world, (double) x, (double) y, (double) z, entity, guistate);
				RandomizedSelectionProcedure.execute(entity);
			}


			if (entity instanceof Player) {
				RandomizedSelectionProcedure.execute(entity);
				Player player = (Player) entity;
				ItemStack stackToRemove = new ItemStack(JujutsucraftaddonModItems.RANDOM_CT_CHANGER.get());
				player.getInventory().clearOrCountMatchingItems(p -> stackToRemove.getItem() == p.getItem(), 1, player.inventoryMenu.getCraftSlots());

			}

		}
	}
}