import java.util.*;

/**
 * Zuul Map
 *   Map of the Zuul World
 *   
 * @author Peter
 * @version 0.1
 */
public class ZMap
{
    private final HashMap<String, Room> zMap;
    private static final Random rnd = new Random();
    
    public ZMap() {
        zMap = new HashMap<>();
        createWorld();
    }
    
    /**
     * Create all the rooms and link their exits together. 
     * First create the room objects and put them in zMap.
     * Next set the room exits from one room to another.
     * Also place any items in the rooms.
     */
    private void createWorld() {
        final Room outside, theater, pub, lab, office;
        final TransporterRoom transporter;
      
        // create the rooms
        outside = new Room("outside the main entrance of the university");
        theater = new Room("in a lecture theater");
        pub = new Room("in the campus pub");
        lab = new Room("in a computing lab");
        office = new Room("in the computing admin office");
        transporter = new TransporterRoom("in the transporter room");
        
        zMap.put("outside", outside);
        zMap.put("theater", theater);
        zMap.put("pub", pub);
        zMap.put("lab", lab);
        zMap.put("office", office);
        zMap.put("transporter", transporter);
        
        // initialise room exits
        outside.setExit("east", theater);
        outside.setExit("south", lab);
        outside.setExit("west", pub);
        outside.setExit("north", transporter);
        outside.addItem(new Item("pouch of 10 gold coins", 5));

        theater.setExit("west", outside);
        theater.addItem(new Item("wand", 1));

        pub.setExit("east", outside);
        pub.addItem(new Item("burger", 1));

        lab.setExit("north", outside);
        lab.setExit("east", office);
        lab.addItem(new Item("energy", 1));

        office.setExit("west", lab);
        office.addItem(new Item("shades", 1));
        
        transporter.setExit("out", null);
        transporter.addItem(new Item("spells", 3));
    }
    
    /**
     * Move the player to the next room or go back
     * @param direction is the exit to take (or back)
     */
    Room goLocation(Player player, String direction) {
        final Room currentRoom = player.getLocation();  // should never be null
        Room nextRoom = null;
        
        if (direction.equals("back")) {
            nextRoom = player.priorRoom();            
        }
        else if (currentRoom instanceof TransporterRoom) {
            nextRoom = getRandomRoom();
        }
        else {
            nextRoom = currentRoom.getExit(direction);
        }
        
        // if (nextRoom instanceof TransporterRoom) {
            // while (nextRoom instanceof TransporterRoom) {
                // nextRoom = getRandomRoom();
            // }
        // }
        
        return nextRoom;        
    }
    
    public Room getStartRoom() {
        return zMap.get("outside");    
    }
    
    /**
     * Get a random room for the transporter
     *   Create an array of Room, populate the array
     *   with all the Room objects in the zMap. Pick
     *   one of the array items randomly.
     * @return a random room from the map
     */
    public Room getRandomRoom() {
        Room[] rooms = new Room[zMap.size()];
        rooms = zMap.values().toArray(rooms);
        return rooms[rnd.nextInt(rooms.length)];
    }
}
