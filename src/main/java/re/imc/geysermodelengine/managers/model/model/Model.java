package re.imc.geysermodelengine.managers.model.model;

import re.imc.geysermodelengine.managers.model.entity.EntityData;
import re.imc.geysermodelengine.managers.model.ModelHandler.ModelHandler;
import re.imc.geysermodelengine.managers.model.PropertyHandler.PropertyHandler;

public interface Model {

    String getName();

    ModelHandler getModelHandler();

    EntityData getEntityData();

    PropertyHandler getPropertyHandler();
}
