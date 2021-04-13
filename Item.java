
/**
 * @author Peter
 * @version 0.01
 */
public class Item {
    // instance variables
    private String description;
    private int weight;
    
    // Item constructor
    public Item(String descr, int weight) {
        description = descr;
        this.weight = weight;
    }
    
    public String getDescription() {
        return description;   
    }
    
    public int getWeight() {
        return weight;   
    }
    
    @Override
    public String toString() {
        return getDescription() + " weighs " + getWeight() + " units.";
    }

    public static void main(String[] args) {
      System.out.println("Item Tester");
      var item = new Item("Thunder axe", 24);
      System.out.println(item);
    }
}
