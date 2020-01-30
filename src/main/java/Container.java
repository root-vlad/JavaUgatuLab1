import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by vgorokhov on 12.10.2017.
 */
public abstract class Container extends Item {
    protected Integer maxSize;
    private List<Item> listItemInContainer = new ArrayList<Item>();

    Container(String name, Integer weight, Integer maxSize, String property) {
        super(name, weight, property);
        this.maxSize = maxSize;
    }

    Container(String name, Integer maxSize, String property) {
        super(name, property);
        this.maxSize = maxSize;
    }

     protected abstract void putOnContainer(Item item) throws ItemStoreException, ItemAlreadyPlacedException;


    protected Item pullOfContainerOnIndex(int index){
         Item item = listItemInContainer.get(index);
         listItemInContainer.remove(index);
         item.setItemInContainer(false);
         return item;
     }
    protected Integer searchItemOnName(String name){
        Iterator <Item> iterator = listItemInContainer.iterator();
        while (iterator.hasNext()){
            Item item = iterator.next();
            if (name.equals(item.getName())) return listItemInContainer.indexOf(item);
        }
        return null;
    }

    public Integer getCountItemInContainer(){
        return listItemInContainer.size();
    }

    public boolean testOnBust(){
        return searchOnProperty("сломанный", "сломанная", "сломанное");
    }

    public void destroyContainer(){
        Iterator<Item> iterator = listItemInContainer.iterator();
        while (iterator.hasNext()) {
            iterator.next().setItemInContainer(false);
        }
        listItemInContainer.clear();

        this.addPropertyDestroy();
    }

    @Override
    public Integer getWeight(){
        Integer weightContainer = super.getWeight();
        for (Item item: listItemInContainer) {
            weightContainer += item.getWeight();
        }
        return weightContainer;
    }

    public List<Item> getListItemInContainer() {
        return listItemInContainer;
    }

    protected void addListItemInContainer(Item item){
        listItemInContainer.add(item);
    }


}