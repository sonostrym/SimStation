package plague;

import mvc.*;


public class SetInfected extends Command {

    Integer value = null;

    public SetInfected(Model m) {
        super(m);
    }

    public void execute() throws Exception {
        if (value == null) {
            String response = Utilities.ask("Set initial infected: ");
            value = Integer.valueOf(response);
        }
        ((Population)model).setInitialInfected(value);
    }
}


