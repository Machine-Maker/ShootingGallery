package me.x1machinemaker1x.shootinggallery;

import org.bukkit.Location;

public class SGBlock {
	private WoolType type;
	private Location loc;

	public SGBlock(WoolType type, Location loc) {
		this.type = type;
		this.loc = loc;
	}

	public WoolType getType() {
		return this.type;
	}

	public Location getLocation() {
		return this.loc;
	}
}
