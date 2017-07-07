package me.x1machinemaker1x.shootinggallery.commands;

import org.bukkit.entity.Player;

import com.sk89q.worldedit.bukkit.selections.CuboidSelection;
import com.sk89q.worldedit.bukkit.selections.Selection;

import me.x1machinemaker1x.shootinggallery.Main;
import me.x1machinemaker1x.shootinggallery.utils.ArenaManager;
import me.x1machinemaker1x.shootinggallery.utils.MessageManager;

public class Create extends SubCommand {
	public void onCommand(Player p, String[] args) {
		if (ArenaManager.getInstance().getArena(args[0]) != null) {
			p.sendMessage(MessageManager.getInstance().getAlreadyCreated());
			return;
		}
		Selection s = Main.getWorldEdit().getSelection(p);
		if (s == null) {
			p.sendMessage(MessageManager.getInstance().getNoSelection());
			return;
		}
		if (!(s instanceof CuboidSelection)) {
			p.sendMessage(MessageManager.getInstance().getNotCuboid());
			return;
		}
		ArenaManager.getInstance().addArena(args[0], (CuboidSelection) s, false);
		p.sendMessage(MessageManager.getInstance().getArenaCreated(args[0]));
	}

	public String name() {
		return "create";
	}

	public String info() {
		return "Creates an ShootingGallery arena";
	}

	public String[] aliases() {
		return new String[] { "add", "carena" };
	}

	public String permission() {
		return "shootinggallery.create";
	}

	public int argsReq() {
		return 1;
	}

	public String format() {
		return "/sg create <ID>";
	}
}
