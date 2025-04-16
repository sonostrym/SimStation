package prisonerdilemma;

import mvc.Utilities;
import java.io.Serializable;

public class RandomlyCooperate extends Strategy {
  
    @Override
    public boolean cooperate(Prisoner self) {
        return Utilities.rng.nextBoolean();
    }

    @Override
    public String getName() {
        return "Random";
    }

}

