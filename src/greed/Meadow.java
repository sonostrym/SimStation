package greed;

import mvc.Utilities;
import simstation.*;

public class Meadow extends World {
    private Patch[][] patches;
    private int waitPenalty;
    public static int moveEnergy;
    private int numCows;
    public static int dim;

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
                patches[i][j].setWorld(this);
            }
        }

        startPatchThreads();
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
            addAgent(cow);
        }

        for(int i=0; i<dim; i++){
            for(int j=0; j<dim; j++){
                patches[i][j].setEnergy(Utilities.rng.nextInt(100));
            }
        }
    }

    @Override
    public void stopAgents(){
        if(running){
            running = false;
            for(Agent a: agents){
                a.stop();
            }
            observer.stop();
            for(int i=0; i<dim; i++){
                for(int j=0; j<dim; j++){
                    patches[i][j].stop();
                }
            }
            changed();
        }
    }

    public void startPatchThreads() {
        for (int row = 0; row < patches.length; row++) {
            int finalRow = row;
            Thread t = new Thread(() -> {
                while (true) {
                    for (int col = 0; col < patches[finalRow].length; col++) {
                        patches[finalRow][col].update();
                    }
                    try {
                        Thread.sleep(100); 
                    } catch (InterruptedException e) {
                        Utilities.error(e);
                        return;
                    }
                }
            });
            t.start();
        }
    }

}
