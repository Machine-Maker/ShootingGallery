package me.x1machinemaker1x.shootinggallery.utils;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;

public class ScoreManager {
	private static ScoreManager instance = new ScoreManager();
	HashMap<UUID, Integer> scores;

	public static ScoreManager getInstance() {
		return instance;
	}

	public void onEnable() {
		this.scores = new HashMap<UUID, Integer>();
		ConfigurationSection conf = ConfigManager.getInstance().getScores().getConfigurationSection("Scores");
		if (conf != null) {
			for (String uuid : conf.getKeys(false)) {
				this.scores.put(UUID.fromString(uuid), Integer.valueOf(conf.getInt(uuid)));
			}
		}
	}

	public void updateScoresInConfig() {
		ConfigManager.getInstance().getScores().set("Arenas", null);
		ConfigManager.getInstance().saveScores();
		if (!this.scores.isEmpty()) {
			ConfigurationSection conf = ConfigManager.getInstance().getScores().createSection("Scores");
			for (UUID uuid : this.scores.keySet()) {
				conf.set(uuid.toString(), this.scores.get(uuid));
			}
			ConfigManager.getInstance().saveScores();
		}
	}

	public boolean addScore(Player p, int score) {
		boolean highScore;
		if (this.scores.containsKey(p.getUniqueId())) {
			if (scores.get(p.getUniqueId()) < score) {
				scores.replace(p.getUniqueId(), score);
				highScore = true;
			} else {
				highScore = false;
			}
		} else {
			this.scores.put(p.getUniqueId(), Integer.valueOf(score));
			highScore = true;
		}
		updateScoresInConfig();
		return highScore;
	}

	public void resetScores() {
		this.scores.clear();
		ConfigManager.getInstance().getScores().set("Scores", null);
		ConfigManager.getInstance().saveScores();
	}
}
