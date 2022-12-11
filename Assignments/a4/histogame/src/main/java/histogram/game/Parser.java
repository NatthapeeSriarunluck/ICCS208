package histogram.game;

import java.util.Scanner;

public class Parser {
    private final CommandWords commands;
    private final Scanner reader;

    public Parser() {
        commands = new CommandWords();
        reader = new Scanner(System.in);
    }

    public Command getCommand() {
        String inputLine;
        String word1 = null;

        System.out.print("> ");

        inputLine = reader.nextLine();


        try (Scanner tokenizer = new Scanner(inputLine)) {
            if (tokenizer.hasNext()) {
                word1 = tokenizer.next().toLowerCase();

            }
        }
        assert word1 != null;
        return new Command(commands.getCommandWord(word1), word1.toLowerCase());
    }
}
