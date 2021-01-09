package com.github.enstroe.client;

import com.github.enstroe.Forgesmith;
import com.github.enstroe.client.gui.screen.ingame.ForgeScreen;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;

@Environment(EnvType.CLIENT)
public class ForgeClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ScreenRegistry.register(Forgesmith.FORGE_SCREEN_HANDLER, ForgeScreen::new);
    }
}