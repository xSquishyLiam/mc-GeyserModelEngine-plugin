package re.imc.geysermodelengine.managers.model.ModelHandler;

import org.bukkit.entity.Entity;

public interface ModelHandler {

    void createModel(Object... objects);

    void processEntities(Entity entity);

    void loadListeners();
}
