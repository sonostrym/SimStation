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
                "The bordering color of the dot (from pink to red) represents how high that prisoners fitness score is." + "\n" +
                "Center Colors: Blue = Cooperate, Green = Cheat, Orange = Random, Magenta = Tit4Tat"
        };
    }

    public String about() {
        return "Prisoners Dilemma version 1.0";
    }
}
