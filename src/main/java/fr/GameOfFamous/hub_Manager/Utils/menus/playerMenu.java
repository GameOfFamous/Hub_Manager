package fr.GameOfFamous.hub_Manager.Utils.menus;

import fr.GameOfFamous.hellstylia_API.Utils.CreateItem;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class playerMenu{

    public static void openPlayerMenu(Player p){

        ItemStack back = CreateItem.getSkull("§7Back",new String[]{}, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZGExZDU1YjNmOTg5NDEwYTM0NzUyNjUwZTI0OGM5YjZjMTc4M2E3ZWMyYWEzZmQ3Nzg3YmRjNGQwZTYzN2QzOSJ9fX0=");
        ItemStack gta = CreateItem.newItem(Material.DIAMOND_HOE, 1, "§cServeur GTA", true, new String[]{"§7Afficher les Statistiques du GTA"});

        ItemStack border = CreateItem.newItem(Material.RED_STAINED_GLASS_PANE, 1, " ",false, new String[]{});

        Inventory inv = Bukkit.createInventory(null, 9, "§7Statistiques");

        inv.setItem(4, gta);
        inv.setItem(0, back);

        inv.setItem(1, border);
        inv.setItem(2, border);
        inv.setItem(3, border);
        inv.setItem(5, border);
        inv.setItem(6, border);
        inv.setItem(7, border);
        inv.setItem(8, border);

        p.openInventory(inv);

    }

}
