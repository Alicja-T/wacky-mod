package net.atexler.wackymod.block;

import net.atexler.wackymod.WackyMod;
import net.atexler.wackymod.block.custom.BouncyBlock;
import net.atexler.wackymod.block.custom.SpinBlock;
import net.atexler.wackymod.item.ModCreativeTab;
import net.atexler.wackymod.item.ModItems;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, WackyMod.MOD_ID);

    public static final RegistryObject<Block> COBALT_BLOCK = registerBlock("cobalt_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(5f)
                    .requiresCorrectToolForDrops()), ModCreativeTab.WACKY_TAB);
    public static final RegistryObject<Block> CURSED_TITANIUM_BLOCK = registerBlock("cursed_titanium_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(5f)
                    .requiresCorrectToolForDrops()), ModCreativeTab.WACKY_TAB);
    public static final RegistryObject<Block> CURSED_TITANIUM_ORE = registerBlock("cursed_titanium_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(2f)
                    .requiresCorrectToolForDrops()), ModCreativeTab.WACKY_TAB);
    public static final RegistryObject<Block> CURSED_TITANIUM_STAIRS = registerBlock("cursed_titanium_stairs",
            () -> new StairBlock(() -> ModBlocks.CURSED_TITANIUM_BLOCK.get().defaultBlockState(),
                        BlockBehaviour.Properties.of(Material.METAL).strength(5f)
                        .requiresCorrectToolForDrops()), ModCreativeTab.WACKY_TAB);
    public static final RegistryObject<Block> CURSED_TITANIUM_SLAB = registerBlock("cursed_titanium_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of(Material.METAL).strength(5f)
                    .requiresCorrectToolForDrops()), ModCreativeTab.WACKY_TAB);


    //special blocks
    public static final RegistryObject<Block> BOUNCY_BLOCK = registerBlock("bouncy_block",
            () -> new BouncyBlock(BlockBehaviour.Properties.of(Material.GRASS).strength(2f)
                    .requiresCorrectToolForDrops()), ModCreativeTab.WACKY_TAB, "tooltip.wackymod.bouncy_block");
    public static final RegistryObject<Block> SPIN_BLOCK = registerBlock("spin_block",
            () -> new SpinBlock(BlockBehaviour.Properties.of(Material.GRASS).strength(2f)
                    .requiresCorrectToolForDrops()), ModCreativeTab.WACKY_TAB);
    private static <T extends Block> RegistryObject<T> registerBlock( String name,
                                                                      Supplier<T> block,
                                                                      CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name,
                                                                            RegistryObject<T> block,
                                                                            CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () ->  new BlockItem(block.get(),
                                                    new Item.Properties().tab(tab) ) );
    }

    private static <T extends Block> RegistryObject<T> registerBlock( String name,
                                                                      Supplier<T> block,
                                                                      CreativeModeTab tab,
                                                                      String tooltipKey) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab, tooltipKey);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name,
                                                                            RegistryObject<T> block,
                                                                            CreativeModeTab tab,
                                                                            String tooltipKey) {
        return ModItems.ITEMS.register(name, () ->  new BlockItem(block.get(),
                new Item.Properties().tab(tab)){
            @Override
            public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltip, TooltipFlag pFlag) {
                pTooltip.add(new TranslatableComponent(tooltipKey));
            }
        });
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

}
