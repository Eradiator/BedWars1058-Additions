package me.eradiator.bedwars.additions.listeners;

import com.andrei1058.bedwars.BedWars;
import com.cryptomorin.xseries.XMaterial;
import me.eradiator.bedwars.additions.utils.enums.path.MainPath;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemDamageEvent;

public class onPlayerItemDamage implements Listener {
    @EventHandler
    public void onPlayerItemDamage(PlayerItemDamageEvent e){
        if (MainPath.UNBREAKABLE_MATERIAL_ENABLED.getBoolean()) {
            if (BedWars.getAPI().getArenaUtil().isPlaying(e.getPlayer())) {
                for (int i = 0; i< MainPath.UNBREAKABLE_MATERIAL.getStringList().size();i++) {
                    if (e.getItem().getType() == XMaterial.valueOf(MainPath.UNBREAKABLE_MATERIAL.getStringList().get(i)).parseMaterial()) {
                        e.setCancelled(true);
                    }
                    else {
                        e.setCancelled(false);
                    }
                }
            }
        }
    }
}
