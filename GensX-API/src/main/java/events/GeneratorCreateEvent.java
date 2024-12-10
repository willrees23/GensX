package events;

import lombok.Getter;
import models.Generator;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

@Getter
public class GeneratorCreateEvent extends Event {
    private static final HandlerList HANDLERS = new HandlerList();
    private final Generator generator;

    public GeneratorCreateEvent(Generator generator) {
        this.generator = generator;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS;
    }
}
