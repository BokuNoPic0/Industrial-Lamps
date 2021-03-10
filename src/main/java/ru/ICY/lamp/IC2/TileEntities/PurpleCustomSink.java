package ru.ICY.lamp.IC2.TileEntities;

import ic2.api.energy.prefab.BasicEnergyTe;
import ic2.api.energy.prefab.BasicSink;
import ic2.api.energy.tile.IEnergyEmitter;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;

public class PurpleCustomSink extends BasicEnergyTe<BasicSink> {
    public PurpleCustomSink(int capacity, int tier) {
        this.energyBuffer = new CustomBasicSink(this, (double)capacity, tier);
    }
    public class CustomBasicSink extends BasicSink{
        PurpleMiniLampICTileEntity entity;
        public CustomBasicSink(TileEntity parent, double capacity, int tier){
            super(parent,capacity,tier);
            entity=(PurpleMiniLampICTileEntity)parent;
        }
        @Override
        public boolean acceptsEnergyFrom(IEnergyEmitter emitter, EnumFacing direction) {
            return (
                            entity.facing==EnumFacing.UP && direction==EnumFacing.DOWN ||
                            entity.facing==EnumFacing.DOWN && direction==EnumFacing.UP ||
                            entity.facing==EnumFacing.NORTH && direction==EnumFacing.SOUTH ||
                            entity.facing==EnumFacing.SOUTH && direction==EnumFacing.NORTH ||
                            entity.facing==EnumFacing.WEST && direction==EnumFacing.EAST ||
                            entity.facing==EnumFacing.EAST && direction==EnumFacing.WEST
            );
        }
    }
}