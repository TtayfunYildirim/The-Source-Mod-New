// Made with Blockbench 4.6.4
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports

public static class Modelclovercannon extends EntityModel<Entity> {
	private final ModelRenderer Back;
	private final ModelRenderer Top;
	private final ModelRenderer Bottom;
	private final ModelRenderer Left;
	private final ModelRenderer Right;
	private final ModelRenderer Head;
	private final ModelRenderer Root;
	private final ModelRenderer cube_r1;
	private final ModelRenderer Front;
	private final ModelRenderer cube_r2;
	private final ModelRenderer FireHead;
	private final ModelRenderer cube_r3;

	public Modelclovercannon() {
		texWidth = 128;
		texHeight = 128;

		Back = new ModelRenderer(this);
		Back.setPos(5.0F, 0.0F, 0.0F);

		Top = new ModelRenderer(this);
		Top.setPos(-5.0F, 21.0F, 6.0F);
		Back.addChild(Top);
		Top.texOffs(80, 46).addBox(-5.0F, -47.0F, 3.0F, 7.0F, 2.0F, 2.0F, 0.0F, false);
		Top.texOffs(94, 12).addBox(2.0F, -45.0F, 3.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		Top.texOffs(88, 92).addBox(-7.0F, -45.0F, 3.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		Top.texOffs(92, 74).addBox(6.0F, -45.0F, 3.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		Top.texOffs(92, 64).addBox(4.0F, -43.0F, 3.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		Top.texOffs(80, 42).addBox(8.0F, -47.0F, 3.0F, 7.0F, 2.0F, 2.0F, 0.0F, false);
		Top.texOffs(58, 92).addBox(15.0F, -45.0F, 3.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		Top.texOffs(54, 0).addBox(-9.0F, -43.0F, 3.0F, 2.0F, 7.0F, 2.0F, 0.0F, false);
		Top.texOffs(44, 92).addBox(-7.0F, -36.0F, 3.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		Top.texOffs(52, 50).addBox(17.0F, -43.0F, 3.0F, 2.0F, 7.0F, 2.0F, 0.0F, false);
		Top.texOffs(36, 92).addBox(-5.0F, -34.0F, 3.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		Top.texOffs(28, 92).addBox(-3.0F, -32.0F, 3.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		Top.texOffs(16, 92).addBox(11.0F, -32.0F, 3.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		Top.texOffs(8, 92).addBox(13.0F, -34.0F, 3.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		Top.texOffs(0, 92).addBox(15.0F, -36.0F, 3.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		Top.texOffs(82, 90).addBox(9.0F, -30.0F, 3.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		Top.texOffs(74, 90).addBox(7.0F, -28.0F, 3.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		Top.texOffs(66, 90).addBox(-1.0F, -30.0F, 3.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		Top.texOffs(90, 58).addBox(1.0F, -28.0F, 3.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		Top.texOffs(80, 56).addBox(3.0F, -26.0F, 3.0F, 4.0F, 2.0F, 2.0F, 0.0F, false);

		Bottom = new ModelRenderer(this);
		Bottom.setPos(5.0F, -23.0F, 9.0F);
		Back.addChild(Bottom);
		setRotationAngle(Bottom, 0.0F, 0.0F, -3.1416F);
		Bottom.texOffs(80, 38).addBox(-5.0F, -47.0F, 0.0F, 7.0F, 2.0F, 2.0F, 0.0F, false);
		Bottom.texOffs(90, 54).addBox(2.0F, -45.0F, 0.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		Bottom.texOffs(90, 50).addBox(-7.0F, -45.0F, 0.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		Bottom.texOffs(22, 90).addBox(6.0F, -45.0F, 0.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		Bottom.texOffs(90, 4).addBox(4.0F, -43.0F, 0.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		Bottom.texOffs(42, 68).addBox(8.0F, -47.0F, 0.0F, 7.0F, 2.0F, 2.0F, 0.0F, false);
		Bottom.texOffs(90, 0).addBox(15.0F, -45.0F, 0.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		Bottom.texOffs(46, 0).addBox(-9.0F, -43.0F, 0.0F, 2.0F, 7.0F, 2.0F, 0.0F, false);
		Bottom.texOffs(88, 88).addBox(-7.0F, -36.0F, 0.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		Bottom.texOffs(42, 42).addBox(17.0F, -43.0F, 0.0F, 2.0F, 7.0F, 2.0F, 0.0F, false);
		Bottom.texOffs(88, 84).addBox(-5.0F, -34.0F, 0.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		Bottom.texOffs(88, 80).addBox(-3.0F, -32.0F, 0.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		Bottom.texOffs(88, 68).addBox(11.0F, -32.0F, 0.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		Bottom.texOffs(60, 88).addBox(13.0F, -34.0F, 0.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		Bottom.texOffs(82, 86).addBox(15.0F, -36.0F, 0.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		Bottom.texOffs(86, 76).addBox(9.0F, -30.0F, 0.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		Bottom.texOffs(74, 86).addBox(7.0F, -28.0F, 0.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		Bottom.texOffs(86, 72).addBox(-1.0F, -30.0F, 0.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		Bottom.texOffs(66, 86).addBox(1.0F, -28.0F, 0.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		Bottom.texOffs(66, 36).addBox(3.0F, -26.0F, 0.0F, 4.0F, 2.0F, 2.0F, 0.0F, false);

		Left = new ModelRenderer(this);
		Left.setPos(-22.0F, -6.0F, 0.0F);
		Back.addChild(Left);
		setRotationAngle(Left, 0.0F, 0.0F, 1.5708F);
		Left.texOffs(66, 52).addBox(-5.0F, -47.0F, 9.0F, 7.0F, 2.0F, 2.0F, 0.0F, false);
		Left.texOffs(86, 62).addBox(2.0F, -45.0F, 9.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		Left.texOffs(60, 84).addBox(-7.0F, -45.0F, 9.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		Left.texOffs(84, 52).addBox(6.0F, -45.0F, 9.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		Left.texOffs(42, 84).addBox(4.0F, -43.0F, 9.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		Left.texOffs(66, 4).addBox(8.0F, -47.0F, 9.0F, 7.0F, 2.0F, 2.0F, 0.0F, false);
		Left.texOffs(30, 84).addBox(15.0F, -45.0F, 9.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		Left.texOffs(0, 40).addBox(-9.0F, -43.0F, 9.0F, 2.0F, 7.0F, 2.0F, 0.0F, false);
		Left.texOffs(22, 84).addBox(-7.0F, -36.0F, 9.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		Left.texOffs(28, 30).addBox(17.0F, -43.0F, 9.0F, 2.0F, 7.0F, 2.0F, 0.0F, false);
		Left.texOffs(14, 84).addBox(-5.0F, -34.0F, 9.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		Left.texOffs(0, 84).addBox(-3.0F, -32.0F, 9.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		Left.texOffs(82, 82).addBox(11.0F, -32.0F, 9.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		Left.texOffs(74, 82).addBox(13.0F, -34.0F, 9.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		Left.texOffs(66, 82).addBox(15.0F, -36.0F, 9.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		Left.texOffs(80, 74).addBox(9.0F, -30.0F, 9.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		Left.texOffs(80, 70).addBox(7.0F, -28.0F, 9.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		Left.texOffs(80, 64).addBox(-1.0F, -30.0F, 9.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		Left.texOffs(80, 60).addBox(1.0F, -28.0F, 9.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		Left.texOffs(62, 28).addBox(3.0F, -26.0F, 9.0F, 4.0F, 2.0F, 2.0F, 0.0F, false);

		Right = new ModelRenderer(this);
		Right.setPos(22.0F, 4.0F, 0.0F);
		Back.addChild(Right);
		setRotationAngle(Right, 0.0F, 0.0F, -1.5708F);
		Right.texOffs(66, 0).addBox(-5.0F, -47.0F, 9.0F, 7.0F, 2.0F, 2.0F, 0.0F, false);
		Right.texOffs(60, 80).addBox(2.0F, -45.0F, 9.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		Right.texOffs(42, 80).addBox(-7.0F, -45.0F, 9.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		Right.texOffs(80, 30).addBox(6.0F, -45.0F, 9.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		Right.texOffs(80, 26).addBox(4.0F, -43.0F, 9.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		Right.texOffs(52, 24).addBox(8.0F, -47.0F, 9.0F, 7.0F, 2.0F, 2.0F, 0.0F, false);
		Right.texOffs(80, 16).addBox(15.0F, -45.0F, 9.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		Right.texOffs(14, 18).addBox(-9.0F, -43.0F, 9.0F, 2.0F, 7.0F, 2.0F, 0.0F, false);
		Right.texOffs(80, 12).addBox(-7.0F, -36.0F, 9.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		Right.texOffs(0, 18).addBox(17.0F, -43.0F, 9.0F, 2.0F, 7.0F, 2.0F, 0.0F, false);
		Right.texOffs(0, 80).addBox(-5.0F, -34.0F, 9.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		Right.texOffs(66, 74).addBox(-3.0F, -32.0F, 9.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		Right.texOffs(52, 72).addBox(11.0F, -32.0F, 9.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		Right.texOffs(66, 70).addBox(13.0F, -34.0F, 9.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		Right.texOffs(0, 68).addBox(15.0F, -36.0F, 9.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		Right.texOffs(66, 56).addBox(9.0F, -30.0F, 9.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		Right.texOffs(42, 64).addBox(7.0F, -28.0F, 9.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		Right.texOffs(0, 64).addBox(-1.0F, -30.0F, 9.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		Right.texOffs(28, 4).addBox(1.0F, -28.0F, 9.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		Right.texOffs(38, 14).addBox(3.0F, -26.0F, 9.0F, 4.0F, 2.0F, 2.0F, 0.0F, false);

		Head = new ModelRenderer(this);
		Head.setPos(0.0F, 24.0F, 0.0F);
		Head.texOffs(0, 0).addBox(-1.0F, -33.0F, 7.0F, 12.0F, 16.0F, 2.0F, 0.0F, false);
		Head.texOffs(52, 80).addBox(-3.0F, -31.0F, 7.0F, 2.0F, 12.0F, 2.0F, 0.0F, false);
		Head.texOffs(38, 0).addBox(11.0F, -31.0F, 7.0F, 2.0F, 12.0F, 2.0F, 0.0F, false);

		Root = new ModelRenderer(this);
		Root.setPos(0.0F, 0.0F, 0.0F);
		Head.addChild(Root);
		Root.texOffs(70, 24).addBox(1.0F, -27.0F, 9.0F, 2.0F, 4.0F, 0.0F, 0.0F, false);
		Root.texOffs(52, 0).addBox(-5.0F, -31.0F, -1.0F, 2.0F, 12.0F, 10.0F, 0.0F, false);
		Root.texOffs(28, 42).addBox(13.0F, -31.0F, -1.0F, 2.0F, 12.0F, 10.0F, 0.0F, false);
		Root.texOffs(46, 9).addBox(7.0F, -27.0F, 9.0F, 2.0F, 4.0F, 0.0F, 0.0F, false);
		Root.texOffs(28, 80).addBox(-3.0F, -19.0F, -1.0F, 2.0F, 2.0F, 10.0F, 0.0F, false);
		Root.texOffs(80, 26).addBox(11.0F, -19.0F, -1.0F, 2.0F, 2.0F, 10.0F, 0.0F, false);
		Root.texOffs(80, 14).addBox(11.0F, -33.0F, -1.0F, 2.0F, 2.0F, 10.0F, 0.0F, false);
		Root.texOffs(0, 80).addBox(-3.0F, -33.0F, -1.0F, 2.0F, 2.0F, 10.0F, 0.0F, false);
		Root.texOffs(28, 0).addBox(3.0F, -27.0F, 11.0F, 4.0F, 4.0F, 0.0F, 0.0F, false);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setPos(0.0F, 0.0F, 0.0F);
		Root.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.0F, 0.0F, 1.5708F);
		cube_r1.texOffs(38, 20).addBox(-35.0F, -11.0F, -1.0F, 2.0F, 12.0F, 10.0F, 0.0F, false);
		cube_r1.texOffs(28, 8).addBox(-29.0F, -7.0F, 9.0F, 2.0F, 4.0F, 0.0F, 0.0F, false);
		cube_r1.texOffs(0, 42).addBox(-17.0F, -11.0F, -1.0F, 2.0F, 12.0F, 10.0F, 0.0F, false);
		cube_r1.texOffs(28, 12).addBox(-23.0F, -7.0F, 9.0F, 2.0F, 4.0F, 0.0F, 0.0F, false);

		Front = new ModelRenderer(this);
		Front.setPos(0.0F, 0.0F, -10.0F);
		Head.addChild(Front);
		Front.texOffs(14, 54).addBox(-3.0F, -29.0F, -1.0F, 2.0F, 8.0F, 10.0F, 0.0F, false);
		Front.texOffs(52, 50).addBox(11.0F, -29.0F, -1.0F, 2.0F, 8.0F, 10.0F, 0.0F, false);
		Front.texOffs(76, 0).addBox(-3.0F, -21.0F, -1.0F, 2.0F, 2.0F, 10.0F, 0.0F, false);
		Front.texOffs(14, 72).addBox(11.0F, -21.0F, -1.0F, 2.0F, 2.0F, 10.0F, 0.0F, false);
		Front.texOffs(66, 70).addBox(11.0F, -31.0F, -1.0F, 2.0F, 2.0F, 10.0F, 0.0F, false);
		Front.texOffs(52, 68).addBox(-3.0F, -31.0F, -1.0F, 2.0F, 2.0F, 10.0F, 0.0F, false);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setPos(0.0F, 0.0F, 0.0F);
		Front.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.0F, 0.0F, 1.5708F);
		cube_r2.texOffs(24, 8).addBox(-33.0F, -11.0F, -1.0F, 2.0F, 12.0F, 10.0F, 0.0F, false);
		cube_r2.texOffs(14, 30).addBox(-19.0F, -11.0F, -1.0F, 2.0F, 12.0F, 10.0F, 0.0F, false);

		FireHead = new ModelRenderer(this);
		FireHead.setPos(0.0F, 0.0F, -6.0F);
		Head.addChild(FireHead);
		FireHead.texOffs(28, 64).addBox(-1.0F, -27.0F, -15.0F, 2.0F, 6.0F, 10.0F, 0.0F, false);
		FireHead.texOffs(0, 64).addBox(9.0F, -27.0F, -15.0F, 2.0F, 6.0F, 10.0F, 0.0F, false);
		FireHead.texOffs(66, 58).addBox(-1.0F, -21.0F, -15.0F, 2.0F, 2.0F, 10.0F, 0.0F, false);
		FireHead.texOffs(66, 40).addBox(9.0F, -21.0F, -15.0F, 2.0F, 2.0F, 10.0F, 0.0F, false);
		FireHead.texOffs(66, 24).addBox(9.0F, -29.0F, -15.0F, 2.0F, 2.0F, 10.0F, 0.0F, false);
		FireHead.texOffs(66, 12).addBox(-1.0F, -29.0F, -15.0F, 2.0F, 2.0F, 10.0F, 0.0F, false);

		cube_r3 = new ModelRenderer(this);
		cube_r3.setPos(0.0F, 0.0F, -14.0F);
		FireHead.addChild(cube_r3);
		setRotationAngle(cube_r3, 0.0F, 0.0F, 1.5708F);
		cube_r3.texOffs(0, 18).addBox(-31.0F, -11.0F, -1.0F, 2.0F, 12.0F, 10.0F, 0.0F, false);
		cube_r3.texOffs(52, 32).addBox(-21.0F, -9.0F, -1.0F, 2.0F, 8.0F, 10.0F, 0.0F, false);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
		// previously the render function, render code was moved to a method below
	}

	@Override
	public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		Back.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		Head.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.xRot = x;
		modelRenderer.yRot = y;
		modelRenderer.zRot = z;
	}
}