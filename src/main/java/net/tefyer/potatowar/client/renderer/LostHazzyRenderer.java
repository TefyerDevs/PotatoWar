
package net.tefyer.potatowar.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.HumanoidModel;

import net.tefyer.potatowar.entity.LostHazzyEntity;

public class LostHazzyRenderer extends HumanoidMobRenderer<LostHazzyEntity, HumanoidModel<LostHazzyEntity>> {
	public LostHazzyRenderer(EntityRendererProvider.Context context) {
		super(context, new HumanoidModel<LostHazzyEntity>(context.bakeLayer(ModelLayers.PLAYER)), 0.5f);
		this.addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)), new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR)), context.getModelManager()));
	}

	@Override
	public ResourceLocation getTextureLocation(LostHazzyEntity entity) {
		return new ResourceLocation("potatowar:textures/entities/428c5d913c53eec7.png");
	}
}
