package prisonerdilemma;

import mvc.Utilities;

public class RandomlyCooperate extends Strategy {
  
    @Override
    public boolean cooperate(Prisoner self) {
        return Utilities.rng.nextBoolean();
    }

}

