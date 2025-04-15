package greed;

import mvc.Utilities;
import simstation.*;

public class Meadow extends World {
    private Patch[][] patches;
    private int waitPenalty;
    public static int moveEnergy;
    private int numCows;
    private int dim;

    public Meadow(){
        super();
        dim = SIZE/Patch.getPatchSize();
        patches = new Patch[dim][dim];
        waitPenalty = 5;
        moveEnergy = 10;
        numCows = 50;

        for(int i=0; i<dim; i++){
            for(int j=0; j<dim; j++){
                patches[i][j] = new Patch("Patch" + i + " - " + j);
            }
        }
    }

    public Patch[][] getPatches(){
        return patches;
    }

    public int getDim(){
        return dim;
    }

    public Patch getPatch(int x, int y){
        return patches[x][y];
    }

    public int getMoveEnergy(){
        return moveEnergy;
    }

    public static void setMoveEnergy(int newMoveEnergy){
        moveEnergy = newMoveEnergy;

    }

    public int getWaitPenalty(){
        return waitPenalty;
    }


    @Override
    public void populate() {
        for(int i=0; i<numCows; i++){
            Cow cow = new Cow("Cow" + i);
            int x = Utilities.rng.nextInt(dim);
            int y = Utilities.rng.nextInt(dim);
            cow.setLocation(x, y);
            addAgent(cow);
        }
    }

}
