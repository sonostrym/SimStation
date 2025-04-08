package simstation;

public class ObserverAgent extends Agent {

    public ObserverAgent(String name){
        super(name);
    }

    @Override
    public void update() {
        try {
            Thread.sleep(1000);
            getWorld().updateStatistics();
        } catch (InterruptedException e) {
            System.err.print("Error Message");
        }
    }
}
