package simstation;

import java.io.*;
import mvc.*;

public abstract class Agent implements Runnable, Serializable{
    private String agentName;
    transient protected Thread myThread;
    private boolean suspended;
    private boolean stopped;
    private int xc, yc;
    private World world;


    public Agent(String agentName, World world){
        this.agentName = agentName;
        this.world = world;
        xc = Utilities.rng.nextInt(World.SIZE);
        yc = Utilities.rng.nextInt(World.SIZE);
        this.suspended = false;
        this.stopped = false;
    }
    
    public String getName(){
        return agentName;
    }

    public World getWorld(){
        return world;
    }

    public int getX(){
        return xc;
    }

    public int getY(){
        return yc;
    }

    public void setXY(int x, int y){
        xc = x;
        yc = y;
    }

    public void start(){
        stopped = false;
        suspended = false;
        myThread = new Thread(this);
        myThread.start();
    }


    public void stop(){
        stopped = true;
        if(suspended){
            resume();
        }
    }

    public synchronized void pause(){
        suspended = true;
    }

    public synchronized void resume(){
        suspended = false;
        notify();
    }

    public abstract void update();


    @Override
    public void run(){
        while(!stopped){
            try {
                synchronized(this){
                    while(suspended){
                        wait();
                    }
                }
                update();
                Thread.sleep(250);
            } catch (InterruptedException e) { 
                System.err.println("Error Message");
            }
        }
    }

    public boolean isAlive(){
        
    }

    
}
