package mvc;
import javax.swing.*;


/*
Vinzent Schubert 3/13 11:20
 */
public abstract class View extends JPanel implements Subscriber{
    protected Model model;

    public View(Model model) { // subscribes to model
        this.model = model;
        model.subscribe(this);
    }

    public void setModel(Model modelNew) { // unsubscribe, update ref, re sub,
        model.unsubscribe(this);
        this.model = modelNew;
        model.subscribe(this);
        repaint();
    }
    @Override
    public void update(){
        repaint();
    }

}
