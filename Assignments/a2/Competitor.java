import java.util.*;

/**
 * Natthapee Sriarunluck 6480266
 */


/*
 * The Competitor class represents a competitor in a dance competition. It keeps
 * attributes related to the competitor, including the competitor's scores from
 * dances.
 */
public class Competitor {

    // Do not modify or add the member variables
    private String aliasName;
    private ScoreKeeper poppingDanceScores;
    private ScoreKeeper hipHopDanceScores;
    private DanceCompetition competition;

    public Competitor() {
        this.competition = new DanceCompetition();

    }

    public void setAlias(String name) {
        this.aliasName = name;
    }

    public String getAlias() {
        //CODE HERE
        return this.aliasName;
    }

    public void setPoppingDanceScore(double[] scores) {
        this.poppingDanceScores = new ScoreKeeper();
        this.poppingDanceScores.setScores(scores);
    }

    public void setHipHopDanceScore(double[] scores) {
        this.hipHopDanceScores = new ScoreKeeper();
        this.hipHopDanceScores.setScores(scores);
    }


    public void setDanceCompetition(DanceCompetition dc) {
        this.competition = dc;
    }


    public void printPoppingDanceScore() {
        System.out.println(Arrays.toString(this.poppingDanceScores.getScores()));
    }

    public void printHipHopDanceScore() {
        System.out.println(Arrays.toString(this.hipHopDanceScores.getScores()));
    }


    public double getPoppingDanceAverage() {
        return this.poppingDanceScores.getCalibratedAverage();
    }


    public double getHipHopDanceAverage() {
        return this.hipHopDanceScores.getCalibratedAverage();
    }

    // Return the weighted average of the dance scores. The weights are specified
    // in competition object as follows:
    //      p = competition.getPoppingDanceFraction();
    //      h = competition.getHipHopFraction();
    // If, however, the competition object is null, use p = 0.6 and h = 0.4.
    // Then, the weighted average is simply:
    //     p * (popping dance calibrated average) + h * (hip-hop dance calibrated average)
    // Remember that the calibrated average of a dance is the average computed after
    // excluding the min and the max.
    public double getTotalDanceScore() {
        double p = this.competition.getPoppingDanceFraction();
        double h = this.competition.getHipHopFraction();
        return (p * this.getPoppingDanceAverage()) + (h * this.getHipHopDanceAverage());
    }

}
