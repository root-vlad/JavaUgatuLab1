/**
 * Created by vgorokhov on 18.10.2017.
 */
public class ItemAlreadyPlacedException extends Exception {
    private Item item;
    private  Container container;

    ItemAlreadyPlacedException(String message, Item item, Container container){
        super(message);
        this.item = item;
        this.container = container;
    }

    public Item getItem() {
        return item;
    }
    public Container getContainer() {
        return container;
    }
}
