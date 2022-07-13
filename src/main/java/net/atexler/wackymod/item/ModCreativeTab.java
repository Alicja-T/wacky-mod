package net.atexler.wackymod.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeTab {
    public static final CreativeModeTab WACKY_TAB = new CreativeModeTab("wacky_mod") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.CURSED_TITANIUM.get());
        }
    };
}
