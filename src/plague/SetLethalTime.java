package plague;

import mvc.*;


public class SetLethalTime extends Command {

    Integer value = null;

    public SetLethalTime(Model m) {
        super(m);
    }

    public void execute() throws Exception {
        if (value == null) {
            String response = Utilities.ask("Set death/recovery time: ");
            value = Integer.valueOf(response);
        }
        ((Population)model).setLethalityTime(value);
    }
}

