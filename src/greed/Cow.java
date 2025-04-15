package greed;

import simstation.*;
import mvc.*;

public class Cow extends MobileAgent {

    private int energy;
    public static int greediness;

    public Cow(String agentName) {
        super(agentName);
        energy = 100;
        greediness = 25;
        int x = Utilities.rng.nextInt(Meadow.dim);
        int y = Utilities.rng.nextInt(Meadow.dim);
        setLocation(x, y);
    }

    public void setLocation(int x, int y){
        super.setXY(x, y);
    }

    public void setEnergy(int moveEnergy){
        energy = moveEnergy;
    }

    public static void setGreediness(int greed){
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
        try{
            boolean ateEnough = location.eatMe(this, greediness);

            if(ateEnough){
                energy += greediness;
            }else if(energy >= meadow.getMoveEnergy()){
                heading = Heading.random();
                int steps = Utilities.rng.nextInt(5);
                move(steps);
                energy -= meadow.getMoveEnergy();
            }
            else{
                energy -= meadow.getWaitPenalty();
            }
    
            if (energy <= 0) {
                stop();
            }
            Thread.sleep(100);
        }
        catch (InterruptedException e) {
            System.err.print("Error Message");
        }


    }

    @Override
    public void move(int steps){
        Meadow meadow = (Meadow) getWorld();
        int worldborder = meadow.getDim() - 1;  
        while(steps > 0){
            int oldX = getX();
            int oldY = getY();
            int newX = oldX;
            int newY = oldY;
            if (heading != null) {
                if(heading == Heading.NORTH) {
                    if(oldY - 1 < 0){
                        newY = worldborder - 1;
                    }
                    else{
                        newY = oldY - 1;
                    }
                } else if (heading == Heading.SOUTH) {
                    if(oldY + 1 > worldborder){
                        newY = 0;
                    }
                    else{
                        newY = oldY + 1;
                    }
                } else if (heading == Heading.EAST) {
                    if(oldX + 1 > worldborder){
                        newX = 0;
                    }
                    else{
                        newX = oldX + 1;
                    }
                } else if (heading == Heading.WEST) {
                    if(oldX - 1 < 0){
                        newX = worldborder - 1;
                    }
                    else{
                        newX = oldX - 1;
                    }
                }
            }
            setXY(newX, newY);
            meadow.changed();
            steps--;
        }
    }


}
