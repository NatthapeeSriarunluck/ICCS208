package histogram.game;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.*;


/*
1. Added a statement "Correct!" and "Try Again" when the player inputs a valid word or not.
2. Added a command "@" which helps the player by revealing 1 answer. The answer will be the shortest possible word
that is still unanswered. This is to prevent the helper revealing a hard answer like a 6-letter word answer.
3. The player can only use "@" TWICE  in game, this is to prevent the player from spamming help and getting the fullscore. When the player tries to
use the helper for the third time, "No More Helpers!" is printed. 

 */


public class TextTwist {
    private final Parser parser;
    private int score;
    private long startTime;
    private String userinput;
    private String random_letters;
    private final WordDatabase dictionary;

    private List<Word> ListofAnswers;
    private int fullscore;

    private final List<String> answered;
    private int helpCounter;


    public TextTwist() throws IOException {
        this.dictionary = new WordDatabase("linuxwords.txt");
        this.parser = new Parser();
        this.score = 0;
        this.userinput = "";
        this.answered = new ArrayList<>();
        this.random_letters = createRandomCharacters();
        Word random_letters_asWords = new Word(this.random_letters);
        this.ListofAnswers = dictionary.getAllSubWords(random_letters_asWords, 0);
        this.fullscore = this.ListofAnswers.size();
        this.helpCounter = 0;

    }

    public void play() {
        this.random_letters = createRandomCharacters();
        this.random_letters = createRandomCharacters();
        this.score = 0;
        Word random_letters_asWords = new Word(this.random_letters);
        this.ListofAnswers = dictionary.getAllSubWords(random_letters_asWords, 0);
        this.fullscore = this.ListofAnswers.size();
        this.startTime = System.currentTimeMillis();
        this.helpCounter = 0;
        printWelcome();

        boolean finished = false;
        while (!finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Bye!");
    }

    public void printWelcome() {
        long endTime = System.currentTimeMillis() - startTime;
        double elapsedTime = endTime / 1000.0;
        String format = formatSeconds(elapsedTime);
        System.out.println("Elapsed time: " + format + " seconds, Score: " + score + "/" + fullscore);
        System.out.println("Commands: q - quit, ! - give up, ? - info");
        System.out.print("[" + random_letters + "] ");
    }

    private String formatSeconds(double elapsedTime) {
        DecimalFormat form = new DecimalFormat("0.00");
        return form.format((System.currentTimeMillis() - startTime) / 1000.0);
    }

    private boolean processCommand(Command command) {
        CommandWord commandWord = command.getCommandWord();
        String guess = command.getSecondWord();
        boolean wantToQuit = false;

        switch (commandWord) {
            case UNKNOWN:
                userinput = guess;
                checkGuess();
                break;

            case QUIT:
                wantToQuit = quit();
                break;

            case GIVEUP:
                giveup();
                break;

            case INFO:
                info();
                break;

            case HELP:
                help();
                break;

        }
        return wantToQuit;

    }

    public boolean quit() {
        return true;
    }

    public void info() {
        ListofAnswers.sort(Word::compareTo);
        Word lastindex = ListofAnswers.get(ListofAnswers.size() - 1);
        for (int i = 0; i < ListofAnswers.size() - 1; i++) {
            boolean inAnswered = answered.contains(ListofAnswers.get(i).getWord());
            boolean shorterThanNext = ListofAnswers.get(i).getWord().length() < ListofAnswers.get(i + 1).getWord().length();
            if (shorterThanNext && inAnswered) {
                System.out.println(ListofAnswers.get(i).getWord());
            } else if (shorterThanNext) {
                int j = 0;
                while (j < ListofAnswers.get(i).getWord().length()) {
                    System.out.print("?");
                    j++;
                }
                System.out.print("\n");
            } else if (inAnswered) {
                System.out.print(ListofAnswers.get(i).getWord() + " ");
            } else {
                int j = 0;
                while (j < ListofAnswers.get(i).getWord().length()) {
                    System.out.print("?");
                    j++;
                }
                System.out.print(" ");
            }
        }
        if (answered.contains(lastindex.getWord())) {
            System.out.print(lastindex.getWord());
        } else {
            int j = 0;
            while (j < lastindex.getWord().length()) {
                System.out.print("?");
                j++;
            }
        }
        System.out.println("\n");
        printWelcome();
    }

    public void giveup() {
        ListofAnswers.sort(Word::compareTo);
        for (int i = 0; i < ListofAnswers.size() - 1; i++) {
            if (ListofAnswers.get(i).getWord().length() < ListofAnswers.get(i + 1).getWord().length()) {
                System.out.println(ListofAnswers.get(i).getWord() + " ");
            } else {
                System.out.print(ListofAnswers.get(i).getWord() + " ");
            }
        }
        if (ListofAnswers.get(ListofAnswers.size() - 1).getWord().length() == ListofAnswers.get(ListofAnswers.size() - 2).getWord().length()) {
            System.out.println(ListofAnswers.get(ListofAnswers.size() - 1).getWord());
        } else {
            System.out.println(ListofAnswers.get(ListofAnswers.size() - 1).getWord());
        }
        System.out.print("\n");
        play();
    }

    public String createRandomCharacters() {
        Word alphabet = new Word("abcdefghijklmnopqrstuvwxyz");
        List<Word> sixLettersWords = dictionary.getAllSubWords(alphabet, 6);
        Collections.shuffle(sixLettersWords);
        String word = sixLettersWords.get(0).getWord();
        List<Character> l = new ArrayList<>();
        for (char c : word.toCharArray()) {
            l.add(c);
            Collections.shuffle(l);
        }
        StringBuilder sb = new StringBuilder();
        for (char c : l) {
            sb.append(c);
        }
        return sb.toString();
    }

    public void checkGuess() {
        List<String> compare = new ArrayList<>();
        for (Word i : ListofAnswers) {
            compare.add(i.getWord());
        }
        if (compare.contains(userinput) && !answered.contains(userinput)) {
            score++;
            answered.add(userinput);
            System.out.println("Correct!" + "\n");
        } else {
            System.out.println("Try Again!" + "\n");
        }
        printWelcome();

        if (score == fullscore){
            play();
        }
    }

    public void help() {
        ListofAnswers.sort(Word::compareTo);
        if (helpCounter < 2) {
            for (Word listofAnswer : ListofAnswers) {
                if (!answered.contains(listofAnswer.getWord())) {
                    score++;
                    answered.add(listofAnswer.getWord());
                    helpCounter++;
                    info();
                    break;
                }
            }
        } else {
            System.out.println("No More Helpers!");
            System.out.print("\n");
            printWelcome();
        }
    }
}