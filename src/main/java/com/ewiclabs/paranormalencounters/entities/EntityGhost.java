package com.ewiclabs.paranormalencounters.entities;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;

public class EntityGhost extends EntityLivingBase {

    // Constructor
    public EntityGhost(World worldIn) {
        super(worldIn);
        this.setSize(0.6F, 1.8F);
        this.setInvisible(true);
        this.setEntityBoundingBox(null);
    }

    // Define the behavior of the ghost
    public void onUpdate() {
        super.onUpdate();
        // Add code here to define the behavior of the ghost
    }
}
