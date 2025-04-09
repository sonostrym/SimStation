package prisonerdilemma;

import simstation.*;

public class Prisoner extends Agent {
    private int fitness = 0;
    private boolean partnerCheated = false;
    private Strategy strategy;

    public Prisoner(String name, Strategy strategy) {
        super(name);
        this.strategy = strategy;
    }

    public boolean cooperate() {
        return strategy.cooperate(this);
    }

    public void updateFitness(int amt) {
        fitness += amt;
    }

    public int getFitness() {
        return fitness;
    }

    public void setPartnerCheated(boolean cheated) {
        this.partnerCheated = cheated;
    }

    public boolean getPartnerCheated() {
        return partnerCheated;
    }

    public Strategy getStrategy() {
        return strategy;
    }

    @Override
    public void update() {
        Prisoner partner = (Prisoner) getWorld().getNeighbor(this,250);
        //unsure what radius should be...

        if (partner != null) {
            boolean myMove = this.cooperate();
            boolean partnerMove = partner.cooperate();

            // both cooperate
            if (myMove && partnerMove) {
                this.updateFitness(3);
                partner.updateFitness(3);
            //partner cheats
            } else if (myMove) {
                this.updateFitness(0);
                partner.updateFitness(5);
            // i cheat
            } else if (partnerMove) {
                this.updateFitness(5);
                partner.updateFitness(0);
            // both cheat
            } else {
                this.updateFitness(1);
                partner.updateFitness(1);
            }

            // Tit4Tat
            this.setPartnerCheated(!partnerMove);
            partner.setPartnerCheated(!myMove);
        }
    }
}
