package sfu.cmpt213.as0;

/**
 * Minion class is used to create minions and store their information
 */
public class Minion {

    private String name;
    private double heightInM;
    private int numEvilDeeds;

    public Minion(String name, double heightInM, int numEvilDeeds) {
        this.name = name;
        this.heightInM = heightInM;
        this.numEvilDeeds = numEvilDeeds;
    }

    public String getName() {
        return name;
    }

    public double getHeightInM() {
        return heightInM;
    }

    public int getNumEvilDeeds() {
        return numEvilDeeds;
    }

    public void incrementEvilDeed() {
        this.numEvilDeeds = this.numEvilDeeds + 1;
    }

    @Override
    public String toString() {
        return getClass().getName()
                + "[Name: " + this.name + ", "
                + "Evil Deeds: " + this.numEvilDeeds + ", "
                + "Height: " + this.heightInM + "]";
    }

}
