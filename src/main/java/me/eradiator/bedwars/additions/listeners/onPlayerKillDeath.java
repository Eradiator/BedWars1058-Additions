package me.eradiator.bedwars.additions.listeners;

import com.andrei1058.bedwars.BedWars;
import com.andrei1058.bedwars.api.events.player.PlayerKillEvent;
import me.eradiator.bedwars.additions.Main;
import me.eradiator.bedwars.additions.utils.enums.path.MainPath;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.scheduler.BukkitRunnable;


public class onPlayerKillDeath implements Listener {
    static String Message;

    @EventHandler
    public void onPlayerDeath(PlayerKillEvent e) {
        /*level bar here----------------------------------------------------------
         * ------------------------------------------------------------------------*/
        if (MainPath.IN_GAME_LEVEL_BAR_ENABLED.getBoolean()) {
            if (MainPath.IN_GAME_LEVEL_BAR_PERMISSION_ENABLED.getBoolean()) {
                if (e.getVictim().hasPermission(MainPath.IN_GAME_LEVEL_BAR_PERMISSION_NODE.getString())) {
                    new BukkitRunnable() {
                        @Override
                        public void run() {
                            e.getVictim().setLevel(Integer.parseInt(BedWars.getLevelSupport().getLevel(e.getVictim())));
                            e.getVictim().setExp((float) (BedWars.getLevelSupport().getCurrentXp(e.getVictim()) / BedWars.getLevelSupport().getRequiredXp(e.getVictim())));
                        }
                    }.runTaskLater(Main.getInstance(), 50L);
                }
                if (e.getKiller().hasPermission(MainPath.IN_GAME_LEVEL_BAR_PERMISSION_NODE.getString())) {
                    new BukkitRunnable() {
                        @Override
                        public void run() {
                            e.getKiller().setLevel(Integer.parseInt(BedWars.getLevelSupport().getLevel(e.getKiller())));
                            e.getKiller().setExp((float) (BedWars.getLevelSupport().getCurrentXp(e.getKiller()) / BedWars.getLevelSupport().getRequiredXp(e.getKiller())));
                        }
                    }.runTaskLater(Main.getInstance(), 50L);
                }
            } else {
                new BukkitRunnable() {
                    @Override
                    public void run() {
                        e.getVictim().setLevel(Integer.parseInt(BedWars.getLevelSupport().getLevel(e.getVictim())));
                        e.getVictim().setExp((float) (BedWars.getLevelSupport().getCurrentXp(e.getVictim()) / BedWars.getLevelSupport().getRequiredXp(e.getVictim())));
                    }
                }.runTaskLater(Main.getInstance(), 50L);
                new BukkitRunnable() {
                    @Override
                    public void run() {
                        e.getKiller().setLevel(Integer.parseInt(BedWars.getLevelSupport().getLevel(e.getKiller())));
                        e.getKiller().setExp((float) (BedWars.getLevelSupport().getCurrentXp(e.getKiller()) / BedWars.getLevelSupport().getRequiredXp(e.getKiller())));
                    }
                }.runTaskLater(Main.getInstance(), 50L);
            }
        }
        // next methods here ------------------------------------------------------------------------------------------------
    }
}
