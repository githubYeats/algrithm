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

        System.out.println("Fido's all done...");

        // Fido 一直在外面没回来
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 再回来时，再为Fido开门
        remote.pressButton();
        System.out.println("Fido's back inside...");

        System.out.println("The dog door will be closed in 5 seconds");
    }
}
