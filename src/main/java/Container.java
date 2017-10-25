import com.sun.istack.internal.NotNull;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by vgorokhov on 12.10.2017.
 */
public class Container extends Item {
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

     protected void putOnContainer(Item item) throws ItemAlreadyPlacedException, ItemStoreException {
         if (item.getItemInContainer()) throw new ItemAlreadyPlacedException("Невозможно добавить предмет, т.к. он уже добавлен в контейнер", item, this);
         if (this.testOnBust()){
             destroyContainer();
             throw new ItemAlreadyPlacedException("Невозможно добавить предмет в сломанный контейнер", item, this);
         }
         listItemInContainer.add(item);
         super.weight += item.weight;
         if (this.getWeight()>maxSize) {
             String message = "При добавлении предмета " + item.toString() + " в контейнер " + this.toString() + ", контейнер сломался";
             throw new ItemStoreException(message, item, this);
         }
         item.setItemInContainer(true);
     }

     protected Item pullOfContainerOnIndex(int index){
         Item item = listItemInContainer.get(index);
         listItemInContainer.remove(index);
         super.weight -= item.weight;
         item.setItemInContainer(false);
         return item;
     }
    protected Integer searchItemOnName(String name){
        Iterator <Item> iterator = listItemInContainer.iterator();
        while (iterator.hasNext()){
            Item item = iterator.next();
            if (name.equals(item.getName())) return listItemInContainer.indexOf(item);
        }
        return null;// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
          // что культурно возвращать если такого элемента нет?
        // Что нужно возвращать если более одного вхождения?
    }

    public Integer getCountItemInContainer(){
        return listItemInContainer.size();
    }

    public boolean testOnBust(){
        return searchOnProperty("сломаанный", "сломанная", "сломанное");
    }
    public void destroyContainer(){
        Iterator<Item> iterator = listItemInContainer.iterator();
        while (iterator.hasNext()) {
            iterator.next().setItemInContainer(false);
        }
        this.addPropertyDestroy();
    }

}
