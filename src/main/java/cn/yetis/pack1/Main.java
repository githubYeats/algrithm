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

        GuitarSpec spec = new GuitarSpec("Stratocastor", BuilderEnum.FENDER,
                TypeEnum.ELECTRIC, WoodEnum.INDIAN_ROSEWOOD,
                WoodEnum.BRAZILIAN_ROSEWOOD, 7L);

        List<Guitar> matchedGuitars = inventory.search(spec);
        if (!matchedGuitars.isEmpty()) {
            System.out.println(matchedGuitars);
        } else {
            System.out.println("Sorry, Erin, we have nothing for you.");
        }

    }

    private static void initializeInventory(Inventory inventory) {
        // add guitars to the inventory: more than one guitar
        GuitarSpec spec = new GuitarSpec("Stratocastor", BuilderEnum.FENDER,
                TypeEnum.ELECTRIC, WoodEnum.INDIAN_ROSEWOOD,
                WoodEnum.BRAZILIAN_ROSEWOOD, 8L);
        inventory.addGuitar("001", spec, 100);
        inventory.addGuitar("002", spec, 200);
    }
}
