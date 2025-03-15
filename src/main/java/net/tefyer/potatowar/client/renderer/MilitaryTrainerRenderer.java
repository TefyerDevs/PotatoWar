
package net.tefyer.potatowar.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.HumanoidModel;

import net.tefyer.potatowar.entity.MilitaryTrainerEntity;

public class MilitaryTrainerRenderer extends HumanoidMobRenderer<MilitaryTrainerEntity, HumanoidModel<MilitaryTrainerEntity>> {
	public MilitaryTrainerRenderer(EntityRendererProvider.Context context) {
		super(context, new HumanoidModel<MilitaryTrainerEntity>(context.bakeLayer(ModelLayers.PLAYER)), 0.5f);
		this.addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)), new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR)), context.getModelManager()));
	}

	@Override
	public ResourceLocation getTextureLocation(MilitaryTrainerEntity entity) {
		return new ResourceLocation("potatowar:textures/entities/potatoman.png");
	}
}
