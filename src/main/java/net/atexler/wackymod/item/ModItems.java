package net.atexler.wackymod.item;

import net.atexler.wackymod.WackyMod;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, WackyMod.MOD_ID);

    public static final RegistryObject<Item> COBALT_INGOT = ITEMS.register("cobalt_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeTab.WACKY_TAB)));

    public static final RegistryObject<Item> CURSED_TITANIUM = ITEMS.register("cursed_titanium",
            () -> new Item(new Item.Properties().tab(ModCreativeTab.WACKY_TAB)));
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
