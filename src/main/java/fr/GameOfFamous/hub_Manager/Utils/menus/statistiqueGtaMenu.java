package fr.GameOfFamous.hub_Manager.Utils.menus;

import fr.GameOfFamous.hellstylia_API.Manager.AccountManager;
import fr.GameOfFamous.hellstylia_API.Utils.CreateItem;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.UUID;

public class statistiqueGtaMenu {

    public static void openGtaStatistiques(Player p){

        UUID uuid = p.getUniqueId();

        ItemStack back = CreateItem.getSkull("§7Back",new String[]{}, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZGExZDU1YjNmOTg5NDEwYTM0NzUyNjUwZTI0OGM5YjZjMTc4M2E3ZWMyYWEzZmQ3Nzg3YmRjNGQwZTYzN2QzOSJ9fX0=");
        ItemStack money = CreateItem.getSkull("§aMoney §f: "+ AccountManager.getMoney(uuid),new String[]{}, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjdmOGQ4YzM5Zjk5MjFhNjRkN2I3NTVkZTMyMmU0NDFmZGVkNGI3NzVhNzY1N2UwYjMxOTZiNmZkYTg2MzY0NiJ9fX0=");
        ItemStack clan = CreateItem.getSkull("§aClan §f: "+ AccountManager.getClan(uuid),new String[]{}, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYTZiZGJjYzUzYzY3ZTk3MGFiM2E2MjE0M2QzZWFjZTk1NWY1NWE1ODlkNjM3MmFmNDdkYjg0NTRjZTc5Nzg4MyJ9fX0=");
        ItemStack kills = CreateItem.getSkull("§aKills §f: "+ AccountManager.getKills(uuid),new String[]{}, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZWY5ODMzN2I4MjQyMjI5ZDk1ZGEyMzA5MDc1NTc4OTc3OGIxOGJmNWQwN2Q2MWY2MjBjZGJkYmJkMjlmYTYxNSJ9fX0=");
        ItemStack death = CreateItem.getSkull("§aDeath §f: "+ AccountManager.getDeath(uuid),new String[]{}, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODU2NDcxYTA0Y2UyZmQ0NGRiMmJiNzYzYmNhNjI5YmFjYjE2ZDZlYzMwYjhlOTA3Y2VlZjcxZjM3ODE1MTAyMyJ9fX0=");
        ItemStack chestopen = CreateItem.getSkull("§aChestOpen §f: "+ AccountManager.getChestOpen(uuid),new String[]{}, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZWYyMjFiMzNmNWIzOWU5OWVlNmZkMzQzYWJhYWE5YWJkZjY2ZDkzZDQzMDZjZjAxY2NhOWYyMDJlODc3M2ZkNiJ9fX0=");

        ItemStack border = CreateItem.newItem(Material.RED_STAINED_GLASS_PANE, 1, " ",false, new String[]{});

        Inventory inv = Bukkit.createInventory(null, 9, "§7GTA Statistiques");

        inv.setItem(4, money);
        inv.setItem(0, back);

        inv.setItem(1, clan);
        inv.setItem(2, border);
        inv.setItem(3, kills);
        inv.setItem(5, death);
        inv.setItem(6, border);
        inv.setItem(7, chestopen);
        inv.setItem(8, border);

        p.openInventory(inv);

    }

}
