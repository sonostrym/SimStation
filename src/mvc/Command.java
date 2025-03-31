package mvc;
/*
Vinzent Schubert  3/13 12:00
 */

public abstract class Command {
    protected Model model;

    public Command(Model model) {
        this.model = model;
    }

    public abstract void execute() throws Exception;


}
