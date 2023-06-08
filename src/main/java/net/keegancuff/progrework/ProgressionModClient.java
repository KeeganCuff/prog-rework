package net.keegancuff.progrework;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.keegancuff.progrework.block.ModBlocks;
import net.minecraft.client.render.RenderLayer;

public class ProgressionModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SIEVE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SAND_DUST, RenderLayer.getTranslucent());
    }
}
