package net.runelite.client.plugins.wintertodt;

import com.google.inject.Provides;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.Overlay;

@PluginDescriptor(
        name = "Wintertodt",
        enabledByDefault = false
)
public class WintertodtPlugin extends Plugin{
    @Inject
    private Client client;

    @Inject
    private WintertodtConfig config;

    private WintertodtOverlay wintertodtOverlay;

    @Provides
    WintertodtConfig provideConfig(ConfigManager configManager)
    {
        return configManager.getConfig(WintertodtConfig.class);
    }

    @Override
    protected void startUp() throws Exception
    {
        wintertodtOverlay = new WintertodtOverlay(client, config);
    }

    @Override
    public Overlay getOverlay()
    {
        return wintertodtOverlay;
    }


}
