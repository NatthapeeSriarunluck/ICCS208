package Assignments.A3.zuul.src.main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * This class is the main class of the "World of Zuul" application.
 * "World of Zuul" is a very simple, text based adventure game.  Users
 * can walk around some scenery. That's all. It should really be extended
 * to make it more interesting!
 * <p>
 * To play this game, create an instance of this class and call the "play"
 * method.
 * <p>
 * This main class creates and initialises all the others: it creates all
 * rooms, creates the parser and starts the game.  It also evaluates and
 * executes the commands that the parser returns.
 *
 * @author Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */

public class Game {
    private final Parser parser;
    private Room currentRoom;
    private int index;
    private final ArrayList<Room> Roomkeeper = new ArrayList<>();

    private static List<Room> Rooms;

    /**
     * Create the game and initialise its internal map.
     */
    public Game() {
        createRooms();
        parser = new Parser();
        index = 0;
    }

    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms() {
        Room Outside, Living_Room, Garden, Bedroom, Kitchen, Music_Studio, Toilet1, Toilet2, Storage, Rooftop, Basement, Magic_Transporter;

        // create the rooms
        Magic_Transporter = new Transporter("in the transporter");
        Outside = new Room("outside the main entrance of the house");
        Garden = new Room("in the garden, these plants are beautiful!");
        Living_Room = new Room("chilling in the living room");
        Bedroom = new Room("in the bedroom, sleepy?");
        Kitchen = new Room("in the kitchen");
        Music_Studio = new Room("in the music studio, creator's favourite room!");
        Toilet1 = new Room("in the bedroom's toilet");
        Toilet2 = new Room(" in the music studio's toilet");
        Storage = new Room("in the storage room");
        Rooftop = new Room("on the Rooftop, there's a staircase to a floating door");
        Basement = new Room("in the basement");

        // initialise room exits
        Outside.setExits("east", Garden);
        Outside.setExits("north", Living_Room);
        Living_Room.setExits("south", Outside);
        Living_Room.setExits("west", Kitchen);
        Living_Room.setExits("east", Music_Studio);
        Living_Room.setExits("north", Bedroom);
        Living_Room.setExits("up", Rooftop);
        Bedroom.setExits("east", Toilet1);
        Bedroom.setExits("south", Living_Room);
        Music_Studio.setExits("east", Toilet2);
        Music_Studio.setExits("north", Storage);
        Music_Studio.setExits("west", Living_Room);
        Toilet1.setExits("west", Bedroom);
        Toilet2.setExits("west", Music_Studio);
        Kitchen.setExits("east", Living_Room);
        Garden.setExits("west", Outside);
        Storage.setExits("south", Music_Studio);
        Storage.setExits("down", Basement);
        Rooftop.setExits("down", Living_Room);
        Rooftop.setExits("up", Magic_Transporter);
        Basement.setExits("up", Storage);
        currentRoom = Outside;  // start game outside
        Roomkeeper.add(index, currentRoom);
        index++;
        Rooms = Arrays.asList(Outside, Living_Room, Garden, Bedroom, Kitchen, Music_Studio, Toilet1, Toilet2, Storage, Rooftop, Basement);


    }

    /**
     * Main play routine.  Loops until end of play.
     */
    public void play() {
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.

        boolean finished = false;
        while (!finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome() {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
        System.out.println(getLocationInfo());
    }

    /**
     * Given a command, process (that is: execute) the command.
     *
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) {

        CommandWord commandWord = command.getCommandWord();
        boolean wantToQuit = false;

        switch (commandWord) {
            case UNKNOWN:
                System.out.println("I don't know what you mean...");
                break;
            case HELP:
                printHelp();
                break;

            case GO:
                goRoom(command);
                break;

            case QUIT:
                wantToQuit = quit(command);
                break;

            case LOOK:
                look();
                break;

            case BACK:
                back();
                break;
        }
        return wantToQuit;
    }

    // implementations of user commands:

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the
     * command words.
     */
    private void printHelp() {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        System.out.println("   go quit help");
    }

    /**
     * Try to go in one direction. If there is an exit, enter
     * the new room, otherwise print an error message.
     */
    private void goRoom(Command command) {
        if (!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();
        Room nextRoom = currentRoom.getExit(direction);
        if (nextRoom == null) {
            System.out.println("There is no door!");
        } else if (nextRoom instanceof Transporter) {
            Roomkeeper.add(index, currentRoom);
            index++;
            currentRoom = RandomRoom();
            System.out.println(getLocationInfo());
        } else {
            Roomkeeper.add(index, currentRoom);
            index++;
            currentRoom = nextRoom;
            System.out.println(getLocationInfo());

        }
    }

    private String getLocationInfo() {
        return "You are " + currentRoom.getDescription() + "\n" + currentRoom.getExitString();
    }

    /**
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     *
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) {
        if (command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        } else {
            return true;  // signal that we want to quit
        }
    }

    private void look() {
        System.out.println("You are " + currentRoom.getDescription() + "\n" + currentRoom.getExitString());

    }

    private void back() {
        if (index == 0) {
            System.out.println("Already at the main entrance!");
        } else {
            currentRoom = Roomkeeper.get(index - 1);
            index--;
            System.out.println("You are " + currentRoom.getDescription() + "\n" + currentRoom.getExitString());
        }
    }

    public static Room RandomRoom() {
        Random random = new Random();
        return Rooms.get(random.nextInt(Rooms.size()));

    }


}
