package me.eradiator.bedwars.additions.utils;

import me.eradiator.bedwars.additions.commands.ExecuteCommand;
import me.eradiator.bedwars.additions.commands.MainCommand;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandMap;

import java.lang.reflect.Field;

public class registerCMD {
    public registerCMD(){
        try {
            final Field bukkitCommandMap = Bukkit.getServer().getClass().getDeclaredField("commandMap");

            bukkitCommandMap.setAccessible(true);
            CommandMap commandMap = (CommandMap) bukkitCommandMap.get(Bukkit.getServer());
            // register commands here
            commandMap.register("execute" , new ExecuteCommand("execute"));
            commandMap.register("bwa" , new MainCommand("bwa"));
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
