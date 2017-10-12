/**
 * Created by vgorokhov on 12.10.2017.
 */
public class Box extends Container {
    Box(String name, Integer weight, Integer maxSize, String property) {
        super(name, weight, maxSize, property);
    }

    Box(String name, Integer maxSize, String property) {
        super(name, maxSize, property);
    }
}
