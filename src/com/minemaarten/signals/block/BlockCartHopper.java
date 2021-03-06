package com.minemaarten.signals.block;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

import com.minemaarten.signals.proxy.CommonProxy.EnumGuiId;
import com.minemaarten.signals.tileentity.TileEntityCartHopper;

public class BlockCartHopper extends BlockBase{

    public BlockCartHopper(){
        super(TileEntityCartHopper.class, "cart_hopper");
    }

    @Override
    public EnumGuiId getGuiID(){
        return EnumGuiId.CART_HOPPER;
    }

    @Override
    public int getWeakPower(IBlockState state, IBlockAccess worldIn, BlockPos pos, EnumFacing side){
        TileEntityCartHopper cartHopper = (TileEntityCartHopper)worldIn.getTileEntity(pos);
        return cartHopper.emitsRedstone() ? 15 : 0;
    }

    /**
     * Can this block provide power. Only wire currently seems to have this change based on its state.
     */
    @Override
    public boolean canProvidePower(IBlockState state){
        return true;
    }
}
