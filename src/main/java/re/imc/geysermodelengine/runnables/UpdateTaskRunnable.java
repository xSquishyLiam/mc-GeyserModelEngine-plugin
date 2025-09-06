package re.imc.geysermodelengine.runnables;

import io.papermc.paper.threadedregions.scheduler.ScheduledTask;
import re.imc.geysermodelengine.GeyserModelEngine;
import re.imc.geysermodelengine.managers.model.entity.EntityData;
import re.imc.geysermodelengine.managers.model.entity.ModelEngineEntityData;
import re.imc.geysermodelengine.managers.model.model.Model;

import java.util.Map;
import java.util.function.Consumer;

public class UpdateTaskRunnable implements Consumer<ScheduledTask> {

    private final GeyserModelEngine plugin;

    public UpdateTaskRunnable(GeyserModelEngine plugin) {
        this.plugin = plugin;
    }

    @Override
    public void accept(ScheduledTask scheduledTask) {
        try {
            for (Map<Model, EntityData> models : plugin.getModelManager().getEntitiesCache().values()) {
                models.values().forEach(model -> model.getEntityTask().updateEntityProperties((ModelEngineEntityData) model, model.getViewers(), false));
            }
        } catch (Throwable err) {
            throw new RuntimeException(err);
        }
    }
}
