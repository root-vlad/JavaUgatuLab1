import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by vgorokhov on 12.10.2017.
 */
public class ContainerTest {
    Container container1;
    Container container2;
    Container container3;
    Container container4;
    Container container5;

    Item cat;
    Item cat1;
    Item cat2;
    Item apple;




    @Before
    public void createContainers(){
        container1 = new Container("Коробка", 5, "плоская");
        container2 = new Container("Коробка", 5, "плоская");
        container3 = new Container("Коробка", 5, "плоская");
        container4 = new Container("Коробка", 5, "плоская");
        container5 = new Container("Коробка", 5, "плоская");

    }


    @Before
    public void createItems(){
        cat = new Item("Cat", 5, "Мягкий");
        cat1 = new Item("Cat", 5, "Мягкий");
        cat2 = new Item("Cat", 5, "Мягкий");
        apple = new Item("Apple", 1, "съедобный");

    }

    @Before
    public void putOnContainer() throws Exception {
        container1.putOnContainer(cat);
        container1.putOnContainer(apple);

        container2.putOnContainer(cat1);
        container2.putOnContainer(apple);
    }

    @Test
    public void equalsTwoContainers(){
        assertEquals(2, container1.countItemInContainer.intValue());
        assertEquals(2, container2.countItemInContainer.intValue());

        assertEquals(5, container1.maxSize.intValue());
        assertEquals(5, container2.maxSize.intValue());
    }

    @Test
    public void pullOfContainerOnIndex() throws Exception {
        putOnContainer();

    }
}