package me.eradiator.bedwars.additions.listeners;

import com.andrei1058.bedwars.BedWars;
import me.eradiator.bedwars.additions.Main;
import me.eradiator.bedwars.additions.utils.enums.path.MainPath;
import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class onPlayerWorldChange implements Listener {
    @EventHandler
    public void onPlayerChangeWorld(PlayerChangedWorldEvent e){
        if (e.getPlayer().getWorld().toString().equalsIgnoreCase(BedWars.getLobbyWorld())) {
            if (MainPath.LOBBY_MODE.getBoolean()) {
                new BukkitRunnable(){
                    @Override
                    public void run() {
                        e.getPlayer().setGameMode(GameMode.ADVENTURE);
                    }
                }.runTaskLater(Main.getInstance() , 50L);
            }
        }
    }
}
