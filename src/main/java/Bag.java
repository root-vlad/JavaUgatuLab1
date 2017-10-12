/**
 * Created by vgorokhov on 12.10.2017.
 */
public class Bag extends Container {
    Bag(String name, Integer weight, Integer maxSize, String property) {
        super(name, weight, maxSize, property);
    }

    Bag(String name, Integer maxSize, String property) {
        super(name, maxSize, property);
    }
}
