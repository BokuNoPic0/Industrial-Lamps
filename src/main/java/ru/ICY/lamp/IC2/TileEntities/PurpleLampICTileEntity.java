package ru.ICY.lamp.IC2.TileEntities;

import ic2.api.energy.prefab.BasicEnergyTe.Sink;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import ru.ICY.lamp.ModMain;

public class PurpleLampICTileEntity extends Sink implements ITickable{
    public PurpleLampICTileEntity() {
        super(ModMain.lampCapacity,1);//todo фикс силы взрыва
    }
    @Override
    public void update() {
        if(this.world.isRemote)
            return;
        double price = ModMain.lampInput;
        if(this.energyBuffer.getEnergyStored()>=price){
            this.energyBuffer.useEnergy(price);
            if(this.world.getBlockState(this.pos).getBlock() == ModMain.CustomBlocks.purple_lamp_off){
                this.world.setBlockState(this.pos,ModMain.CustomBlocks.purple_lamp_on.getDefaultState());
            }
        } else {
            if(this.world.getBlockState(this.pos).getBlock() == ModMain.CustomBlocks.purple_lamp_on){
                this.world.setBlockState(this.pos,ModMain.CustomBlocks.purple_lamp_off.getDefaultState());
            }
        }
        TileEntity te = world.getTileEntity(this.pos);
        if(te!=null && te!=this && te instanceof PurpleLampICTileEntity){
            ((PurpleLampICTileEntity)te).energyBuffer.setEnergyStored(this.energyBuffer.getEnergyStored());
        }
    }
    public double getEnergy(){
        return this.energyBuffer.getEnergyStored();
    }
    public double getMaxEnergy(){
        return this.energyBuffer.getCapacity();
    }
    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        return super.writeToNBT(compound);
    }
    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
    }
}
