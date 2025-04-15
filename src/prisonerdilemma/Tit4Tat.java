package prisonerdilemma;

import java.io.Serializable;

public class Tit4Tat extends Strategy implements Serializable {
  
    @Override
    public boolean cooperate(Prisoner self) {
        return !self.getPartnerCheated();
    }

    @Override
    public String getName() {
        return "Tit4Tat";
    }

}
