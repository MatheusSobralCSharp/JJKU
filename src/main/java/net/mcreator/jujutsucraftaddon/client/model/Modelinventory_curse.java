package net.mcreator.jujutsucraftaddon.client.model;

import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.EntityModel;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

// Made with Blockbench 4.9.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
public class Modelinventory_curse<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("jujutsucraftaddon", "modelinventory_curse"), "main");
	public final ModelPart bipedHead;
	public final ModelPart bipedBody;
	public final ModelPart bipedLeftArm;
	public final ModelPart bipedRightArm;
	public final ModelPart bipedLeftLeg;
	public final ModelPart bipedRightLeg;

	public Modelinventory_curse(ModelPart root) {
		this.bipedHead = root.getChild("bipedHead");
		this.bipedBody = root.getChild("bipedBody");
		this.bipedLeftArm = root.getChild("bipedLeftArm");
		this.bipedRightArm = root.getChild("bipedRightArm");
		this.bipedLeftLeg = root.getChild("bipedLeftLeg");
		this.bipedRightLeg = root.getChild("bipedRightLeg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition bipedHead = partdefinition.addOrReplaceChild("bipedHead", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition armorHead = bipedHead.addOrReplaceChild("armorHead", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition bipedBody = partdefinition.addOrReplaceChild("bipedBody", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition armorBody = bipedBody.addOrReplaceChild("armorBody", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition neck_1 = armorBody.addOrReplaceChild("neck_1", CubeListBuilder.create(), PartPose.offsetAndRotation(7.0F, -3.0F, 2.0F, -0.2209F, -0.3044F, 0.0099F));
		PartDefinition neck_1_r1 = neck_1.addOrReplaceChild("neck_1_r1", CubeListBuilder.create().texOffs(0, 12).addBox(-2.0F, -2.0F, -1.4F, 3.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.1745F, 0.0F));
		PartDefinition neck_2 = armorBody.addOrReplaceChild("neck_2", CubeListBuilder.create(), PartPose.offsetAndRotation(5.0F, -2.0F, 5.0F, -0.7931F, -1.273F, 0.7133F));
		PartDefinition neck_2_r1 = neck_2.addOrReplaceChild("neck_2_r1", CubeListBuilder.create().texOffs(0, 12).addBox(-1.75F, -1.5F, -3.0F, 3.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.8955F, -0.4351F, 2.917F, 0.0229F, -0.3262F, -0.1566F));
		PartDefinition neck_3 = armorBody.addOrReplaceChild("neck_3", CubeListBuilder.create().texOffs(0, 12).addBox(-1.9F, -2.55F, 0.0F, 3.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -1.0F, 5.0F, 3.0756F, -1.1855F, 3.0341F));
		PartDefinition neck_4 = armorBody.addOrReplaceChild("neck_4", CubeListBuilder.create(), PartPose.offsetAndRotation(-4.6F, -0.4F, 3.1F, 2.7732F, 0.0491F, 3.1415F));
		PartDefinition neck_4_r1 = neck_4.addOrReplaceChild("neck_4_r1", CubeListBuilder.create().texOffs(0, 12).addBox(-1.9F, -2.3F, 0.0F, 3.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.1309F, 0.0F));
		PartDefinition neck_5 = armorBody.addOrReplaceChild("neck_5", CubeListBuilder.create().texOffs(0, 12).addBox(-1.9F, -2.3F, -1.0F, 3.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-4.9F, 2.1F, -2.0F, 2.0249F, 0.9552F, 2.2167F));
		PartDefinition neck_6 = armorBody.addOrReplaceChild("neck_6", CubeListBuilder.create(), PartPose.offsetAndRotation(0.1F, 3.4F, -2.7F, 1.395F, 1.1967F, 1.5158F));
		PartDefinition neck_6_r1 = neck_6.addOrReplaceChild("neck_6_r1", CubeListBuilder.create().texOffs(0, 12).addBox(-1.9F, -2.3F, -1.0F, 3.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.1309F, 0.0F, 0.0F));
		PartDefinition neck_7 = armorBody.addOrReplaceChild("neck_7", CubeListBuilder.create().texOffs(0, 12).addBox(-1.9F, -2.3F, -1.0F, 3.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(3.9F, 4.0F, -1.0F, -0.1401F, -0.2916F, 0.1857F));
		PartDefinition neck_8 = armorBody.addOrReplaceChild("neck_8", CubeListBuilder.create().texOffs(0, 12).addBox(-1.9F, -2.3F, -1.0F, 3.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.3F, 4.4F, 3.3F, -1.1859F, -1.4424F, 0.9301F));
		PartDefinition neck_9 = armorBody.addOrReplaceChild("neck_9", CubeListBuilder.create().texOffs(0, 12).addBox(-1.9F, -2.3F, -1.0F, 3.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-3.7F, 5.8F, 3.3F, 2.9313F, -0.4271F, 2.9977F));
		PartDefinition neck_10 = armorBody.addOrReplaceChild("neck_10", CubeListBuilder.create().texOffs(0, 12).addBox(-0.9F, -2.3F, -1.0F, 3.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-5.2F, 7.2F, -0.7F, 2.9475F, 0.9779F, -3.1104F));
		PartDefinition head = armorBody.addOrReplaceChild("head",
				CubeListBuilder.create().texOffs(21, 30).addBox(4.0F, -6.0F, -4.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(31, 45).addBox(3.5F, -2.0F, -5.0F, 2.5F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(31, 45)
						.addBox(5.6F, -1.0F, -4.5F, 2.0F, 1.0F, 0.1F, new CubeDeformation(0.0F)).texOffs(31, 45).addBox(6.6F, -1.0F, -4.5F, 2.0F, 1.0F, 0.1F, new CubeDeformation(0.0F)).texOffs(31, 45)
						.addBox(6.6F, -2.5F, -4.5F, 2.0F, 1.0F, 0.1F, new CubeDeformation(0.0F)).texOffs(31, 45).addBox(4.0F, -7.5F, -2.5F, 6.0F, 2.0F, 3.5F, new CubeDeformation(0.0F)).texOffs(31, 45)
						.addBox(4.0F, -7.2F, -4.0F, 6.0F, 1.3F, 1.5F, new CubeDeformation(0.0F)).texOffs(31, 45).addBox(4.0F, -7.2F, 0.7F, 6.0F, 1.3F, 1.1F, new CubeDeformation(0.0F)).texOffs(31, 45)
						.addBox(5.5F, -2.5F, -4.5F, 2.0F, 1.0F, 0.1F, new CubeDeformation(0.0F)).texOffs(2, 59).addBox(5.5F, -1.6F, -4.5F, 2.0F, 0.5F, 1.5F, new CubeDeformation(0.0F)).texOffs(2, 59)
						.addBox(6.5F, -1.6F, -4.5F, 2.0F, 0.5F, 1.5F, new CubeDeformation(0.0F)).texOffs(39, 56).addBox(4.5F, -5.0F, -4.5F, 2.0F, 2.0F, 1.5F, new CubeDeformation(0.0F)).texOffs(39, 56)
						.addBox(7.5F, -5.0F, -4.5F, 2.0F, 2.0F, 1.5F, new CubeDeformation(0.0F)).texOffs(31, 45).addBox(8.0F, -2.0F, -5.0F, 2.5F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition bipedLeftArm = partdefinition.addOrReplaceChild("bipedLeftArm", CubeListBuilder.create(), PartPose.offset(-4.0F, 2.0F, 0.0F));
		PartDefinition armorLeftArm = bipedLeftArm.addOrReplaceChild("armorLeftArm", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition bipedRightArm = partdefinition.addOrReplaceChild("bipedRightArm", CubeListBuilder.create(), PartPose.offset(4.0F, 2.0F, 0.0F));
		PartDefinition armorRightArm = bipedRightArm.addOrReplaceChild("armorRightArm", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition bipedLeftLeg = partdefinition.addOrReplaceChild("bipedLeftLeg", CubeListBuilder.create(), PartPose.offset(-2.0F, 12.0F, 0.0F));
		PartDefinition armorLeftLeg = bipedLeftLeg.addOrReplaceChild("armorLeftLeg", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition armorLeftBoot = bipedLeftLeg.addOrReplaceChild("armorLeftBoot", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition bipedRightLeg = partdefinition.addOrReplaceChild("bipedRightLeg", CubeListBuilder.create(), PartPose.offset(2.0F, 12.0F, 0.0F));
		PartDefinition armorRightLeg = bipedRightLeg.addOrReplaceChild("armorRightLeg", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition armorRightBoot = bipedRightLeg.addOrReplaceChild("armorRightBoot", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		bipedHead.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bipedBody.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bipedLeftArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bipedRightArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bipedLeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bipedRightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
