package ru.ICY.lamp.IC2.TileEntities;

import net.minecraft.block.state.IBlockState;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import ru.ICY.lamp.IC2.blocks.MiniLampBlock;
import ru.ICY.lamp.ModMain;

public class BlueMiniLampICTileEntity extends BlueCustomSink implements ITickable{
    EnumFacing facing=null;
    public BlueMiniLampICTileEntity(EnumFacing facing) {
        super(ModMain.miniLampCapacity,1);
        this.facing=facing;
    }
    public BlueMiniLampICTileEntity() {
        super(ModMain.miniLampCapacity,1);
    }
    @Override
    public void update() {
        if(this.world.isRemote)
            return;
        if(facing==null){
            IBlockState state =this.world.getBlockState(this.pos);
            if(state.getBlock() instanceof MiniLampBlock){
                try {
                    facing=state.getValue(MiniLampBlock.FACING);
                } catch (Exception e){
                    facing = EnumFacing.UP;
                }
            } else facing = EnumFacing.UP;
        }
        double price = ModMain.miniLampInput;
        if(this.energyBuffer.getEnergyStored()>=price){
            this.energyBuffer.useEnergy(price);
            if(this.world.getBlockState(this.pos).getBlock() == ModMain.CustomBlocks.blue_mini_lamp_off){
                this.world.setBlockState(this.pos,ModMain.CustomBlocks.mini_lamp_on.getDefaultState().withProperty(MiniLampBlock.FACING,facing));
            }
        } else {
            if(this.world.getBlockState(this.pos).getBlock() == ModMain.CustomBlocks.blue_mini_lamp_on){
                this.world.setBlockState(this.pos,ModMain.CustomBlocks.mini_lamp_off.getDefaultState().withProperty(MiniLampBlock.FACING,facing));
            }
        }
        TileEntity te = world.getTileEntity(this.pos);
        if(te!=null && te!=this && te instanceof BlueMiniLampICTileEntity){
            ((BlueMiniLampICTileEntity)te).energyBuffer.setEnergyStored(this.energyBuffer.getEnergyStored());
        }
    }
    public double getEnergy(){
        return this.energyBuffer.getEnergyStored();
    }
    public double getMaxEnergy(){
        return this.energyBuffer.getCapacity();
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt) {
        super.readFromNBT(nbt);
    }
    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        super.writeToNBT(compound);
        return compound;
    }

}
