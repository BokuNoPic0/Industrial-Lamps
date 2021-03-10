package ru.ICY.lamp.Other;

import com.google.common.base.Predicate;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import ru.ICY.lamp.ModMain;

import javax.annotation.Nullable;

public class TestBlock extends Block {
    public static final PropertyDirection FACING = PropertyDirection.create("facing", new Predicate<EnumFacing>()
    {
        public boolean apply(@Nullable EnumFacing enumFacing) {
            return true;//enumFacing != EnumFacing.DOWN;
        }
    });
    protected static final AxisAlignedBB DOWN_AABB = new AxisAlignedBB(0.25, 1D, 0.25, 0.75, 0.4, 0.75);
    protected static final AxisAlignedBB UP_AABB = new AxisAlignedBB(0.25, 0.0D, 0.25, 0.75, 0.6, 0.75);//STANDING
    protected static final AxisAlignedBB NORTH_AABB = new AxisAlignedBB(0.25, 0.25, 0.4, 0.8, 0.75, 1);
    protected static final AxisAlignedBB SOUTH_AABB = new AxisAlignedBB(0.25, 0.25, 0.0D, 0.8, 0.75, 0.6);
    protected static final AxisAlignedBB WEST_AABB = new AxisAlignedBB(0.5, 0.25, 0.25, 1.0D, 0.75, 0.75);
    protected static final AxisAlignedBB EAST_AABB = new AxisAlignedBB(0.0D, 0.25, 0.25, 0.6, 0.75, 0.75);
    public TestBlock(String name, CreativeTab tab) {
        super(Material.CIRCUITS);
        this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.UP));
        this.setTickRandomly(true);
        this.setCreativeTab(CreativeTabs.DECORATIONS);
        this.setTranslationKey(ModMain.MOD_ID+"."+name);
        this.setRegistryName(ModMain.MOD_ID,name);
        this.setCreativeTab(tab);
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
                iblockstate = iblockstate.withProperty(FACING, EnumFacing.UP);
            case 6:
            default:
                iblockstate = iblockstate.withProperty(FACING, EnumFacing.DOWN);
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
            case UP:
                return 5;
            case DOWN:
            default:
                return 6;
        }
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
}
