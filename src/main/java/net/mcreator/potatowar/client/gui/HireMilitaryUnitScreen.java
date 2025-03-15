package net.mcreator.potatowar.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.potatowar.world.inventory.HireMilitaryUnitMenu;
import net.mcreator.potatowar.network.HireMilitaryUnitButtonMessage;
import net.mcreator.potatowar.PotatowarMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class HireMilitaryUnitScreen extends AbstractContainerScreen<HireMilitaryUnitMenu> {
	private final static HashMap<String, Object> guistate = HireMilitaryUnitMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_hire;

	public HireMilitaryUnitScreen(HireMilitaryUnitMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("potatowar:textures/screens/hire_military_unit.png");

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
		guiGraphics.drawString(this.font, Component.translatable("gui.potatowar.hire_military_unit.label_1"), 33, 25, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.potatowar.hire_military_unit.label_2"), 33, 52, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.potatowar.hire_military_unit.label_3"), 96, 25, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		button_hire = Button.builder(Component.translatable("gui.potatowar.hire_military_unit.button_hire"), e -> {
			if (true) {
				PotatowarMod.PACKET_HANDLER.sendToServer(new HireMilitaryUnitButtonMessage(0, x, y, z));
				HireMilitaryUnitButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 87, this.topPos + 52, 46, 20).build();
		guistate.put("button:button_hire", button_hire);
		this.addRenderableWidget(button_hire);
	}
}
