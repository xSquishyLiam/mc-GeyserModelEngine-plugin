package re.imc.geysermodelengine.managers.model.propertyhandler;

import com.ticxo.modelengine.api.model.ActiveModel;
import me.zimzaza4.geyserutils.spigot.api.EntityUtils;
import org.bukkit.entity.Player;
import org.joml.Vector3fc;
import re.imc.geysermodelengine.managers.model.entity.EntityData;
import re.imc.geysermodelengine.managers.model.entity.ModelEngineEntityData;

import java.awt.*;
import java.lang.reflect.Method;
import java.util.Collection;

public class ModelEnginePropertyHandler implements PropertyHandler {

    private final Method scaleMethod;

    public ModelEnginePropertyHandler() {
        try {
            this.scaleMethod = ActiveModel.class.getMethod("getScale");
        } catch (NoSuchMethodException err) {
            throw new RuntimeException(err);
        }
    }

    @Override
    public void sendScale(EntityData modelData, Collection<Player> players, float lastScale, boolean firstSend) {
        try {
            if (players.isEmpty()) return;

            ModelEngineEntityData modelEngineEntityData = (ModelEngineEntityData) modelData;

            Vector3fc scale = (Vector3fc) scaleMethod.invoke(modelEngineEntityData.getActiveModel());

            float average = (scale.x() + scale.y() + scale.z()) / 3;

            if (!firstSend) {
                if (average == lastScale) return;
            }

            for (Player player : players) {
                EntityUtils.sendCustomScale(player, modelEngineEntityData.getEntity().getEntityId(), average);
            }
        } catch (Throwable ignored) {}
    }

    @Override
    public void sendColor(EntityData modelData, Collection<Player> players, Color lastColor, boolean firstSend) {
        if (players.isEmpty()) return;

        ModelEngineEntityData modelEngineEntityData = (ModelEngineEntityData) modelData;

        Color color = new Color(modelEngineEntityData.getActiveModel().getDefaultTint().asARGB());
        if (modelEngineEntityData.getActiveModel().isMarkedHurt()) color = new Color(modelEngineEntityData.getActiveModel().getDamageTint().asARGB());

        if (firstSend) {
            if (color.equals(lastColor)) return;
        }

        for (Player player : players) {
            EntityUtils.sendCustomColor(player, modelEngineEntityData.getEntity().getEntityId(), color);
        }
    }

    @Override
    public void sendHitBox(EntityData modelData, Player player) {
        for (Player viewer : modelData.getViewers()) {
            EntityUtils.sendCustomHitBox(viewer, modelData.getEntity().getEntityId(), 0.01f, 0.01f);
        }
    }
}
