package greed;


import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.*;

import simstation.*;

public class GreedPanel extends WorldPanel implements ChangeListener{

    JPanel sliderPanel = new JPanel();
    JSlider greedSlider, gbrateSlider, moveSlider;

    public GreedPanel(WorldFactory factory) {
        super(factory);
        

        sliderPanel.setLayout(new GridLayout(3, 1));
        sliderPanel.setOpaque(false);

        greedSlider = new JSlider(JSlider.HORIZONTAL, 0, 100, 50);
        greedSlider.setMajorTickSpacing(10);
        greedSlider.setPaintTicks(true);
        greedSlider.setPaintLabels(true);
        greedSlider.setLabelTable(greedSlider.createStandardLabels(10));

        gbrateSlider = new JSlider(JSlider.HORIZONTAL, 0, 10, 1);
        gbrateSlider.setMajorTickSpacing(10);
        gbrateSlider.setMinorTickSpacing(2);
        gbrateSlider.setPaintTicks(true);
        gbrateSlider.setPaintLabels(true);
        gbrateSlider.setLabelTable(gbrateSlider.createStandardLabels(10));

        moveSlider = new JSlider(JSlider.HORIZONTAL, 0, 50, 10);
        moveSlider.setMajorTickSpacing(10);
        moveSlider.setMinorTickSpacing(5);
        moveSlider.setPaintTicks(true);
        moveSlider.setPaintLabels(true);
        moveSlider.setLabelTable(moveSlider.createStandardLabels(10));

        greedSlider.addChangeListener(this);
        gbrateSlider.addChangeListener(this);
        moveSlider.addChangeListener(this);

        greedSlider.addChangeListener(e -> {
            Cow.greediness = greedSlider.getValue();
        });
        gbrateSlider.addChangeListener(e -> {
            Patch.growBackRate = gbrateSlider.getValue();
        });
        moveSlider.addChangeListener(e -> {
            Meadow.moveEnergy = moveSlider.getValue();
        });

        JPanel p = new JPanel();
        JPanel pp = new JPanel();

        p.setLayout(new BorderLayout());
        p.setOpaque(false);
        pp.setOpaque(false);
        pp.add(new JLabel("Greediness"));
        p.add(pp, BorderLayout.NORTH);
        pp = new JPanel();
        pp.setOpaque(false);
        pp.add(greedSlider);
        p.add(pp, BorderLayout.CENTER);
        sliderPanel.add(p);

        p = new JPanel();
        pp = new JPanel();
        p.setLayout(new BorderLayout());
        p.setOpaque(false);
        pp.setOpaque(false);
        pp.add(new JLabel("Grow Back Rate"));
        p.add(pp, BorderLayout.NORTH);
        pp = new JPanel();
        pp.setOpaque(false);
        pp.add(gbrateSlider);
        p.add(pp, BorderLayout.CENTER);
        sliderPanel.add(p);

        p = new JPanel();
        pp = new JPanel();
        p.setLayout(new BorderLayout());
        p.setOpaque(false);
        pp.setOpaque(false);
        pp.add(new JLabel("Move Energy"));
        p.add(pp, BorderLayout.NORTH);
        pp = new JPanel();
        pp.setOpaque(false);
        pp.add(moveSlider);
        p.add(pp, BorderLayout.CENTER);
        sliderPanel.add(p);

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
        topPanel.setOpaque(false);
        topPanel.add(threadPanel);      
        topPanel.add(sliderPanel);     
        
        controlPanel.add(topPanel, BorderLayout.NORTH);
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        if(e.getSource() == greedSlider){
            Cow.setGreediness(greedSlider.getValue());
        }else if(e.getSource() == gbrateSlider){
            Patch.setGrowBackRate(gbrateSlider.getValue());
        }else if(e.getSource() == moveSlider){
            Meadow.setMoveEnergy(moveSlider.getValue());
        }
        model.changed();
    }

    public void update(){
        greedSlider.setValue(Cow.greediness);
        gbrateSlider.setValue(Patch.growBackRate);
        moveSlider.setValue(Meadow.moveEnergy);
    }
}

