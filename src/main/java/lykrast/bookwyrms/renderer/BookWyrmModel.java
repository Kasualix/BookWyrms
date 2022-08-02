package lykrast.bookwyrms.renderer;

import lykrast.bookwyrms.BookWyrms;
import net.minecraft.client.model.QuadrupedModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.world.entity.Entity;

public class BookWyrmModel<T extends Entity> extends QuadrupedModel<T> {
	public static final ModelLayerLocation MODEL = new ModelLayerLocation(BookWyrms.rl("book_wyrm"), "main");
	
	public BookWyrmModel(ModelPart p_170515_) {
		// scaleHead, babyYHeadOffset, babyZHeadOffset, babyHeadScale, babyBodyScale, bodyYOffset
		super(p_170515_, false, 4, 4, 2, 2, 24);
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		partdefinition.addOrReplaceChild("head", CubeListBuilder.create()
				.texOffs(0, 0).addBox(-3, -3, -6, 6, 6, 6)
				.texOffs(0, 12).addBox("mouth", -2, -1, -12, 4, 3, 6),
				PartPose.offset(0, 17, -6));
		partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(32, 10).addBox(-5, -10, -2, 10, 16, 6),
				PartPose.offsetAndRotation(0, 20, 3, ((float) Math.PI / 2F), 0.0F, 0.0F));
		CubeListBuilder cubelistbuilder = CubeListBuilder.create().texOffs(0, 22).addBox(-2, 0, -2, 4, 6, 4);
		partdefinition.addOrReplaceChild("right_hind_leg", cubelistbuilder, PartPose.offset(-7, 18, 7));
		partdefinition.addOrReplaceChild("left_hind_leg", cubelistbuilder, PartPose.offset(7, 18, 7));
		partdefinition.addOrReplaceChild("right_front_leg", cubelistbuilder, PartPose.offset(-7, 18, -5));
		partdefinition.addOrReplaceChild("left_front_leg", cubelistbuilder, PartPose.offset(7, 18, -5));
		return LayerDefinition.create(meshdefinition, 64, 32);
	}

}
