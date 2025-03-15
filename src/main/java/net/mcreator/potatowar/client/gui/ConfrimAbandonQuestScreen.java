package net.mcreator.potatowar.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.potatowar.world.inventory.ConfrimAbandonQuestMenu;
import net.mcreator.potatowar.network.ConfrimAbandonQuestButtonMessage;
import net.mcreator.potatowar.PotatowarMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class ConfrimAbandonQuestScreen extends AbstractContainerScreen<ConfrimAbandonQuestMenu> {
	private final static HashMap<String, Object> guistate = ConfrimAbandonQuestMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_abandon_quest;

	public ConfrimAbandonQuestScreen(ConfrimAbandonQuestMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("potatowar:textures/screens/confrim_abandon_quest.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.potatowar.confrim_abandon_quest.label_are_you_sure_you_want_to"), 24, 7, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.potatowar.confrim_abandon_quest.label_abandon_this_quest"), 33, 25, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.potatowar.confrim_abandon_quest.label_you_will_recive_no_reward_and_wi"), 24, 43, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.potatowar.confrim_abandon_quest.label_and_will_not_be_able_to_comlete"), 6, 61, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.potatowar.confrim_abandon_quest.label_the_quest_later"), 51, 79, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		button_abandon_quest = Button.builder(Component.translatable("gui.potatowar.confrim_abandon_quest.button_abandon_quest"), e -> {
			if (true) {
				PotatowarMod.PACKET_HANDLER.sendToServer(new ConfrimAbandonQuestButtonMessage(0, x, y, z));
				ConfrimAbandonQuestButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 42, this.topPos + 106, 93, 20).build();
		guistate.put("button:button_abandon_quest", button_abandon_quest);
		this.addRenderableWidget(button_abandon_quest);
	}
}
