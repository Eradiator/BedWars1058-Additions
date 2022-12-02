package me.eradiator.bedwars.additions.listeners;

import com.andrei1058.bedwars.BedWars;
import me.eradiator.bedwars.additions.Main;
import me.eradiator.bedwars.additions.utils.enums.path.MainPath;
import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.scheduler.BukkitRunnable;

public class onPlayerServerJoin implements Listener {
    @EventHandler
    public void onPlayerJoin(org.bukkit.event.player.PlayerJoinEvent e){
        if (e.getPlayer().getWorld().toString().equalsIgnoreCase(BedWars.getLobbyWorld())) {
            if (MainPath.LOBBY_MODE.getBoolean()) {
                e.getPlayer().setGameMode(GameMode.ADVENTURE);
            }
            if (MainPath.LOBBY_LEVEL_BAR_ENABLED.getBoolean()) {
                if (MainPath.LOBBY_LEVEL_BAR_PERMISSION_ENABLED.getBoolean()) {
                    if (e.getPlayer().hasPermission(MainPath.LOBBY_LEVEL_BAR_PERMISSION_NODE.getString())) {
                        new BukkitRunnable() {
                            @Override
                            public void run() {
                                e.getPlayer().setLevel(Integer.parseInt(BedWars.getLevelSupport().getLevel(e.getPlayer())));
                                e.getPlayer().setExp((float) (BedWars.getLevelSupport().getCurrentXp(e.getPlayer()) / BedWars.getLevelSupport().getRequiredXp(e.getPlayer())));
                            }
                        }.runTaskLater(Main.getInstance() , 50L);
                    }
                }
                else {
                    new BukkitRunnable() {
                        @Override
                        public void run() {
                            e.getPlayer().setLevel(Integer.parseInt(BedWars.getLevelSupport().getLevel(e.getPlayer())));
                            e.getPlayer().setExp((float) (BedWars.getLevelSupport().getCurrentXp(e.getPlayer()) / BedWars.getLevelSupport().getRequiredXp(e.getPlayer())));
                        }
                    }.runTaskLater(Main.getInstance() , 50L);
                }
            }
        }
    }
}
