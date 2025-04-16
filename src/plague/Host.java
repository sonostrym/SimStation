package plague;

import mvc.*;
import simstation.*;

public class Host extends MobileAgent {

    private boolean infected = false;
    private int timeInfected;

    public Host(String agentName) {
        super(agentName);
        setXY(Utilities.rng.nextInt(World.SIZE),
                Utilities.rng.nextInt(World.SIZE));
    }

    public boolean choose(Host host) {
        return Utilities.rng.nextInt(100) < Population.VIRULENCE;
    }
    public void interact(Host other) {
        if (!this.infected && other.isInfected() && choose(other)) {
            this.setInfected();
            timeInfected = getWorld().getClock();
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
        Agent other = world.getNeighbor(this,20);
        if (other != null) {
            interact((Host)other);
        }
        int time = world.getClock() - timeInfected;
        if (time >= Population.LETHALITY_TIME) {
            if (Population.FATAL) {
                this.stop();
            } else {
                this.infected = false;
            }
        }
        move(1);
    }
}
