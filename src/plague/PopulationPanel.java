package plague;

import simstation.*;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;



public class PopulationPanel extends WorldPanel implements ChangeListener {

    JPanel sliderPanel = new JPanel();
    JSlider initialInfected, probability, initialPopulation, infectionTime;
    JButton lethality;

    public PopulationPanel(PlagueFactory factory) {
        super(factory);

        sliderPanel.setLayout(new GridLayout(6, 1));
        sliderPanel.setOpaque(false);

        initialInfected = new JSlider(JSlider.HORIZONTAL, 0, 100, 25);
        initialInfected.setMinorTickSpacing(1);
        initialInfected.setMajorTickSpacing(3);
        initialInfected.setPaintTicks(true);
        initialInfected.setPaintLabels(true);
        initialInfected.setLabelTable(initialInfected.createStandardLabels(10));


        probability = new JSlider(JSlider.HORIZONTAL, 0, 100, 50);
        probability.setMinorTickSpacing(1);
        probability.setMajorTickSpacing(3);
        probability.setPaintTicks(true);
        probability.setPaintLabels(true);
        probability.setLabelTable(probability.createStandardLabels(10));

        initialPopulation = new JSlider(JSlider.HORIZONTAL, 0, 100, 50);
        initialPopulation.setMinorTickSpacing(1);
        initialPopulation.setMajorTickSpacing(3);
        initialPopulation.setPaintTicks(true);
        initialPopulation.setPaintLabels(true);
        initialPopulation.setLabelTable(initialPopulation.createStandardLabels(10));

        infectionTime = new JSlider(JSlider.HORIZONTAL, 0, 100, 50);
        infectionTime.setMinorTickSpacing(1);
        infectionTime.setMajorTickSpacing(3);
        infectionTime.setPaintTicks(true);
        infectionTime.setPaintLabels(true);
        infectionTime.setLabelTable(infectionTime.createStandardLabels(10));

        initialInfected.addChangeListener(this);
        probability.addChangeListener(this);
        initialPopulation.addChangeListener(this);
        infectionTime.addChangeListener(this);

        JPanel p = new JPanel();
        JPanel pp = new JPanel();
        p.setLayout(new BorderLayout());
        p.setOpaque(false);
        pp.setLayout(new BorderLayout());
        pp.setOpaque(false);
        pp.add(new JLabel("Initial Infected"));
        p.add(pp, BorderLayout.NORTH);
        pp = new JPanel();
        pp.setOpaque(false);
        pp.add(initialInfected);
        p.add(pp, BorderLayout.CENTER);

    }
    
}


