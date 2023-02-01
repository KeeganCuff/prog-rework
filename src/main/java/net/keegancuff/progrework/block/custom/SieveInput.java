package net.keegancuff.progrework.block.custom;

import net.keegancuff.progrework.item.ModItems;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.StringIdentifiable;

public enum SieveInput implements StringIdentifiable {
    EMPTY("empty", Items.AIR, Items.AIR, 0),
    GRAVEL("gravel", Items.GRAVEL, Items.FLINT, 3),
    SAND("sand", Items.SAND, ModItems.QUARTZ_NUGGET, 1);

    private final String name;
    private final Item input;
    private final Item output;

    private final int chance;

    SieveInput(String name, Item input, Item output, int chance){
        this.name = name;
        this.input = input;
        this.output = output;
        this.chance = chance;
    }

    @Override
    public String asString() {
        return name;
    }

    public Item getInput(){
        return input;
    }
    public Item getOutput(){
        return output;
    }
    public int getChance() {
        return chance;
    }
}
