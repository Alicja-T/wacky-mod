package net.atexler.wackymod.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

public class BouncyBlock extends Block {

    public BouncyBlock(Properties properties) {
        super(properties);
    }

    @Override
    public void stepOn(Level pLevel, BlockPos pPos, BlockState pState, Entity pEntity) {

       if(pEntity instanceof LivingEntity){
           Vec3 vec3 = pEntity.getDeltaMovement();
           pEntity.setDeltaMovement(vec3.x, vec3.y + 0.75f, vec3.z);
       }
       super.stepOn(pLevel, pPos, pState, pEntity);
    }
}
