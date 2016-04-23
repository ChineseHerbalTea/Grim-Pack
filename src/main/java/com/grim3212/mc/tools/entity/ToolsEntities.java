package com.grim3212.mc.tools.entity;

import com.grim3212.mc.core.part.IPartEntities;
import com.grim3212.mc.tools.GrimTools;

import net.minecraftforge.fml.common.registry.EntityRegistry;

public class ToolsEntities implements IPartEntities {

	@Override
	public void initEntities() {
		EntityRegistry.registerModEntity(EntityBallisticKnife.class, "BallisticKnife", 0, GrimTools.INSTANCE, 32, 5, true);
		EntityRegistry.registerModEntity(EntityKnife.class, "Knife", 1, GrimTools.INSTANCE, 32, 5, true);
		EntityRegistry.registerModEntity(EntityTomahawk.class, "Tomahawk", 2, GrimTools.INSTANCE, 32, 5, true);
		EntityRegistry.registerModEntity(EntityPokeball.class, "Pokeball", 3, GrimTools.INSTANCE, 32, 5, true);
		EntityRegistry.registerModEntity(EntityBlockPushPull.class, "BlockPushPull", 4, GrimTools.INSTANCE, 32, 5, true);
		EntityRegistry.registerModEntity(EntityRayw.class, "RayShot", 5, GrimTools.INSTANCE, 32, 5, true);
		EntityRegistry.registerModEntity(EntityAdvRayw.class, "AdvRayShot", 6, GrimTools.INSTANCE, 32, 5, true);
		EntityRegistry.registerModEntity(EntitySlingpellet.class, "SlingPellet", 7, GrimTools.INSTANCE, 32, 5, true);
	}

}
