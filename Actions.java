import java.util.HashMap;
import java.util.List;

/**
 * @author Peter
 * @version 0.01
 * 
 * Concept idea a long way from actual usage.....
 * Trying to create a structure to hold the methods
 *    tied to the commands, arguments to some
 *    methods and not others is an issue....??
 */
public class Actions {
    // instance variables
    private HashMap<String, Runnable> actions;
    
    // Actions constructor
    public Actions(Parser parser) {
        actions = new HashMap<>();
        initActions(parser);
    }
    
    private void initActions(Parser parser) {
         List<String> commands =  parser.commandStrings();
         actions.put(commands.get(0), () -> doX());
    }

    public void doX() { System.out.println("hmmm.... under construction"); }
    
    public static void main(String[] args) {
      System.out.println("hello from Actions");
    }
}
