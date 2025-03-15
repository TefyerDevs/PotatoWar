
package net.tefyer.potatowar.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.HumanoidModel;

import net.tefyer.potatowar.entity.HumanMilitaEntity;

public class HumanMilitaRenderer extends HumanoidMobRenderer<HumanMilitaEntity, HumanoidModel<HumanMilitaEntity>> {
	public HumanMilitaRenderer(EntityRendererProvider.Context context) {
		super(context, new HumanoidModel<HumanMilitaEntity>(context.bakeLayer(ModelLayers.PLAYER)), 0.5f);
		this.addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)), new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR)), context.getModelManager()));
	}

	@Override
	public ResourceLocation getTextureLocation(HumanMilitaEntity entity) {
		return new ResourceLocation("potatowar:textures/entities/classic-steve-on-planetminecraft-com.png");
	}
}
