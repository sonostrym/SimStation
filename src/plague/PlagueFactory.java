package plague;

import simstation.*;
import mvc.*;
import javax.swing.*;

public class PlagueFactory extends WorldFactory {
    public Model makeModel() { return new Population(); }
    public String getTitle() { return "Plague"; }

    public String[] getHelp() {
        return new String[] {
                "Click on Stats to the current number of alive agents, the time passed, and percent infected."
        };
    }

    public String[] getEditCommands() {
        return new String[] { "Start", "Pause", "Resume", "Stop", "Stats", "Initial % Infected", "Infection Probability", "Initial Population Size", "Fatality/Recovery Time", "Change Lethality"};
    }

    public String about() {
        return "Plague 1.0";
    }
}
