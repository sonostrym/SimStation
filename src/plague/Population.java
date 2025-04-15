package plague;

import simstation.*;
import mvc.*;
import java.util.*;

public class Population extends World {

    public static int VIRULENCE = 50; // % chance of infection
    public static int LETHALITY_TIME = 50;
    public static int numHosts = 50;

    public void populate() {
        for(int i = 0; i < numHosts; i++) {
            addAgent(new Host("Host"));
        }
    }

    public void setInitialPopulation(Integer value) {
        numHosts = value;
        changed();
    }

    public void setVirulence(Integer value) {
        VIRULENCE = value;
        changed();
    }

    public void setInitialInfected(Integer value) {
        for (Agent a : getAgents()) {
            Host h = (Host) a;
            for (int i = 0; i <= value; i++) {
                h.setInfected();
            }
        }
        changed();
    }

    public void setLethalityTime(Integer value) {
        LETHALITY_TIME = value;
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
