package greed;

import java.util.ArrayList;
import java.util.List;
import mvc.*;
import simstation.*;

public class Patch extends Agent {
    private int energy;
    public static int growBackRate;
    private static int patchSize = 10;
    private Object lock = new Object();

    public Patch(String agentName) {
        super(agentName);
        energy = Utilities.rng.nextInt(100);
        growBackRate = 1;
    }

    public static int getPatchSize() {
        return patchSize;
    }

    public int getEnergy(){
        return energy;
    }

    public static void setGrowBackRate(int newGrowBackRate) {
        growBackRate = newGrowBackRate;
    }

    public boolean eatMe(Cow cow, int greediness){
        synchronized(lock){
            if(greediness <= energy){
                energy -= greediness;
                return true;
            }
            return false;
        }
    }

    @Override
    public void update() {
        try{
            synchronized(lock) {
                energy += growBackRate;
                if (energy > 100) {
                    energy = 100; 
                }
                Thread.sleep(100);
            }
        }
        catch (InterruptedException e) {
            System.err.print("Error Message");
        }

        
    }



    
}


