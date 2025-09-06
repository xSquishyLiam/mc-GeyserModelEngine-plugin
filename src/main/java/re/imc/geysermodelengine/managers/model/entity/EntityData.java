package re.imc.geysermodelengine.managers.model.entity;

import org.bukkit.entity.Player;
import re.imc.geysermodelengine.managers.model.model.Model;
import re.imc.geysermodelengine.packet.entity.PacketEntity;
import re.imc.geysermodelengine.runnables.EntityTaskRunnable;

import java.util.Set;

public interface EntityData {

    PacketEntity getEntity();
    Set<Player> getViewers();

    void teleportToModel();

    void remove();

    EntityTaskRunnable getEntityTask();
}
