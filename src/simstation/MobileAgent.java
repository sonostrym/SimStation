package simstation;

public abstract class MobileAgent extends Agent {

    protected Heading heading;
    
    public MobileAgent(String agentName) {
        super(agentName);
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
                if(heading == Heading.NORTH) {
                    newY = oldY - 1;
                } else if (heading == Heading.SOUTH) {
                    newY = oldY + 1;
                } else if (heading == Heading.EAST) {
                    newX = oldX + 1;
                } else if (heading == Heading.WEST) {
                    newX = oldX - 1;
                }
            }
            setXY(newX, newY);
            steps--;
        }
    }

    public void turn(Heading dir){
        heading = dir;
    }

}
