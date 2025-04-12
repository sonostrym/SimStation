package prisonerdilemma;

import mvc.*;
import simstation.*;

public class PrisonersDilemmaFactory extends WorldFactory {
    public Model makeModel() { return new PrisonersDilemmaSimulation(); }
    public String getTitle() { return "Prisoner's Dilemma"; }

    public String[] getHelp() {
        return new String[] {
                "Click on Stats to see average fitness scores for each strategy."
        };
    }

    public String about() {
        return "Prisoners Dilemma version 1.0";
    }
}
