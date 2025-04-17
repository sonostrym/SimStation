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
        System.out.println("Initial Population: " + numHosts);
        changed();
    }

    public void setVirulence(Integer value) {
        VIRULENCE = value;
        System.out.println("Infection Probability: " + VIRULENCE);
        changed();
    }

    public void setInitialInfected(Integer value) {
        numInfected = value;
        for(int i = 0; i < numInfected; i++){
            Host h = (Host) getAgents().get(i);
            h.setInfected();
        }
        System.out.println("Hosts infected: " + numInfected);
        changed();
    }

    public void setLethalityTime(Integer value) {
        LETHALITY_TIME = value;
        System.out.println("Fatal/Recovery Time: " + LETHALITY_TIME);
        changed();
    }

    public void changeFatal() {
        FATAL = !FATAL;
        System.out.println("Fatality Toggled: " + FATAL); // just for feedback
        changed();
    }

    public boolean checkFatal() {
        return FATAL;
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
