package me.eradiator.bedwars.additions.listeners;

import com.andrei1058.bedwars.BedWars;
import com.andrei1058.bedwars.api.arena.GameState;
import com.andrei1058.bedwars.api.events.player.PlayerJoinArenaEvent;
import me.eradiator.bedwars.additions.Main;
import me.eradiator.bedwars.additions.utils.enums.path.MainPath;
import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;


public class onPlayerArenaJoin implements Listener {
    @EventHandler
    public void playerArenaJoinEvent(PlayerJoinArenaEvent e){
        if (e.getArena().getStatus() == GameState.waiting || e.getArena().getStatus() == GameState.starting) {
            if (MainPath.WAITING_MODE.getBoolean()) {
                e.getPlayer().setGameMode(GameMode.ADVENTURE);
            }
            if (MainPath.WAITING_FLIGHT_ENABLED.getBoolean()) {
                if (MainPath.WAITING_FLIGHT_PERMISSION_ENABLED.getBoolean()) {
                    if (e.getPlayer().hasPermission(MainPath.WAITING_FLIGHT_PERMISSION.getString())) {
                        e.getPlayer().setAllowFlight(true);
                        e.getPlayer().setFlying(true);
                    }
                }
                else {
                    e.getPlayer().setAllowFlight(true);
                    e.getPlayer().setFlying(true);
                }
            }
            if (MainPath.WAITING_BLINDNESS_ENABLED.getBoolean()) {
                if (MainPath.WAITING_BLINDNESS_PERMISSION_ENABLED.getBoolean()) {
                    if (!e.getPlayer().hasPermission(MainPath.WAITING_BLINDNESS_PERMISSION.getString())) {
                        e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS , 999999 ,1));

                    }
                }
            }
        }
        if (e.getArena().getStatus().equals(GameState.playing)) {
            if (MainPath.WAITING_BLINDNESS_ENABLED.getBoolean()) {
                if (MainPath.WAITING_BLINDNESS_PERMISSION_ENABLED.getBoolean()) {
                    if (!e.getPlayer().hasPermission(MainPath.WAITING_BLINDNESS_PERMISSION.getString())) {
                        e.getPlayer().removePotionEffect(PotionEffectType.BLINDNESS);
                    }
                }
            }
            if (MainPath.WAITING_LEVEL_BAR_ENABLED.getBoolean()) {
                if (MainPath.WAITING_LEVEL_BAR_PERMISSION_ENABLED.getBoolean()) {
                    if (e.getPlayer().hasPermission(MainPath.WAITING_LEVEL_BAR_PERMISSION_NODE.getString())) {
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
//TODO- REWRITE THIS CODE.