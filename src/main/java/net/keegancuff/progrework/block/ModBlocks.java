package net.keegancuff.progrework.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.keegancuff.progrework.ProgressionMod;
import net.keegancuff.progrework.block.custom.SandDustBlock;
import net.keegancuff.progrework.block.custom.SieveBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block SIEVE = registerBlockAndItem("sieve",
            new SieveBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).nonOpaque()));
    public static final Block SAND_DUST = registerBlockAndItem("sand_dust",
            new SandDustBlock(FabricBlockSettings.copyOf(Blocks.REDSTONE_WIRE).sounds(BlockSoundGroup.SAND)));

    private static Block registerBlockNoItem(String name, Block block) {
        return Registry.register(Registries.BLOCK, new Identifier(ProgressionMod.MODID, name), block);
    }

    private static Block registerBlockAndItem(String name, Block block){
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(ProgressionMod.MODID, name), block);
    }

    private static Item registerBlockItem(String name, Block block){
        return Registry.register(Registries.ITEM, new Identifier(ProgressionMod.MODID, name), new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerBlocks(){
        ProgressionMod.LOGGER.debug("Registering blocks for mod: " + ProgressionMod.MODID);
    }

}
