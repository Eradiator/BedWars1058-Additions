package me.eradiator.bedwars.additions;

import me.eradiator.bedwars.additions.utils.registerCMD;
import me.eradiator.bedwars.additions.hooks.PAPI;
import me.eradiator.bedwars.additions.utils.EventsRegister;
import me.eradiator.bedwars.additions.utils.Msg;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {
    static Main instance;
    static Msg Msg = new Msg();


    @Override
    public void onEnable() {
        // Plugin startup logic

        instance = this;
        if (Bukkit.getServer().getPluginManager().getPlugin("BedWars1058") != null) {
            if (Bukkit.getServer().getPluginManager().getPlugin("PlaceholderAPI") != null) {
                getConfig().options().copyDefaults();
                saveDefaultConfig();
                new EventsRegister(this);
                new PAPI().register();
                new registerCMD();
                Msg.console("&e&l[BedWars1058-Additions] &ahas been enabled successfully.");
                Msg.console("&f[BedWars1058-Additions] &bHooks: \n" +
                        "&aPlaceholderAPI\n" +
                        "&aBedWars1058");


            }
            else{
                getConfig().options().copyDefaults();
                saveDefaultConfig();
                new EventsRegister(this);
                new registerCMD();
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


    public static me.eradiator.bedwars.additions.utils.Msg getMsgUtil() {
        return Msg;
    }
}
