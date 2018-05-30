package net.runelite.client.plugins.safespotter;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

import java.awt.Color;

@ConfigGroup(
        keyName = "safespotter",
        name = "Safespotter",
        description = "Highlights Enemies that can be attacked from your current spot safely"
)
public interface SafespotterConfig  extends Config {

    @ConfigItem(
            keyName = "safeEnemyColour",
            name = "Safe Enemy Highlight Colour",
            description = "Colour used to highlight monsters that cannot melee you"
    )
    default Color getSafeColour()
    {
        return Color.GREEN;
    }

    @ConfigItem(
            keyName = "highlightSafeEnemies",
            name = "Highlight Safe Enemies",
            description = "Highlight Enemies that not be able to melee you"
    )
    default boolean highlightSafeTargets()
    {
        return true;
    }

    @ConfigItem(
            keyName = "dangerousEnemyColour",
            name = "Dangerous Enemy Colour",
            description = "Colour used to highlight monsters that can still melee you "
    )
    default Color getDangerousColour()
    {
        return Color.RED;
    }

    @ConfigItem(
            keyName = "highlightDangerousEnemies",
            name = "Highlight Dangerous Enemies",
            description = "Highlight Enemies that will be able to melee you"
    )
    default boolean highlightDangerous()
    {
        return false;
    }
}
