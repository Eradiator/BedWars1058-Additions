package me.eradiator.bedwars.additions.utils;

import me.eradiator.bedwars.additions.utils.enums.path.MessagePath;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Msg {
    public static String CC(String message){
        return ChatColor.translateAlternateColorCodes('&' , message);
    }
    public static void player(Player player , String message){
        player.sendMessage(CC(prefix(message)));
    }
    public static void console(String message){
        Bukkit.getConsoleSender().sendMessage(CC(prefix(message)));
    }
    public static void sender(CommandSender sender , String message){
        sender.sendMessage(CC(prefix(message)));
    }
    public static String prefix(String message){
        return MessagePath.PREFIX.getString()+message;
    }
}
