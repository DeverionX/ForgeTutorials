package deverionx.tutorial.client.core.handlers;


import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.Player;
import cpw.mods.fml.relauncher.*;

@SideOnly(Side.CLIENT)
public class ClientPacketHandler implements IPacketHandler{
	@Override
	public void onPacketData(INetworkManager manager, Packet250CustomPayload payload, Player player){
		DataInputStream data = new DataInputStream(new ByteArrayInputStream(payload.data)); //Handles incoming data
	}
}