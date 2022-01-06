package ru.main.wallhack;

import java.util.*;
import org.bukkit.*;
import org.bukkit.potion.*;
import org.bukkit.entity.*;
import org.bukkit.command.*;
import net.md_5.bungee.api.*;
import org.bukkit.plugin.java.*;
import org.bukkit.event.block.*;
import org.bukkit.event.player.*;
import ru.tehkode.permissions.bukkit.*;

/**
 * @Copyright © 2021 TheKrealisYT or Exept.
 * @Author source code: @naulbimix. All rights reserved. Please telegram @naulbimix for usage rights and other information.
 */

public class WallHack extends JavaPlugin implements CommandExecutor {

	@Override
    public void onEnable() {
        getCommand("wallhack").setExecutor(this);
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
