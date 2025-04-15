package greed;

import mvc.*;
import simstation.*;

public class GreedFactory extends WorldFactory{
        public Model makeModel() { return new Meadow(); }
        public String getTitle() { return "Greed"; }
        public View makeView(Model m) { return new GreedView(m);}

    public String[] getHelp() {
        return new String[] {
                "Cow stuff"
        };
    }

    public String about() {
        return "Greed version 1.0";
    }
}
