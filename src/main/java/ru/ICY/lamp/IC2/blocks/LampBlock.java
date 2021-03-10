package ru.ICY.lamp.IC2.blocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import ru.ICY.lamp.IC2.TileEntities.LampICTileEntity;
import ru.ICY.lamp.ModMain;
import ru.ICY.lamp.Other.CreativeTab;

import javax.annotation.Nullable;
import java.util.Random;

public class LampBlock extends BlockContainer {
    protected static final AxisAlignedBB FULL_AABB = new AxisAlignedBB(0D, 0D, 0D, 1D, 1D, 1D);
    public LampBlock(String name, Material material, CreativeTab tab, float lightLevel) {
        this(name,material,lightLevel);
        this.setCreativeTab(tab);
    }
    public LampBlock(String name, Material material, float lightLevel) {
        super(material);
        this.setHardness(0.3f); //прочность_блока, к примеру 3.0F как у руд
        this.setResistance(0.3f); //К примеру 15.0F как у руд
        this.setTranslationKey(ModMain.MOD_ID+"."+name);
        this.setRegistryName(ModMain.MOD_ID,name);
        this.setLightLevel(lightLevel);
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
    @Override
    public boolean isOpaqueCube(IBlockState state)
    {
        return true;
    }
    public boolean isFullCube(IBlockState state)
    {
        return true;
    }
    public int quantityDropped(Random random)
    {
        return 1;
    }
    protected boolean canSilkHarvest()
    {
        return true;
    }
    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getRenderLayer()
    {
        return BlockRenderLayer.SOLID;
    }
    @Override
    public EnumBlockRenderType getRenderType(IBlockState state) {
        return EnumBlockRenderType.MODEL;
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new LampICTileEntity();
    }
    @Override
    public void breakBlock(World world, BlockPos pos, IBlockState state) { super.breakBlock(world, pos, state); }
    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if(!worldIn.isRemote){
            TileEntity te = worldIn.getTileEntity(pos);
            if (te != null && te instanceof LampICTileEntity && playerIn.capabilities.isCreativeMode) {
                playerIn.sendMessage(new TextComponentString("energy: "+((LampICTileEntity) te).getEnergy()+"/"+((LampICTileEntity) te).getMaxEnergy()));
            }
        }
        return true;
    }
}
