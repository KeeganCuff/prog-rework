package net.keegancuff.progrework.mixin;

import net.keegancuff.progrework.ProgressionMod;
import net.keegancuff.progrework.item.ModToolMaterials;
import net.minecraft.item.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

@Mixin(Items.class)
public class ItemsMixin {

    @ModifyArgs(method = "<clinit>", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/SwordItem;<init>(Lnet/minecraft/item/ToolMaterial;IFLnet/minecraft/item/Item$Settings;)V"))
    private static void swordChanges(Args args) {
        ToolMaterials mat = args.get(0);
        switch (mat){
            case WOOD:
                args.set(0, ModToolMaterials.WOOD);
                break;
            case GOLD:
                args.set(0, ModToolMaterials.GOLD);
                args.set(2, -3.0f);
                break;
            case IRON:
                args.set(0, ModToolMaterials.IRON);
                break;
            case STONE:
                args.set(0, ModToolMaterials.STONE);
                break;
        }
    }

    @ModifyArgs(method = "<clinit>", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/AxeItem;<init>(Lnet/minecraft/item/ToolMaterial;FFLnet/minecraft/item/Item$Settings;)V"))
    private static void axeChanges(Args args) {
        ToolMaterials mat = args.get(0);
        switch (mat){
            case WOOD:
                args.set(0, ModToolMaterials.WOOD);
                break;
            case GOLD:
                args.set(0, ModToolMaterials.GOLD);
                args.set(2, 5.0f);
                args.set(2, -3.3f);
                break;
            case IRON:
                args.set(0, ModToolMaterials.IRON);
                break;
            case STONE:
                args.set(0, ModToolMaterials.STONE);
                break;
        }
    }
    @ModifyArgs(method = "<clinit>", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/PickaxeItem;<init>(Lnet/minecraft/item/ToolMaterial;IFLnet/minecraft/item/Item$Settings;)V"))
    private static void pickChanges(Args args) {
        ToolMaterials mat = args.get(0);
        switch (mat){
            case WOOD:
                args.set(0, ModToolMaterials.WOOD);
                break;
            case GOLD:
                args.set(0, ModToolMaterials.GOLD);
                break;
            case IRON:
                args.set(0, ModToolMaterials.IRON);
                break;
            case STONE:
                args.set(0, ModToolMaterials.STONE);
                break;
        }
    }
    @ModifyArgs(method = "<clinit>", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ShovelItem;<init>(Lnet/minecraft/item/ToolMaterial;FFLnet/minecraft/item/Item$Settings;)V"))
    private static void shovelChanges(Args args) {
        ToolMaterials mat = args.get(0);
        switch (mat){
            case WOOD:
                args.set(0, ModToolMaterials.WOOD);
                break;
            case GOLD:
                args.set(0, ModToolMaterials.GOLD);
                break;
            case IRON:
                args.set(0, ModToolMaterials.IRON);
                break;
            case STONE:
                args.set(0, ModToolMaterials.STONE);
                break;
        }
    }
    @ModifyArgs(method = "<clinit>", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/HoeItem;<init>(Lnet/minecraft/item/ToolMaterial;IFLnet/minecraft/item/Item$Settings;)V"))
    private static void hoeChanges(Args args) {
        ToolMaterials mat = args.get(0);
        switch (mat){
            case WOOD:
                args.set(0, ModToolMaterials.WOOD);
                break;
            case GOLD:
                args.set(0, ModToolMaterials.GOLD);
                break;
            case IRON:
                args.set(0, ModToolMaterials.IRON);
                break;
            case STONE:
                args.set(0, ModToolMaterials.STONE);
                break;
        }
    }



//    @ModifyArgs(method = "<clinit>", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/Items;register(Ljava/lang/String;Lnet/minecraft/item/Item;)Lnet/minecraft/item/Item;"))
//    private static void injected(Args args) {
//        String name = args.get(0);
//        args.set(0, name);
//        switch(name){
//            case "golden_sword": // THE PROBLEM IS HERE: all items that are created must be registered. The old args.get(1) is still being created, just not registered.
//                args.set(1, (Item) new SwordItem(ModToolMaterials.GOLD, 100, -2.4f, new Item.Settings()));
//                break;
//            default:
//                args.set(1, args.get(1));
//                return;
//        }
//        ProgressionMod.LOGGER.info(name);
//    }
}
