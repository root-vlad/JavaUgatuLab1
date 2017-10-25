/**
 * Created by vgorokhov on 18.10.2017.
 */
public class ListItemException extends Exception {

    public String getName() {
        return name;
    }

    private String name;

    public ListItemException(String message, String name){
        super(message);
        this.name = name;
    }
}
