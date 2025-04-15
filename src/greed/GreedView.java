package greed;

import mvc.Model;
import java.awt.*;
import java.awt.image.TileObserver;

import prisonerdilemma.Prisoner;
import simstation.Agent;
import simstation.World;
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
        int x = cow.getX() * TILE_SIZE;
        int y = cow.getY() * TILE_SIZE;
        gc.setColor(Color.RED);
        gc.fillOval(x + 5, y + 5, 5, 5);
        gc.setColor(Color.BLACK);
        gc.drawOval(x + 5, y + 5, 5, 5);
    }

    public void drawPatch(Graphics gc, Patch patch, int row, int col ) {
       int TILE_SIZE = Patch.getPatchSize();
       int x = col * TILE_SIZE;
       int y = row * TILE_SIZE;

       gc.setColor(Color.GREEN);
       gc.fillRect(x, y, TILE_SIZE, TILE_SIZE);
       gc.setColor(Color.BLACK);
       gc.drawRect(x, y, TILE_SIZE, TILE_SIZE);
    }


    
}
