package plague;

import mvc.*;
public class SetInfectProbability extends Command {

    Integer value = null;

    public SetInfectProbability(Model m) {
        super(m);
    }

    public void execute() throws Exception {
        if (value == null) {
            String response = Utilities.ask("Set infect probability: ");
            value = Integer.valueOf(response);
        }
        ((Population)model).setVirulence(value);
    }
}


