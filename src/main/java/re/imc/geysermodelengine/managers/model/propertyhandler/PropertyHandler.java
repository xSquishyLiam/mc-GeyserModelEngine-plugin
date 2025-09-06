package re.imc.geysermodelengine.managers.model.propertyhandler;

import org.bukkit.entity.Player;
import re.imc.geysermodelengine.managers.model.entity.EntityData;

import java.awt.*;
import java.util.Collection;

public interface PropertyHandler {

    void sendScale(EntityData modelData, Collection<Player> players, float lastScale, boolean firstSend);
    void sendColor(EntityData modelData, Collection<Player> players, Color lastColor, boolean firstSend);
    void sendHitBox(EntityData modelData, Player player);


}
