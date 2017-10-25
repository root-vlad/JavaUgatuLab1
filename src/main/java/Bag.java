/**
 * Created by vgorokhov on 12.10.2017.
 */
public class Bag extends Container {
    Bag(String name, Integer maxSize, String property) {
        super(name, maxSize, property);
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


}
