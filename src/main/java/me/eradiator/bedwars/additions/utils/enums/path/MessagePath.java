package me.eradiator.bedwars.additions.utils.enums.path;

import me.eradiator.bedwars.additions.Main;
import org.bukkit.configuration.file.YamlConfiguration;

import java.util.List;

public enum MessagePath {
    PREFIX("messages.prefix"),
    EXECUTE_CMD_PLAYER_NOT_FOUND("execute-command.player-not-found"),
    EXECUTE_CMD_NO_PERMISSION("execute-command.no-permission"),
    EXECUTE_CMD_USAGE("execute-command.usage"),
    COMMAND_NO_PERMISSION("messages.command-no-permission");

    final String path;
    MessagePath(String path){
        this.path = path;
    }
    public String getString(){
        return Main.getInstance().getConfig().getString(path);
    }
    public List<String> getStringList(){
        return Main.getInstance().getConfig().getStringList(path);
    }
    public YamlConfiguration getConfig(){
        return (YamlConfiguration) Main.getInstance().getConfig();
    }
}
