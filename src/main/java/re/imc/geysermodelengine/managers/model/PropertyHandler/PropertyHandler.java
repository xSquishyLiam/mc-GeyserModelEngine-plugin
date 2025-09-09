package re.imc.geysermodelengine.managers.model.PropertyHandler;

import org.bukkit.entity.Player;
import re.imc.geysermodelengine.managers.model.entity.EntityData;

import java.awt.*;
import java.util.Collection;

public interface PropertyHandler {

    void sendScale(EntityData entityData, Collection<Player> players, float lastScale, boolean firstSend);
    void sendColor(EntityData entityData, Collection<Player> players, Color lastColor, boolean firstSend);
    void sendHitBox(EntityData entityData, Player player);

    void updateEntityProperties(EntityData entityData, Collection<Player> players, boolean firstSend, String... forceAnims);
}
