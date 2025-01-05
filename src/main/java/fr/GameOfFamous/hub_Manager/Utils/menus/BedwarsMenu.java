package fr.GameOfFamous.hub_Manager.Utils.menus;

import fr.gameoffamous.hellstyliaAPI.Utils.CreateItem;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class BedwarsMenu {

    public static void openBedwarsMenu(Player player){

        ItemStack bedwarsSolo = CreateItem.newItem(Material.RED_BED, 1, "§aBedwars SOLO", false, new String[]{});
        ItemStack bedwarsDuo = CreateItem.newItem(Material.ORANGE_BED, 2, "§cBedwars DUO", true, new String[]{});

        ItemStack border = CreateItem.newItem(Material.RED_STAINED_GLASS_PANE, 1, " ",false, new String[]{});

        ItemStack back = CreateItem.getSkull("§7Back",new String[]{}, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZGExZDU1YjNmOTg5NDEwYTM0NzUyNjUwZTI0OGM5YjZjMTc4M2E3ZWMyYWEzZmQ3Nzg3YmRjNGQwZTYzN2QzOSJ9fX0=");

        Inventory inv = Bukkit.createInventory(null, 9, "§aServeur Bedwars");

        inv.setItem(3, bedwarsSolo);
        inv.setItem(5, bedwarsDuo);
        inv.setItem(0, back);

        inv.setItem(1, border);
        inv.setItem(2, border);
        inv.setItem(4, border);
        inv.setItem(6, border);
        inv.setItem(7, border);
        inv.setItem(8, border);

        player.openInventory(inv);

    }

}