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
        if (this.world.isRemote && this.rand.nextInt(200) == 0) {
            // Get a random sound event from the assets/sounds folder
            ResourceLocation soundLocation = new ResourceLocation("paranormalencounters", "sounds/ghost_sound");
            SoundEvent soundEvent = SoundEvent.REGISTRY.getObject(soundLocation);
            if (soundEvent != null) {
                // Play the sound at the entity's position
                this.world.playSound(this.posX, this.posY, this.posZ, soundEvent, SoundCategory.HOSTILE, 1.0F, 1.0F, true);
            }
        }
        // Add code here to define the behavior of the ghost
    }
}
