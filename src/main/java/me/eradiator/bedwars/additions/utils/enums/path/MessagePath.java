package me.eradiator.bedwars.additions.utils.enums.path;

import me.eradiator.bedwars.additions.Main;
import me.eradiator.bedwars.additions.files.Messages;
import org.bukkit.configuration.file.YamlConfiguration;

import java.util.List;

public enum MessagePath {
    PREFIX("prefix"),
    COMMAND_NO_PERMISSION("command-no-permission");
    final String path;
    final Messages Messages = new Messages();
    MessagePath(String path){
        this.path = path;
    }
    public String getString(){
        return Messages.getConfig().getString(path);
    }
    public List<String> getStringList(){
        return Main.getMessageConfig().getConfig().getStringList(path);
    }
    public YamlConfiguration getConfig(){
        return (YamlConfiguration) Main.getMessageConfig().getConfig();
    }
}
