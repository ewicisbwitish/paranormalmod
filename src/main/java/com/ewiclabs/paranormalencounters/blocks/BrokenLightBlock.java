package com.ewiclabs.paranormalencounters.blocks;

import com.ewiclabs.paranormalencounters.ModMain;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BrokenLightBlock extends Block {

    public BrokenLightBlock() {
        super(Material.GLASS);
        setRegistryName("broken_light_block");
        setUnlocalizedName(ModMain.MODID + ".broken_light_block");
        setSoundType(SoundType.GLASS);
        setHardness(0.5F);
        setLightLevel(0.0F);
    }
}