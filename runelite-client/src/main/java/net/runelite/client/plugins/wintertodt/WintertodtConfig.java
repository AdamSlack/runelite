package net.runelite.client.plugins.wintertodt;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import java.awt.Color;

@ConfigGroup(
        keyName = "wintertodt",
        name = "Wintertodt",
        description = "Highlights Wintertodt minigame events, including snowfall and broken fires"
)

public interface WintertodtConfig extends Config{
    @ConfigItem(
            keyName = "snowfallHighlightColour",
            name = "Snowfall Highlight Colour",
            description = "The colour of the tile highlight used to indicate Wintertodt snowfall"
    )
    default Color snowfallHighlightColour()
    {
        return Color.RED;
    }
}
