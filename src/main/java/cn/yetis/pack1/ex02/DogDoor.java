package cn.yetis.pack1.ex02;

import lombok.Data;

/**
 * 超级狗门
 *
 * @author fyyang
 * @since 2020-10-4
 */
@Data
public class DogDoor {

    /**
     * 狗门是否开启
     */
    private boolean open;

    public DogDoor(){

    }

    public DogDoor(boolean open) {
        this.open = open;
    }

    public void open() {
        System.out.println("the dog door is opened.");
        open = true;
    }

    public void close() {
        System.out.println("the dog door is closed.");
        open = false;
    }

    public boolean isOpen() {
        return open;
    }
}
