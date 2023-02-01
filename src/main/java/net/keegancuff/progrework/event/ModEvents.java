package net.keegancuff.progrework.event;

import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.fabricmc.fabric.api.item.v1.ModifyItemAttributeModifiersCallback;

public class ModEvents {
    public static void registerEvents(){
        ModifyItemAttributeModifiersCallback.EVENT.register(new ItemAttributeHandler());
    }
}
