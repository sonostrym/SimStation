package prisonerdilemma;

import java.io.Serializable;

public class Cooperate extends Strategy implements Serializable {
  
    @Override
    public boolean cooperate(Prisoner self) {
        return true;
    }

    @Override
    public String getName() {
        return "Cooperate";
    }

}

