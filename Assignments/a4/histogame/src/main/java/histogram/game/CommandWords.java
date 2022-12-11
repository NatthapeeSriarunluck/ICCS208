package histogram.game;

import java.util.HashMap;

public class CommandWords {
    private final HashMap<String, CommandWord> validCommands;

    public CommandWords() {
        validCommands = new HashMap<String, CommandWord>();
        validCommands.put("q", CommandWord.QUIT);
        validCommands.put("!", CommandWord.GIVEUP);
        validCommands.put("?", CommandWord.INFO);
        validCommands.put("@", CommandWord.HELP);
    }

    public CommandWord getCommandWord(String commandWord) {
        CommandWord command = validCommands.get(commandWord);
        if (command != null) {
            return command;
        }
        return CommandWord.UNKNOWN;
    }
    public boolean isCommand(String aString) {
        return validCommands.containsKey(aString);
    }
}
