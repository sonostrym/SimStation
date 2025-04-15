package prisonerdilemma;

import java.io.Serializable;

public class Cheat extends Strategy implements Serializable {
  
    @Override
    public boolean cooperate(Prisoner self) {
        return false;
    }
  
    @Override
    public String getName() {
        return "Cheat";
    }

}

