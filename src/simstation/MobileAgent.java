package simstation;

public abstract class MobileAgent extends Agent {

    protected Heading heading;
    
    public MobileAgent(String agentName) {
        super(agentName);
        heading = Heading.random();
    }

    public void move(int steps){
        World world = getWorld();
        while(steps > 0){
            int oldX = getX();
            int oldY = getY();
            int newX = oldX;
            int newY = oldY;
            if (heading != null) {
                if(heading == Heading.NORTH) {
                    if(oldY - 1 < 0){
                        newY = World.SIZE - 1;
                    }
                    else{
                        newY = oldY - 1;
                    }
                } else if (heading == Heading.SOUTH) {
                    if(oldY + 1 > World.SIZE){
                        newY = 0;
                    }
                    else{
                        newY = oldY + 1;
                    }
                } else if (heading == Heading.EAST) {
                    if(oldX + 1 > World.SIZE){
                        newX = 0;
                    }
                    else{
                        newX = oldX + 1;
                    }
                } else if (heading == Heading.WEST) {
                    if(oldX - 1 < 0){
                        newX = World.SIZE - 1;
                    }
                    else{
                        newX = oldX - 1;
                    }
                }
            }
            setXY(newX, newY);
            world.changed();
            steps--;
        }
    }

    public void turn(Heading dir){
        heading = dir;
    }

}
