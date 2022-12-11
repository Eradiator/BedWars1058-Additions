package me.eradiator.bedwars.additions.hooks;
/*
This  Contains a part of tanguygab's code so be sure to go visit him github@tanguygab
*/

import com.andrei1058.bedwars.api.BedWars;
import com.andrei1058.bedwars.api.arena.IArena;
import com.andrei1058.bedwars.api.arena.team.ITeam;
import com.andrei1058.bedwars.api.language.Language;
import com.andrei1058.bedwars.api.party.Party;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import me.eradiator.bedwars.additions.Main;
import me.eradiator.bedwars.additions.utils.Msg;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PAPI extends PlaceholderExpansion {
    Msg Msg = new Msg();
    BedWars api;
    @Override
    public  String getIdentifier() {
        return "bw";
    }

    @Override
    public  String getRequiredPlugin() {
        return "BedWars1058";
    }

    @Override
    public  String getAuthor() {
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
    public  String getVersion() {
        return Main.getInstance().getDescription().getVersion();
    }

    /*@Override
    public @Nullable String onPlaceholderRequest(Player player, @NotNull String params) {

        if (params.equalsIgnoreCase("team_letter")) {
             return String.valueOf(BedWars.getAPI().getArenaUtil().getArenaByPlayer(player).getTeam(player).getDisplayName(Language.getPlayerLanguage(player)).charAt(0)).toUpperCase();
        }
        else if (params.equalsIgnoreCase("team_color")) {
            return BedWars.getAPI().getArenaUtil().getArenaByPlayer(player).getTeam(player).getColor().toString();
        }
        else if (params.equalsIgnoreCase("player_kills")) {
            return String.valueOf(BedWars.getAPI().getArenaUtil().getArenaByPlayer(player).getPlayerKills(player , true));
        }
        else if (params.equalsIgnoreCase("player_beds")) {
            return String.valueOf(BedWars.getAPI().getArenaUtil().getArenaByPlayer(player).getPlayerBedsDestroyed(player));
        }
        else if (params.equals("team_tab")) {
            return PlaceholderAPI.setPlaceholders(player , Msg.CC("%bw_team_color%&l%bw_team_letter%"));
        }
        else{
            return null;
        }
    }*/
    public String onRequest(OfflinePlayer player, String params) {
        if (player == null) {
            return "";
        } else {
            Player p = player.getPlayer();
            if (p == null) {
                return "";
            } else {
                Party party = this.api.getPartyUtil();
                if (params.equalsIgnoreCase("party_has")) {
                    return party.hasParty(p) + "";
                } else if (params.startsWith("party_members")) {
                    String output = "";
                    List<Player> list = new ArrayList(party.getMembers(p));
                    if (params.equalsIgnoreCase("party_members_amount")) {
                        output = list.size() + "";
                    } else if (params.equalsIgnoreCase("party_members")) {
                        Iterator var20 = list.iterator();

                        while(var20.hasNext()) {
                            Player pl = (Player)var20.next();
                            output = output + pl.getName();
                            if (list.indexOf(pl) != list.size() - 1) {
                                output = output + ", ";
                            }
                        }
                    }

                    return output;
                } else {
                    Player p2;
                    if (params.startsWith("party_in_yours_")) {
                        p2 = Bukkit.getServer().getPlayer(params.replace("party_in_yours_", ""));
                        return p2 == null ? "false" : party.isMember(p, p2) + "";
                    } else if (params.startsWith("party_in_his_")) {
                        p2 = Bukkit.getServer().getPlayer(params.replace("party_in_his_", ""));
                        return p2 == null ? "false" : party.isMember(p2, p) + "";
                    } else {
                        if (params.startsWith("party_is_owner")) {
                            if (params.equalsIgnoreCase("party_is_owner")) {
                                return party.isOwner(p) + "";
                            }

                            if (params.startsWith("party_is_owner_")) {
                                p2 = Bukkit.getServer().getPlayer(params.replace("party_is_owner_", ""));
                                if (p2 == null) {
                                    return "false";
                                }

                                return party.isOwner(p2) + "";
                            }
                        }

                        Language lang = this.api.getPlayerLanguage(p);
                        if (params.startsWith("lang")) {
                            return lang.getLangName();
                        } else {
                            IArena arena = this.api.getArenaUtil().getArenaByPlayer(p);
                            if (arena == null) {
                                return "";
                            } else {
                                ITeam team;
                                if (params.startsWith("team_status")) {
                                    if (params.equalsIgnoreCase("team_status")) {
                                        team = arena.getTeam(p);
                                    } else {
                                        team = arena.getTeam(params.replace("team_status_", ""));
                                    }

                                    if (team != null) {
                                        return !team.isBedDestroyed() ? lang.getString("format-sb-team-alive") : (!team.getMembers().isEmpty() ? team.getMembers().size() + "" : lang.getString("format-sb-team-eliminated"));
                                    }
                                }

                                if (params.startsWith("team_color")) {
                                    if (params.equalsIgnoreCase("team_color")) {
                                        team = arena.getTeam(p);
                                    } else {
                                        team = arena.getTeam(params.replace("team_color_", ""));
                                    }

                                    if (team != null) {
                                        return team.getColor().chat().toString();
                                    }
                                }

                                if (params.startsWith("team_letter")) {
                                    if (params.equalsIgnoreCase("team_letter")) {
                                        team = arena.getTeam(p);
                                    } else {
                                        team = arena.getTeam(params.replace("team_letter_", ""));
                                    }

                                    if (team != null) {
                                        return team.getName().substring(0, 1).toUpperCase();
                                    }
                                }

                                if (params.startsWith("team_players_amount")) {
                                    if (params.equalsIgnoreCase("team_players_amount")) {
                                        team = arena.getTeam(p);
                                    } else {
                                        team = arena.getTeam(params.replace("team_players_amount_", ""));
                                    }

                                    if (team != null) {
                                        return team.getMembers().size() + "";
                                    }
                                }

                                if (params.startsWith("team_players")) {
                                    if (params.equalsIgnoreCase("team_players")) {
                                        team = arena.getTeam(p);
                                    } else {
                                        team = arena.getTeam(params.replace("team_players_", ""));
                                    }

                                    if (team != null) {
                                        String output = "";
                                        List<Player> list = new ArrayList(team.getMembers());
                                        Iterator var18 = list.iterator();

                                        while(var18.hasNext()) {
                                            Player pl = (Player)var18.next();
                                            output = output + pl.getName();
                                            if (list.indexOf(pl) != list.size() - 1) {
                                                output = output + ", ";
                                            }
                                        }

                                        return output;
                                    }
                                }

                                if (params.equalsIgnoreCase("arena_nextevent_name")) {
                                    return arena.getNextEvent().toString().toLowerCase().replace("_", " ");
                                } else if (params.equalsIgnoreCase("arena_nextevent_time")) {
                                    return arena.getNextEvent().toString().toLowerCase().replace("_", " ");
                                } else if (params.equalsIgnoreCase("arena_name")) {
                                    return arena.getArenaName();
                                } else if (params.equalsIgnoreCase("arena_group")) {
                                    return arena.getGroup();
                                } else if (params.equalsIgnoreCase("arena_world")) {
                                    return arena.getWorldName();
                                } else if (params.equalsIgnoreCase("arena_status_plocale")) {
                                    return arena.getDisplayStatus(lang);
                                } else if (params.equalsIgnoreCase("arena_status")) {
                                    return arena.getDisplayStatus(this.api.getDefaultLang());
                                } else if (params.equalsIgnoreCase("player_kills")) {
                                    return arena.getPlayerKills(p, false) + "";
                                } else if (params.equalsIgnoreCase("player_kills_total")) {
                                    return arena.getPlayerKills(p, true) + arena.getPlayerKills(p, false) + "";
                                } else if (params.equalsIgnoreCase("player_kills_final")) {
                                    return arena.getPlayerKills(p, true) + "";
                                } else if (params.equalsIgnoreCase("player_deaths")) {
                                    return arena.getPlayerDeaths(p, false) + "";
                                } else if (params.equalsIgnoreCase("player_deaths_total")) {
                                    return arena.getPlayerDeaths(p, true) + arena.getPlayerDeaths(p, false) + "";
                                } else if (params.equalsIgnoreCase("player_deaths_final")) {
                                    return arena.getPlayerDeaths(p, true) + "";
                                } else if (params.equalsIgnoreCase("player_beds")) {
                                    return arena.getPlayerBedsDestroyed(p) + "";
                                } else if (!params.startsWith("players")) {
                                    return "";
                                } else {
                                    String output = "";
                                    List<Player> list = new ArrayList(arena.getPlayers());
                                    if (params.equalsIgnoreCase("players_amount")) {
                                        output = list.size() + "";
                                    } else if (params.equalsIgnoreCase("players")) {
                                        Iterator var9 = list.iterator();

                                        while(var9.hasNext()) {
                                            Player pl = (Player)var9.next();
                                            output = output + pl.getName();
                                            if (list.indexOf(pl) != list.size() - 1) {
                                                output = output + ", ";
                                            }
                                        }
                                    }

                                    return output;
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
