package prisonerdilemma;

public class Cheat extends Strategy {
  
    @Override
    public boolean cooperate(Prisoner self) {
        return false;
    }
  
    @Override
    public String getName() {
        return "Cheat";
    }

}

