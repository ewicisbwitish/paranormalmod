package com.ewiclabs.paranormalencounters.items;

import com.ewiclabs.paranormalencounters.ModMain;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;

import java.awt.*;
import java.util.List;

public class EMFReader extends Item implements IItemColor {

    private int level;

    // Constructor
    public EMFReader() {
        super();
        this.setMaxStackSize(1);
        this.setUnlocalizedName("emf_reader");
        this.setRegistryName(ModMain.MODID, "emf_reader");
        this.level = 1;
        this.setCreativeTab(ModMain.tabParanormalEncounters);
    }

    // Detect active redstone and EntityGhost entities
    public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        super.onUpdate(stack, worldIn, entityIn, itemSlot, isSelected);

        if (entityIn instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) entityIn;
            List<Entity> entities = worldIn.getEntitiesWithinAABBExcludingEntity(player, new AxisAlignedBB(player.getPosition().add(-5, -5, -5), player.getPosition().add(5, 5, 5)));

            int newLevel = 1;
            for (Entity entity : entities) {
                if (entity instanceof EntityLivingBase && !(entity instanceof EntityPlayer)) {
                    EntityLivingBase living = (EntityLivingBase) entity;
                    if (living.getName().equals("Ghost")) {
                        newLevel = 5;
                        player.sendMessage("EMF reader detected a ghost nearby!");
                    }
                }
            }

            if (worldIn.isBlockPowered(player.getPosition())) {
                newLevel = 5;
                player.sendMessage("EMF reader detected active redstone nearby!");
            }

            if (newLevel != this.level) {
                this.level = newLevel;
                stack.setItemDamage(this.level - 1);
            }
        }
    }

    // Change the color of the item based on its level
    public int colorMultiplier(ItemStack stack, int tintIndex) {
        if (tintIndex == 1) {
            float r, g, b;
            switch (this.level) {
                case 1:
                    return Minecraft.getMinecraft().getTextureMapBlocks().getAtlasSprite(ModMain.paranormalencounters + ":items/emf_reader_1").getAverageColor();
                case 2:
                    return Minecraft.getMinecraft().getTextureMapBlocks().getAtlasSprite(ModMain.paranormalencounters + ":items/emf_reader_2").getAverageColor();
                case 3:
                    return Minecraft.getMinecraft().getTextureMapBlocks().getAtlasSprite(ModMain.paranormalencounters + ":items/emf_reader_3").getAverageColor();
                case 4:
                    return Minecraft.getMinecraft().getTextureMapBlocks().getAtlasSprite(ModMain.paranormalencounters + ":items/emf_reader_4").getAverageColor();
                case 5:
                    return Minecraft.getMinecraft().getTextureMapBlocks().getAtlasSprite(ModMain.paranormalencounters + ":items/emf_reader_5").getAverageColor();
                default:
                    return Minecraft.getMinecraft().getTextureMapBlocks().getAtlasSprite(ModMain.paranormalencounters + ":items/emf_reader_off").getAverageColor();
            }
            Color color = new Color(r, g, b);
            return color.getRGB();
        } else {
            return 0xFFFFFF;
        }
    }

    // Return the model location for the item
    public String getCustomModelResourceLocation() {
        return ModMain.MODID + ":emf_reader";
    }
}