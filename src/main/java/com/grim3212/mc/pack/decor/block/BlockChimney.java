package com.grim3212.mc.pack.decor.block;

import java.util.Random;

import com.grim3212.mc.pack.decor.GrimDecor;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockChimney extends BlockFireplaceBase {

	@Override
	public void randomDisplayTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand) {
		if (worldIn.getBlockState(pos.down()).getBlock() == Blocks.FIRE) {
			if (worldIn.rand.nextInt(2) == 0) {
				int smokeheight = 1;
				while (worldIn.getBlockState(pos.up(smokeheight)) == DecorBlocks.chimney) {
					smokeheight++;
				}

				GrimDecor.proxy.produceSmoke(worldIn, pos.up(smokeheight), 0.5D, 0.0D, 0.5D, 1, true);
			}
		}
	}

}
