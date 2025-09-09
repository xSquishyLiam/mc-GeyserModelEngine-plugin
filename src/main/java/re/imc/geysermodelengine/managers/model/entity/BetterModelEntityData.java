package re.imc.geysermodelengine.managers.model.entity;

import com.github.retrooper.packetevents.protocol.entity.type.EntityTypes;
import com.google.common.collect.Sets;
import kr.toxicity.model.api.tracker.Tracker;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import re.imc.geysermodelengine.GeyserModelEngine;
import re.imc.geysermodelengine.managers.model.taskshandler.BetterModelTaskHandler;
import re.imc.geysermodelengine.packet.entity.PacketEntity;

import java.util.Set;

public class BetterModelEntityData implements EntityData {

    private final GeyserModelEngine plugin;

    private final PacketEntity entity;
    private final Set<Player> viewers = Sets.newConcurrentHashSet();

    private final Entity entitySource;
    private final Tracker tracker;

    private BetterModelTaskHandler entityTask;

    public BetterModelEntityData(GeyserModelEngine plugin, Entity entitySource, Tracker tracker) {
        this.plugin = plugin;

        this.entitySource = entitySource;
        this.tracker = tracker;
        this.entity = new PacketEntity(EntityTypes.PIG, viewers, entitySource.getLocation());

        runEntityTask();
    }

    @Override
    public void teleportToModel() {
        Location location = entitySource.getLocation();
        entity.teleport(location);
    }

    public void runEntityTask() {
        entityTask = new BetterModelTaskHandler(plugin, this);
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
    public BetterModelTaskHandler getEntityTask() {
        return entityTask;
    }

    public Entity getEntitySource() {
        return entitySource;
    }

    public Tracker getTracker() {
        return tracker;
    }
}
