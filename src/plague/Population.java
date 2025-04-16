package plague;

import simstation.*;
import mvc.*;
import java.util.*;

public class Population extends World {

    public static int VIRULENCE = 50; // % chance of infection
    public static int LETHALITY_TIME = 50;
    public static int numHosts = 50;
    public static int numInfected = 10;
    public static boolean FATAL = true;

    public void populate() {
        for(int i = 0; i < numHosts; i++) {
            Host h = new Host("Host" + i);
            addAgent(h);
        }

        setInitialInfected(numInfected);
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
        numInfected = value;
        for(int i = 0; i < numInfected; i++){
            Host h = (Host) getAgents().get(i);
            h.setInfected();
        }
        changed();
    }

    public void setLethalityTime(Integer value) {
        LETHALITY_TIME = value;
        changed();
    }

    public void changeFatal() {
        FATAL = false;
    }
    private double percentInfected() {
        double totalInfected = 0.0;
        for (Agent a : getAgents()) {
            Host h = (Host) a;
            if (h.isInfected()) {
                totalInfected++;
            }
        }
        return (totalInfected / getAgents().size()) * 100.0;
    }

    @Override
    public void getStatus() {
        Utilities.inform("Agents: " + getAgents().size() + "\n" +
                "Clock: " + getClock() + "\n" +
                "% Infected: " + percentInfected() + "\n");
    }

    public static void main(String[] args) {
        AppPanel app = new PopulationPanel(new PlagueFactory());
        app.display();
    }

}
