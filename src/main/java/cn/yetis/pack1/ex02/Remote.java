package cn.yetis.pack1.ex02;

import lombok.Data;

/**
 * 远程控制狗门的遥控器
 *
 * @author fyyang
 * @since 2020-10-4
 */
@Data
public class Remote {

    private DogDoor dogDoor;

    public Remote(DogDoor dogDoor) {
        this.dogDoor = dogDoor;
    }

    public void pressButton() {
        System.out.println("Pressing the remote control button...");
        if (dogDoor.isOpen()) {
            dogDoor.close();
        } else {
            dogDoor.open();
        }
    }
}
