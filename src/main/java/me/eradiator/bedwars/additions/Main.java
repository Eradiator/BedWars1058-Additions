package me.eradiator.bedwars.additions;

import me.eradiator.bedwars.additions.files.Messages;
import me.eradiator.bedwars.additions.listeners.onPlayerArenaJoin;
import me.eradiator.bedwars.additions.listeners.onPlayerServerJoin;
import me.eradiator.bedwars.additions.listeners.onPlayerWorldChange;
import me.eradiator.bedwars.additions.utils.Msg;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {
    static Main instance;

    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;
        Messages.getConfig().options().copyDefaults();
        Messages.saveDefaultConfig();
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        getServer().getPluginManager().registerEvents(new onPlayerArenaJoin() , this);
        getServer().getPluginManager().registerEvents(new onPlayerServerJoin() ,this);
        getServer().getPluginManager().registerEvents(new onPlayerWorldChange() ,this);
        Msg.console("&e&l[BedWars1058-Additions] &ahas been enabled successfully.");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static Main getInstance() {
        return instance;
    }
}
