package net.tefyer.potatowar.client.screen.custom;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.level.Level;
import net.tefyer.api.menus.messages.ItemQuestButtonMessage;
import net.tefyer.potatowar.PotatowarMod;
import net.tefyer.potatowar.client.menus.custom.ItemQuestMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.gui.components.Button;
import com.mojang.blaze3d.systems.RenderSystem;

import java.util.HashMap;


public class ItemQuestScreen extends AbstractContainerScreen<ItemQuestMenu> {
        private final static HashMap<String, Object> guistate = ItemQuestMenu.guistate;
        private final Level world;
        private final int x, y, z;
        private final Player entity;
        private static final ResourceLocation texture = new ResourceLocation("potatowar:textures/screens/itemquest.png");
        Button button_trade;

        public ItemQuestScreen(ItemQuestMenu container, Inventory inventory, Component text) {
            super(container, inventory, text);
            this.world = container.world;
            this.x = container.x;
            this.y = container.y;
            this.z = container.z;
            this.entity = container.entity;
            this.imageWidth = 176;
            this.imageHeight = 166;
        }
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
            guiGraphics.blit(texture, this.leftPos, this.topPos,
                    0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
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
            guiGraphics.drawString(this.font, Component.translatable("gui.potatowar.itemquest.label_can_you_get_me"), 6, 16, -12829636, false);
            guiGraphics.drawString(this.font, Component.translatable("gui.potatowar.itemquest.label_reward"), 114, 16, -12829636, false);
        }

        @Override
        public void init() {
            super.init();
            button_trade = Button.builder(Component.translatable("gui.potatowar.itemquest.button_trade"), e -> {
                PotatowarMod.PACKET_HANDLER.sendToServer(new ItemQuestButtonMessage(0, x, y, z));
                ItemQuestButtonMessage.handleButtonAction(entity, 0, x, y, z);
            }).bounds(this.leftPos + 105, this.topPos + 61, 51, 20).build();
            guistate.put("button:button_trade", button_trade);
            this.addRenderableWidget(button_trade);
        }
    }