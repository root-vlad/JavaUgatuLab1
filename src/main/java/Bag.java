/**
 * Created by vgorokhov on 12.10.2017.
 */
public class Bag extends Container {
    Bag(String name, Integer weight, Integer maxSize, String property) {
        super(name, weight, maxSize, property);
    }

    Bag(Integer maxSize, String property) {
        super("Мешок", maxSize, property);
    }

    protected Item pullOfContainerOnName(String name) throws ListItemException{
        Integer index = super.searchItemOnName(name);
        if (index == null) throw new ListItemException("Предмета с таким названиеим нет", name);
        return pullOfContainerOnIndex(index);
    }

    protected Item pullRandomItem(){
        Double size = super.getCountItemInContainer().doubleValue();
        Double randomNumber = (Math.random()*size);
        return pullOfContainerOnIndex(randomNumber.intValue());
    }

    public void putOnContainer(Item item) throws ItemStoreException, ItemAlreadyPlacedException {
        if (item.isItemInContainer()) {
            throw new ItemAlreadyPlacedException("Невозможно добавить предмет в сумку, т.к. он уже добавлен в какой-то контейнер", item, this);
        }else {
            if (this.testOnBust()){
                throw new ItemAlreadyPlacedException("Невозможно добавить предмет в сломанную сумку", item, this);
            }else {
                if (this.isItemInContainer()){
                    throw new ItemAlreadyPlacedException("Невозможно добавить предмет в сумку, которая уже находится в другом контейнере", item, this);
                }else {
                    this.addListItemInContainer(item);
                    item.setItemInContainer(true);
                }
//                listItemInContainer.add(item);
//                item.setItemInContainer(true);
            }
        }

//        super.putOnContainer(item);

        if (this.getWeight()>maxSize) {
            String message = "При добавлении предмета " + item.toString() + " в сумку " + this.toString() + ", сумка сломалась";
            destroyContainer();
            throw new ItemStoreException(message, item, this);
        }
    }


}
