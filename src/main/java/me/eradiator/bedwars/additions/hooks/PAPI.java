package me.eradiator.bedwars.additions.hooks;

import com.andrei1058.bedwars.BedWars;
import com.andrei1058.bedwars.api.language.Language;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import me.eradiator.bedwars.additions.Main;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class PAPI extends PlaceholderExpansion {
    @Override
    public @NotNull String getIdentifier() {
        return "bw";
    }

    @Override
    public @NotNull String getAuthor() {
        return "Eradiator";
    }

    @Override
    public boolean canRegister() {
        return true;
    }

    @Override
    public boolean persist() {
        return true;
    }

    @Override
    public @NotNull String getVersion() {
        return Main.getInstance().getDescription().getVersion();
    }

    @Override
    public @Nullable String onPlaceholderRequest(Player player, @NotNull String params) {
        String out = null;
        if (params.equalsIgnoreCase("team_letter")) {
            out = String.valueOf(BedWars.getAPI().getArenaUtil().getArenaByPlayer(player).getTeam(player).getDisplayName(Language.getPlayerLanguage(player)).charAt(0)).toUpperCase();
        }
        if (params.equalsIgnoreCase("team_color")) {
            out = BedWars.getAPI().getArenaUtil().getArenaByPlayer(player).getTeam(player).getColor().toString();
        }
        if (params.equalsIgnoreCase("player_kills")) {
            out = String.valueOf(BedWars.getAPI().getArenaUtil().getArenaByPlayer(player).getPlayerKills(player , true));
        }
        if (params.equalsIgnoreCase("player_beds")) {
            out = String.valueOf(BedWars.getAPI().getArenaUtil().getArenaByPlayer(player).getPlayerBedsDestroyed(player));
        }
        return out;
    }
}
