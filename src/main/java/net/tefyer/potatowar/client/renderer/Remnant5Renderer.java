
package net.tefyer.potatowar.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.HumanoidModel;

import net.tefyer.potatowar.entity.Remnant5Entity;

public class Remnant5Renderer extends HumanoidMobRenderer<Remnant5Entity, HumanoidModel<Remnant5Entity>> {
	public Remnant5Renderer(EntityRendererProvider.Context context) {
		super(context, new HumanoidModel<Remnant5Entity>(context.bakeLayer(ModelLayers.PLAYER)), 0f);
		this.addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)), new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR)), context.getModelManager()));
	}

	@Override
	public ResourceLocation getTextureLocation(Remnant5Entity entity) {
		return new ResourceLocation("potatowar:textures/entities/2023_03_13_bluebear-21418733-modified.png");
	}
}
