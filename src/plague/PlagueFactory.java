package plague;

import simstation.*;
import mvc.*;

public class PlagueFactory extends WorldFactory {
    public Model makeModel() { return new Population(); }
    public String getTitle() { return "Plague"; }
    public View makeView(Model m) { return new PopulationView(m);}

    public String[] getHelp() {
        return new String[] {
                "Click on Stats to see the current number of alive agents, the time passed, and percent infected."
        };
    }

    public String[] getEditCommands() {
        return new String[] { "Start", "Pause", "Resume", "Stop", "Stats", "Initial % Infected", "Infection Probability", "Initial Population Size", "Fatality/Recovery Time", "Change Lethality"};
    }

    public Command makeEditCommand(Model model, String name, Object source) {
        if(name.equalsIgnoreCase("start")) {
            return new StartCommand(model);
        } else if(name.equalsIgnoreCase("pause")) {
            return new SuspendCommand(model);
        } else if(name.equalsIgnoreCase("resume")) {
            return new ResumeCommand(model);
        } else if(name.equalsIgnoreCase("Stop")) {
            return new StopCommand(model);
        } else if(name.equalsIgnoreCase("Stats")) {
            return new StatsCommand(model);
        } else if(name.equalsIgnoreCase("Initial % Infected")) {
            return new SetInfected(model);
        } else if(name.equalsIgnoreCase("Infection Probability")) {
            return new SetInfectProbability(model);
        } else if(name.equalsIgnoreCase("Initial Population Size")) {
            return new SetPopulation(model);
        } else if(name.equalsIgnoreCase("Fatality/Recovery Time")) {
            return new SetLethalTime(model);
        } else if(name.equalsIgnoreCase("Change Lethality")) {
            return new SetFatality(model);
        }
        return null;
    }

    public String about() {
        return "Plague 1.0";
    }
}
