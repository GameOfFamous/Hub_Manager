package fr.GameOfFamous.hub_Manager.Utils.menus;

import fr.GameOfFamous.hellstylia_API.Utils.CreateItem;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class navMenu {

    public static void createNavMenu(Player p){
        ItemStack build = CreateItem.newItem(Material.GRASS_BLOCK, 1, "§cServeur Build", false, new String[]{"§9Serveur réservé aux Builders"});
        ItemStack gta = CreateItem.newItem(Material.DIAMOND_HOE, 1, "§cBientôt", true, new String[]{"§9Serveur en cours de développement", "§9Prochainement : §eGTA"});
        ItemStack dev = CreateItem.newItem(Material.REDSTONE_TORCH, 1, "§cServeur Developpement", false, new String[]{"§9Serveur réservé aux développeurs"});
        ItemStack bedwars = CreateItem.newItem(Material.RED_BED, 1, "§cBientôt", true, new String[]{"§9Serveur en cours de développement", "§9Prochainement : §eBedwars"});
        ItemStack murder = CreateItem.newItem(Material.DIAMOND_SWORD, 1, "§cBientôt", false, new String[]{"§9Serveur en cours de développement", "§9Prochainement : §eMurder"});
        ItemStack monster = CreateItem.newItem(Material.ZOMBIE_HEAD, 1, "§cBientôt", false, new String[]{"§9Serveur en cours de développement", "§9Prochainement : §eMonster INC"});

        ItemStack border = CreateItem.newItem(Material.RED_STAINED_GLASS_PANE, 1, " ",false, new String[]{});
        ItemStack back = CreateItem.newItem(Material.BARRIER, 1, "§cFermer", false, new String[]{});
        ItemStack wiki = CreateItem.newItem(Material.PAPER, 1, "§bWiki", false, new String[]{});

        ItemStack player = CreateItem.getPlayerSkull(p.getName(), new String[]{"§2Statistiques de jeux"});

        ItemStack site = CreateItem.getSkull("§bSite Internet",new String[]{}, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjk3MzEwM2MxNmIyMDkwYTg1Zjc0MGQ5OTg4YWJlNTE4MzQ5N2M3MmU1ZTY5YzMzMjE2OTIyZTc5NGYxNDVjZSJ9fX0=");



        Inventory inv = Bukkit.createInventory(null, 54, "§7Navigation");

        //border
        inv.setItem(1, border);
        inv.setItem(2, border);
        inv.setItem(3, border);
        inv.setItem(4, border);
        inv.setItem(5, border);
        inv.setItem(6, border);
        inv.setItem(7, border);

        inv.setItem(9, border);
        inv.setItem(18, border);
        inv.setItem(27, border);
        inv.setItem(36, border);

        inv.setItem(17, border);
        inv.setItem(26, border);
        inv.setItem(35, border);
        inv.setItem(44, border);

        inv.setItem(46, border);
        inv.setItem(47, border);
        inv.setItem(48, border);
        inv.setItem(50, border);
        inv.setItem(51, border);
        inv.setItem(52, border);

        //games
        inv.setItem(37, build);
        inv.setItem(13, gta);
        inv.setItem(21, bedwars);
        inv.setItem(43, dev);
        inv.setItem(23, murder);
        inv.setItem(31, monster);

        //close
        inv.setItem(53, back);
        inv.setItem(45, back);

        //Utils
        inv.setItem(0, site);
        inv.setItem(49, player);
        inv.setItem(8, wiki);

        p.openInventory(inv);
    }

}
