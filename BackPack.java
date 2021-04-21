import java.util.HashMap;
import java.util.Set;

/**
 * @author Peter
 * @version 0.01
 */
public class BackPack {
    // instance variables
    private HashMap<String, Item> items;
    
    // BackPack constructor
    public BackPack() { 
        items = new HashMap<>();
    }

    public void put(Item item) {
        items.put(item.getDescription(), item);    
    }
     
    public String getItemString() {
        String itemsString = "";   
        Set<String> keys = items.keySet();
        
        for (String item : keys) {
            itemsString += item + ", ";
        }
        
        if (itemsString.length() > 0) {
            itemsString = itemsString.substring(0, itemsString.length() - 2);   
        }
        return itemsString;
    }

    
    /**
     * ... might return a null
     */
    public Item get(String description) {
        return items.get(description);   
    }
    
    public Item remove(String description) {
         return items.remove(description);   
    }
    
    public static void main(String[] args) {
      System.out.println("BackPack");
    }
}
