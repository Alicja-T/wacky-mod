package net.atexler.wackymod.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class SpinBlock extends Block {
    public SpinBlock(Properties properties) {
        super(properties);
    }

    @Override
    public void stepOn(Level pLevel, BlockPos pPos, BlockState pState, Entity pEntity) {

        if(pEntity instanceof LivingEntity) {
            Vec2 vec2 = pEntity.getRotationVector();
            pEntity.setYRot(vec2.y + 1.5f);
        }
        super.stepOn(pLevel, pPos, pState, pEntity);
    }
}
