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
        String name = p.getStrategy().getName();

        if (fitness >= 400) {
            gc.setColor(new Color(9, 9, 9));
        } else if (fitness >= 300) {
            gc.setColor(new Color(60, 61, 61));
        } else if (fitness >= 200) {
            gc.setColor(new Color(130, 148, 148));
        } else if (fitness >= 100) {
            gc.setColor(new Color(180, 199, 199));
        } else {
            gc.setColor(new Color(251, 252, 251));
        }

        gc.fillOval(p.getX()-5, p.getY()-5, 10, 10);


        if(name.equals("Cooperate")){
            gc.setColor(Color.BLUE);
        } else if(name.equals("Cheat")){
            gc.setColor(Color.GREEN);
        } else if(name.equals("Random")){
            gc.setColor(Color.ORANGE);
        } else if(name.equals("Tit4Tat")){
            gc.setColor(Color.MAGENTA);
        }

        gc.fillOval(p.getX()-3, p.getY()-3, 6, 6);

        gc.setColor(Color.BLACK);
        gc.drawOval(p.getX()-5, p.getY()-5, 10, 10);
    }
}
