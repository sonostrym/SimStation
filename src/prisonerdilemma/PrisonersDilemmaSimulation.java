package prisonerdilemma;

import mvc.*;
import simstation.*;

class PrisonersDilemmaSimulation extends World {
    public void populate() {
        for (int i = 0; i < 10; i++) {
            addAgent(new Prisoner("Cooperator" + i, new Cooperate()));
            addAgent(new Prisoner("Cheater" + i, new Cheat()));
            addAgent(new Prisoner("Random" + i, new RandomlyCooperate()));
            addAgent(new Prisoner("Tit4Tat" + i, new Tit4Tat()));
        }
    }
    
    @Override
    public void getStatus() {
        int coopTotal = 0, cheatTotal = 0, randTotal = 0, t4tTotal = 0;
        int coopCount = 0, cheatCount = 0, randCount = 0, t4tCount = 0;

        for (Agent a : getAgents()) {
            Prisoner p = (Prisoner) a;
            int fitness = p.getFitness();
            String strat = p.getStrategy().getName();

            switch (strat) {
                case "Cooperate":
                    coopTotal += fitness;
                    coopCount++;
                    break;
                case "Cheat":
                    cheatTotal += fitness;
                    cheatCount++;
                    break;
                case "Random":
                    randTotal += fitness;
                    randCount++;
                    break;
                case "Tit4Tat":
                    t4tTotal += fitness;
                    t4tCount++;
                    break;
            }
        }

        Utilities.inform("Cooperate average fitness: " + (coopTotal / coopCount)+
                "\n"+"Cheat average fitness: " + (cheatTotal / cheatCount)+
                "\n"+"Random average fitness: " + (randTotal / randCount)+
                "\n"+"Tit4Tat average fitness: " + (t4tTotal / t4tCount));
    }

    public static void main(String[] args) {
        AppPanel panel = new WorldPanel(new PrisonersDilemmaFactory());
        panel.display();
    }
}
