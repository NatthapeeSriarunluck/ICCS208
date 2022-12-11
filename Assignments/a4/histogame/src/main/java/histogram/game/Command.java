package histogram.game;

public class Command
{
    private final CommandWord commandWord;
    private final String input;

    public Command(CommandWord commandWord, String input)
    {
        this.commandWord = commandWord;
        this.input = input;
    }

    public String getSecondWord()
    {
        return input;
    }


    public CommandWord getCommandWord() {
        return commandWord;
    }
}

