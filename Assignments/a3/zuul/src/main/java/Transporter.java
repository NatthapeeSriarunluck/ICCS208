package Assignments.A3.zuul.src.main.java;

public class Transporter extends Room {
    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open courtyard".
     *
     * @param description The room's description.
     */
    public Transporter(String description) {
        super(description);
    }
    public Room getExit(String direction) {
        return Game.RandomRoom();
    }


}
