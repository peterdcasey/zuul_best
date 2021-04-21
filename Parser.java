import java.util.Scanner;
import java.util.List;
import java.util.Arrays;

/**
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 * 
 * This parser reads user input and tries to interpret it as an "Adventure"
 * command. Every time it is called it reads a line from the terminal and
 * tries to interpret the line as a two-word command. It returns the command
 * as an object of class Command.
 *
 * The parser has a set of known command words. It checks user input against
 * the known commands, and if the input is not one of the known commands, it
 * returns a command object that is marked as an unknown command.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */
public class Parser 
{
    private final CommandWords commands;  // holds all valid command words
    private final Scanner reader;         // source of command input

    /**
     * Create a parser to read from the terminal window.
     */
    public Parser() 
    {
        commands = new CommandWords();
        reader = new Scanner(System.in);
    }

    /**
     * @return The next command from the user.
     */
    public Command getCommand() 
    {
        final String inputLine;   // will hold the full input line
        String word1 = null;
        String word2 = null;

        System.out.print("> ");     // print prompt
        inputLine = reader.nextLine();

        // Find up to two words on the line.
        final Scanner tokenizer = new Scanner(inputLine);
        
        if (tokenizer.hasNext()) {
            word1 = tokenizer.next();      // get first word
            
            if (word1.equals("item")) {/* do something ????? */ }
            
            if (tokenizer.hasNext()) {
                word2 = tokenizer.next();      // get second word
                // note: we just ignore the rest of the input line.
            }
        }

        return new Command(commands.getCommandWord(word1), word2);
    }
    
    public String getLine() 
    {
        final String inputLine;   // will hold the full input line
        String word1 = null;
        String word2 = null;

        System.out.print("> ");     // print prompt
        inputLine = reader.nextLine();
        return inputLine;
    }

    /**
     * Print out a list of valid command words.
     */
    public void showCommands()
    {
        commands.showAll();
    }
    
    public List commandStrings() {
         return commands.commandStrings();   
    }
    
    public String toString() {
         return commands.toString();   
    }
}
