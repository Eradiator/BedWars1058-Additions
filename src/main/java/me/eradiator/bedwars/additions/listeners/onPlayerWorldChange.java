package me.eradiator.bedwars.additions.listeners;

import com.andrei1058.bedwars.BedWars;
import me.eradiator.bedwars.additions.utils.enums.path.MainPath;
import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;

public class onPlayerWorldChange implements Listener {
    @EventHandler
    public void onPlayerChangeWorld(PlayerChangedWorldEvent e){
        if (e.getPlayer().getWorld().toString().equalsIgnoreCase(BedWars.getLobbyWorld())) {
            if (MainPath.LOBBY_MODE.getBoolean()) {
                e.getPlayer().setGameMode(GameMode.ADVENTURE);
            }
        }
    }
}
