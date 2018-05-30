package net.runelite.client.plugins.wintertodt;

import net.runelite.api.*;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.queries.GameObjectQuery;
import net.runelite.client.ui.overlay.*;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.io.Console;
import java.util.List;

public class WintertodtOverlay extends Overlay {
    private final Client client;
    private final WintertodtConfig config;

    private static final int MAX_DISTANCE = 2350;

    private static final int SNOW_CENTER_ID = ObjectID.NULL_502;
    private static final int SNOW_PARTICLES_ID = GraphicID.SNOW_PARTICLES;
    private static final int SNOW_FALL_ID = GraphicID.SNOW_PARTICLES_OTHER;

    WintertodtOverlay(Client client, WintertodtConfig config)
    {
        this.client = client;
        this.config = config;
        setPosition(OverlayPosition.DYNAMIC);
        setLayer(OverlayLayer.ABOVE_SCENE);
        setPriority(OverlayPriority.LOW);
    }

    @Override
    public Dimension render(Graphics2D graphics)
    {

        List<GraphicsObject> graphicsObjectList = client.getGraphicsObjects();
        GameObjectQuery query = new GameObjectQuery();

        for(int i = 0; i < graphicsObjectList.size(); i++){
            GraphicsObject object = graphicsObjectList.get(i);
            if (object.getId() == SNOW_CENTER_ID) {
                LocalPoint snowCenter = object.getLocation();
                Polygon poly = Perspective.getCanvasTileAreaPoly(client, snowCenter, 3);
                OverlayUtil.renderPolygon(graphics, poly, config.snowfallHighlightColour());
            }
            else if (object.getId() == SNOW_FALL_ID || object.getId() == SNOW_PARTICLES_ID) {
                LocalPoint snowCenter = object.getLocation();
                Polygon poly = Perspective.getCanvasTilePoly(client, snowCenter);
                OverlayUtil.renderPolygon(graphics, poly, config.snowfallHighlightColour());
            }
        }

        return null;
    }
}
