public class OrbEntity extends Entity {
    public OrbEntity(EntityType<?> type, World world) {
        super(type, world);
        this.setNoGravity(true); // Set the orb to ignore gravity
    }

    @Override
    public void tick() {
        super.tick();
        // Add any custom behavior for the orb here
    }
}