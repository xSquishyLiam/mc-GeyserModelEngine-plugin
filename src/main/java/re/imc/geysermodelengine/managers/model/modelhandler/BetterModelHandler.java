package re.imc.geysermodelengine.managers.model.modelhandler;

import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import re.imc.geysermodelengine.GeyserModelEngine;
import re.imc.geysermodelengine.listener.BetterModelListener;

public class BetterModelHandler implements ModelHandler {

    @Override
    public void createModel(GeyserModelEngine plugin, Object modeledEntity, Object activeModel) {

    }

    @Override
    public void processEntities(GeyserModelEngine plugin, Entity entity) {

    }

    @Override
    public void removeEntities(GeyserModelEngine plugin) {

    }

    @Override
    public void loadListeners(GeyserModelEngine plugin) {
        Bukkit.getPluginManager().registerEvents(new BetterModelListener(plugin), plugin);
    }
}
