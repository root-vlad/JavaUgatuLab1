import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by vgorokhov on 12.10.2017.
 */
public class Item {
    public boolean isItemInContainer() {
        return itemInContainer;
    }

    public void setItemInContainer(boolean itemInContainer) {
        this.itemInContainer = itemInContainer;
    }

    private boolean itemInContainer = false;
    private String name;

    public Integer getWeight() {
        return weight;
    }

    protected Integer weight = 0;
    private Set<String> properties = new HashSet<String>();

    public String getName() {
        return name;
    }

    Item(String name, Integer weight, String property){
        this.name=name;
        this.weight=weight;
        this.properties.add(property);
    }

    Item(String name, String property){
        this.name=name;
        this.properties.add(property);
    }

    public void getInfo(){
        System.out.print(name + " весит " + weight + " кг. ");
        Iterator<String> iterator = properties.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
    }

    public boolean testOnFlat(){
        return searchOnProperty("плоский", "плоская", "плоское");
    }

    public boolean searchOnProperty(String... strings){
        Iterator<String> iterator = properties.iterator();
        while (iterator.hasNext()){
            String property = iterator.next();
            for (String p : strings) {
                if (property.equalsIgnoreCase(p)) return true;
            }
        }
        return false;
    }

    public void addPropertyDestroy(){
        properties.add("сломанный");
    }

    @Override
    public String toString(){
        return this.name;
    }
}
