import java.util.HashMap;
import java.util.Stack;

/**
 * Write a description of class Player here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Player {
    private static Integer nextID = 0;
    private final String name;
    private final Integer playerID;
    private Room location;
    private final BackPack backPack;
    private final Stack<Room> goStack;
    private int health;
    public static final int DEFAULT_HEALTH = 100;
    
    public Player(String name, Room startRoom) {
        this.name = name;
        playerID = nextID++;
        backPack = new BackPack();
        location = startRoom;
        goStack = new Stack<>();
        setLocation(location);
        health = DEFAULT_HEALTH;
    }
    
    public void setLocation(Room location) {
        this.location = location;
        goStack.push(location);
        health--;
    }
    
    public Integer getID() {
        return playerID;    
    }
    
    public Room getLocation() {
        return location;
    }
    
    public void addToBackPack(Item item) {
        backPack.put(item);   
    }
    
    public Item getItem(String description) {
         Item item = backPack.remove(description);
         return item;
    }
    
    public String itemString() {
        return backPack.getItemString();   
    }
    
    /**
     * Try to go back one move
     * If back at the beginning, indicate such
     */
    public Room priorRoom() {
        Room previousRoom = null;
        
        if (! goStack.empty()) {
            Room currentLocation = goStack.pop();
            
            if (! goStack.empty()) {
                previousRoom = goStack.pop();  
            }
            else {
                System.out.println("You are back at the start");
                goStack.push(currentLocation);
                previousRoom = currentLocation;
            }
        }
        
        return previousRoom;
    }

    public String getName() {
        return name;
    }
    
    @Override
    public String toString() {
        return getName() + " " + getID();   
    }
    
    public static void main(String[] args) {
        Player p = new Player("Bob", null);
        System.out.println(p); 
    }
}
