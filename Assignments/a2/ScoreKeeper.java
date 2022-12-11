import java.util.*;

/**
 * Natthapee Sriarunluck 6480266
 */

/*
 * The ScoreKeeper class stores scores and answers basic statistical average
 * about the scores. It is intended to be use as part of another class for
 * score storage.
 */
public class ScoreKeeper {
    private double[] scores;

    public ScoreKeeper() {

    }

    /*
     * Record the scores given by double[] scores into your instance variable
     * scores. If the member variable already has existing data, clear it before
     * putting in the new scores.
     */
    public void setScores(double[] scores) {
        this.scores = Arrays.copyOf(scores, scores.length);
    }

    // Return an array double[] of scores as was previously set
    public double[] getScores() {
        return this.scores;
    }

    /*
     * Return the average of the scores after excluding the minimum and maximum
     * value. In short, it should return
     *   (SUM(this.scores) - MIN(this.scores) - MAX(this.scores))/(n-2), where
     * n is the length of the score list. This function will return Double.NaN if
     * n is <= 2 because no meaningful average can be computed.
     */
    public double getCalibratedAverage() {
        if (this.scores.length <= 2) {
            return Double.NaN;
        }
        Arrays.sort(this.scores);
        double Sum = 0;
        for (double i : this.scores) {
            Sum += i;
        }
        return (Sum - this.scores[0] - this.scores[this.scores.length - 1]) / (this.scores.length - 2);
    }

}
