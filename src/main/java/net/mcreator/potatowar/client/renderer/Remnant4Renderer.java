
package net.mcreator.potatowar.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.HumanoidModel;

import net.mcreator.potatowar.entity.Remnant4Entity;

public class Remnant4Renderer extends HumanoidMobRenderer<Remnant4Entity, HumanoidModel<Remnant4Entity>> {
	public Remnant4Renderer(EntityRendererProvider.Context context) {
		super(context, new HumanoidModel<Remnant4Entity>(context.bakeLayer(ModelLayers.PLAYER)), 0f);
		this.addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)), new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR)), context.getModelManager()));
	}

	@Override
	public ResourceLocation getTextureLocation(Remnant4Entity entity) {
		return new ResourceLocation("potatowar:textures/entities/2023_04_29_pinky---cat-21558840-modified.png");
	}
}
