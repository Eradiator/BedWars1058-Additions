package me.eradiator.bedwars.additions.utils.enums.path;

import me.eradiator.bedwars.additions.files.Messages;
import org.bukkit.configuration.file.YamlConfiguration;

import java.util.List;

public enum MessagePath {
    PREFIX("prefix"),
    COMMAND_NO_PERMISSION("command-no-permission");
    final String path;
    MessagePath(String path){
        this.path = path;
    }
    public String getString(){
        return Messages.getConfig().getString(path);
    }
    public List<String> getStringList(){
        return Messages.getConfig().getStringList(path);
    }
    public YamlConfiguration getConfig(){
        return (YamlConfiguration) Messages.getConfig();
    }
}
