package net.atexler.wackymod.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties FORTUNE_COOKIE = new FoodProperties.Builder().nutrition(1).saturationMod(0.1f)
            .effect(() -> new MobEffectInstance(MobEffects.LUCK, 400), 0.5f).build();
}
