import java.util.ArrayList;
import java.util.List;

/**
 * Created by vgorokhov on 12.10.2017.
 */
public class Container extends Item {
    private Integer maxSize;
    protected Integer countItemInContainer = 0;
    private List<Item> listItemInContainer = new ArrayList<Item>();

    Container(String name, Integer weight, Integer maxSize, String property) {
        super(name, weight, property);
        this.maxSize = maxSize;
    }

    Container(String name, Integer maxSize, String property) {
        super(name, property);
        this.maxSize = maxSize;
    }

     protected void putOnContainer(Item item){
         listItemInContainer.add(item);
         countItemInContainer = listItemInContainer.size();
         super.weight += item.weight;
     }

     protected Item pullOfContainerOnIndex(int index){
         Item item = listItemInContainer.get(index);
         listItemInContainer.remove(index);
         return item;
     }
}
