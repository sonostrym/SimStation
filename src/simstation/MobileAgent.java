package simstation;

public abstract class MobileAgent extends Agent {

    protected Heading heading;
    
    public MobileAgent(String agentName, World world) {
        super(agentName, world);
        heading = Heading.random();
    }

    public void move(int steps){
        String agentName = getName();
        World world = getWorld();

        while(steps > 0){
            int oldX = getX();
            int oldY = getY();
            int newX = oldX;
            int newY = oldY;
            if (heading != null) {
                switch (heading) {
                    case NORTH -> newY = oldY - 1;
                    case SOUTH -> newY = oldY + 1;
                    case EAST -> newX = oldX + 1;
                    case WEST -> newX = oldX - 1;
                    default -> {
                    }
                }
            }
            // world.changed(agentName, oldX, oldY, newX, newY);
            setXY(newX, newY);
            steps--;
        }
    }

    public void turn(Heading dir){
        heading = dir;
    }

}
