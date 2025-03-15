package net.mcreator.potatowar.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.potatowar.world.inventory.AssassinQuestMenu;
import net.mcreator.potatowar.procedures.PlayerAssassinThingProcedure;
import net.mcreator.potatowar.procedures.PlayerAssassinNameProcedure;
import net.mcreator.potatowar.procedures.AssassinZProcedure;
import net.mcreator.potatowar.procedures.AssassinXProcedure;
import net.mcreator.potatowar.network.AssassinQuestButtonMessage;
import net.mcreator.potatowar.PotatowarMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class AssassinQuestScreen extends AbstractContainerScreen<AssassinQuestMenu> {
	private final static HashMap<String, Object> guistate = AssassinQuestMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_accpet_quest;

	public AssassinQuestScreen(AssassinQuestMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("potatowar:textures/screens/assassin_quest.png");

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
		guiGraphics.drawString(this.font, Component.translatable("gui.potatowar.assassin_quest.label_hey_i_got_a_job_for_you"), 24, 7, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.potatowar.assassin_quest.label_has"), 15, 43, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.potatowar.assassin_quest.label_can_you_go_to_these_cordinates_a"), 6, 61, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.potatowar.assassin_quest.label_and_eliminate_them_for_me"), 15, 79, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.potatowar.assassin_quest.label_i_will_pay_you_well_if_you_succe"), 33, 97, -12829636, false);
		guiGraphics.drawString(this.font,

				PlayerAssassinNameProcedure.execute(entity), 15, 25, -12829636, false);
		guiGraphics.drawString(this.font,

				PlayerAssassinThingProcedure.execute(entity), 33, 43, -12829636, false);
		guiGraphics.drawString(this.font,

				AssassinXProcedure.execute(entity), 33, 115, -12829636, false);
		guiGraphics.drawString(this.font,

				AssassinZProcedure.execute(entity), 87, 115, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		button_accpet_quest = Button.builder(Component.translatable("gui.potatowar.assassin_quest.button_accpet_quest"), e -> {
			if (true) {
				PotatowarMod.PACKET_HANDLER.sendToServer(new AssassinQuestButtonMessage(0, x, y, z));
				AssassinQuestButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 42, this.topPos + 133, 87, 20).build();
		guistate.put("button:button_accpet_quest", button_accpet_quest);
		this.addRenderableWidget(button_accpet_quest);
	}
}
