package net.mcreator.potatowar.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.potatowar.world.inventory.ShowCurrentQuestMenu;
import net.mcreator.potatowar.procedures.PlayerAssassinNameProcedure;
import net.mcreator.potatowar.procedures.AssassinZProcedure;
import net.mcreator.potatowar.procedures.AssassinXProcedure;
import net.mcreator.potatowar.network.ShowCurrentQuestButtonMessage;
import net.mcreator.potatowar.PotatowarMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class ShowCurrentQuestScreen extends AbstractContainerScreen<ShowCurrentQuestMenu> {
	private final static HashMap<String, Object> guistate = ShowCurrentQuestMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_abandon_quest;

	public ShowCurrentQuestScreen(ShowCurrentQuestMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("potatowar:textures/screens/show_current_quest.png");

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
		guiGraphics.drawString(this.font, Component.translatable("gui.potatowar.show_current_quest.label_current_quest"), 51, 7, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.potatowar.show_current_quest.label_elimnate"), 60, 25, -12829636, false);
		guiGraphics.drawString(this.font,

				PlayerAssassinNameProcedure.execute(entity), 24, 43, -12829636, false);
		guiGraphics.drawString(this.font,

				AssassinXProcedure.execute(entity), 33, 79, -12829636, false);
		guiGraphics.drawString(this.font,

				AssassinZProcedure.execute(entity), 87, 79, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.potatowar.show_current_quest.label_last_seen_at"), 51, 61, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		button_abandon_quest = Button.builder(Component.translatable("gui.potatowar.show_current_quest.button_abandon_quest"), e -> {
			if (true) {
				PotatowarMod.PACKET_HANDLER.sendToServer(new ShowCurrentQuestButtonMessage(0, x, y, z));
				ShowCurrentQuestButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 42, this.topPos + 115, 93, 20).build();
		guistate.put("button:button_abandon_quest", button_abandon_quest);
		this.addRenderableWidget(button_abandon_quest);
	}
}
