package simstation;

import java.io.*;
import mvc.*;

public abstract class Agent implements Runnable, Serializable{
    private final String agentName;
    transient protected Thread myThread;
    private boolean paused;
    private boolean stopped;
    private int xc, yc;
    private World world;


    public Agent(String agentName){
        this.agentName = agentName;
        world = null;
        xc = Utilities.rng.nextInt(World.SIZE);
        yc = Utilities.rng.nextInt(World.SIZE);
        this.paused = false;
        this.stopped = false;
    }

    public void setWorld(World w){
        world = w;
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
        if (myThread != null) return; // checking if already started
        stopped = false;
        paused = false;
        myThread = new Thread(this);
        myThread.start();
    }


    public void stop(){
        stopped = true;
        if(paused){
            resume();
        }
        System.out.println(getName() + " died.");
        myThread = null; //agents go to ready state when you stop. 
    }

    public synchronized void pause(){
        paused = true;
    }

    public synchronized void resume(){
        paused = false;
        notify();
    }

    public abstract void update();
    protected synchronized void onStart() {}
    protected synchronized void onInterrupted() {}
    protected synchronized void onExit() {}

    @Override
    public void run(){
        try {
            // myThread = Thread.currentThread();
            //"checkPaused();"
            onStart();
            while(!stopped){
                try {
                    synchronized(this){
                        while(paused){
                            wait();
                        }
                    }
                    update();
                    Thread.sleep(250);
                    //"checkPaused();"
                } catch (InterruptedException e) { 
                    onInterrupted();
                    Utilities.error(e);
                }
            }
        }
        finally{
            onExit();
        }
    }
    public boolean isAlive(){
        return !stopped;
    }

    public boolean isReady() {
        return myThread == null;
    }
}

