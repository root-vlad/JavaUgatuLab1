/**
 * Created by vgorokhov on 18.10.2017.
 */
public class ItemStoreException extends Exception {

    public Item getItem() {
        return item;
    }

    public Container getContainer() {
        return container;
    }

    Item item;
    Container container;
    ItemStoreException(String message, Item item, Container container){
        super(message);
        this.item = item;
        this.container = container;

    }
}
