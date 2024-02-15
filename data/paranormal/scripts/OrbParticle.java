public class OrbParticle extends Particle {
    public OrbParticle(World world, double x, double y, double z, double dx, double dy, double dz) {
        super(world, x, y, z, dx, dy, dz);
        this.particleRed = 1.0f; // Set the particle's color
        this.particleGreen = 1.0f;
        this.particleBlue = 1.0f;
        this.particleMaxAge = 100; // Set the particle's lifespan
    double x = world.rand.nextDouble() * 100; // Random x coordinate
    double y = world.rand.nextDouble() * 100; // Random y coordinate        double z = world.rand.nextDouble() * 100; // Random z coordinate
    world.spawnParticle(new OrbParticle(world, x, y, z, 0, 0, 0));
    }

    @Override
    public void tick() {
        super.tick();
        // Add any custom behavior for the particle here
    }
}