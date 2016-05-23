package com.grim3212.mc.pack.decor.client.event;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import com.google.common.collect.Maps;
import com.grim3212.mc.pack.GrimPack;
import com.grim3212.mc.pack.core.client.RenderHelper;
import com.grim3212.mc.pack.decor.block.DecorBlocks;
import com.grim3212.mc.pack.decor.client.model.FurnitureModel;
import com.grim3212.mc.pack.decor.item.DecorItems;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelBakeEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ModelEvent {

	public static HashMap<Item, String[]> renderStates = Maps.newHashMap();

	@SubscribeEvent
	public void onModelBake(ModelBakeEvent event) {
		TextureAtlasSprite particle = Minecraft.getMinecraft().getTextureMapBlocks().getAtlasSprite("minecraft:blocks/portal");

		Iterator<Entry<Item, String[]>> itr = renderStates.entrySet().iterator();

		while (itr.hasNext()) {
			Entry<Item, String[]> entry = itr.next();

			for (String state : entry.getValue()) {
				String name = entry.getKey().getUnlocalizedName().substring(5);
				IBakedModel model = event.getModelRegistry().getObject(new ModelResourceLocation(GrimPack.modID + ":" + name, state));

				// Add all of the currently known Builders
				if (allowedFurniture.contains(entry.getKey()))
					event.getModelRegistry().putObject(new ModelResourceLocation(GrimPack.modID + ":" + name, state), new FurnitureModel(model, particle));
				// else if (allowedLamps.contains(entry.getKey()))
				// event.getModelRegistry().putObject(new
				// ModelResourceLocation(GrimPack.modID + ":" + name, state),
				// new LampPostBuilder(model, particle).makeBakedModel());
				// else if (allowedLampItems.contains(entry.getKey()))
				// event.getModelRegistry().putObject(new
				// ModelResourceLocation(GrimPack.modID + ":" + name, state),
				// new LampPostItemBuilder(model, particle).makeBakedModel());
				// else if (allowedFireplaces.contains(entry.getKey())) {
				// event.getModelRegistry().putObject(new
				// ModelResourceLocation(GrimPack.modID + ":" + name, state),
				// new FireplaceBuilder(model, particle).makeBakedModel());
				// }
			}
		}
	}

	public static void renderCustomModel(Block block, String... states) {
		renderCustomModel(Item.getItemFromBlock(block), states);
	}

	public static void renderNormalModel(Block block) {
		renderCustomModel(Item.getItemFromBlock(block), new String[] { "inventory", "normal" });
	}

	public static void renderCustomModel(Item item, String... states) {
		RenderHelper.renderItem(item);
		renderStates.put(item, states);
	}

	private static List<Item> allowedFurniture = new ArrayList<Item>();
	private static List<Item> allowedLamps = new ArrayList<Item>();
	private static List<Item> allowedLampItems = new ArrayList<Item>();
	private static List<Item> allowedFireplaces = new ArrayList<Item>();

	static {
		allowedFurniture.addAll(Arrays.<Item> asList(new Item[] { Item.getItemFromBlock(DecorBlocks.counter), Item.getItemFromBlock(DecorBlocks.wall), Item.getItemFromBlock(DecorBlocks.table), Item.getItemFromBlock(DecorBlocks.stool), Item.getItemFromBlock(DecorBlocks.chair), Item.getItemFromBlock(DecorBlocks.fence_gate), Item.getItemFromBlock(DecorBlocks.fence) }));
		allowedLamps.addAll(Arrays.<Item> asList(new Item[] { Item.getItemFromBlock(DecorBlocks.lamp_post_bottom), Item.getItemFromBlock(DecorBlocks.lamp_post_middle), Item.getItemFromBlock(DecorBlocks.lamp_post_top) }));
		allowedLampItems.add(DecorItems.lamp_item);
		allowedFireplaces.addAll(Arrays.<Item> asList(new Item[] { Item.getItemFromBlock(DecorBlocks.chimney), Item.getItemFromBlock(DecorBlocks.fireplace), Item.getItemFromBlock(DecorBlocks.firepit), Item.getItemFromBlock(DecorBlocks.firering), Item.getItemFromBlock(DecorBlocks.stove), Item.getItemFromBlock(DecorBlocks.grill) }));
	}
}
