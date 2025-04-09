package prisonerdilemma;

public class Tit4Tat extends Strategy {
  
    @Override
    public boolean cooperate(Prisoner self) {
        return !self.getPartnerCheated();
    }

}
