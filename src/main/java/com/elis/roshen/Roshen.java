package com.elis.roshen;

import com.elis.roshen.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Roshen implements ModInitializer {
	public final static String MOD_ID = "roshen";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Mod initialing");

		ModItems.registerModItems();
	}
}