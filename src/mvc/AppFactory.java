package mvc;
/*
Vinzent Schubert 3/13 11:30 - followed The MVC framework guidelines for all classes/interfaces in mvc package
 */

public interface AppFactory {
    Model makeModel();
    View makeView(Model model);
    String getTitle();
    String[] getHelp();
    String about();
    String[] getEditCommands();
    Command makeEditCommand(Model model, String name, Object source);
}
