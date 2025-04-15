package simstation;

import java.util.*;
import mvc.*;

public abstract class World extends Model {
    public static int SIZE = 500;
    private int clock = 0;
    private int alive = 0;
    private List<Agent> agents;
    private ObserverAgent observer;
    private boolean running;
    private boolean paused;

    public World(){
        agents = new ArrayList<>();
        observer = new ObserverAgent("Observer");
        running = false;
        paused = false;
    }

    public int getClock(){
        return clock;
    }

    public int getAlive(){
        return alive;
    }

    public List<Agent> getAgents(){
        return agents;
    }


    public void addAgent(Agent a){
        agents.add(a);
    }

    public void startAgents(){
        running = true;
        paused = false;
        clock = 0;
        if(agents.size() > 0){
            for(Agent a: agents){
                a.stop();
            }
            agents.clear();
        }
        populate();
        alive = agents.size();
        for(Agent a : agents){
            a.setWorld(this);
            a.start();
        }
        observer.setWorld(this);
        observer.start();
        changed();
    }

    public void stopAgents(){
        if(running){
            running = false;
            for(Agent a: agents){
                a.stop();
            }
            observer.stop();
            changed();
        }
    }

    public void pauseAgents(){
        if(!paused){
            paused = true;
            for(Agent a: agents){
                a.pause();
            }
            observer.pause();
            changed(); 
        }
    }

    public void resumeAgents(){
        if(paused){
            paused = false;
            for(Agent a: agents){
                a.resume();
            }
            observer.resume();
            changed(); 
        }
    }

    public abstract void populate();
    

    public void getStatus(){
        Utilities.inform("Agents: " + agents.size() + "\n" +
                "Alive: " + alive + "\n" +
                "Clock: " + clock + "\n");
    }
    

    public void updateStatistics(){
        clock++;
        alive = 0;
        for(Agent a: agents){
            if(a.isAlive()){
                alive++;
            }
        }
        changed();
    }
    
    public Agent getNeighbor(Agent caller, int radius){
        int startIndex = Utilities.rng.nextInt(agents.size());
        int size = agents.size();

        for(int i = 0; i < size; i++){
            int index = (startIndex + i) % size; //circular iteration 
            Agent potentialNeighbor = agents.get(index);

            if(potentialNeighbor != caller){
                int dx = potentialNeighbor.getX() - caller.getX();
                int dy = potentialNeighbor.getY() - caller.getY();

                if(Math.sqrt(dx * dx + dy * dy ) <= radius){  //Euclidean
                    return potentialNeighbor;
                }
            }
        }
        return null;
    }

    public Iterator<Agent> iterator() {
        return agents.iterator();
    }

    //checking if agent is ready when you try to call save.
    @Serial
    private void writeObject(ObjectOutputStream out) throws IOException {
        for (Agent a : agents) {
            if (!a.isReady()) {
                throw new IOException("Cannot save simulation while agents have been started. Please stop simmulation first.");
            }
        }
        out.defaultWriteObject();
    }

}
