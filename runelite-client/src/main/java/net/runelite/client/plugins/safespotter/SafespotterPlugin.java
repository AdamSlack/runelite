package net.runelite.client.plugins.safespotter;

import com.google.inject.Provides;
import net.runelite.api.Client;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;

import javax.inject.Inject;

public class SafespotterPlugin extends Plugin {

    @Inject
    private Client client;

    @Inject
    private SafespotterConfig config;

    @Inject
    private SafespotterOverlay overlay;

    @Provides
    SafespotterConfig provideConfig(ConfigManager configManager)
    {
        return configManager.getConfig(SafespotterConfig.class);
    }

    @Override
    protected void startUp() throws Exception
    {
        safespotterOverlay = new SafespotterOverlay(client, config)
    }

}
