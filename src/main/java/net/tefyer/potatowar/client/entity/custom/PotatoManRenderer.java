package net.tefyer.potatowar.client.entity.custom;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.resources.ResourceLocation;
import net.tefyer.potatowar.entity.custom.PotatoManEntity;

import static net.minecraft.client.model.geom.ModelLayers.*;

public class PotatoManRenderer extends HumanoidMobRenderer<PotatoManEntity, HumanoidModel<PotatoManEntity>> {
    public PotatoManRenderer(EntityRendererProvider.Context context) {
        super(context, new HumanoidModel<PotatoManEntity>(context.bakeLayer(PLAYER)), 0.5f);
        this.addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(PLAYER_INNER_ARMOR)), new HumanoidModel(context.bakeLayer(PLAYER_OUTER_ARMOR)), context.getModelManager()));
    }


    @Override
    public ResourceLocation getTextureLocation(PotatoManEntity pEntity) {
        return new ResourceLocation("potatowar:textures/entities/potatoman.png");
    }
}
