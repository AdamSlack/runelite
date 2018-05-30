package net.runelite.client.plugins.safespotter;

import net.runelite.api.Client;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;

import javax.inject.Inject;
import java.awt.*;


public class SafespotterOverlay extends Overlay {

    private final SafespotterConfig config;
    private final SafespotterPlugin plugin;
    private final Client client;

    @Inject
    SafespotterOverlay(Client client, SafespotterConfig config, SafespotterPlugin plugin)
    {
        this.config = config;
        this.plugin = plugin;
        this.client = client;

        setPosition(OverlayPosition.DYNAMIC);
        setPriority(OverlayPriority.LOW);
        setLayer(OverlayLayer.ABOVE_SCENE);
    }

    @Override
    public Dimension render(Graphics2D graphics)
    {
        return null;
    }
}
