/**
 *  This class is the main class of the "World of Zuul" application. 
 *  "World of Zuul" is a very simple, text based adventure game.  Users 
 *  can walk around some scenery. That's all. It should really be extended 
 *  to make it more interesting!
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */
import java.util.Stack;
import java.util.HashMap;

public class Game 
{
    private Parser parser;         // Replace with a GUI later
    private final Display display;
    // private final GUI gui = new GUI();
    
    private ZMap zMap;
    private HashMap<Integer, Player> players;
    private Actions actions;

    //private Player player;
        
    /**
     * Create the game and initialise its internal map.
     */
    public Game() {
        parser = new Parser();
        zMap = new ZMap();
        players = new HashMap<>();
        display = new Display();
        actions = new Actions(parser);
        //Room startRoom = zMap.getRandomRoom();
        Room startRoom = zMap.getStartRoom();
        Player player = new Player("Bob", startRoom);
        AIPlayer ai = new AIPlayer(zMap.getRandomRoom());
        players.put(ai.getID(), ai);
        players.put(player.getID(), player);
        // play();  // auto-start play
    }

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() {            
        printWelcome();
        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over. 
        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        display.show("Thank you for playing.  Good bye.");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type '" + CommandWord.HELP + "' if you need help.");
        System.out.println();
        Room currentRoom = players.get(0).getLocation();
        System.out.println(currentRoom.getLongDescription());
    }

    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        CommandWord commandWord = command.getCommandWord();

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
                lookAround();
                break;
                
            case PICKUP:
                pickup();
                break;
                
            case PUTDOWN:
                putdown();
                break;
                
            case DUCK:
                System.out.println("<< not yet implemented >>");
                break;
                
            default:
                System.out.println("Internal command error");
        }
        return wantToQuit;
    }

    // Implementations of user commands:

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    private void printHelp() 
    {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are: " + parser);
        //parser.showCommands();
    }

    /** 
     * Try to go in one direction. If there is an exit, enter the new
     * room, otherwise print an error message.
     */
    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) {
            // no second word, we don't know where to go...
            System.out.println("Go where?");
        }
        else {
            String direction = command.getSecondWord();
            // Try to leave current room.
            Room room = zMap.goLocation(players.get(0), direction);
            //Room room = zMap.goLocation(player, direction);
    
            if (room != null) {
                players.get(0).setLocation(room);
                System.out.println(players.get(0).getLocation().getLongDescription());
            }
            else {
                System.out.println("There is no door in that direction!");
            }
        }
    }

    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;  // signal that we want to quit
        }
    }
    
    private void lookAround() {
        Room currentRoom = players.get(0).getLocation();
        System.out.println(currentRoom.getLongDescription());   
    }
    
    private void pickup() {
        Room currentRoom = players.get(0).getLocation();
        System.out.println(currentRoom.getLongDescription());
        System.out.println("What do you want to pick up?");
        Command command = parser.getCommand();
        CommandWord word = command.getCommandWord();
        String item = command.getSecondWord();
        System.out.println(item);
        Item theItem = currentRoom.getItem(item);
        System.out.println("You picked up: "+ theItem);
    }
    
    private void putdown() {
        System.out.println("What do you want to put down?");
        System.out.println(" --- not implemented --- ");
    }
}
