
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.tefyer.potatowar.init;

import org.lwjgl.glfw.GLFW;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;

import net.tefyer.potatowar.network.CurrentQuestKeyMessage;
import net.tefyer.potatowar.PotatowarMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class PotatowarModKeyMappings {
	public static final KeyMapping CURRENT_QUEST_KEY = new KeyMapping("key.potatowar.current_quest_key", GLFW.GLFW_KEY_Z, "key.categories.ui") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				PotatowarMod.PACKET_HANDLER.sendToServer(new CurrentQuestKeyMessage(0, 0));
                assert Minecraft.getInstance().player != null;
                CurrentQuestKeyMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};

	@SubscribeEvent
	public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
		event.register(CURRENT_QUEST_KEY);
	}

	@Mod.EventBusSubscriber({Dist.CLIENT})
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onClientTick(TickEvent.ClientTickEvent event) {
			if (Minecraft.getInstance().screen == null) {
				CURRENT_QUEST_KEY.consumeClick();
			}
		}
	}
}
