package data.paranormal.scripts;
public class InvisibleEntity extends Entity {
    public InvisibleEntity(EntityType<?> type, World world) {
        super(type, world);
        this.setFlag(6, true); // Set the entity as invisible
    }

    @Override
    public void tick() {
        // Add any custom behavior for the entity here
    }
}