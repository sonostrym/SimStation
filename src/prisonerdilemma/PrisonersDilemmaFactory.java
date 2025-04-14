package prisonerdilemma;

import mvc.*;
import simstation.*;

public class PrisonersDilemmaFactory extends WorldFactory {
    public Model makeModel() { return new PrisonersDilemmaSimulation(); }
    public String getTitle() { return "Prisoner's Dilemma"; }
        public View makeView(Model m) { return new PrisonersDilemmaView(m);}

    public String[] getHelp() {
        return new String[] {
                "Click on Stats to see average fitness scores for each strategy." + "\n" +
                        "The color of the dot (from red to blue) represents how high that prisoners fitness score is."
        };
    }

    public String about() {
        return "Prisoners Dilemma version 1.0";
    }
}
