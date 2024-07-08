package com.elis.roshen;

import com.elis.roshen.block.ModBlocks;
import com.elis.roshen.item.ModItems;
import eu.pb4.polymer.resourcepack.api.PolymerResourcePackUtils;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Roshen implements ModInitializer {
    public final static String MOD_ID = "roshen";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("Mod initialing");

        ModItems.registerModItems();
        ModBlocks.registerModBlocks();

        if (PolymerResourcePackUtils.addModAssets(MOD_ID)) {
            LOGGER.info("Successfully added mod assets for " + MOD_ID);
        } else {
			LOGGER.info("Failed to add mod assets " + MOD_ID);
        }

		PolymerResourcePackUtils.markAsRequired();
    }
}