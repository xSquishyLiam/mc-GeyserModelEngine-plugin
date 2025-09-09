package re.imc.geysermodelengine.listener;

import kr.toxicity.model.api.event.CreateEntityTrackerEvent;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import re.imc.geysermodelengine.GeyserModelEngine;

public class BetterModelListener implements Listener {

    private final GeyserModelEngine plugin;

    public BetterModelListener(GeyserModelEngine plugin) {
        this.plugin = plugin;
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onModelSpawn(CreateEntityTrackerEvent event) {
        plugin.getModelManager().getModelHandler().createModel(event.sourceEntity(), event.getTracker());
    }
}
