package cn.yetis.pack1.ex01;

import lombok.Data;

import java.util.LinkedList;
import java.util.List;

/**
 * @author fyyang
 * @since 2020-9-23
 */
@Data
public class Inventory {
    private List<Guitar> guitars;

    public Inventory() {
        this.guitars = new LinkedList<>();
    }

    public void addGuitar(String serialNumber, BuilderEnum builder, String model,
                          TypeEnum type, WoodEnum backWood, WoodEnum topWood, double price) {
        Guitar guitar = new Guitar(serialNumber, builder, model, type, backWood, topWood, price);
        guitars.add(guitar);
    }

    public Guitar getGuitar(String serialNumber) {
        for (Guitar guitar : guitars) {
            if (guitar.getSerialNumber().equals(serialNumber)) {
                return guitar;
            }
        }
        return null;
    }

    public Guitar search(Guitar searchGuitar) {
        for (Guitar guitar : guitars) {
            // serialNumber、price两者不判断了，因为它们都是唯一的。  price假设也是唯一的。

            BuilderEnum builder = searchGuitar.getBuilder();
            if ((!"".equals(builder.name())) && (builder.equals(guitar.getBuilder()))) {
                return guitar;
            }

            String model = searchGuitar.getModel();
            if ((!"".equals(model)) && (!model.equals(guitar.getModel()))) {
                return guitar;
            }

            TypeEnum type = searchGuitar.getType();
            if ((!"".equals(type.name())) && (!type.equals(guitar.getType()))) {
                return guitar;
            }

            WoodEnum backWood = searchGuitar.getBackWood();
            if ((!"".equals(backWood.name())) && (!backWood.equals(guitar.getBackWood()))) {
                return guitar;
            }

            WoodEnum topWood = searchGuitar.getTopWood();
            if ((!"".equals(topWood.name())) && (!topWood.equals(guitar.getTopWood()))) {
                return guitar;
            }
        }
        return null;
    }

}
