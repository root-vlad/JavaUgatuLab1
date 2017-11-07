import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by vgorokhov on 12.10.2017.
 */
public class ContainerTest {
    Container container1;
    Box box;
    Bag bag;
    Container container3;
    Container container4;
    Container container5;
    Stack stack;

    Item cat;
    Item cat1;
    Item cat2;
    Item apple;
    Item apple1;
    Item iphone;
    Item iphone1;
    Item iphone2;
    Item iphone3;




    @Before
    public void createContainers(){
        container1 = new Bag("Контейнер 1", 1, 15, "плоская");
        box = new Box(1, 15);
        bag = new Bag("Сумка", 1, 9, "плоская");
        container3 = new Bag("Коробка", 1, 15, "плоская");
        container4 = new Bag("Коробка", 1, 15, "плоская");
        container5 = new Bag("Коробка", 1, 15, "плоская");
        stack = new Stack(2, "маленькая");

    }


    @Before
    public void createItems(){
        cat = new Item("Cat", 5, "Мягкий");
        cat1 = new Item("Cat1", 5, "Мягкий");
        cat2 = new Item("Cat2", 5, "Мягкий");
        apple = new Item("Apple", 1, "съедобный");
        apple1 = new Item("Apple", 1, "съедобный");
        iphone = new Item("IPhone 10", 1, "плоский");
        iphone1 = new Item("IPhone 11", 1, "плоский");
        iphone2 = new Item("IPhone 12", 1, "плоский");

    }

    @Before
    public void putOnContainer() throws Exception {

        try {
            container1.putOnContainer(cat);
            container1.putOnContainer(apple);

            box.putOnContainer(cat1);
            box.putOnContainer(apple1);
            box.putOnContainer(cat2);
        } catch (ItemAlreadyPlacedException e){
            System.err.println(e.getMessage());
            e.getItem().getInfo();
            e.getContainer().getInfo();
        }



    }

    @Test
    public void equalsTwoContainers(){
        assertEquals(2, container1.getCountItemInContainer().intValue());
        assertEquals(3, box.getCountItemInContainer().intValue());

        assertEquals(12, box.getWeight().intValue());
        assertEquals(7, container1.getWeight().intValue());

        assertEquals(15, container1.maxSize.intValue());
        assertEquals(15, box.maxSize.intValue());
    }

    @Test
    public void pullOfContainerOnIndex() throws Exception {
        assertEquals(cat.getName(), container1.pullOfContainerOnIndex(0).getName());
        assertEquals(2, container1.getWeight().intValue());

        assertEquals(1, container1.getCountItemInContainer().intValue());
        assertEquals(apple, container1.pullOfContainerOnIndex(0));
        assertEquals(1, container1.getWeight().intValue());
    }


    @Test
    public void pullOfContainerOnName(){
        try {
            assertEquals(apple1, box.pullOfContainerOnName("Apple"));
        } catch (ListItemException e) {
            System.err.println(e.getName());
            System.err.println(e.getMessage());
        }
        assertEquals(2, box.getCountItemInContainer().intValue());
        assertEquals(11, box.getWeight().intValue());
    }

    @Test
    public void getInfo(){
        cat.getInfo();
        apple.getInfo();
    }

    @Test
    public void testOnFlat(){
        assertEquals(true, container1.testOnFlat());
        assertEquals(true, box.testOnFlat());
        assertEquals(false, cat.testOnFlat());
        assertEquals(false, apple.testOnFlat());
    }

    @Test
    public void pullRandomItem(){
        System.out.println("Выведем случайный объект");
        box.pullRandomItem().getInfo();
        assertEquals(2, box.getCountItemInContainer().intValue());
    }

    @Test(expected = ItemAlreadyPlacedException.class)
    public void testItemAlreadyPlacedException() throws ItemStoreException, ItemAlreadyPlacedException {
            box.putOnContainer(stack);
            box.putOnContainer(stack);
            System.out.println("Вес коробки равен: " + box.getWeight());
    }

    @Test(expected = ItemStoreException.class)
    public void testItemStoreException() throws ItemStoreException {
        try {
            box.putOnContainer(stack);
            box.putOnContainer(container1);
        } catch (ItemAlreadyPlacedException e) {
            e.printStackTrace();
        }
        System.out.println("Вес коробки равен: " + box.getWeight());
    }

    @Test(expected = ItemAlreadyPlacedException.class)
    public void testItemAlreadyPlacedException2() throws ItemAlreadyPlacedException, ItemStoreException {

        try {
            box.putOnContainer(stack);
            box.putOnContainer(container1);
        } catch (ItemStoreException e) {
            e.printStackTrace();
        }
        box.putOnContainer(iphone);
        assertFalse(iphone.isItemInContainer());
    }

    @Test
    public void testDestroy(){
        try {
            box.putOnContainer(stack);
            box.putOnContainer(container1);
        } catch (ItemStoreException e) {
            e.printStackTrace();
        } catch (ItemAlreadyPlacedException e){
            e.printStackTrace();
        }
        assertEquals(1, box.getWeight().intValue());
        assertTrue(box.testOnBust());
        assertFalse(stack.isItemInContainer());
    }

    @Test(expected = ItemStoreException.class)
    public void testPullItemOnStack() throws ItemStoreException, ItemAlreadyPlacedException {
        stack.putOnContainer(iphone);
        stack.putOnContainer(iphone1);
        stack.putOnContainer(iphone2);
        assertFalse(stack.testOnBust());
        assertFalse(iphone.isItemInContainer());
//        stack.putItemInStack(iphone2);

    }

    @Test(expected = ItemAlreadyPlacedException.class)
    public void testPullItemOnStack2() throws ItemAlreadyPlacedException, ItemStoreException {
        try {
            stack.putOnContainer(iphone);
            stack.putOnContainer(iphone1);
            stack.putOnContainer(iphone2);
        } catch (ItemStoreException e) {
            e.printStackTrace();
        }
        stack.putOnContainer(iphone2);

    }
}