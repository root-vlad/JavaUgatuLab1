/**
 * Created by vgorokhov on 12.10.2017.
 */
public class Box extends Container {
    Box(Integer maxSize) {
        super("Коробка", maxSize, "плоский");
    }

    Box(String name, Integer maxSize, String property) {
        super(name, maxSize, property);
    }
}
