package data.paranormal.scripts;
public class GhostlyAppearanceRenderer extends LivingEntityRenderer<EntityLiving, EntityModel<EntityLiving>> {
    public GhostlyAppearanceRenderer(EntityRendererManager rendererManager) {
        super(rendererManager, new EntityModel<>(0.0f), 0.5f);
    }

    @Override
    protected void preRenderCallback(EntityLiving entity, float partialTickTime) {
        // Add any pre-rendering logic here
        float alpha = 0.5f; // Set the entity's transparency
        GlStateManager.color4f(1.0F, 1.0F, 1.0F, alpha);
    }
}