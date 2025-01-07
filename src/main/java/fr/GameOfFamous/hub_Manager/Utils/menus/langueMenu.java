package fr.GameOfFamous.hub_Manager.Utils.menus;

import fr.GameOfFamous.hellstylia_API.Utils.CreateItem;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class langueMenu{

    public static void openLangueMenu(Player p){

        ItemStack france = CreateItem.getSkull("§9Francais",new String[]{"§2Serveur traduit à 100%"}, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNTEyNjlhMDY3ZWUzN2U2MzYzNWNhMWU3MjNiNjc2ZjEzOWRjMmRiZGRmZjk2YmJmZWY5OWQ4YjM1Yzk5NmJjIn19fQ==");
        ItemStack anglais = CreateItem.getSkull("§9English",new String[]{"§2Server translated to 0%"}, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODgzMWM3M2Y1NDY4ZTg4OGMzMDE5ZTI4NDdlNDQyZGZhYTg4ODk4ZDUwY2NmMDFmZDJmOTE0YWY1NDRkNTM2OCJ9fX0=");
        ItemStack allemand = CreateItem.getSkull("§9Deutsch",new String[]{"§2Server übersetzt nach 0%"}, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMjFjMjMwOTdlZjE3NjJkNTFkZjI5N2Y5YzQ0NTcwOGQ5NDM5ZmY5MTc0NmQyZjY3N2IyOGRkZGZhMjczMTYifX19");

        ItemStack back = CreateItem.getSkull("§7Back",new String[]{}, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZGExZDU1YjNmOTg5NDEwYTM0NzUyNjUwZTI0OGM5YjZjMTc4M2E3ZWMyYWEzZmQ3Nzg3YmRjNGQwZTYzN2QzOSJ9fX0=");

        ItemStack border = CreateItem.newItem(Material.RED_STAINED_GLASS_PANE, 1, " ",false, new String[]{});

        Inventory inv = Bukkit.createInventory(null, 9, "§7Langue");

        inv.setItem(4 , france);
        inv.setItem(2, anglais);
        inv.setItem(6, allemand);

        inv.setItem(0, back);
        inv.setItem(1, border);
        inv.setItem(3, border);
        inv.setItem(5, border);
        inv.setItem(7, border);
        inv.setItem(8, border);

        p.openInventory(inv);

    }

}
