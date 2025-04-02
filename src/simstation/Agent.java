package simstation;

import java.io.*;
import mvc.*;
import java.awt.Point;

public abstract class Agent implements Runnable, Serializable{
    private final String agentName;
    transient protected Thread myThread;
    private boolean suspended;
    private boolean stopped;
    private int xc, yc;
    private final World world;


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
        int oldX = xc;
        int oldY = yc;
        xc = x;
        yc = y;

        Point oldPoint = new Point(oldX, oldY);
        Point newPoint = new Point(x, y);
        world.changed(agentName, oldPoint, newPoint); //we need to implement this I think
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

    protected void onStart() {}
    protected void onInterrupted() {}
    protected void onExit() {}

    @Override
    public void run(){
        try {
            onStart();
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
                    onInterrupted();
                    System.err.println("Error Message");
                }
            }
        }
        finally{
            onExit();
        }
    }

    public boolean isAlive(){
        return myThread != null && myThread.isAlive() && !stopped;
    }
}
