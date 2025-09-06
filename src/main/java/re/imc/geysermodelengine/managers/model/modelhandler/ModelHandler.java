package re.imc.geysermodelengine.managers.model.modelhandler;

import org.bukkit.entity.Entity;
import re.imc.geysermodelengine.GeyserModelEngine;

public interface ModelHandler {

    // Might do a hashmap way tbf
    void createModel(GeyserModelEngine plugin, Object modeledEntity, Object activeModel);

    void processEntities(GeyserModelEngine plugin, Entity entity);

    void removeEntities(GeyserModelEngine plugin);

    void loadListeners(GeyserModelEngine plugin);
}
