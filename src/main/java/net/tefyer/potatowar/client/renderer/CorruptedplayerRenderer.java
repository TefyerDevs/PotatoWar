
package net.tefyer.potatowar.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.HumanoidModel;

import net.tefyer.potatowar.entity.CorruptedplayerEntity;

public class CorruptedplayerRenderer extends HumanoidMobRenderer<CorruptedplayerEntity, HumanoidModel<CorruptedplayerEntity>> {
	public CorruptedplayerRenderer(EntityRendererProvider.Context context) {
		super(context, new HumanoidModel<CorruptedplayerEntity>(context.bakeLayer(ModelLayers.PLAYER)), 0.5f);
		this.addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)), new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR)), context.getModelManager()));
	}

	@Override
	public ResourceLocation getTextureLocation(CorruptedplayerEntity entity) {
		return new ResourceLocation("potatowar:textures/entities/glitch_2.png");
	}
}
