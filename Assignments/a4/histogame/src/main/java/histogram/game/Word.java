package histogram.game;

import histogram.Histogram;
import histogram.SimpleHistogram;


public class Word implements Formable<Word>, Comparable<Word> {
    private Histogram<Character> histogram;
    private Character[] wordArray;
    private String word;


    public Word(String word) {
        this.word = word;
        this.wordArray = new Character[word.length()];
        for (int i = 0; i < word.length(); i++) {
            wordArray[i] = word.charAt(i);
        }
        this.histogram = new SimpleHistogram<>(wordArray);
    }

    public String getWord() {
        return word;
    }

    public Histogram<Character> getHistogram() {
        return this.histogram;
    }

    @Override
    public boolean canForm(Word other) {
        boolean ans = false;
        for (Character x : other.histogram) {
            ans = false;
            if (histogram.getCount(x) >= other.histogram.getCount(x)) {
                ans = true;
            } else {
                return false;
            }
        }
        return ans;
    }

    @Override
    public int compareTo(Word o) {
        if (this.histogram.getTotalCount() < o.histogram.getTotalCount()) {
            return -1;
        }
        if (this.histogram.getTotalCount() == o.histogram.getTotalCount()) {
            for (int i = 0; i < word.length(); i++) {
                if (this.word.charAt(i) < o.word.charAt(i)) {
                    return -1;
                }
                if (this.word.charAt(i) > o.word.charAt(i)) {
                    return 1;
                }
            }
            return 0;
        }
        return 1;
    }
}