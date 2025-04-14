package prisonerdilemma;

import java.awt.*;
import mvc.Model;
import simstation.*;

public class PrisonersDilemmaView extends WorldView {

    public PrisonersDilemmaView(Model model) {
        super(model);
    }

    @Override
    public void drawAgent(Agent a, Graphics gc) {
        Prisoner p = (Prisoner) a;
        int fitness = p.getFitness();

        if (fitness >= 90) {
            gc.setColor(Color.BLUE);
        } else if (fitness >= 70) {
            gc.setColor(Color.GREEN);
        } else if (fitness >= 40) {
            gc.setColor(Color.YELLOW);
        } else if (fitness >= 20) {
            gc.setColor(Color.ORANGE);
        } else {
            gc.setColor(Color.RED);
        }

        gc.fillOval(p.getX(), p.getY(), 10, 10);
    }
}
