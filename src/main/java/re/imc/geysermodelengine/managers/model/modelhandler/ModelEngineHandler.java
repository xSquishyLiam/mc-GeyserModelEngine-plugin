package re.imc.geysermodelengine.managers.model.modelhandler;

import com.ticxo.modelengine.api.ModelEngineAPI;
import com.ticxo.modelengine.api.model.ActiveModel;
import com.ticxo.modelengine.api.model.ModeledEntity;
import kr.toxicity.model.api.data.raw.ModelData;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import re.imc.geysermodelengine.GeyserModelEngine;
import re.imc.geysermodelengine.listener.ModelEngineListener;
import re.imc.geysermodelengine.managers.model.entity.EntityData;
import re.imc.geysermodelengine.managers.model.entity.ModelEngineEntityData;
import re.imc.geysermodelengine.managers.model.model.Model;
import re.imc.geysermodelengine.managers.model.model.ModelEngineModel;
import re.imc.geysermodelengine.managers.model.propertyhandler.PropertyHandler;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ModelEngineHandler implements ModelHandler {

    @Override
    public void createModel(GeyserModelEngine plugin, Object modeledEntity, Object activeModel) {
        ModeledEntity megEntity = (ModeledEntity) modeledEntity;
        ActiveModel megActiveModel = (ActiveModel) activeModel;

        int entityID = megEntity.getBase().getEntityId();

        PropertyHandler propertyHandler = plugin.getEntityTaskManager().getPropertyHandler();
        EntityData entityData = new ModelEngineEntityData(plugin, megEntity, megActiveModel);

        Model model = new ModelEngineModel(megActiveModel, this, entityData, propertyHandler);

        Map<Model, EntityData> entityDataCache = plugin.getModelManager().getEntitiesCache().computeIfAbsent(entityID, k -> new HashMap<>());

        for (Map.Entry<Model, EntityData> entry : entityDataCache.entrySet()) {
            if (entry.getKey() !=  model && entry.getKey().getName().equals(megActiveModel.getBlueprint().getName())) {
                return;
            }
        }

        plugin.getModelManager().getModelEntitiesCache().put(entityID, model);
        entityDataCache.put(model, entityData);
    }

    @Override
    public void processEntities(GeyserModelEngine plugin, Entity entity) {
        if (plugin.getModelManager().getEntitiesCache().containsKey(entity.getEntityId())) return;

        ModeledEntity modeledEntity = ModelEngineAPI.getModeledEntity(entity);
        if (modeledEntity == null) return;

        Optional<ActiveModel> model = modeledEntity.getModels().values().stream().findFirst();
        model.ifPresent(m -> createModel(plugin, modeledEntity, m));
    }

    @Override
    public void removeEntities(GeyserModelEngine plugin) {
        for (Map<Model, EntityData> entities : plugin.getModelManager().getEntitiesCache().values()) {
            entities.forEach((model, modelEntity) -> modelEntity.getEntity().remove());
        }
    }

    @Override
    public void loadListeners(GeyserModelEngine plugin) {
        Bukkit.getPluginManager().registerEvents(new ModelEngineListener(plugin), plugin);
    }
}
