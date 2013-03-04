package deverionx.tutorial.client.core.handlers;

import java.util.EnumSet;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiContainerCreative;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.src.ModLoader;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;

public class GuiTicker implements ITickHandler {

	@Override
	public void tickStart(EnumSet<TickType> type, Object... tickData) {

	}

	@Override
	public void tickEnd(EnumSet<TickType> type, Object... tickData) {
		Minecraft mc = ModLoader.getMinecraftInstance();
		EntityPlayer p;
		
		if(Minecraft.getMinecraft().renderViewEntity instanceof EntityPlayer){
			p = (EntityPlayer) mc.getMinecraft().renderViewEntity;
			
			long time = System.currentTimeMillis();
			
			GuiScreen gs = mc.currentScreen;
			
			if(type.contains(TickType.RENDER)){
				if(gs instanceof GuiContainerCreative){
					gs.drawString(mc.fontRenderer, "Tutorials are great!", 20, 10, 0xFFFFFF);
				}
			}
		}
		

	}

	@Override
	public EnumSet<TickType> ticks() {
		return EnumSet.of(TickType.RENDER);
	}

	@Override
	public String getLabel() {
		return "Deverions Tutorials";
	}

}
