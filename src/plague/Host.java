package plague;

import mvc.*;
import simstation.*;

public class Host extends MobileAgent {

    private boolean infected = false;

    public Host(String agentName) {
        super(agentName);
    }

    public boolean choose(Host host) {
        return Utilities.rng.nextInt(100) < Population.VIRULENCE;
    }
    public void interact(Host other) {
        if (!this.infected && other.isInfected() && choose(other)) {
            this.setInfected();
        }
    }

    public boolean isInfected() {
        return infected;
    }

    public void setInfected() {
        this.infected = true;
    }

    @Override
    public void update() {
        World world = getWorld();
        Agent other = world.getNeighbor(this,100);
        if (other != null) {
            interact((Host)other);
        }
        move(1);
    }
}
