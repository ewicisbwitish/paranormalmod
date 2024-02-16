package com.ewiclabs.paranormalencounters.blocks;

import com.ewiclabs.paranormalencounters.ModMain;
import com.ewiclabs.paranormalencounters.entities.EntityGhost;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;

public class REMPodBlock extends Block {

    // Constructor
    public REMPodBlock() {
        super(Material.ROCK);
        this.setSoundType(SoundType.STONE);
        this.setHardness(1.5F);
        this.setResistance(10.0F);
        this.setUnlocalizedName("rem_pod_block");
        this.setRegistryName(ModMain.MODID, "rem_pod_block");
    }

    // Define the behavior of the REMpod block when an entity enters its detection area
    public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, Entity entityIn) {
        if (!worldIn.isRemote && entityIn instanceof EntityGhost) {
            EntityPlayer player = worldIn.getClosestPlayer(pos.getX(), pos.getY(), pos.getZ(), -1, false);
            if (player != null) {
                player.sendMessage(new TextComponentString("REMPod has detected something"));
            }
        }
    }

    // Define the detection area of the REMpod block
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        return new AxisAlignedBB(pos.getX() - 5, pos.getY() - 5, pos.getZ() - 5, pos.getX() + 5, pos.getY() + 5, pos.getZ() + 5);
    }

}