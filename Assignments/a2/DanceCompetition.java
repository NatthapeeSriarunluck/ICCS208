import java.util.*;

/**
 * Natthapee Sriarunluck 648066
 */


public class DanceCompetition {

    // Do not modify or add the member variables
    private List<Competitor> competitors;  // a list of competitors
    private double hiphopFraction;         // weight of hip-hop dance
    private double poppingDanceFraction;   // weight of popping dance
    // -----------------------------------------


    public DanceCompetition(double poppingDance, double hipHop) {
        this.poppingDanceFraction = poppingDance;
        this.hiphopFraction = hipHop;
        this.competitors = new ArrayList<Competitor>();
    }


    public DanceCompetition() {
        this(0.6, 0.4);
    }

    public List<Competitor> getGoldMedal() {
        for (Competitor i : this.competitors) {
            if (i.getTotalDanceScore() < 8) {
                this.competitors.remove(i);
            }
        }
        return this.competitors;
    }


    public double getHipHopFraction() {
        //CODE HERE
        return this.hiphopFraction;
    }

    // Return the weight (i.e., fraction) of popping dance
    public double getPoppingDanceFraction() {
        //CODE HERE
        return this.poppingDanceFraction;
    }

    // Add Competitor c into the list of competitors and also
    // inform the competitor c that c belongs to this competition 
    // by invoking c.setDanceCompetition suitably. 
    // Did you already inform the competitor?
    public void addCompetitor(Competitor c) {
        this.competitors.add(c);
        c.setDanceCompetition(this);
    }
}
