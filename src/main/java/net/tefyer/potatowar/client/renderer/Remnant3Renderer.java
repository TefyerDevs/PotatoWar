
package net.tefyer.potatowar.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.HumanoidModel;

import net.tefyer.potatowar.entity.Remnant3Entity;

public class Remnant3Renderer extends HumanoidMobRenderer<Remnant3Entity, HumanoidModel<Remnant3Entity>> {
	public Remnant3Renderer(EntityRendererProvider.Context context) {
		super(context, new HumanoidModel<Remnant3Entity>(context.bakeLayer(ModelLayers.PLAYER)), 0f);
		this.addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)), new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR)), context.getModelManager()));
	}

	@Override
	public ResourceLocation getTextureLocation(Remnant3Entity entity) {
		return new ResourceLocation("potatowar:textures/entities/2020_09_27_patchwork-bear-recolour-15369336-modified.png");
	}
}
