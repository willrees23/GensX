package models;

import lombok.Getter;
import org.bukkit.inventory.ItemStack;

public record Generator(String id, String name, int level, ItemStack item, long interval, long lastGenerated,
                        long createdAt, long updatedAt) {

    public long nextGenerate() {
        return lastGenerated + interval;
    }
}
