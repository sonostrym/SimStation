package greed;

import mvc.*;
import simstation.*;

public class GreedFactory extends WorldFactory{
        public Model makeModel() { return new Meadow(); }
        public String getTitle() { return "Greed"; }
        public View makeView(Model m) { return new GreedView(m);}

    public String[] getHelp() {
        return new String[] {
                "Cows gain energy from any grass patches they stand on. If cows reach 0 energy, they die (cow dots turn white). "
                + "\n" + "Greed: Adjust a cows willingness to share its grass patch/how much of the grass patch it will consume itself."
                 + "\n" + "Grow back rate: Adjust the rate at which a grass patch reproduces its energy." + "\n" 
                + "Move Energy: Adjust the energy required for a cow to keep moving and not die." };
    }

    public String about() {
        return "Greed version 1.0";
    }
}
