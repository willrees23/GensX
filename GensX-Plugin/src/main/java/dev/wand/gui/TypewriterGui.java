package dev.wand.gui;

import me.lucko.helper.item.ItemStackBuilder;
import me.lucko.helper.menu.Gui;
import me.lucko.helper.menu.scheme.MenuPopulator;
import me.lucko.helper.menu.scheme.MenuScheme;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class TypewriterGui extends Gui {

    // the display book
    private static final MenuScheme DISPLAY = new MenuScheme().mask("000010000");

    // the keyboard buttons
    private static final MenuScheme BUTTONS = new MenuScheme()
            .mask("000000000")
            .mask("000000001")
            .mask("111111111")
            .mask("111111111")
            .mask("011111110")
            .mask("000010000");

    // we're limited to 9 keys per line, so add 'P' one line above.
    private static final String KEYS = "PQWERTYUIOASDFGHJKLZXCVBNM";

    private final StringBuilder message = new StringBuilder();

    public TypewriterGui(Player player) {
        super(player, 6, "&7Typewriter");
    }

    @Override
    public void redraw() {

        // perform initial setup.
        if (isFirstDraw()) {
            // when the GUI closes, send the resultant message to the player
            bind(() -> getPlayer().sendMessage("Your typed message was: " + message.toString()));

            // place the buttons
            MenuPopulator populator = BUTTONS.newPopulator(this);
            for (char keyChar : KEYS.toCharArray()) {
                populator.accept(ItemStackBuilder.of(Material.CLAY_BALL)
                        .name("&f&l" + keyChar)
                        .lore("")
                        .lore("&7Click to type this character")
                        .build(() -> {
                            message.append(keyChar);
                            redraw();
                        }));
            }

            // space key
            populator.accept(ItemStackBuilder.of(Material.CLAY_BALL)
                    .name("&f&lSPACE")
                    .lore("")
                    .lore("&7Click to type this character")
                    .build(() -> {
                        message.append(" ");
                        redraw();
                    }));
        }

        // update the display every time the GUI is redrawn.
        DISPLAY.newPopulator(this).accept(ItemStackBuilder.of(Material.BOOK)
                .name("&f" + message.toString() + "&7_")
                .lore("")
                .lore("&f> &7Use the buttons below to type your message.")
                .lore("&f> &7Hit ESC when you're done!")
                .buildItem().build());
    }
}
