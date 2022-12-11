package me.eradiator.bedwars.additions.utils;

import me.eradiator.bedwars.additions.listeners.onPlayerArenaJoin;
import me.eradiator.bedwars.additions.listeners.onPlayerBuyItem;
import me.eradiator.bedwars.additions.listeners.onPlayerServerJoin;
import me.eradiator.bedwars.additions.listeners.onPlayerWorldChange;
import org.bukkit.plugin.Plugin;

import static org.bukkit.Bukkit.getServer;

public class EventsRegister {
    public EventsRegister(Plugin plugin){
        getServer().getPluginManager().registerEvents(new onPlayerArenaJoin() , plugin);
        getServer().getPluginManager().registerEvents(new onPlayerServerJoin() ,plugin);
        getServer().getPluginManager().registerEvents(new onPlayerWorldChange() ,plugin);
        getServer().getPluginManager().registerEvents(new onPlayerBuyItem() , plugin);
    }
}
