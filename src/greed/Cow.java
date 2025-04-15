package greed;

import simstation.*;
import mvc.*;

public class Cow extends MobileAgent {

    private static int energy;
    private static int greediness;

    public Cow(String agentName) {
        super(agentName);
        energy = 100;
        greediness = 25;
    }

    public void setLocation(int x, int y){
        super.setXY(x, y);
    }

    public void setEnergy(int moveEnergy){
        energy = moveEnergy;
    }

    public void setGreediness(int greed){
        greediness = greed;
    }

    public int getEnergy(){
        return energy;
    }

    public int getGreediness(){
        return greediness;
    }

    @Override
    public void update() {
        Meadow meadow = (Meadow) getWorld();
        Patch location = meadow.getPatch(getX(), getY());

        boolean ateEnough = location.eatMe(this, greediness);

        if(ateEnough){
            energy += greediness;
        }else if(energy >= meadow.getMoveEnergy()){
            heading = Heading.random();
            int steps = Utilities.rng.nextInt(5);
            move(steps);
        }
        else{
            energy -= meadow.getWaitPenalty();
        }

        if (energy <= 0) {
            stop();
        }

    }


}
