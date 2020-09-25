package cn.yetis.pack1;


import cn.yetis.pack1.ex01.*;

/**
 * @author fyyang
 * @date
 * @since v1.0.0
 */
public class Main {

    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        initializeInventory(inventory);

        Guitar whatErinLikes = new Guitar("001", BuilderEnum.FENDER,
                "Stratocastor", TypeEnum.ELECTRIC, WoodEnum.INDIAN_ROSEWOOD,
                WoodEnum.BRAZILIAN_ROSEWOOD, 100);

        Guitar guitar = inventory.search(whatErinLikes);
        if (null != guitar) {
            System.out.println(guitar);
        } else {
            System.out.println("Sorry, Erin, we have nothing for you.");
        }

    }

    private static void initializeInventory(Inventory inventory) {
        // add guitars to the inventory
        inventory.addGuitar("001", BuilderEnum.FENDER,
                "Stratocastor", TypeEnum.ELECTRIC, WoodEnum.INDIAN_ROSEWOOD, WoodEnum.BRAZILIAN_ROSEWOOD, 100);
    }
}
