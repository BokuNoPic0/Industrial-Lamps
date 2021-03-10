package ru.ICY.lamp.IC2.blocks;

import com.google.common.base.Predicate;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.*;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import ru.ICY.lamp.IC2.TileEntities.MiniLampICTileEntity;
import ru.ICY.lamp.IC2.TileEntities.PurpleMiniLampICTileEntity;
import ru.ICY.lamp.ModMain;
import ru.ICY.lamp.Other.CreativeTab;

import javax.annotation.Nullable;
import java.util.Random;

public class PurpleMiniLampBlock extends BlockContainer{// BlockContainer block
    public static final PropertyDirection FACING = PropertyDirection.create("facing", new Predicate<EnumFacing>()
    {
        public boolean apply(@Nullable EnumFacing enumFacing) {
            return true;//enumFacing != EnumFacing.DOWN;
        }
    });
    protected static final AxisAlignedBB DOWN_AABB = new AxisAlignedBB(0.1875, 1D, 0.1875, 0.8125, 0.25, 0.8125);
    protected static final AxisAlignedBB UP_AABB = new AxisAlignedBB(0.1875, 0.0D, 0.1875, 0.8125, 0.75, 0.8125);//STANDING
    protected static final AxisAlignedBB NORTH_AABB = new AxisAlignedBB(0.1875, 0.1875, 0.25, 0.8125, 0.8125, 1);
    protected static final AxisAlignedBB SOUTH_AABB = new AxisAlignedBB(0.1875, 0.1875, 0.0D, 0.8125, 0.8125, 0.75);
    protected static final AxisAlignedBB WEST_AABB = new AxisAlignedBB(0.25, 0.1875, 0.1875, 1.0D, 0.8125, 0.8125);
    protected static final AxisAlignedBB EAST_AABB = new AxisAlignedBB(0.0D, 0.1875, 0.1875, 0.75, 0.8125, 0.8125);
    public PurpleMiniLampBlock(String name, CreativeTab tab, float lightLevel) {
        super(Material.CIRCUITS);
        this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.UP));
        this.setTickRandomly(true);
        this.setCreativeTab(CreativeTabs.DECORATIONS);
        this.setTranslationKey(ModMain.MOD_ID+"."+name);
        this.setRegistryName(ModMain.MOD_ID,name);
        this.setCreativeTab(tab);
        this.setLightLevel(lightLevel);
    }
    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        switch ((EnumFacing)state.getValue(FACING)) {
            case EAST:
                return EAST_AABB;
            case WEST:
                return WEST_AABB;
            case SOUTH:
                return SOUTH_AABB;
            case NORTH:
                return NORTH_AABB;
            case UP:
                return UP_AABB;
            default:
                return DOWN_AABB;
        }
    }
    @Override
    public AxisAlignedBB getCollisionBoundingBox(IBlockState state, IBlockAccess worldIn, BlockPos pos)
    {
        switch ((EnumFacing)state.getValue(FACING)) {
            case EAST:
                return EAST_AABB;
            case WEST:
                return WEST_AABB;
            case SOUTH:
                return SOUTH_AABB;
            case NORTH:
                return NORTH_AABB;
            case UP:
                return UP_AABB;
            default:
                return DOWN_AABB;
        }
    }
    @Override
    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }
    @Override
    public boolean isFullCube(IBlockState state)
    {
        return false;
    }
    @Override
    public boolean canPlaceBlockOnSide(World worldIn, BlockPos pos, EnumFacing side) {
        return true;
    }
    @Override
    public boolean canPlaceBlockAt(World worldIn, BlockPos pos) {
        return true;
    }
    @Override
    public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
        return this.getDefaultState().withProperty(FACING, facing);
    }
    @Override
    public IBlockState getStateFromMeta(int meta) {
        IBlockState iblockstate = this.getDefaultState();
        switch (meta) {
            case 1:
                iblockstate = iblockstate.withProperty(FACING, EnumFacing.EAST);
                break;
            case 2:
                iblockstate = iblockstate.withProperty(FACING, EnumFacing.WEST);
                break;
            case 3:
                iblockstate = iblockstate.withProperty(FACING, EnumFacing.SOUTH);
                break;
            case 4:
                iblockstate = iblockstate.withProperty(FACING, EnumFacing.NORTH);
                break;
            case 5:
                iblockstate = iblockstate.withProperty(FACING, EnumFacing.DOWN);
                break;
            case 6:
                iblockstate = iblockstate.withProperty(FACING, EnumFacing.UP);
                break;
            default:
                iblockstate = iblockstate.withProperty(FACING, EnumFacing.UP);
        }
        return iblockstate;
    }

    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getRenderLayer()
    {
        return BlockRenderLayer.CUTOUT;
    }
    public int getMetaFromState(IBlockState state) {
        switch ((EnumFacing)state.getValue(FACING)) {
            case EAST:
                return 1;
            case WEST:
                return 2;
            case SOUTH:
                return 3;
            case NORTH:
                return 4;
            case DOWN:
                return 5;
            case UP:
                return 6;
            default:
                return 5;
        }
    }
    @Override
    public EnumBlockRenderType getRenderType(IBlockState state) {
        return EnumBlockRenderType.MODEL;
    }
    @Override
    public IBlockState withRotation(IBlockState state, Rotation rot) {
        return state.withProperty(FACING, rot.rotate((EnumFacing)state.getValue(FACING)));
    }
    @Override
    public IBlockState withMirror(IBlockState state, Mirror mirrorIn) {
        return state.withRotation(mirrorIn.toRotation((EnumFacing)state.getValue(FACING)));
    }
    @Override
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {FACING});
    }
    @Override
    public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face){
        return BlockFaceShape.UNDEFINED;
    }
    @Override
    public int quantityDropped(Random random)
    {
        return 1;
    }
    @Override
    public void breakBlock(World world, BlockPos pos, IBlockState state) { super.breakBlock(world, pos, state); }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new PurpleMiniLampICTileEntity(getStateFromMeta(meta).getValue(FACING));
    }
    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if(!worldIn.isRemote){
            TileEntity te = worldIn.getTileEntity(pos);
            if (te != null && te instanceof PurpleMiniLampICTileEntity && playerIn.capabilities.isCreativeMode) {
                playerIn.sendMessage(new TextComponentString("energy: "+((PurpleMiniLampICTileEntity) te).getEnergy()+"/"+((MiniLampICTileEntity) te).getMaxEnergy()));
            }
        }
        return true;
    }
}
