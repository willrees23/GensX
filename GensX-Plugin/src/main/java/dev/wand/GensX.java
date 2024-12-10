package dev.wand;

import dev.wand.manager.CommandManager;
import me.lucko.helper.Commands;
import me.lucko.helper.plugin.ExtendedJavaPlugin;
import me.lucko.helper.plugin.ap.Plugin;
import models.Generator;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

@Plugin(name = "GensX", version = "1.0.0", description = "Item generators to make your life easier!")
public class GensX extends ExtendedJavaPlugin {

    public final CommandManager commandManager = new CommandManager();

    @Override
    public void enable() {
        commandManager.registerCommands();

        Generator generator = new Generator(
                "test",
                "hey guys!",
                1,
                new ItemStack(Material.DIAMOND),
                1,
                1,
                1,
                1
        );

        getLogger().info("GensX Plugin has been enabled!");
    }

    @Override
    public void disable() {
        getLogger().info("GensX Plugin has been disabled!");
    }
}
