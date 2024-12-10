package dev.wand.manager;

import dev.wand.gui.TypewriterGui;
import me.lucko.helper.Commands;
import org.bukkit.entity.Player;

public class CommandManager {

    public void registerCommands() {
        Commands.create()
                .assertPlayer()
                .handler(s -> {
                    Player sender = s.sender();
                    TypewriterGui gui = new TypewriterGui(sender);
                    gui.open();
                })
                .register("gensx");
    }
}
