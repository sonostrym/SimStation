package plague;

import mvc.*;

public class SetFatality extends Command {

    public SetFatality(Model m) {
        super(m);
    }

    public void execute() throws Exception {
        ((Population)model).changeFatal();
    }
}
