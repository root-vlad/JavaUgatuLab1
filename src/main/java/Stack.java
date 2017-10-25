/**
 * Created by vgorokhov on 12.10.2017.
 */
public class Stack extends Container  {

    Stack( Integer maxSize, String property) {
        super("Стопка", maxSize, property);
    }

    Stack( Integer maxSize) {
        super("Стопка", maxSize, "плоский");
    }

    public Item pullItemOnStack(){
        return this.pullOfContainerOnIndex(getCountItemInContainer() - 1);
    }



}
