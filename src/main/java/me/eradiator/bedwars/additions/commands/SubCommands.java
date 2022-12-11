package me.eradiator.bedwars.additions.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

public interface SubCommands {
    public String getName();
    public String getDescription();
    public String getPermission();
    public void perform(CommandSender sender , String[] args);
}
