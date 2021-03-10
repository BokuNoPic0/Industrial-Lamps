package ru.ICY.lamp.Other;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import ru.ICY.lamp.ModMain;

import javax.annotation.Nullable;
import java.util.Random;

public class DefaultBlock extends Block {
    protected static final AxisAlignedBB STANDING_AABB = new AxisAlignedBB(0.2D, 0.2D, 0.2D, 0.8D, 0.8D, 0.8D);
    protected static final AxisAlignedBB FULL_AABB = new AxisAlignedBB(0D, 0D, 0D, 1D, 1D, 1D);
    public DefaultBlock(String name, Material material, CreativeTab tab) {
        this(name,material);
        this.setCreativeTab(tab);
    }
    public DefaultBlock(String name, Material material) {
        super(material);
        this.setHardness(0.3f); //прочность_блока, к примеру 3.0F как у руд
        this.setResistance(0.3f); //К примеру 15.0F как у руд
        this.setTranslationKey(ModMain.MOD_ID+"."+name);
        this.setRegistryName(ModMain.MOD_ID,name);
        this.setLightLevel(0.5f);
        this.setLightOpacity(0);
        //this.setHarvestLevel("pickaxe", 0); //К примеру pickaxe и 0 как деревянная кирка
    }
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        return FULL_AABB;
    }
    @Nullable
    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos){
        return FULL_AABB;//NULL_AABB;
    }
    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }
    public int quantityDropped(Random random)
    {
        return 0;
    }
    public boolean isFullCube(IBlockState state)
    {
        return false;
    }
    protected boolean canSilkHarvest()
    {
        return true;
    }
    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getRenderLayer()
    {
        return BlockRenderLayer.TRANSLUCENT;
    }
    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side) {
        IBlockState iblockstate = blockAccess.getBlockState(pos.offset(side));
        Block block = iblockstate.getBlock();
        return block != this;
    }
}
