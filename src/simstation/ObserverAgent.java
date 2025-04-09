package simstation;

public class ObserverAgent extends Agent {

    public ObserverAgent(String name){
        super(name);
    }

    @Override
    public void update() {
        try {
            getWorld().updateStatistics();
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.err.print("Error Message");
        }
    }
}
