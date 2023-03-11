package net.keegancuff.progrework;

import net.fabricmc.api.ModInitializer;
import net.keegancuff.progrework.block.ModBlocks;
import net.keegancuff.progrework.event.ModEvents;
import net.keegancuff.progrework.item.ModItems;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.random.Random;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

public class ProgressionMod implements ModInitializer {
	public static final String MODID = "progrework";
	public static final Logger LOGGER = LoggerFactory.getLogger(MODID);

	@Override
	public void onInitialize() {
		ModBlocks.registerBlocks();
		ModItems.registerItemsAndGroups();

		ModEvents.registerEvents(); // unused
	}

	public static void fortuneFormula(Random random, int initialCount, int enchantmentLevel, CallbackInfoReturnable<Integer> ci){
		for (int i = 0; i<enchantmentLevel; i++){
			if (true){
				initialCount *=2;
				break;
			}
		}
		ci.setReturnValue(initialCount);
		ci.cancel();
	}
}
