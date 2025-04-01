package simstation;

public class ObserverAgent extends Agent {

    public ObserverAgent(String name, World world){
        super(name, world);
    }

    @Override
    public void update() {
        try {
            Thread.sleep(50);
            getWorld().updateStatistics();
        } catch (InterruptedException e) {
            System.err.print("Error Message");
        }
    }
}
