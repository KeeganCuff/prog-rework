package net.keegancuff.progrework.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.keegancuff.progrework.ProgressionMod;
import net.keegancuff.progrework.block.ModBlocks;
import net.minecraft.item.*;
import net.minecraft.registry.MutableRegistry;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item QUARTZ_NUGGET = registerItem("quartz_nugget", new Item(new FabricItemSettings()));
    //public static final Item SAND_DUST = registerItem("sand_dust", new Item(new FabricItemSettings()));




    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(ProgressionMod.MODID, name), item);
    }

    public static void registerItemsAndGroups(){
        ProgressionMod.LOGGER.debug("Registering items for mod: " + ProgressionMod.MODID);
        registerGroups();
    }

    private static void registerGroups() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(entries -> entries.addAfter(Items.FURNACE, ModBlocks.SIEVE));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> entries.addAfter(Items.FLINT, ModItems.QUARTZ_NUGGET));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> entries.addAfter(ModItems.QUARTZ_NUGGET, ModBlocks.SAND_DUST));
    }
}
