package me.eradiator.bedwars.additions.files;

import com.google.common.base.Charsets;
import me.eradiator.bedwars.additions.Main;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Level;

public class Messages {
    private static final File file = new File(Main.getInstance().getDataFolder().toString() , "messages.yml");
    private static YamlConfiguration config = null;

    public static void saveConfig() {
        try {
            getConfig().save(file);
        } catch (IOException var2) {
            Main.getInstance().getLogger().log(Level.SEVERE, "Could not save message config to " + file, var2);
        }

    }
    public static void saveDefaultConfig() {
        if (!file.exists()) {
            Main.getInstance().saveResource("messages.yml", false);
        }

    }
    public static FileConfiguration getConfig() {
        if (config == null) {
            reloadConfig();
        }

        return config;
    }public static void reloadConfig() {
        config = YamlConfiguration.loadConfiguration(file);
        InputStream defConfigStream = Main.getInstance().getResource("messages.yml");
        if (defConfigStream != null) {
            config.setDefaults(YamlConfiguration.loadConfiguration(new InputStreamReader(defConfigStream, Charsets.UTF_8)));
        }
    }
    public static File getFile(){
        return file;
    }
    public static File getDataFolder(){
        return Main.getInstance().getDataFolder();
    }
}
