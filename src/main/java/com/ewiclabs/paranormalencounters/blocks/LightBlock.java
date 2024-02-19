package com.ewiclabs.paranormalencounters.blocks;

import com.ewiclabs.paranormalencounters.ModMain;
import com.ewiclabs.paranormalencounters.entities.EntityGhost;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

public class LightBlock extends Block {

    public LightBlock() {
        super(Material.GLASS);
        setRegistryName("light_block");
        setUnlocalizedName(ModMain.MODID + ".light_block");
        setSoundType(SoundType.GLASS);
        setHardness(0.5F);
        setLightLevel(1.0F);
    }

    public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn) {
        if (entityIn instanceof EntityGhost) {
            EntityGhost.GhostType type = ((EntityGhost) entityIn).getType();
            switch (type) {
                case PASSIVE:
                    this.setLightLevel(0.3F);
                    break;
                case AGGRESSIVE:
                    this.setLightLevel(0.8F);
                    break;
                case DEMONIC:
                    worldIn.setBlockState(pos, ModMain.BROKEN_LIGHT_BLOCK.getDefaultState());
                    break;
            }
        } else {
            this.setLightLevel(1.0F);
        }
    }
}