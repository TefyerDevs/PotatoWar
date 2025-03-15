
package net.mcreator.potatowar.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.potatowar.entity.TownCenterMobEntity;
import net.mcreator.potatowar.client.model.ModelTownCenter;

public class TownCenterMobRenderer extends MobRenderer<TownCenterMobEntity, ModelTownCenter<TownCenterMobEntity>> {
	public TownCenterMobRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelTownCenter<TownCenterMobEntity>(context.bakeLayer(ModelTownCenter.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(TownCenterMobEntity entity) {
		return new ResourceLocation("potatowar:textures/entities/blackthing.png");
	}
}
