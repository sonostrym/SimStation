package simstation;

import mvc.*;

public class WorldFactory implements AppFactory {
    public Model makeModel() {
        return null; //fix
    }


    public View makeView(Model m) {
        return new WorldView((World) m);
    }

    public String[] getEditCommands() {
        return new String[] {"Resume", "Suspend", "Start", "Stop", "Stats"};
    }

    public Command makeEditCommand(Model model, String name, Object source) {
        return null; //fix
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
