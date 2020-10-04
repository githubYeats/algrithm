package cn.yetis.pack1.ex02;

/**
 * @author fyyang
 * @since 2020-19-4
 */
public class Main2 {
    public static void main(String[] args) {
        DogDoor dogDoor = new DogDoor();
        Remote remote = new Remote(dogDoor);
        // Fido, name of the dog.
        System.out.println("Fido barks to go outside...");
        remote.pressButton();
        System.out.println("Fido has gone outside...");
        remote.pressButton();
        System.out.println("Fido's all done...");
        remote.pressButton();
        System.out.println("Fido's back inside...");
        remote.pressButton();
    }
}
