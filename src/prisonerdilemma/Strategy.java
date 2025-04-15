package prisonerdilemma;

import java.io.Serializable;

public abstract class Strategy implements Serializable {
    public abstract boolean cooperate(Prisoner myPrisoner);
    public abstract String getName();
    
}

