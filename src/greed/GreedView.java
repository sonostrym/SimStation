package greed;

import mvc.Model;
import java.awt.*;
import simstation.Agent;
import simstation.WorldView;

public class GreedView extends WorldView {
    public GreedView(Model m) {
        super(m);
    }

    @Override
    public void paintComponent(Graphics gc){
        super.paintComponent(gc);
        Meadow meadow  = (Meadow) model;
        gc.setColor(Color.GREEN);
        for (int i = 0; i < meadow.getDim(); i++) {
            for (int j = 0; j < meadow.getDim(); j++) {
                Patch patch = meadow.getPatch(i, j);
                drawPatch(gc, patch, i, j);
            }
        }

        for (Agent a : meadow.getAgents()) {
            drawAgent(a, gc);
        }
    }

    @Override
    public void drawAgent(Agent a, Graphics gc) {
        int TILE_SIZE = Patch.getPatchSize();
        Cow cow = (Cow) a;
        int x = cow.getY() * TILE_SIZE;
        int y = cow.getX() * TILE_SIZE;
        if(cow.isAlive()){
            gc.setColor(Color.RED);
            gc.fillOval(x, y, 10, 10);
            gc.setColor(Color.BLACK);
            gc.drawOval(x, y, 10, 10);
        } else {
            gc.setColor(Color.WHITE);
            gc.fillOval(x, y, 10, 10);
            gc.setColor(Color.BLACK);
            gc.drawOval(x, y, 10, 10);
        }
    }

    public void drawPatch(Graphics gc, Patch patch, int row, int col ) {
        int TILE_SIZE = Patch.getPatchSize();
        int x = col * TILE_SIZE;
        int y = row * TILE_SIZE;

        int energy = patch.getEnergy();

        if(energy >= 80){
            gc.setColor(new Color(0, 50, 0));
            gc.fillRect(x, y, TILE_SIZE, TILE_SIZE);
        }
        else if(energy >= 60){
            gc.setColor(new Color(0, 100, 0));
            gc.fillRect(x, y, TILE_SIZE, TILE_SIZE);
        }
        else if(energy >= 40){
            gc.setColor(new Color(0, 150, 0));
            gc.fillRect(x, y, TILE_SIZE, TILE_SIZE);
        }
        else if(energy >= 20){
            gc.setColor(new Color(0, 200, 0));
            gc.fillRect(x, y, TILE_SIZE, TILE_SIZE);
        }
        else{
            gc.setColor(new Color(0, 250, 0));
            gc.fillRect(x, y, TILE_SIZE, TILE_SIZE);
        }
            gc.setColor(Color.BLACK);
            gc.drawRect(x, y, TILE_SIZE, TILE_SIZE);
        }


    
}
