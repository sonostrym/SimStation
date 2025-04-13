package simstation;

import mvc.*;

public class WorldFactory implements AppFactory {
    public Model makeModel() {
        return null;
         //Just override this method to return a new instance of your model class.
    }

    public View makeView(Model m) {
        return new WorldView((World) m);
    }

    public String[] getEditCommands() {
        return new String[] {"Start", "Pause", "Resume", "Stop", "Stats"};
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
        }
        return null; 
    }

    public String getTitle() {
        return "SimStation";
    }

    public String[] getHelp() {
        return new String[] {
                "Click start, stop, pause, or resume to control agent behavior."
        };
    }

    public String about() {
        return "SimStation version 1.0";
    }
}
