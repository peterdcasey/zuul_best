
/**
 * TransporterRoom bounces on entrance to a random room
 *
 * @author Peter
 * @version 0.1
 */
public class TransporterRoom extends Room {
    public TransporterRoom(String description) {
        super(description);
    }
    
    private String getExitString() {
        return "Sorry, there are no obvious exits, try 'out'" +
               "\n" + getItemString();
    }
    
    @Override
    public String getLongDescription() {
        return "You are " + getShortDescription() + ".\n" + getExitString();
    }
}
