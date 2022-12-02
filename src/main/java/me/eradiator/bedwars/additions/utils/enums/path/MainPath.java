package me.eradiator.bedwars.additions.utils.enums.path;

import me.eradiator.bedwars.additions.Main;
import org.bukkit.configuration.ConfigurationSection;

import java.util.List;

public enum MainPath {
    WAITING_FLIGHT_ENABLED("waiting.flight.enabled"),
    WAITING_FLIGHT_PERMISSION("waiting.flight.permission.node"),
    WAITING_FLIGHT_PERMISSION_ENABLED("waiting.flight.permission.enabled"),
    WAITING_BLINDNESS_ENABLED("waiting.blindness.enabled"),
    WAITING_BLINDNESS_PERMISSION("waiting.blindness.permission"),
    WAITING_BLINDNESS_PERMISSION_ENABLED("waiting.blindness.permission.enabled"),
    WAITING_LEVEL_BAR_PERMISSION_ENABLED("waiting.level-bar.permission.enabled"),
    WAITING_LEVEL_BAR_PERMISSION_NODE("waiting.level-bar.permission.node"),
    WAITING_LEVEL_BAR_ENABLED("waiting.level-bar.enabled"),
    LOBBY_LEVEL_BAR_PERMISSION_ENABLED("lobby.level-bar.permission.enabled"),
    LOBBY_LEVEL_BAR_PERMISSION_NODE("lobby.level-bar.permission.node"),
    LOBBY_LEVEL_BAR_ENABLED("lobby.level-bar.enabled"),
    IN_GAME_LEVEL_BAR_PERMISSION_ENABLED("in-game.level-bar.permission.enabled"),
    IN_GAME_LEVEL_BAR_PERMISSION_NODE("in-game.level-bar.permission.node"),
    IN_GAME_LEVEL_BAR_ENABLED("in-game.level-bar.enabled"),
    LOBBY_MODE("lobby.adventure-mode"),
    WAITING_MODE("waiting.adventure-mode");

    final String path;
    MainPath(String path){
      this.path = path;
    }
    public String getString (){
        return Main.getInstance().getConfig().getString(path);
    }
    public Integer getInt(){
        return Main.getInstance().getConfig().getInt(path);
    }
    public Boolean getBoolean() {
        return Main.getInstance().getConfig().getBoolean(path);
    }
    public List<String> getStringList(){
        return Main.getInstance().getConfig().getStringList(path);
    }
    public List<Integer> getIntegerList(){
        return Main.getInstance().getConfig().getIntegerList(path);
    }
    public ConfigurationSection getConfigurationSection() {
        return Main.getInstance().getConfig().getConfigurationSection(path);
    }

}