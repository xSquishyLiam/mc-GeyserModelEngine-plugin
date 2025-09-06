package re.imc.geysermodelengine.managers.model.entity;

import com.github.retrooper.packetevents.protocol.entity.type.EntityTypes;
import com.google.common.collect.Sets;
import com.ticxo.modelengine.api.model.ActiveModel;
import com.ticxo.modelengine.api.model.ModeledEntity;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import re.imc.geysermodelengine.GeyserModelEngine;
import re.imc.geysermodelengine.managers.model.model.Model;
import re.imc.geysermodelengine.packet.entity.PacketEntity;
import re.imc.geysermodelengine.runnables.EntityTaskRunnable;

import java.util.Set;

public class ModelEngineEntityData implements EntityData {

    private final GeyserModelEngine plugin;

    private final PacketEntity entity;

    private final Set<Player> viewers = Sets.newConcurrentHashSet();

    private final ModeledEntity modeledEntity;

    private final ActiveModel activeModel;

    private EntityTaskRunnable entityTask;

    public ModelEngineEntityData(GeyserModelEngine plugin, ModeledEntity modeledEntity, ActiveModel activeModel) {
        this.plugin = plugin;

        this.modeledEntity = modeledEntity;
        this.activeModel = activeModel;
        this.entity = new PacketEntity(EntityTypes.PIG, viewers, modeledEntity.getBase().getLocation());

        runEntityTask();
    }

    @Override
    public void teleportToModel() {
        Location location = modeledEntity.getBase().getLocation();
        entity.teleport(location);
    }

    public void runEntityTask() {
        entityTask = new EntityTaskRunnable(plugin, this);
    }

    @Override
    public PacketEntity getEntity() {
        return entity;
    }

    @Override
    public Set<Player> getViewers() {
        return viewers;
    }

    @Override
    public void remove() {

    }

    @Override
    public EntityTaskRunnable getEntityTask() {
        return entityTask;
    }

    public ModeledEntity getModeledEntity() {
        return modeledEntity;
    }

    public ActiveModel getActiveModel() {
        return activeModel;
    }
}
