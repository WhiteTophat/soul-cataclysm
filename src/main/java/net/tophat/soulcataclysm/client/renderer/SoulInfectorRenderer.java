
package net.tophat.soulcataclysm.client.renderer;

import net.tophat.soulcataclysm.entity.SoulInfectorEntity;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.HumanoidModel;

public class SoulInfectorRenderer extends HumanoidMobRenderer<SoulInfectorEntity, HumanoidModel<SoulInfectorEntity>> {
	public SoulInfectorRenderer(EntityRendererProvider.Context context) {
		super(context, new HumanoidModel<SoulInfectorEntity>(context.bakeLayer(ModelLayers.PLAYER)), 0f);
		this.addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)), new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR)), context.getModelManager()));
	}

	@Override
	public ResourceLocation getTextureLocation(SoulInfectorEntity entity) {
		return new ResourceLocation("soulcataclysm:textures/entities/blank.png");
	}

	@Override
	protected boolean isBodyVisible(SoulInfectorEntity entity) {
		return false;
	}
}
