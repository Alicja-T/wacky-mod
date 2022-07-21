package net.atexler.wackymod.item;

import net.atexler.wackymod.WackyMod;
import net.atexler.wackymod.item.custom.DowsingRodItem;
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

    public static final RegistryObject<Item> RAW_CURSED_TITANIUM = ITEMS.register("raw_cursed_titanium",
            () -> new Item(new Item.Properties().tab(ModCreativeTab.WACKY_TAB)));

    public static final RegistryObject<Item> FORTUNE_COOKIE = ITEMS.register("fortune_cookie",
            () -> new Item(new Item.Properties().tab(ModCreativeTab.WACKY_TAB).food(ModFoods.FORTUNE_COOKIE)));

    public static final RegistryObject<Item> DOWSING_ROD = ITEMS.register("dowsing_rod",
            () -> new DowsingRodItem(new Item.Properties().tab(ModCreativeTab.WACKY_TAB)));
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
