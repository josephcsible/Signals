package com.minemaarten.signals.network;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumParticleTypes;

/**
 * MineChess
 * @author MineMaarten
 * www.minemaarten.com
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */

public class PacketSpawnParticle extends LocationDoublePacket<PacketSpawnParticle>{

    private double dx, dy, dz;
    private int particleId;

    public PacketSpawnParticle(){}

    public PacketSpawnParticle(EnumParticleTypes particle, double x, double y, double z, double dx, double dy, double dz){
        super(x, y, z);
        particleId = particle.ordinal();
        this.dx = dx;
        this.dy = dy;
        this.dz = dz;
    }

    @Override
    public void toBytes(ByteBuf buffer){
        super.toBytes(buffer);
        buffer.writeInt(particleId);
        buffer.writeDouble(dx);
        buffer.writeDouble(dy);
        buffer.writeDouble(dz);
    }

    @Override
    public void fromBytes(ByteBuf buffer){
        super.fromBytes(buffer);
        particleId = buffer.readInt();
        dx = buffer.readDouble();
        dy = buffer.readDouble();
        dz = buffer.readDouble();
    }

	@Override
	public void handleClientSide(EntityPlayer player) {
		 player.world.spawnParticle(EnumParticleTypes.values()[particleId], x, y, z, dx, dy, dz);
	}

	@Override
	public void handleServerSide(EntityPlayer player) {
		// TODO Auto-generated method stub
		
	}

}
