package fr.GameOfFamous.hub_Manager.Utils;

import fr.GameOfFamous.hellstylia_API.Manager.AccountManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import java.util.UUID;

public class Board implements Runnable{

    private final static Board instance = new Board();

    private Board(){

    }

    @Override
    public void run(){

        for(Player player : Bukkit.getOnlinePlayers()){
            player.getScoreboard();
            if(player.getScoreboard().getObjective("Hellstylia") != null){
                updateScoreboard(player);
            }else{
                createNewScoreboard(player);
            }
        }

    }

    private void createNewScoreboard(Player player){

        Scoreboard scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
        Objective objective = scoreboard.registerNewObjective("Hellstylia", "dummy");

        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        objective.setDisplayName(ChatColor.GOLD +""+ ChatColor.BOLD + "Hellstylia");

        objective.getScore("§a ").setScore(7);
        //objective.getScore("§bGrade §f: [Joueur]").setScore(6);
        objective.getScore("§e ").setScore(5);
        objective.getScore("§bGems §f: 0").setScore(4);
        objective.getScore("§c ").setScore(3);
        //objective.getScore("§bLangue §f: Francais").setScore(2);
        objective.getScore("§1 ").setScore(1);
        objective.getScore("§6§lhellstylia.com").setScore(0);

        Team team1 = scoreboard.registerNewTeam("team1");
        String teamkey = ChatColor.BLUE.toString();

        team1.addEntry(teamkey);
        team1.setPrefix("§bGrade §f: ");
        team1.setSuffix("[Joueur]");

        objective.getScore(teamkey).setScore(6);

        Team team2 = scoreboard.registerNewTeam("team2");
        String teamkey2 = ChatColor.GOLD.toString();

        team2.addEntry(teamkey2);
        team2.setPrefix("§bLangue §f: ");
        team2.setSuffix("Francais");

        objective.getScore(teamkey2).setScore(2);

        player.setScoreboard(scoreboard);

    }

    private void updateScoreboard(Player player){

        UUID uuid = player.getUniqueId();

        Scoreboard scoreboard = player.getScoreboard();
        Team team1 = scoreboard.getTeam("team1");

        team1.setSuffix(AccountManager.getStaff(uuid).getPrefix());

        Team team2 = scoreboard.getTeam("team2");

        team2.setSuffix(AccountManager.getLanguage(uuid).getName());

    }

    public static Board getInstance(){
        return instance;
    }

}
