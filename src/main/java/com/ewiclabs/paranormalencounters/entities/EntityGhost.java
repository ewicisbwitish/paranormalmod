package com.ewiclabs.paranormalencounters.entities;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityGhost extends EntityLivingBase {
    public enum GhostType {
        PASSIVE,
        AGGRESSIVE,
        DEMONIC
    }

    private GhostType type;

    public EntityGhost(World worldIn, GhostType type) {
        super(worldIn);
        this.type = type;
        this.setSize(0.6F, 1.8F);
        this.setInvisible(true);
        this.setEntityBoundingBox(null);
    }

    public void onUpdate() {
        super.onUpdate();
        switch (type) {
            case PASSIVE:
                // Add code for passive ghost behavior
                break;
            case AGGRESSIVE:
                // Add code for aggressive ghost behavior
                if (this.getAttackTarget() != null) {
                    this.getAttackTarget().attackEntityFrom(DamageSource.MAGIC, 2.0F);
                }
                break;
            case DEMONIC:
                // Add code for demonic ghost behavior
                if (this.getAttackTarget() != null) {
                    this.getAttackTarget().attackEntityFrom(DamageSource.MAGIC, 4.0F);
                }
                break;
        }
    }
}