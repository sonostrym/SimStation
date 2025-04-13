package plague;

import simstation.*;
import mvc.*;

public class Population extends World {

    public static int VIRULENCE = 50; // % chance of infection
    // public static int RESISTANCE = 2; // % chance of resisting infection // I don't think this is actually used, just an example maybe
    static int numHosts = 50;


    public void populate() {
        for(int i = 0; i < numHosts; i++) {
            addAgent(new Host("Host"));
        }
    }

    public void setVirulence(Integer value) {
        VIRULENCE = value;
        changed();
    }

    private double percentInfected() {
        double totalInfected = 0.0;
        for (Agent a : getAgents()) {
            Host h = (Host) a;
            if (h.isInfected()) {
                totalInfected++;
            }
        }
        return getAgents().size() / totalInfected;
    }

    @Override
    public void getStatus() {
        Utilities.inform("Agents: " + getAgents().size() + "\n" +
                "Clock: " + getClock() + "\n" +
                "Infected: " + percentInfected() + "\n");
    }

    public static void main(String[] args) {
        AppPanel app = new PopulationPanel(new PlagueFactory());
        app.display();
    }
}
