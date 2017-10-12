import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by vgorokhov on 12.10.2017.
 */
public class ContainerTest {

    @Test
    public void putOnContainer() throws Exception {
        Container container1 = new Container("Коробка", 5, "плоская");
        Container container2 = new Container("Коробка", 5, "плоская");
        Container container3 = new Container("Коробка", 5, "плоская");
        Container container4 = new Container("Коробка", 5, "плоская");
        Container container5 = new Container("Коробка", 5, "плоская");

        Item cat = new Item("Cat", 5, "Мягкий");
        Item cat1 = new Item("Cat", 5, "Мягкий");
        Item cat2 = new Item("Cat", 5, "Мягкий");

        Item apple = new Item("Apple", 1, "съедобный");

        container1.putOnContainer(cat);
        container1.putOnContainer(apple);

        container2.putOnContainer(cat1);
        container2.putOnContainer(apple);

//        assertEquals(container1, container2);
        assertEquals(container1.countItemInContainer, container2.countItemInContainer);
        assertEquals(container1.countItemInContainer, 2);
        assertEquals(container1.maxSize, container2.maxSize);
//        assertEquals(container1.listItemInContainer, container2.listItemInContainer);




    }

    @Test
    public void pullOfContainerOnIndex() throws Exception {

    }
}