import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.
 * 
 * This class holds an enumeration of all command words known to the game.
 * It is used to recognise commands as they are typed in.
 *
 * @author  Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */

public class CommandWords
{
    // A mapping between a command word and the CommandWord
    // associated with it.
    private HashMap<String, CommandWord> validCommands;

    /**
     * Constructor - initialise the command words.
     */
    public CommandWords()
    {
        validCommands = new HashMap<>();
        
        for(CommandWord command : CommandWord.values()) {
            if(/*command != CommandWord.UNKNOWN*/true) {
                validCommands.put(command.toString(), command);
            }
        }
        //System.out.println(validCommands);
    }

    /**
     * Find the CommandWord associated with a command word.
     * @param commandWord The word to look up.
     * @return The CommandWord correspondng to commandWord, or UNKNOWN
     *         if it is not a valid command word.
     */
    public CommandWord getCommandWord(String commandWord)
    {
        CommandWord command = validCommands.get(commandWord);
        
        return (command != null) ? command : CommandWord.UNKNOWN;
        
        // if(command != null) {
            // return command;
        // }
        // else {
            // return CommandWord.UNKNOWN;
        // }
    }
    
    /**
     * Check whether a given String is a valid command word. 
     * @return true if it is, false if it isn't.
     */
    public boolean isCommand(String commandWord)
    {
        return validCommands.containsKey(commandWord);
    }

    /**
     * Print all valid commands to System.out.
     */
    public void showAll() 
    {
        System.out.println(this);   // call toString() method
        
        // for(String command : validCommands.keySet()) {
            // System.out.print(command + "  ");
        // }
        // System.out.println();
    }
    
    @Override
    public String toString() {
        String commands = "";
        
        for(String command : validCommands.keySet()) {
            commands += command + ", ";
        }
        
        return commands.substring(0, commands.length() - 2);
    }
    
    public List<String> commandStrings() {
        return new ArrayList<>(validCommands.keySet());
    }
    
    public static void main(String[] args) {
        CommandWords x = new CommandWords();
        System.out.println(x);
    }
}
