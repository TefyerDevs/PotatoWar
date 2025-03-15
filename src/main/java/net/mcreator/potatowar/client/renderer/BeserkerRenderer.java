
package net.mcreator.potatowar.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.HumanoidModel;

import net.mcreator.potatowar.entity.BeserkerEntity;

public class BeserkerRenderer extends HumanoidMobRenderer<BeserkerEntity, HumanoidModel<BeserkerEntity>> {
	public BeserkerRenderer(EntityRendererProvider.Context context) {
		super(context, new HumanoidModel<BeserkerEntity>(context.bakeLayer(ModelLayers.PLAYER)), 0.5f);
		this.addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)), new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR)), context.getModelManager()));
	}

	@Override
	public ResourceLocation getTextureLocation(BeserkerEntity entity) {
		return new ResourceLocation("potatowar:textures/entities/beserker.png");
	}
}
