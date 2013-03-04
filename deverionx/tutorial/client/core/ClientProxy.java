package deverionx.tutorial.client.core;

import deverionx.tutorial.common.core.CommonProxy;
import net.minecraftforge.client.MinecraftForgeClient;

public class ClientProxy extends CommonProxy {
     
	public void registerRenderInformation(){
		MinecraftForgeClient.preloadTexture("/TutorialGFX/Items.png");
		MinecraftForgeClient.preloadTexture("/TutorialGFX/Blocks.png");
	}
	
}
