package me.x1machinemaker1x.shootinggallery.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTeleportEvent;

import me.x1machinemaker1x.shootinggallery.utils.ArenaManager;
import me.x1machinemaker1x.shootinggallery.utils.MessageManager;

public class PlayerTeleport implements Listener {
	@EventHandler
	public void onPlayerTeleport(PlayerTeleportEvent e) {
		if (ArenaManager.getInstance().getArena(e.getPlayer()) == null) {
			return;
		}
		if (e.getPlayer().hasPermission("shootinggallery.teleport")) {
			return;
		}
		e.setCancelled(true);
		e.getPlayer().sendMessage(MessageManager.getInstance().getNoTeleport());
	}
}
