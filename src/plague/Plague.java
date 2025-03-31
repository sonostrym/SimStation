package plague;

import mvc.*;
import simstation.*;

// mirroring RandomWalk.java

class Plague extends MobileAgent {
}

class PlagueFactory extends WorldFactory {

}

public class PlagueSimulation extends Simulation {
    public static int VIRULENCE = 50; // % chance of infection
    public static int RESISTANCE = 2; // % chance of resisting infection
    // etc.
}