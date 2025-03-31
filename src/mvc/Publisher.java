package mvc;
/*
Vinzent Schubert 3/12 22:35

 */

import java.util.*;


public class Publisher {
    private final List<Subscriber> subscriberList = new ArrayList<>();

    public void subscribe (Subscriber subscriber ){
        if(!subscriberList.contains(subscriber)){
            subscriberList.add(subscriber);
        }
    }

    public void unsubscribe (Subscriber subscriber){
            subscriberList.remove(subscriber);
    }
    protected void notifySubscribers(){
        for (Subscriber subscriber : subscriberList){
            subscriber.update();
        }
    }
}
