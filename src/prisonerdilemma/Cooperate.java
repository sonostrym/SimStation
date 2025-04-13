package prisonerdilemma;

public class Cooperate extends Strategy {
  
    @Override
    public boolean cooperate(Prisoner self) {
        return true;
    }

    @Override
    public String getName() {
        return "Cooperate";
    }

}

