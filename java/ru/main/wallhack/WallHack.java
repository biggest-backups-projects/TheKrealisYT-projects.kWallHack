package ru.main.wallhack;

import java.util.*;
import org.bukkit.*;
import org.bukkit.event.*;
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

public class WallHack extends JavaPlugin implements EventListener { // commandexecutor contains javaplugin, eventlistener no

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
        if(sender != null) {
            if(sender instanceof Player) {
                Player p = (Player)sender;
                if (!p.hasPermission("kwallhack.wh")) {
                    p.sendMessage(ChatColor.RED + "Недостаточно прав!"); // безправный
                    return true;
                }

                List<Player> players = new ArrayList<>();
                World worldPlayer = p.getWorld();
                for (Player player : Bukkit.getOnlinePlayers()) {
                    if (player.getWorld().equals(worldPlayer) && !player.equals(p)) { // equals воркает быстрее
                        players.add(player);
                    } // дальше мне было похуй
                    if (players.size() == 0) {
                        p.sendMessage(ChatColor.RED + "Поблизости игроков нет!");
                        return true;
                    } else {
                        List<UUID> nrbPlayers = new ArrayList<>();
                        for (Entity e : p.getNearbyEntities(30.0D, 30.0D, 30.0D)) {
                            if (e.getType().equals(EntityType.PLAYER)) {
                                nrbPlayers.add(e.getUniqueId());
                            }
                        }

                        if (nrbPlayers.size() == 0) {
                            p.sendMessage(ChatColor.RED + "Рядом нет игроков!");
                            return true;
                        } else {
                            p.sendMessage(ChatColor.GREEN + "WallHack активирован!");
                            nrbPlayers.forEach(nearbyPlayers -> Bukkit.getPlayer(nearbyPlayers).addPotionEffect(new PotionEffect(PotionEffectType.GLOWING, 300, 1))); // если бы мне заплатили 1.5к я бы сделал это на пакетах из пятёрочки)
                            return true;
                        }
                    }
                }
            }
            sender.sendMessage("Команду можно использовать только от имени игрока!"); // от имени ноунейма
            return true;
        }
        // Это баккит? А я думал вордж
        // Это зкцкрусайдер? А я думал денди
        return true;
    }
	
}
