package re.imc.geysermodelengine.managers.model.entity;

import org.bukkit.entity.Player;
import re.imc.geysermodelengine.managers.model.taskshandler.TaskHandler;
import re.imc.geysermodelengine.packet.entity.PacketEntity;

import java.util.Set;

public interface EntityData {

    void teleportToModel();

    PacketEntity getEntity();
    Set<Player> getViewers();

    TaskHandler getEntityTask();
}
