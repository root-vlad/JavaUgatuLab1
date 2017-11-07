/**
 * Created by vgorokhov on 12.10.2017.
 */
public class Stack extends Container  {

    Stack( Integer maxSize, String property) {
        super("Стопка", maxSize, property);
    }

    Stack( Integer maxSize) {
        super("Стопка", maxSize, "плоский");
    }

    public Item pullItemOnStack(){
        return this.pullOfContainerOnIndex(getCountItemInContainer() - 1);
    }

    protected void putOnContainer(Item item) throws ItemStoreException, ItemAlreadyPlacedException {
        if (item.isItemInContainer()) {
            throw new ItemAlreadyPlacedException("Невозможно добавить предмет в стек, т.к. он уже добавлен в какой-то контейнер", item, this);
        }
            if (this.isItemInContainer()){
                throw new ItemAlreadyPlacedException("Невозможно добавить предмет в стек, который уже находится в другом контейнере", item, this);
            }


                addListItemInContainer(item);
                item.setItemInContainer(true);

//            listItemInContainer.add(item);
//            item.setItemInContainer(true);

        if (this.getCountItemInContainer()>maxSize) {
            String message = "При добавлении предмета " + item.toString() + " в стек " + this.toString() + ", стек сломался";
            throw new ItemStoreException(message, item, this);
        }
    }
}
