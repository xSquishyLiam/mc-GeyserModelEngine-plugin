package re.imc.geysermodelengine.managers.model.taskshandler;

import org.bukkit.entity.Player;
import re.imc.geysermodelengine.managers.model.entity.EntityData;

public interface TaskHandler {

    void runAsync();
    void sendEntityData(EntityData entityData, Player player, int delay);
    void cancel();
}
