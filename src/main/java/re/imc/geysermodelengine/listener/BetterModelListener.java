package re.imc.geysermodelengine.listener;

import kr.toxicity.model.api.event.CreateTrackerEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import re.imc.geysermodelengine.GeyserModelEngine;

public class BetterModelListener implements Listener {

    private final GeyserModelEngine plugin;

    public BetterModelListener(GeyserModelEngine plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onModelSpawn(CreateTrackerEvent event) {
        plugin.getLogger().info(event.getTracker().name());
    }
}
