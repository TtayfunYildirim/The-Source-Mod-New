package net.mcreator.thesource.procedures;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.util.ResourceLocation;

import net.mcreator.thesource.entity.CloverCannonEntity;

//modified for 1.16.5, use at your own risk
public class CloverCannonModelProcedure extends AnimatedGeoModel<CloverCannonEntity.CustomEntity> {
	@Override
	public ResourceLocation getAnimationFileLocation(CloverCannonEntity.CustomEntity entity) {
		return new ResourceLocation("the_source", "animations/clover.animation.json");
	}

	@Override
	public ResourceLocation getModelLocation(CloverCannonEntity.CustomEntity entity) {
		return new ResourceLocation("the_source", "geo/clover.geo.json");
	}

	@Override
	public ResourceLocation getTextureLocation(CloverCannonEntity.CustomEntity entity) {
		return new ResourceLocation("the_source", "textures/entities/clover.png");
	}
	/**
	@Override
	public void setCustomAnimations(CloverCannonEntity.CustomEntity animatable, int instanceId, AnimationEvent animationEvent) {
	super.setCustomAnimations(animatable, instanceId, animationEvent);
	IBone head = this.getAnimationProcessor().getBone("head");
	EntityModelData extraData = (EntityModelData) animationEvent.getExtraDataOfType(EntityModelData.class).get(0);
	AnimationData manager = animatable.getFactory().getOrCreateAnimationData(instanceId);
	head.setRotationX(head.getRotationX() + extraData.headPitch * ((float) Math.PI / 180F));
	head.setRotationY(head.getRotationY() + extraData.netHeadYaw * ((float) Math.PI / 180F));
	}
	 /** **/
}
