package plague;

import simstation.*;
import mvc.*;
import java.awt.*;

public class PopulationView extends WorldView {

    public PopulationView(Model m) {
        super(m);
    }

    @Override
    public void paintComponent(Graphics gc){
        super.paintComponent(gc);

        for (Agent a : ((Population)model).getAgents()) {
            drawAgent(a, gc);
        }
    }

    @Override
    public void drawAgent(Agent a, Graphics gc) {
        Host h = (Host) a;
        if (h.isInfected()) {
            gc.setColor(Color.RED);
        } else {
            gc.setColor(Color.GREEN);
        }

        gc.fillOval(h.getX(), h.getY(), 10, 10);
    }
}
