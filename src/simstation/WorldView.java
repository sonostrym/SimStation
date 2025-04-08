package simstation;

import java.awt.*;

import javax.swing.*;
import mvc.*;

public class WorldView extends View {
  
      public WorldView(Model model) {
        super(model);
        setBorder(BorderFactory.createLineBorder(Color.black));
    }
    
    @Override
    public void setModel(Model newModel) {
        super.setModel(newModel);
        repaint();
    }

    @Override
    public void paintComponent(Graphics gc) {
        super.paintComponent(gc);
        World world = (World) model;
        for (Agent a : world.getAgents()) {
            drawAgent(a, gc);
        }
    }

    public void drawAgent(Agent a, Graphics gc) {
        gc.setColor(Color.RED);
        gc.fillOval(a.getX(), a.getY(), 10, 10);
    }
}
