import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by vgorokhov on 12.10.2017.
 */
public class Item {
    private String name;
    protected Integer weight = 0;
    private Set<String> properties = new HashSet<String>();

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
        System.out.print(name + "весит " + weight + " кг. ");
        Iterator<String> iterator = properties.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next() + " ");
        }
    }
}
