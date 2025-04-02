package simstation;

import mvc.*;

public class SuspendCommand extends Command {
      public SuspendCommand(Model model) {
        super(model);
    }

    public void execute() {
        ((World)model).pauseAgents();
    }
}
