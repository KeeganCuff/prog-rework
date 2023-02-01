package net.keegancuff.progrework;

import net.fabricmc.api.ModInitializer;
import net.keegancuff.progrework.block.ModBlocks;
import net.keegancuff.progrework.event.ModEvents;
import net.keegancuff.progrework.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProgressionMod implements ModInitializer {
	public static final String MODID = "progrework";
	public static final Logger LOGGER = LoggerFactory.getLogger(MODID);

	@Override
	public void onInitialize() {
		ModBlocks.registerBlocks();
		ModItems.registerItemsAndGroups();

		ModEvents.registerEvents(); // unused
	}
}
