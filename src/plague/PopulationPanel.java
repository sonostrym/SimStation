package plague;

import greed.Cow;
import greed.Meadow;
import simstation.*;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class PopulationPanel extends WorldPanel implements ChangeListener, ActionListener  {

    JPanel sliderPanel = new JPanel();
    JSlider initialInfected, probability, initialPopulation, infectionTime;
    JButton lethality;

    public PopulationPanel(PlagueFactory factory) {
        super(factory);

        sliderPanel.setLayout(new GridLayout(5, 1));
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

        infectionTime = new JSlider(JSlider.HORIZONTAL, 0, 200, 100);
        //infectionTime.setMinorTickSpacing(1);
        infectionTime.setMajorTickSpacing(3);
        infectionTime.setPaintTicks(true);
        infectionTime.setPaintLabels(true);
        infectionTime.setLabelTable(infectionTime.createStandardLabels(20));

        lethality = new JButton("Fatal"); // this needs to change the text to 'Fatal' when pressed

        initialInfected.addChangeListener(this);
        probability.addChangeListener(this);
        initialPopulation.addChangeListener(this);
        infectionTime.addChangeListener(this);
        
        lethality.addActionListener(e -> {
            ((Population) model).changeFatal();

            if (((Population) model).checkFatal()) {
                lethality.setText("Fatal");
            } else {
                lethality.setText("Not Fatal");
            }
        });

        JPanel p = new JPanel();
        JPanel pp = new JPanel();
        p.setLayout(new BorderLayout());
        p.setOpaque(false);
        pp.setOpaque(false);
        pp.add(new JLabel("Initial Infected"));
        p.add(pp, BorderLayout.NORTH);
        pp = new JPanel();
        pp.setOpaque(false);
        pp.add(initialInfected);
        p.add(pp, BorderLayout.CENTER);
        sliderPanel.add(p);

        p = new JPanel();
        pp = new JPanel();
        p.setLayout(new BorderLayout());
        p.setOpaque(false);
        pp.setOpaque(false);
        pp.add(new JLabel("Infection Probability"));
        p.add(pp, BorderLayout.NORTH);
        pp = new JPanel();
        pp.setOpaque(false);
        pp.add(probability);
        p.add(pp, BorderLayout.CENTER);
        sliderPanel.add(p);

        p = new JPanel();
        pp = new JPanel();
        p.setLayout(new BorderLayout());
        p.setOpaque(false);
        pp.setOpaque(false);
        pp.add(new JLabel("Initial Population Size"));
        p.add(pp, BorderLayout.NORTH);
        pp = new JPanel();
        pp.setOpaque(false);
        pp.add(initialPopulation);
        p.add(pp, BorderLayout.CENTER);
        sliderPanel.add(p);

        p = new JPanel();
        pp = new JPanel();
        p.setLayout(new BorderLayout());
        p.setOpaque(false);
        pp.setOpaque(false);
        pp.add(new JLabel("Fatality/Recovery Time"));
        p.add(pp, BorderLayout.NORTH);
        pp = new JPanel();
        pp.setOpaque(false);
        pp.add(infectionTime);
        p.add(pp, BorderLayout.CENTER);
        sliderPanel.add(p);

        p = new JPanel();
        pp = new JPanel();
        p.setLayout(new BorderLayout());
        p.setOpaque(false);
        pp.setOpaque(false);
        p.add(pp, BorderLayout.NORTH);
        pp = new JPanel();
        pp.setOpaque(false);
        pp.add(lethality);
        p.add(pp, BorderLayout.CENTER);
        sliderPanel.add(p);

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
        topPanel.setOpaque(false);
        topPanel.add(threadPanel);
        topPanel.add(sliderPanel);
        controlPanel.add(topPanel, BorderLayout.NORTH);

    }

    public void stateChanged(ChangeEvent e) {
        if (e.getSource() == initialInfected) {
            ((Population)model).numInfected = initialInfected.getValue();
        }
        if (e.getSource() == probability) {
            ((Population)model).setVirulence(probability.getValue());
        }
        if (e.getSource() == initialPopulation) {
            ((Population)model).numHosts = initialPopulation.getValue();
        }
        if (e.getSource() == infectionTime) {
            ((Population)model).setLethalityTime(infectionTime.getValue());
        }

        model.changed();
    }

    public void update() {
        initialInfected.setValue(((Population)model).numInfected);
        probability.setValue(((Population)model).VIRULENCE);
        initialPopulation.setValue(((Population)model).numHosts);
        infectionTime.setValue(((Population)model).LETHALITY_TIME);
        repaint();
    }
}
