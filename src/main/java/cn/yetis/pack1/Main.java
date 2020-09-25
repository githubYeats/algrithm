package cn.yetis.pack1;


import cn.yetis.pack1.ex01.*;

import java.util.List;

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

        List<Guitar> matchedGuitars = inventory.search(whatErinLikes);
        if (!matchedGuitars.isEmpty()) {
            System.out.println(matchedGuitars);
        } else {
            System.out.println("Sorry, Erin, we have nothing for you.");
        }

    }

    private static void initializeInventory(Inventory inventory) {
        // add guitars to the inventory: more than one guitar
        inventory.addGuitar("001", BuilderEnum.FENDER,
                "Stratocastor", TypeEnum.ELECTRIC, WoodEnum.INDIAN_ROSEWOOD, WoodEnum.BRAZILIAN_ROSEWOOD, 100);

        inventory.addGuitar("002", BuilderEnum.FENDER,
                "Stratocastor", TypeEnum.ELECTRIC, WoodEnum.INDIAN_ROSEWOOD, WoodEnum.BRAZILIAN_ROSEWOOD, 200);
    }
}
