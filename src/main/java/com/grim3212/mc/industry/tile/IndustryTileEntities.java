package com.grim3212.mc.industry.tile;

import com.grim3212.mc.core.part.IPartEntities.IPartTileEntities;

import net.minecraftforge.fml.common.registry.GameRegistry;

public class IndustryTileEntities implements IPartTileEntities {

	@Override
	public void initTileEntities() {
		GameRegistry.registerTileEntity(TileEntitySensor.class, "sensors");
		GameRegistry.registerTileEntity(TileEntityGravity.class, "gravity");
		GameRegistry.registerTileEntity(TileEntityCamo.class, "camo_plate");
		GameRegistry.registerTileEntity(TileEntityDGravity.class, "directional_gravity");
		GameRegistry.registerTileEntity(TileEntityMachine.class, "machine");
		GameRegistry.registerTileEntity(TileEntityMFurnace.class, "modern_furnace");
	}

}
