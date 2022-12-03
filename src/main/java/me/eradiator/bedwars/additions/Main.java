package me.eradiator.bedwars.additions;

import me.eradiator.bedwars.additions.files.Messages;
import me.eradiator.bedwars.additions.hooks.PAPI;
import me.eradiator.bedwars.additions.listeners.onPlayerArenaJoin;
import me.eradiator.bedwars.additions.listeners.onPlayerServerJoin;
import me.eradiator.bedwars.additions.listeners.onPlayerWorldChange;
import me.eradiator.bedwars.additions.utils.Msg;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {
    static Main instance;
    static Messages Messages = new Messages();
    static Msg Msg = new Msg();


    @Override
    public void onEnable() {
        // Plugin startup logic

        instance = this;
        if (Bukkit.getServer().getPluginManager().getPlugin("BedWars1058") != null) {
            if (Bukkit.getServer().getPluginManager().getPlugin("PlaceholderAPI") != null) {
                Messages.getConfig().options().copyDefaults();
                Messages.saveDefaultConfig();
                getConfig().options().copyDefaults();
                saveDefaultConfig();
                getServer().getPluginManager().registerEvents(new onPlayerArenaJoin() , this);
                getServer().getPluginManager().registerEvents(new onPlayerServerJoin() ,this);
                getServer().getPluginManager().registerEvents(new onPlayerWorldChange() ,this);
                new PAPI().register();
                Msg.console("&e&l[BedWars1058-Additions] &ahas been enabled successfully.");
                Msg.console("&f[BedWars1058-Additions] &bHooks: \n" +
                        "&aPlaceholderAPI\n" +
                        "&aBedWars1058");


            }
            else{
                Messages.getConfig().options().copyDefaults();
                Messages.saveDefaultConfig();
                getConfig().options().copyDefaults();
                saveDefaultConfig();
                getServer().getPluginManager().registerEvents(new onPlayerArenaJoin() , this);
                getServer().getPluginManager().registerEvents(new onPlayerServerJoin() ,this);
                getServer().getPluginManager().registerEvents(new onPlayerWorldChange() ,this);
                Msg.console("&e&l[BedWars1058-Additions] &ahas been enabled successfully.");
                Msg.console("&f[BedWars1058-Additions] &bHooks: \n" +
                        "&cPlaceholderAPI\n" +
                        "&aBedWars1058");
            }
        }
        else  {
            Msg.console("&f[BedWars1058-Additions] &cBedWars1058 was not found, disabling.");
            Bukkit.getServer().getPluginManager().disablePlugin(this);
        }
    }

    @Override
    public void onDisable() {
        Msg.console("&f[BedWars1058-Additions] &cdisabling.");
    }

    public static Main getInstance() {
        return instance;
    }

    public static me.eradiator.bedwars.additions.files.Messages getMessageConfig() {
        return Messages;
    }

    public static me.eradiator.bedwars.additions.utils.Msg getMsgUtil() {
        return Msg;
    }
}
